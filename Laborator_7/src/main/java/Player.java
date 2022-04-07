import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Tile tile : extracted)
            stringBuilder.append(tile.getLetter());
        String word = stringBuilder.toString();
        game.getBoard().addWord(this, word);
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void run() {
        do {
            running = submitWord();
        } while (running);
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}