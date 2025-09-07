
/*
File: src/Main.java

Parcial – Estructura de Datos (Unidad 1) – Implementación en Java puro
Referencia del enunciado: ver PDF provisto.

PLAN (pseudocódigo resumido)
1) Constantes y estructuras base
   - MAX_LIBROS, NUM_SUCURSALES
   - Array Libro[] catalogo (ordenado por codigo, con bajas lógicas)
   - Matriz int disponibilidad[ MAX_LIBROS ][ NUM_SUCURSALES ]
   - Listas:
     a) Prestamos (lista enlazada simple)
     b) Historial (lista doblemente enlazada)

2) Clases modelo
   - Libro: codigo:int, titulo:String, autor:String, stock:int, activo:boolean
   - Prestamo: codigoLibro:int, usuario:String, fecha:LocalDate, devuelto:boolean
   - OperacionHistorial: tipo:enum {ALTA, BAJA, PRESTAMO, DEVOLUCION}, timestamp:LocalDateTime, detalle:String

3) Estructuras enlazadas propias (sin colecciones del JDK)
   - ListaPrestamos (Singly): insertarInicio/Fin, marcarDevueltoYRemover(codigo, usuario), recorrerImprimir()
   - ListaHistorial (Doubly): add(tipo, detalle), recorrerAdelante(), recorrerAtras()

4) Catálogo (arrays)
   - altaLibro(): verifica capacidad y duplicados, inserta manteniendo orden por codigo (shift)
   - bajaLogicaPorCodigo(): busca (binaria), marca activo=false; agrega al historial
   - buscarPorCodigo(): binaria O(log n) sobre segmento [0, numLibros)
   - buscarPorTitulo(): lineal O(n)
   - actualizarStockYDisponibilidad(): ajusta stock total y matriz por sucursal con validaciones
   - listarCatalogo(): recorre e imprime activos

5) Préstamos (lista simple)
   - prestarLibro(): si stock>0 y libro activo, decrementa stock, añade a lista, historial
   - devolverLibro(): busca en lista, marca devuelto, remueve nodo, incrementa stock, historial
   - listarPrestamos(): recorre lista

6) Historial (lista doble)
   - registrar en cada operación
   - listar hacia adelante/atrás

7) Interfaz de consola (programación estructurada)
   - bucle while con switch (menu)
   - manejo de entradas inválidas y excepciones, sin terminar el programa
   - métodos modulares: cargarLibro(), eliminarLibro(), buscarLibroPorTitulo(), prestarLibro(), devolverLibro(), etc.

8) README (en comentarios al final):
   - cómo compilar/ejecutar
   - elección de estructuras y complejidad

NOTAS de complejidad (indicadas junto a métodos clave):
- Inserción ordenada en array: O(n) en peor caso (shift)
- Búsqueda binaria por código: O(log n)
- Búsqueda lineal por título: O(n)
- Operaciones en listas enlazadas: inserción/eliminación O(1) (con búsqueda O(n) cuando aplica)

*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// ====== MODELO ======
class Libro {
    int codigo;
    String titulo;
    String autor;
    int stock; // stock total (suma de sucursales)
    boolean activo; // baja lógica

    Libro(int codigo, String titulo, String autor, int stock) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.stock = Math.max(0, stock);
        this.activo = true;
    }
}

class Prestamo {
    int codigoLibro;
    String usuario;
    LocalDate fecha;
    boolean devuelto;

    Prestamo(int codigoLibro, String usuario, LocalDate fecha) {
        this.codigoLibro = codigoLibro;
        this.usuario = usuario;
        this.fecha = fecha;
        this.devuelto = false;
    }
}

enum TipoOperacion {
    ALTA, BAJA, PRESTAMO, DEVOLUCION
}

class OperacionHistorial {
    TipoOperacion tipo;
    LocalDateTime timestamp;
    String detalle;

    OperacionHistorial(TipoOperacion tipo, String detalle) {
        this.tipo = tipo;
        this.detalle = detalle;
        this.timestamp = LocalDateTime.now();
    }
}

// ====== LISTA ENLAZADA SIMPLE (Préstamos) ======
class NodoPrestamo {
    Prestamo data;
    NodoPrestamo next;

    NodoPrestamo(Prestamo p) {
        this.data = p;
    }
}

class ListaPrestamos {
    private NodoPrestamo head;
    private NodoPrestamo tail;

    // Inserción al final: O(1)
    void insertarAlFinal(Prestamo p) {
        NodoPrestamo n = new NodoPrestamo(p);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    // Eliminar por (codigo, usuario): O(n). Remueve el nodo y retorna true si
    // existía.
    boolean marcarDevueltoYRemover(int codigoLibro, String usuario) {
        NodoPrestamo prev = null;
        NodoPrestamo curr = head;
        while (curr != null) {
            if (curr.data.codigoLibro == codigoLibro && curr.data.usuario.equalsIgnoreCase(usuario)
                    && !curr.data.devuelto) {
                curr.data.devuelto = true; // why: aseguramos registrar estado antes de quitar nodo
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                if (curr == tail) {
                    tail = prev;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    boolean estaVacia() {
        return head == null;
    }

    void imprimir() {
        if (head == null) {
            System.out.println("No hay préstamos activos.");
            return;
        }
        System.out.println("\n--- Préstamos activos ---");
        NodoPrestamo curr = head;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (curr != null) {
            Prestamo p = curr.data;
            System.out.printf("Usuario: %s | Libro: %d | Fecha: %s\n", p.usuario, p.codigoLibro, p.fecha.format(df));
            curr = curr.next;
        }
    }
}

// ====== LISTA DOBLEMENTE ENLAZADA (Historial) ======
class NodoHistorial {
    OperacionHistorial data;
    NodoHistorial prev, next;

    NodoHistorial(OperacionHistorial op) {
        this.data = op;
    }
}

class ListaHistorial {
    private NodoHistorial head;
    private NodoHistorial tail;

    // Añadir al final: O(1)
    void add(TipoOperacion tipo, String detalle) {
        OperacionHistorial op = new OperacionHistorial(tipo, detalle);
        NodoHistorial n = new NodoHistorial(op);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void recorrerAdelante() {
        if (head == null) {
            System.out.println("Historial vacío.");
            return;
        }
        System.out.println("\n--- Historial (adelante) ---");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        NodoHistorial cur = head;
        while (cur != null) {
            var op = cur.data;
            System.out.printf("[%s] %s -> %s\n", op.timestamp.format(dtf), op.tipo, op.detalle);
            cur = cur.next;
        }
    }

    void recorrerAtras() {
        if (tail == null) {
            System.out.println("Historial vacío.");
            return;
        }
        System.out.println("\n--- Historial (atrás) ---");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        NodoHistorial cur = tail;
        while (cur != null) {
            var op = cur.data;
            System.out.printf("[%s] %s -> %s\n", op.timestamp.format(dtf), op.tipo, op.detalle);
            cur = cur.prev;
        }
    }
}

// ====== SISTEMA BIBLIOTECA (Arrays + Listas) ======
class BibliotecaU1 {
    // Configurables
    public static final int MAX_LIBROS = 200;
    public static final int NUM_SUCURSALES = 3;

    private final Libro[] catalogo = new Libro[MAX_LIBROS];
    private final int[][] disponibilidad = new int[MAX_LIBROS][NUM_SUCURSALES];
    private int numLibros = 0; // cantidad de posiciones ocupadas (activos o no)

    private final ListaPrestamos prestamos = new ListaPrestamos();
    private final ListaHistorial historial = new ListaHistorial();

    // === Utilidades internas ===
    private boolean hayEspacio() {
        return numLibros < MAX_LIBROS;
    }

    // Búsqueda binaria por código sobre [0, numLibros): O(log n)
    private int indicePorCodigo(int codigo) {
        int lo = 0, hi = numLibros - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int cmp = Integer.compare(catalogo[mid].codigo, codigo);
            if (cmp == 0)
                return mid;
            if (cmp < 0)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    // Inserción ordenada por código con corrimiento: O(n)
    private int insertarOrdenado(Libro libro) {
        int i = numLibros - 1;
        while (i >= 0 && catalogo[i].codigo > libro.codigo) {
            catalogo[i + 1] = catalogo[i];
            // mover fila de disponibilidad en paralelo
            for (int s = 0; s < NUM_SUCURSALES; s++)
                disponibilidad[i + 1][s] = disponibilidad[i][s];
            i--;
        }
        catalogo[i + 1] = libro;
        for (int s = 0; s < NUM_SUCURSALES; s++)
            disponibilidad[i + 1][s] = 0;
        numLibros++;
        return i + 1;
    }

    // === API del catálogo ===
    public boolean altaLibro(int codigo, String titulo, String autor, int stock, int[] distPorSucursal) {
        if (!hayEspacio()) {
            System.out.println("No hay espacio en el catálogo.");
            return false;
        }
        if (stock < 0) {
            System.out.println("Stock no puede ser negativo.");
            return false;
        }
        if (indicePorCodigo(codigo) >= 0) {
            System.out.println("Código duplicado.");
            return false;
        }

        Libro libro = new Libro(codigo, titulo, autor, stock);
        int pos = insertarOrdenado(libro);
        if (distPorSucursal != null) {
            if (distPorSucursal.length != NUM_SUCURSALES) {
                System.out.println("Distribución por sucursal inválida, se coloca todo en Sucursal 0.");
                disponibilidad[pos][0] = stock;
            } else {
                int suma = 0;
                for (int s = 0; s < NUM_SUCURSALES; s++) {
                    disponibilidad[pos][s] = Math.max(0, distPorSucursal[s]);
                    suma += disponibilidad[pos][s];
                }
                if (suma != stock) {
                    // why: mantener consistencia total = stock
                    System.out.println("La suma por sucursales no coincide con el stock, se ajusta todo a Sucursal 0.");
                    for (int s = 0; s < NUM_SUCURSALES; s++)
                        disponibilidad[pos][s] = 0;
                    disponibilidad[pos][0] = stock;
                }
            }
        } else {
            disponibilidad[pos][0] = stock;
        }
        historial.add(TipoOperacion.ALTA, "Alta libro #" + codigo + " - '" + titulo + "'");
        return true;
    }

    public boolean bajaLogicaPorCodigo(int codigo) {
        int idx = indicePorCodigo(codigo);
        if (idx < 0) {
            System.out.println("No existe el código.");
            return false;
        }
        Libro l = catalogo[idx];
        if (!l.activo) {
            System.out.println("El libro ya está dado de baja.");
            return false;
        }
        // Validación: no permitir baja si hay préstamos activos del libro
        if (!prestamos.estaVacia()) {
            // recorrido lineal O(n) para verificar existencia en préstamos
            NodoPrestamo cur = obtenerHeadPrestamos();
            while (cur != null) {
                if (cur.data.codigoLibro == codigo && !cur.data.devuelto) {
                    System.out.println("No se puede dar de baja: hay préstamos activos de este libro.");
                    return false;
                }
                cur = cur.next;
            }
        }
        l.activo = false;
        l.stock = 0;
        for (int s = 0; s < NUM_SUCURSALES; s++)
            disponibilidad[idx][s] = 0;
        historial.add(TipoOperacion.BAJA, "Baja libro #" + codigo + " - '" + l.titulo + "'");
        return true;
    }

    // Solo para validaciones internas (sin exponer la estructura)
    private NodoPrestamo obtenerHeadPrestamos() {
        try {
            java.lang.reflect.Field f = ListaPrestamos.class.getDeclaredField("head");
            f.setAccessible(true);
            return (NodoPrestamo) f.get(prestamos);
        } catch (Exception e) {
            return null;
        }
    }

    public Libro buscarPorCodigo(int codigo) {
        int idx = indicePorCodigo(codigo);
        if (idx >= 0 && catalogo[idx].activo)
            return catalogo[idx];
        return null;
    }

    public Libro buscarPorTitulo(String titulo) {
        for (int i = 0; i < numLibros; i++) {
            Libro l = catalogo[i];
            if (l != null && l.activo && l.titulo.equalsIgnoreCase(titulo))
                return l;
        }
        return null;
    }

    public void listarCatalogo() {
        System.out.println("\n--- Catálogo (activos) ---");
        System.out.printf("%-8s | %-30s | %-20s | %-5s | %s\n", "Código", "Título", "Autor", "Stock", "Distribución");
        for (int i = 0; i < numLibros; i++) {
            Libro l = catalogo[i];
            if (l != null && l.activo) {
                System.out.printf("%-8d | %-30s | %-20s | %-5d | ", l.codigo, trunc(l.titulo, 30), trunc(l.autor, 20),
                        l.stock);
                imprimirDistribucion(i);
            }
        }
    }

    private String trunc(String s, int n) {
        if (s == null)
            return "";
        if (s.length() <= n)
            return s;
        return s.substring(0, n - 1) + "…";
    }

    private void imprimirDistribucion(int idx) {
        System.out.print("[");
        for (int s = 0; s < NUM_SUCURSALES; s++) {
            System.out.print(disponibilidad[idx][s]);
            if (s < NUM_SUCURSALES - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Actualización de stock + distribución: O(1) + O(S)
    public boolean actualizarStockYDisponibilidad(int codigo, int nuevoStock, int[] nuevaDist) {
        int idx = indicePorCodigo(codigo);
        if (idx < 0) {
            System.out.println("Código inexistente.");
            return false;
        }
        Libro l = catalogo[idx];
        if (!l.activo) {
            System.out.println("Libro inactivo.");
            return false;
        }
        if (nuevoStock < 0) {
            System.out.println("Stock inválido.");
            return false;
        }
        int suma = 0;
        if (nuevaDist != null) {
            if (nuevaDist.length != NUM_SUCURSALES) {
                System.out.println("Distribución inválida.");
                return false;
            }
            for (int s = 0; s < NUM_SUCURSALES; s++) {
                if (nuevaDist[s] < 0) {
                    System.out.println("Valores negativos no permitidos.");
                    return false;
                }
                suma += nuevaDist[s];
            }
            if (suma != nuevoStock) {
                System.out.println("La suma por sucursales debe igualar el stock.");
                return false;
            }
            for (int s = 0; s < NUM_SUCURSALES; s++)
                disponibilidad[idx][s] = nuevaDist[s];
        } else {
            for (int s = 0; s < NUM_SUCURSALES; s++)
                disponibilidad[idx][s] = 0;
            disponibilidad[idx][0] = nuevoStock;
        }
        l.stock = nuevoStock;
        historial.add(TipoOperacion.ALTA, "Actualización stock libro #" + codigo + " = " + nuevoStock);
        return true;
    }

    // === Préstamos ===
    public boolean prestarLibro(int codigoLibro, String usuario) {
        int idx = indicePorCodigo(codigoLibro);
        if (idx < 0) {
            System.out.println("Código inexistente.");
            return false;
        }
        Libro l = catalogo[idx];
        if (!l.activo) {
            System.out.println("Libro inactivo.");
            return false;
        }
        if (l.stock <= 0) {
            System.out.println("Sin stock disponible.");
            return false;
        }

        // reducir de la primera sucursal con disponibilidad
        for (int s = 0; s < NUM_SUCURSALES; s++) {
            if (disponibilidad[idx][s] > 0) {
                disponibilidad[idx][s]--;
                break;
            }
        }
        l.stock--;
        prestamos.insertarAlFinal(new Prestamo(codigoLibro, usuario, LocalDate.now()));
        historial.add(TipoOperacion.PRESTAMO, "Préstamo libro #" + codigoLibro + " a '" + usuario + "'");
        return true;
    }

    public boolean devolverLibro(int codigoLibro, String usuario) {
        boolean ok = prestamos.marcarDevueltoYRemover(codigoLibro, usuario);
        if (!ok) {
            System.out.println("No se encontró el préstamo activo.");
            return false;
        }
        int idx = indicePorCodigo(codigoLibro);
        if (idx >= 0 && catalogo[idx].activo) {
            // sumar a sucursal 0 por simplicidad (se podría solicitar sucursal)
            disponibilidad[idx][0]++;
            catalogo[idx].stock++;
        }
        historial.add(TipoOperacion.DEVOLUCION, "Devolución libro #" + codigoLibro + " de '" + usuario + "'");
        return true;
    }

    public void listarPrestamos() {
        prestamos.imprimir();
    }

    public void listarHistorialAdelante() {
        historial.recorrerAdelante();
    }

    public void listarHistorialAtras() {
        historial.recorrerAtras();
    }

    // Carga de datos demo opcional
    public void cargarDemo() {
        altaLibro(1001, "Estructuras de Datos", "A. Knuth", 5, new int[] { 2, 2, 1 });
        altaLibro(1005, "Algoritmos", "S. Dasgupta", 3, new int[] { 1, 1, 1 });
        altaLibro(1003, "Java Básico", "J. Gosling", 4, new int[] { 0, 2, 2 });
    }
}

// ====== INTERFAZ DE CONSOLA ======\
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BibliotecaU1 biblioteca = new BibliotecaU1();
        biblioteca.cargarDemo(); // opcional para pruebas rápidas

        boolean salir = false;
        while (!salir) {
            menu();
            int opcion = leerEntero("Seleccione opción: ");
            switch (opcion) {
                case 1 -> altaLibroUI(biblioteca);
                case 2 -> bajaLibroUI(biblioteca);
                case 3 -> buscarPorTituloUI(biblioteca);
                case 4 -> prestarUI(biblioteca);
                case 5 -> devolverUI(biblioteca);
                case 6 -> biblioteca.listarCatalogo();
                case 7 -> biblioteca.listarPrestamos();
                case 8 -> biblioteca.listarHistorialAdelante();
                case 9 -> biblioteca.listarHistorialAtras();
                case 0 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        }
    }

    private static void menu() {
        System.out.println("\n===== Biblioteca U1 =====");
        System.out.println("1) Alta de libro");
        System.out.println("2) Baja lógica por código");
        System.out.println("3) Buscar por título");
        System.out.println("4) Prestar libro");
        System.out.println("5) Devolver libro");
        System.out.println("6) Listar catálogo");
        System.out.println("7) Listar préstamos activos");
        System.out.println("8) Historial adelante");
        System.out.println("9) Historial atrás");
        System.out.println("0) Salir");
    }

    private static void altaLibroUI(BibliotecaU1 biblioteca) {
        int codigo = leerEntero("Código: ");
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        int stock = leerEntero("Stock total: ");
        int sucursales = BibliotecaU1.NUM_SUCURSALES;
        int[] dist = new int[sucursales];
        int suma = 0;
        for (int i = 0; i < sucursales; i++) {
            dist[i] = leerEntero("Disponibilidad Sucursal " + i + ": ");
            suma += dist[i];
        }
        if (suma != stock)
            System.out.println("Aviso: la suma no coincide; se ajustará si es necesario.");
        boolean ok = biblioteca.altaLibro(codigo, titulo, autor, stock, dist);
        if (ok)
            System.out.println("Alta registrada.");
    }

    private static void bajaLibroUI(BibliotecaU1 biblioteca) {
        int codigo = leerEntero("Código a dar de baja: ");
        if (biblioteca.bajaLogicaPorCodigo(codigo))
            System.out.println("Baja lógica realizada.");
    }

    private static void buscarPorTituloUI(BibliotecaU1 biblioteca) {
        System.out.print("Título exacto: ");
        String titulo = scanner.nextLine().trim();
        Libro l = biblioteca.buscarPorTitulo(titulo);
        if (l == null)
            System.out.println("No encontrado.");
        else
            System.out.printf("Encontrado -> Código: %d | Autor: %s | Stock: %d\n", l.codigo, l.autor, l.stock);
    }

    private static void prestarUI(BibliotecaU1 biblioteca) {
        int codigo = leerEntero("Código de libro: ");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine().trim();
        if (biblioteca.prestarLibro(codigo, usuario))
            System.out.println("Préstamo realizado.");
    }

    private static void devolverUI(BibliotecaU1 biblioteca) {
        int codigo = leerEntero("Código de libro: ");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine().trim();
        if (biblioteca.devolverLibro(codigo, usuario))
            System.out.println("Devolución registrada.");
    }

    private static int leerEntero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, intente nuevamente.");
            }
        }
    }
}
