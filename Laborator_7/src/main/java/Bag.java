import org.jgrapht.alg.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Pair<Tile, Integer>> tiles = new ArrayList<>();

    public Bag() {
        for (char c = 'a'; c <= 'z'; c++) {
            Random random = new Random();
            int points = random.nextInt(10) + 1;
            tiles.add(new Pair<>(new Tile(c, points), 10));
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty())
                break;
            Random random = new Random();
            int tileIndex = random.nextInt(tiles.size());
            tiles.get(tileIndex).setSecond(tiles.get(tileIndex).getSecond() - 1);
            extracted.add(new Tile(tiles.get(tileIndex).getFirst().getLetter(), tiles.get(tileIndex).getFirst().getPoints()));
            if (tiles.get(tileIndex).getSecond() == 0)
                tiles.remove(tileIndex);
        }
        return extracted;
    }
}