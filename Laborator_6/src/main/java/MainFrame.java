import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        add(configPanel, BorderLayout.NORTH);

        canvas = new DrawingPanel(this);
        add(canvas, BorderLayout.CENTER);

        controlPanel = new ControlPanel(this);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
    }

    public void setCanvas(DrawingPanel canvas) {
        this.canvas = canvas;
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}