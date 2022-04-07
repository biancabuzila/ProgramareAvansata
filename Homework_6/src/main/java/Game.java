import org.jgrapht.Graph;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.alg.util.Triple;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel {
    private Graph<Pair<Integer, Integer>, DefaultEdge> board = new SimpleGraph<>(DefaultEdge.class);
    private List<Triple<Integer, Integer, Integer>> coloredStones = new ArrayList<>(); //0-BLUE, 1-RED
    private int turn = 0;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private int stoneSize;

    public Game(int padX, int padY, int cellWidth, int cellHeight, int stoneSize) {
        init(padX, padY, cellWidth, cellHeight, stoneSize);
    }

    private void init(int padX, int padY, int cellWidth, int cellHeight, int stoneSize) {
        this.padX = padX;
        this.padY = padY;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.stoneSize = stoneSize;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                paintStone(e.getX(), e.getY(), turn, g);
                repaint();
            }
        });
    }

    private void paintStone(int x, int y, int color, Graphics2D g) {
        if (color % 2 == 0) g.setColor(Color.BLUE);
        else g.setColor(Color.RED);
        g.fillOval(padX + x * cellWidth - stoneSize / 2, padY + y * cellHeight - stoneSize / 2, stoneSize, stoneSize);
    }

    public Graph<Pair<Integer, Integer>, DefaultEdge> getBoard() {
        return board;
    }

    public List<Triple<Integer, Integer, Integer>> getColoredStones() {
        return coloredStones;
    }
}