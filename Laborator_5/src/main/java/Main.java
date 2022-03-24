import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        try {
            Catalog catalog = new Catalog("MyRefs");
            var book = new Book("knuth67", "The Art of Computer Programming", "D:\\test\\book.txt", 1967, "Donald E. Knuth");
            var article = new Article("java17", "The Java Language Specification", "D:\\test\\article.txt", 2021, "James Gosling & others");
            catalog.add(book);
            catalog.add(article);
            System.out.println(catalog);
            CatalogUtil.save(catalog, "D:\\test\\catalog.json");
        } catch (IOException | InvalidYearException e) {
            System.out.println(e);
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("D:\\test\\catalog.json");
            System.out.println(catalog);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}