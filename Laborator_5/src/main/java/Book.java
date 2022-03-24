import java.io.FileNotFoundException;

public class Book extends Item {
    public Book(String id, String title, String location, int year, String author) throws InvalidYearException, FileNotFoundException {
        super(id, title, location, year, author);
    }
}
