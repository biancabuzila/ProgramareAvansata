import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private JLabel label;
    private JSpinner spinnerRows, spinnerCols;
    private int rows, cols;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        add(label);
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        try {
            spinnerRows.commitEdit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        add(spinnerRows);
        rows = (int) spinnerRows.getValue();
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        try {
            spinnerCols.commitEdit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        add(spinnerCols);
        cols = (int) spinnerCols.getValue();
        JButton createBtn = new JButton("Create");
        add(createBtn);
        createBtn.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent e) {
        rows = (int) spinnerRows.getValue();
        cols = (int) spinnerCols.getValue();
        frame.getConfigPanel().setRows(rows);
        frame.getConfigPanel().setCols(cols);
        frame.remove(frame.getCanvas());
        frame.setCanvas(new DrawingPanel(frame));
        frame.add(frame.getCanvas());
        SwingUtilities.updateComponentTreeUI(frame.getCanvas());
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}