public class ListCommand implements Command {
    @Override
    public void implementCommand(Catalog catalog) {
        System.out.println("The catalog " + catalog.getName() + ":");
        for (Item item : catalog.getItems()) {
            if (item instanceof Book)
                System.out.print("The book: ");
            else if (item instanceof Article)
                System.out.print("The article: ");
            System.out.println("title: " + item.getTitle() + "author: " + item.getAuthor() + "year: " + item.getYear());
        }
    }
}
