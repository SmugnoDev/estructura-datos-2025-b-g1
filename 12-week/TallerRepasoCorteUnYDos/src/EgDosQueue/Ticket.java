package EgDosQueue;

// Clase que representa un ticket de atención
public class Ticket implements Comparable<Ticket> {
    private int id;
    private String descripcion;
    private Prioridad prioridad;
    private String cliente;
    private int ordenLlegada;
    private static int contador = 1;

    public enum Prioridad {
        ALTA(1), MEDIA(2), BAJA(3);

        private final int valor;

        Prioridad(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    public Ticket(String descripcion, Prioridad prioridad, String cliente) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.cliente = cliente;
        this.ordenLlegada = contador;
    }

    // Implementación de compareTo para ordenamiento natural por prioridad
    @Override
    public int compareTo(Ticket otro) {
        // Primero por prioridad (valor más bajo = mayor prioridad)
        int comparacionPrioridad = Integer.compare(this.prioridad.getValor(),
                otro.prioridad.getValor());

        // Si tienen la misma prioridad, por orden de llegada
        if (comparacionPrioridad == 0) {
            return Integer.compare(this.ordenLlegada, otro.ordenLlegada);
        }

        return comparacionPrioridad;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return String.format("Ticket #%d [%s] - %s - Cliente: %s",
                id, prioridad, descripcion, cliente);
    }
}
