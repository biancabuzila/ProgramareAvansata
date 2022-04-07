import org.jgrapht.alg.util.Pair;
import org.jgrapht.alg.util.Triple;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private final int canvasWidth = 400, canvasHeight = 400;
    private int rows, cols;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private int stoneSize;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.getConfigPanel().getRows(), frame.getConfigPanel().getCols());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
        paintStones(g);
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.stoneSize = canvasHeight / Math.max(rows, cols) / 2;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = padX + col * cellWidth;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void paintSticks(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(4.0f));
        Random random = new Random();
        int sticks = random.nextInt(rows * (cols - 1) + cols * (rows - 1)) + 1;
        for (int i = 0; i < sticks; i++) {
            int x = random.nextInt(cols);
            int y = random.nextInt(rows);
            frame.getGame().getBoard().addVertex(new Pair<>(x, y));
            int neighbor = random.nextInt(4); //0-up,1-right,2-down,3-left
            if (x == 0 && y == 0) {//left-top corner
                if (neighbor == 0) neighbor = 1;
                else if (neighbor == 3) neighbor = 2;
            } else if (x == cols - 1 && y == 0) { //right-top corner
                if (neighbor == 0) neighbor = 3;
                else if (neighbor == 1) neighbor = 2;
            } else if (x == 0 && y == rows - 1) { //left-bottom corner
                if (neighbor == 2) neighbor = 1;
                else if (neighbor == 3) neighbor = 0;
            } else if (x == cols - 1 && y == rows - 1) { //right-bottom corner
                if (neighbor == 1) neighbor = 0;
                else if (neighbor == 2) neighbor = 3;
            } else if (x == 0) {
                if (neighbor == 3) neighbor = random.nextInt(3);
            } else if (x == cols - 1) {
                while (neighbor == 1) neighbor = random.nextInt(4);
            } else if (y == 0) {
                while (neighbor == 0) neighbor = random.nextInt(4);
            } else if (y == rows - 1) {
                while (neighbor == 2) neighbor = random.nextInt(4);
            }
            switch (neighbor) {
                case 0 -> {
                    g.drawLine(padX + cellWidth * x, padY + cellHeight * y, padX + cellWidth * x, padY + cellHeight * (y - 1));
                    frame.getGame().getBoard().addVertex(new Pair<>(x, y - 1));
                    frame.getGame().getBoard().addEdge(new Pair<>(x, y), new Pair<>(x, y - 1));
                }
                case 1 -> {
                    g.drawLine(padX + cellWidth * x, padY + cellHeight * y, padX + cellWidth * (x + 1), padY + cellHeight * y);
                    frame.getGame().getBoard().addVertex(new Pair<>(x + 1, y));
                    frame.getGame().getBoard().addEdge(new Pair<>(x, y), new Pair<>(x + 1, y));
                }
                case 2 -> {
                    g.drawLine(padX + cellWidth * x, padY + cellHeight * y, padX + cellWidth * x, padY + cellHeight * (y + 1));
                    frame.getGame().getBoard().addVertex(new Pair<>(x, y + 1));
                    frame.getGame().getBoard().addEdge(new Pair<>(x, y), new Pair<>(x, y + 1));
                }
                case 3 -> {
                    g.drawLine(padX + cellWidth * x, padY + cellHeight * y, padX + cellWidth * (x - 1), padY + cellHeight * y);
                    frame.getGame().getBoard().addVertex(new Pair<>(x - 1, y));
                    frame.getGame().getBoard().addEdge(new Pair<>(x, y), new Pair<>(x - 1, y));
                }
            }
        }
    }

    private void paintStones(Graphics2D g) {
        Random random = new Random();
        int stones = random.nextInt((rows * cols) / 2) + 1;
        for (int i = 0; i < stones; i++) {
            if (i % 2 == 0) g.setColor(Color.BLUE);
            else g.setColor(Color.RED);
            int x = random.nextInt(cols);
            int y = random.nextInt(rows);
            frame.getGame().getColoredStones().add(new Triple<>(x, y, i % 2));
            g.fillOval(padX + x * cellWidth - stoneSize / 2, padY + y * cellHeight - stoneSize / 2, stoneSize, stoneSize);
        }
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public int getPadX() {
        return padX;
    }

    public int getPadY() {
        return padY;
    }

    public int getStoneSize() {
        return stoneSize;
    }
}