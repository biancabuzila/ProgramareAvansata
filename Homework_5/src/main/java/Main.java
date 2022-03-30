import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.testCreateListSaveReport();
        app.testLoadList();
    }

    private void testCreateListSaveReport() {
        try {
            Catalog catalog = new Catalog("MyRefs");
            var book = new Book("knuth67", "The Art of Computer Programming", "D:\\test\\book.txt", 1967, "Donald E. Knuth");
            var article = new Article("java17", "The Java Language Specification", "D:\\test\\article.txt", 2021, "James Gosling & others");
            List<Command> commandList = new ArrayList<>();
            commandList.add(new AddCommand(book));
            commandList.add(new AddCommand(article));
            commandList.add(new ListCommand());
            commandList.add(new ViewCommand());
            commandList.add(new SaveCommand("D:\\test\\catalog.json"));
            commandList.add((new ReportCommand()));
            for (Command command : commandList)
                command.implementCommand(catalog);
        } catch (IOException | InvalidYearException e) {
            System.out.println(e);
        }
    }

    private void testLoadList() {
        try {
            Command command = new LoadCommand("D:\\test\\catalog.json");
            command.implementCommand(new Catalog("MyRefs"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}