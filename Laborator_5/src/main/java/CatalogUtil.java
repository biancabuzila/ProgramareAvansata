import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void save(Catalog catalog, String location) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(location), catalog);
    }

    public static Catalog load(String location) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(location), Catalog.class);
    }
}
