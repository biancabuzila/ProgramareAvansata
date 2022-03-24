import java.io.FileNotFoundException;

public class Article extends Item {
    public Article(String id, String title, String location, int year, String author) throws InvalidYearException, FileNotFoundException {
        super(id, title, location, year, author);
    }
}
