// Se utiliza el castellano para evitar conflictos
class Nodo {
    String dato;
    Nodo siguiente;

    public Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Simulación de lista de espera en un consultorio usando lista enlazada simple
class ListaEspera {
    private Nodo cabeza;
    private Nodo cola; // optimizamos para O(1) en inserción al final

    // Insertar paciente al final (cuando llega a la lista de espera)
    public void agregarPaciente(String nombre) {
        Nodo nuevo = new Nodo(nombre);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        System.out.println("Paciente agregado: " + nombre);
    }

    // Atender paciente (eliminar al inicio)
    public String atenderPaciente() {
        if (cabeza == null) {
            System.out.println("No hay pacientes en espera.");
            return null;
        }
        String nombre = cabeza.dato;
        cabeza = cabeza.siguiente;
        if (cabeza == null) cola = null; // si la lista queda vacía
        System.out.println("Atendiendo a: " + nombre);
        return nombre;
    }

    // Mostrar lista actual
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("Lista de espera vacía.");
            return;
        }
        Nodo temp = cabeza;
        System.out.print("Lista de espera: ");
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}

public class Ejercicio6 {
    public static void main(String[] args) {
        ListaEspera lista = new ListaEspera();

        // Llegan pacientes
        lista.agregarPaciente("Paciente A");
        lista.agregarPaciente("Paciente B");
        lista.agregarPaciente("Paciente C");
        lista.mostrarLista();

        // Atender pacientes
        lista.atenderPaciente();
        lista.mostrarLista();

        // Llega un nuevo paciente
        lista.agregarPaciente("Paciente D");
        lista.mostrarLista();

        // Atender todos
        lista.atenderPaciente();
        lista.atenderPaciente();
        lista.atenderPaciente(); // lista vacía
        lista.mostrarLista();
    }
}
