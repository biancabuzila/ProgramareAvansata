import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    @Override
    public void implementCommand(Catalog catalog) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        for (Item item : catalog.getItems())
            desktop.open(new File(item.getLocation()));
    }
}
