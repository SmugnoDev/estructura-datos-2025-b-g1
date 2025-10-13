import java.util.Scanner;

public class Ejercicio1 {
    private HashTable<String, String> diccionario;

    public Ejercicio1() {
        diccionario = new HashTable<>();
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== DICCIONARIO USUARIO -> ROL ===");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Consultar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Mostrar todos");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner);
                    break;
                case 2:
                    consultarUsuario(scanner);
                    break;
                case 3:
                    eliminarUsuario(scanner);
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private void agregarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese rol: ");
        String rol = scanner.nextLine();

        String resultado = diccionario.put(usuario, rol);
        if (resultado == null) {
            System.out.println("Usuario agregado exitosamente");
        } else {
            System.out.println("Usuario actualizado. Rol anterior: " + resultado);
        }
    }

    private void consultarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario a consultar: ");
        String usuario = scanner.nextLine();

        String rol = diccionario.get(usuario);
        if (rol != null) {
            System.out.println("Usuario: " + usuario + ", Rol: " + rol);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario a eliminar: ");
        String usuario = scanner.nextLine();

        String rol = diccionario.remove(usuario);
        if (rol != null) {
            System.out.println("Usuario eliminado. Rol: " + rol);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private void mostrarTodos() {
        System.out.println("\n=== TODOS LOS USUARIOS ===");
        for (String usuario : diccionario.keys()) {
            System.out.println("Usuario: " + usuario + ", Rol: " + diccionario.get(usuario));
        }
        System.out.println("Total: " + diccionario.size() + " usuarios");
    }

    public static void main(String[] args) {
        new Ejercicio1().ejecutar();
    }
}
