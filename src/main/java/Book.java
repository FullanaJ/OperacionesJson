import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Book implements Serializable {
    private String title;
    private String author;
    private int yearPublished;
    private int numPages;
    private String genre;

    public Book() {
    }
    public Book(String title, String author, int yearPublished, int numPages, String genre) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.numPages = numPages;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author +
                ", yearPublished=" + yearPublished +
                ", numPages=" + numPages +
                ", genre='" + genre + '\'' +
                '}';
    }
}
