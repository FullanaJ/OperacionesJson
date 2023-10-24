import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 1178, "Fantasy"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310, "Fantasy"));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 223, "Fantasy"));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 251, "Fantasy"));
        books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 317, "Fantasy"));
        Libreria libreria = new Libreria(books);
        Path path = Path.of(".", "src", "main", "resources", "libreria.json");
        Libreria.escribirListaObjetosJson(libreria, path);
        libreria = Libreria.leerArrayObjetosJson(path);
        libreria.getBooks().forEach(System.out::println);
        try {
            libreria.menuInteractivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
