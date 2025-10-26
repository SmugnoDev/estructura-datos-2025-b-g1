package EgDosQueue;

public class DemoSistemaAtencion {
    public static void main(String[] args) {
        SistemaAtencion sistema = new SistemaAtencion();

        System.out.println("🎪 SISTEMA DE ATENCIÓN CON PRIORIDADES");
        System.out.println("=".repeat(50));

        // Simulación: agregar tickets con diferentes prioridades
        System.out.println("\n📥 AGREGANDO TICKETS...");

        // Tickets de alta prioridad (urgentes)
        sistema.agregarTicket("Sistema no inicia", Ticket.Prioridad.ALTA, "Empresa XYZ");
        sistema.agregarTicket("Error crítico en producción", Ticket.Prioridad.ALTA, "Admin Server");

        // Tickets de media prioridad
        sistema.agregarTicket("Consulta sobre funcionalidad", Ticket.Prioridad.MEDIA, "Juan Pérez");
        sistema.agregarTicket("Solicitud de nuevo reporte", Ticket.Prioridad.MEDIA, "María García");

        // Tickets de baja prioridad
        sistema.agregarTicket("Cambio de logo", Ticket.Prioridad.BAJA, "Departamento Marketing");
        sistema.agregarTicket("Pregunta general", Ticket.Prioridad.BAJA, "Carlos López");

        // Mostrar estado inicial
        System.out.println("\n📊 ESTADO INICIAL:");
        sistema.mostrarCola();

        // Proceso de atención
        System.out.println("\n🎯 PROCESO DE ATENCIÓN:");
        while (sistema.hayTicketsPendientes()) {
            sistema.atenderSiguiente();
        }

        System.out.println("\n✅ RESUMEN FINAL:");
        System.out.println("Tickets atendidos: " + sistema.getTicketsAtendidos());
        System.out.println("Tickets pendientes: " + sistema.getTicketsPendientes());
    }
}
