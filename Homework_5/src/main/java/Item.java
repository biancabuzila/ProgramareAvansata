import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Calendar;

@JsonSubTypes({@JsonSubTypes.Type(value = Book.class), @JsonSubTypes.Type(value = Article.class)})
public abstract class Item implements Serializable {
    private String id;
    private String title;
    private String location;
    private int year;
    private String author;

    public Item(String id, String title, String location, int year, String author) throws FileNotFoundException, InvalidYearException {
        if (year > Calendar.getInstance().get(Calendar.YEAR))
            throw new InvalidYearException("The year " + year + " did not happen yet.");
        if (!new File(location).exists())
            throw new FileNotFoundException("The location " + location + " is invalid.");
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Item: " +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                '}' + '\n';
    }
}
