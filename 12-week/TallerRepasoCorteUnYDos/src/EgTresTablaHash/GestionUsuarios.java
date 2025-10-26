package EgTresTablaHash;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    private HashMap<String, Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new HashMap<>();
    }

    // Clase interna Usuario
    static class Usuario {
        private String id;
        private String nombre;
        private String email;

        public Usuario(String id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
        }

        // Getters
        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return String.format("ID: %s | Nombre: %s | Email: %s", id, nombre, email);
        }
    }

    // Método para agregar usuario
    public boolean agregarUsuario(String id, String nombre, String email) {
        if (usuarios.containsKey(id)) {
            System.out.println("❌ Ya existe un usuario con ID: " + id);
            return false;
        }

        Usuario nuevoUsuario = new Usuario(id, nombre, email);
        usuarios.put(id, nuevoUsuario);
        System.out.println("✅ Usuario agregado: " + nuevoUsuario);
        return true;
    }

    // Método para buscar usuario por ID
    public Usuario buscarUsuario(String id) {
        Usuario usuario = usuarios.get(id);
        if (usuario != null) {
            System.out.println("🔍 Usuario encontrado: " + usuario);
        } else {
            System.out.println("❌ No se encontró usuario con ID: " + id);
        }
        return usuario;
    }

    // Método para eliminar usuario
    public boolean eliminarUsuario(String id) {
        Usuario eliminado = usuarios.remove(id);
        if (eliminado != null) {
            System.out.println("🗑️  Usuario eliminado: " + eliminado);
            return true;
        } else {
            System.out.println("❌ No se pudo eliminar. Usuario no encontrado: " + id);
            return false;
        }
    }

    // Método para mostrar todos los usuarios
    public void mostrarTodosLosUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("📭 No hay usuarios registrados");
            return;
        }

        System.out.println("\n📋 LISTA DE USUARIOS (" + usuarios.size() + "):");
        System.out.println("=".repeat(50));

        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("=".repeat(50));
    }

    // Método para contar usuarios
    public int totalUsuarios() {
        return usuarios.size();
    }

    // Método para verificar si existe un usuario
    public boolean existeUsuario(String id) {
        return usuarios.containsKey(id);
    }
}
