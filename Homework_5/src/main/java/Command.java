import java.io.IOException;

public interface Command {
    void implementCommand(Catalog catalog) throws IOException;
}
