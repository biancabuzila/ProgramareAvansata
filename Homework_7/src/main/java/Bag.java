import org.jgrapht.alg.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Pair<Tile, Integer>> tiles = new ArrayList<>();

    public Bag() {
        tiles.add(new Pair<>(new Tile('a', 1), 9));
        tiles.add(new Pair<>(new Tile('b', 3), 2));
        tiles.add(new Pair<>(new Tile('c', 3), 2));
        tiles.add(new Pair<>(new Tile('d', 2), 4));
        tiles.add(new Pair<>(new Tile('e', 1), 12));
        tiles.add(new Pair<>(new Tile('f', 4), 2));
        tiles.add(new Pair<>(new Tile('g', 2), 3));
        tiles.add(new Pair<>(new Tile('h', 4), 2));
        tiles.add(new Pair<>(new Tile('i', 1), 9));
        tiles.add(new Pair<>(new Tile('j', 8), 1));
        tiles.add(new Pair<>(new Tile('k', 5), 1));
        tiles.add(new Pair<>(new Tile('l', 1), 4));
        tiles.add(new Pair<>(new Tile('m', 3), 2));
        tiles.add(new Pair<>(new Tile('n', 1), 6));
        tiles.add(new Pair<>(new Tile('o', 1), 8));
        tiles.add(new Pair<>(new Tile('p', 3), 2));
        tiles.add(new Pair<>(new Tile('q', 10), 1));
        tiles.add(new Pair<>(new Tile('r', 1), 6));
        tiles.add(new Pair<>(new Tile('s', 1), 4));
        tiles.add(new Pair<>(new Tile('t', 1), 6));
        tiles.add(new Pair<>(new Tile('u', 1), 4));
        tiles.add(new Pair<>(new Tile('v', 4), 2));
        tiles.add(new Pair<>(new Tile('w', 4), 2));
        tiles.add(new Pair<>(new Tile('x', 8), 1));
        tiles.add(new Pair<>(new Tile('y', 4), 2));
        tiles.add(new Pair<>(new Tile('z', 10), 1));
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

    public synchronized void addTile(Tile tile) {
        for (int i = 0; i < tiles.size(); i++)
            if (tiles.get(i).getFirst() == tile) {
                tiles.get(i).setSecond(tiles.get(i).getSecond() + 1);
                return;
            }
        tiles.add(new Pair<>(tile, 1));
    }
}