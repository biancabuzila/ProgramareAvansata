import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;

public class ReportCommand implements Command {

    @Override
    public void implementCommand(Catalog catalog) throws IOException {
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File(Main.class.getResource("/templates").toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Template template = configuration.getTemplate("catalog.ftl");
        Writer writer = new OutputStreamWriter(System.out);
        try {
            template.process(catalog, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
