import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MockDictionary implements Dictionary {
    Set<String> words = new HashSet<>();

    public MockDictionary() {
        Path path = Paths.get("C:\\Users\\biian\\Desktop\\lab7\\src\\main\\resources\\dictionary.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> words.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getWords() {
        return words;
    }
}