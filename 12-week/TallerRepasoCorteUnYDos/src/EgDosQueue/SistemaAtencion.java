package EgDosQueue;

import java.util.PriorityQueue;

public class SistemaAtencion {
    private PriorityQueue<Ticket> colaPrioridad;
    private int ticketsAtendidos;

    public SistemaAtencion() {
        // Usamos PriorityQueue que ordena automáticamente por prioridad
        this.colaPrioridad = new PriorityQueue<>();
        this.ticketsAtendidos = 0;
    }

    // Método para agregar un ticket
    public void agregarTicket(String descripcion, Ticket.Prioridad prioridad, String cliente) {
        Ticket nuevoTicket = new Ticket(descripcion, prioridad, cliente);
        colaPrioridad.offer(nuevoTicket);
        System.out.println("✅ Ticket agregado: " + nuevoTicket);
    }

    // Método para atender el siguiente ticket (el de mayor prioridad)
    public Ticket atenderSiguiente() {
        if (colaPrioridad.isEmpty()) {
            System.out.println("⚠️  No hay tickets en espera");
            return null;
        }

        Ticket ticketAtendido = colaPrioridad.poll();
        ticketsAtendidos++;

        System.out.println("🎯 Atendiendo: " + ticketAtendido);
        System.out.println("📊 Tickets pendientes: " + colaPrioridad.size());

        return ticketAtendido;
    }

    // Método para ver el próximo ticket sin eliminarlo
    public Ticket verProximoTicket() {
        if (colaPrioridad.isEmpty()) {
            System.out.println("No hay tickets en espera");
            return null;
        }

        Ticket proximo = colaPrioridad.peek();
        System.out.println("👀 Próximo ticket: " + proximo);
        return proximo;
    }

    // Método para mostrar todos los tickets en cola
    public void mostrarCola() {
        if (colaPrioridad.isEmpty()) {
            System.out.println("📭 La cola está vacía");
            return;
        }

        System.out.println("\n📋 TICKETS EN COLA (" + colaPrioridad.size() + "):");
        System.out.println("=".repeat(50));

        // Creamos una copia para no modificar la cola original
        PriorityQueue<Ticket> copia = new PriorityQueue<>(colaPrioridad);
        int posicion = 1;

        while (!copia.isEmpty()) {
            System.out.println(posicion + ". " + copia.poll());
            posicion++;
        }
        System.out.println("=".repeat(50));
    }

    // Métodos de utilidad
    public int getTicketsPendientes() {
        return colaPrioridad.size();
    }

    public int getTicketsAtendidos() {
        return ticketsAtendidos;
    }

    public boolean hayTicketsPendientes() {
        return !colaPrioridad.isEmpty();
    }
}