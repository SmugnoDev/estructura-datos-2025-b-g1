package EgTresTablaHash;

public class DemoUsuarios {
    public static void main(String[] args) {
        GestionUsuarios gestion = new GestionUsuarios();

        System.out.println("👥 SISTEMA DE GESTIÓN DE USUARIOS");
        System.out.println("=".repeat(40));

        // Agregar usuarios
        gestion.agregarUsuario("001", "Ana García", "ana@email.com");
        gestion.agregarUsuario("002", "Carlos López", "carlos@email.com");
        gestion.agregarUsuario("003", "María Rodríguez", "maria@email.com");

        // Intentar agregar usuario con ID duplicado
        gestion.agregarUsuario("001", "Pedro Martínez", "pedro@email.com");

        // Mostrar todos los usuarios
        gestion.mostrarTodosLosUsuarios();

        // Buscar usuarios
        gestion.buscarUsuario("002");
        gestion.buscarUsuario("999"); // No existe

        // Eliminar usuario
        gestion.eliminarUsuario("003");

        // Mostrar estado final
        gestion.mostrarTodosLosUsuarios();
        System.out.println("Total de usuarios: " + gestion.totalUsuarios());
    }
}
