import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Setter
@Getter


public class Libreria implements Serializable {
    private List<Book> books;

    public Libreria() {
    }
    public Libreria(List<Book> books) {
        this.books = books;
    }
    public void menuInteractivo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        do {
            menu();
            System.out.println("Introduce una opción: ");
            opcion = Integer.parseInt(reader.readLine());
            switch (opcion) {
                case 1:
                    addBook(createBook());
                    break;
                case 2:
                    System.out.println("Introduce el título o autor: ");
                    String title = reader.readLine();
                    searchFilter(title);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 4);
    }

    private Book createBook() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el título: ");
        String title = reader.readLine();
        System.out.println("Introduce el autor: ");
        String author = reader.readLine();
        System.out.println("Introduce el año de publicación: ");
        int yearPublished = Integer.parseInt(reader.readLine());
        System.out.println("Introduce el número de páginas: ");
        int numPages = Integer.parseInt(reader.readLine());
        System.out.println("Introduce el género: ");
        String genre = reader.readLine();
        return new Book(title, author, yearPublished, numPages, genre);
    }

    public void menu() {
        System.out.println("1. Añadir libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Mostrar libros");
        System.out.println("4. Salir");
    }

    public void addBook(Book book) {
        Set<Book> bookSet = Set.copyOf(books);
        if (bookSet.contains(book)) {
            System.out.println("El libro ya existe");
        } else {
            books.add(book);
        }
    }

    public void searchFilter(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)| book.getAuthor().equals(title)) {
                System.out.println(book);
            }
        }
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static <T> void escribirListaObjetosJson(T lenguajes, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), lenguajes);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static Libreria leerArrayObjetosJson(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(ruta.toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
