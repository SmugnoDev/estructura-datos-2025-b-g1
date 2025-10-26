package EgUnoStack;

public class DemoEditorTexto {
    public static void main(String[] args) {
        EditorDeTexto editor = new EditorDeTexto();

        System.out.println("=== SIMULACIÓN EDITOR DE TEXTO ===");

        // Escribir texto
        editor.escribir("Hola ");
        editor.mostrarEstadoPilas();

        editor.escribir("mundo");
        editor.mostrarEstadoPilas();

        editor.escribir(" Java!");
        editor.mostrarEstadoPilas();

        // Deshacer
        System.out.println(">>> Deshacer:");
        editor.deshacer();
        editor.mostrarEstadoPilas();

        // Rehacer
        System.out.println(">>> Rehacer:");
        editor.rehacer();
        editor.mostrarEstadoPilas();

        // Eliminar texto
        System.out.println(">>> Eliminar 5 caracteres:");
        editor.eliminar(5);
        editor.mostrarEstadoPilas();

        // Probar múltiples deshacer
        System.out.println(">>> Múltiples deshacer:");
        editor.deshacer();
        editor.mostrarEstadoPilas();

        editor.deshacer();
        editor.mostrarEstadoPilas();

        editor.deshacer();
        editor.mostrarEstadoPilas();

        // Intentar deshacer más de lo posible
        if (!editor.deshacer()) {
            System.out.println("No se puede deshacer más");
        }
    }
}
