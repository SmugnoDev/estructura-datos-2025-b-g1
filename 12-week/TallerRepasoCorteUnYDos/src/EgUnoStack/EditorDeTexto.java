package EgUnoStack;

import java.util.Stack;

public class EditorDeTexto {

    // Atributos
    private StringBuilder textoActual;
    private Stack<String> pilaDeshacer;
    private Stack<String> pilaRehacer;

    public EditorDeTexto() {
        this.textoActual = new StringBuilder();
        this.pilaDeshacer = new Stack<>();
        this.pilaRehacer = new Stack<>();
        // Guardamos el estado inicial (texto vacío)
        pilaDeshacer.push(textoActual.toString());
    }

    // Método para escribir texto
    public void escribir(String texto) {
        // Limpiar pila de rehacer cuando se realiza una nueva acción
        pilaRehacer.clear();

        // Guardar estado actual antes de modificar
        pilaDeshacer.push(textoActual.toString());

        // Agregar el nuevo texto
        textoActual.append(texto);
    }

    // Método para eliminar texto
    public void eliminar(int cantidad) {
        if (cantidad <= 0 || textoActual.length() == 0)
            return;

        // Limpiar pila de rehacer
        pilaRehacer.clear();

        // Guardar estado actual
        pilaDeshacer.push(textoActual.toString());

        // Eliminar la cantidad especificada
        int inicio = Math.max(0, textoActual.length() - cantidad);
        textoActual.delete(inicio, textoActual.length());
    }

    // Método Deshacer
    public boolean deshacer() {
        if (pilaDeshacer.size() <= 1) {
            return false; // No se puede deshacer más
        }

        // Mover el estado actual a pila de rehacer
        pilaRehacer.push(textoActual.toString());

        // Restaurar estado anterior
        pilaDeshacer.pop(); // Eliminar estado actual
        textoActual = new StringBuilder(pilaDeshacer.peek());

        return true;
    }

    // Método Rehacer
    public boolean rehacer() {
        if (pilaRehacer.isEmpty()) {
            return false; // No hay nada para rehacer
        }

        // Guardar estado actual en pila de deshacer
        pilaDeshacer.push(textoActual.toString());

        // Restaurar estado de rehacer
        textoActual = new StringBuilder(pilaRehacer.pop());

        return true;
    }

    // Método para obtener el texto actual
    public String getTexto() {
        return textoActual.toString();
    }

    // Método para mostrar el estado de las pilas (útil para debugging)
    public void mostrarEstadoPilas() {
        System.out.println("Texto actual: \"" + textoActual + "\"");
        System.out.println("Pila Deshacer: " + pilaDeshacer);
        System.out.println("Pila Rehacer: " + pilaRehacer);
        System.out.println("---");
    }
}