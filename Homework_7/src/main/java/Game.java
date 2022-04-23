import javax.management.timer.Timer;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new MockDictionary();
    private final static List<Player> players = new ArrayList<>();
    private int playerToMove;
    private int rounds = 100;

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        List<Thread> playerThreads = new ArrayList<>();
        for (Player player : players)
            playerThreads.add(new Thread(player));
        playerToMove = 0;
        for (Thread thread : playerThreads)
            thread.start();
        for (Thread thread : playerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();

        int highestScore = 0;
        Player winner = new Player("Winner");
        for (Player player : players)
            if (highestScore < player.getScore()) {
                highestScore = player.getScore();
                winner = player;
            }
        System.out.println("The winner is " + winner.getName() + " with score " + winner.getScore());
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getPlayerToMove() {
        return playerToMove;
    }

    public void setPlayerToMove(int playerToMove) {
        this.playerToMove = playerToMove;
    }

    public boolean canMove(Player player) {
        return players.get(playerToMove) == player;
    }

    public int getNrPlayers() {
        return players.size();
    }
}