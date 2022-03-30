import java.io.IOException;

public class AddCommand implements Command {
    Item item;

    public AddCommand(Item item) {
        this.item = item;
    }

    @Override
    public void implementCommand(Catalog catalog) throws IOException {
        catalog.getItems().add(item);
    }
}
