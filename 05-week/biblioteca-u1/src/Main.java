import java.util.Scanner;
import model.Catalog;
import model.Book;

public class Main {

    public static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú de Gestión de Biblioteca ---");
        System.out.println("1. Agregar un libro");
        System.out.println("2. Buscar un libro");
        System.out.println("3. Prestar un libro");
        System.out.println("4. Devolver un libro");
        System.out.println("5. Lista de prestamos");
        System.out.println("6. Historial bibliotecario");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static Book readDataBook(Scanner scanner) {
        System.out.print("Ingrese el código del libro: ");
        String code = scanner.nextLine();
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String author = scanner.nextLine();
        System.out.print("Ingrese el stock inicial: ");
        int stock = Integer.parseInt(scanner.nextLine());
        return new Book(code, title, author, stock);
    }

    public static class Library {
        private Catalog catalog;

        public Library() {
            this.catalog = new Catalog();
        }

        public boolean addBook(Book book) {
            return catalog.addBook(book);
        }

        public Book searchBook(String code) {
            return catalog.searchBook(code);
        }

        public boolean lendBook(String code) {
            return false;
        }

    }

    public static void main(String[] args) {

        // Inicio del sistema de gestion
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean exit = false;

        // Bucle principal
        while (!exit) {
            mostrarMenuPrincipal();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Lógica para agregar un libro
                    if (library.addBook(readDataBook(scanner))) {
                        System.out.println("Libro agregado exitosamente.");
                    } else {
                        System.out.println("No se pudo agregar el libro.");
                    }
                    break;
                case 2:
                    // Lógica para buscar un libro
                    System.out.println("Ingrese el código del libro a buscar: ");
                    String code = scanner.nextLine();
                    Book foundBook = library.searchBook(code);
                    if (foundBook != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println("Código: " + foundBook.getCode());
                        System.out.println("Título: " + foundBook.getTitle());
                        System.out.println("Autor: " + foundBook.getAuthor());
                        System.out.println("Stock: " + foundBook.getStock());
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    // Lógica para prestar un libro
                default:
                    System.out.println("Saliendo del sistema...");
                    exit = true;
                    break;
            }
        }
        scanner.close();

    }
}
