import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
    private String location;

    public LoadCommand(String location) {
        this.location = location;
    }

    @Override
    public void implementCommand(Catalog catalog) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        catalog = objectMapper.readValue(new File(location), Catalog.class);
        ListCommand list = new ListCommand();
        list.implementCommand(catalog);
    }
}
