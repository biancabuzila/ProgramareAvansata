import java.util.*;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private int score;
    private int requestedTiles;
    private List<Tile> tiles = new ArrayList<>();
    private boolean running;

    public Player(String name) {
        this.name = name;
        requestedTiles = 7;
        score = 0;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(requestedTiles);
        if (extracted.isEmpty()) {
            return false;
        }
        tiles.addAll(extracted);

        Map<Character, Integer> lettersTiles = new HashMap<>();
        Map<Character, Integer> lettersWordDict = new HashMap<>();
        tiles.forEach(tile -> lettersTiles.merge(tile.getLetter(), 1, Integer::sum));
        int ok;

        for (String word : game.getDictionary().getWords()) {
            for (char c : word.toCharArray())
                lettersWordDict.merge(c, 1, Integer::sum);
            ok = 1;
            for (char c : lettersWordDict.keySet())
                if (!lettersTiles.containsKey(c)) {
                    ok = 0;
                    break;
                }
            if (ok == 1)
                for (char c : lettersWordDict.keySet())
                    if (lettersTiles.get(c) < lettersWordDict.get(c)) {
                        ok = 0;
                        break;
                    }
            if (ok == 1) {
                int points = 0;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.toCharArray()[i];
                    Tile aux = tiles.stream().filter(tile -> tile.getLetter() == c).findFirst().get();
                    points += aux.getPoints();
                    tiles.remove(aux);
                }
                score += word.length() * points;
                game.getBoard().addWord(this, word);
                requestedTiles = word.length();
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            } else lettersWordDict.clear();
        }

        requestedTiles = 7;
        tiles.forEach(tile -> game.getBag().addTile(tile));
        tiles.clear();
        return true;
    }

    @Override
    public void run() {
        synchronized (game) {
            while (game.getRounds() != 0)
                if (game.canMove(this)) {
                    if (submitWord())
                        game.setRounds(game.getRounds() - 1);
                    game.setPlayerToMove((game.getPlayerToMove() + 1) % game.getNrPlayers());
                    game.notifyAll();
                } else {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }
}