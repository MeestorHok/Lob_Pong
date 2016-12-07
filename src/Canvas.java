import javax.swing.JComponent;
import java.awt.*;

class Canvas extends JComponent {
    private GameEngine engine;
    private InputManager input;

    Canvas(GameEngine engine) {
        this.engine = engine;
        this.input = new InputManager(engine);

        addMouseMotionListener(input);
        addKeyListener(input);
        setFocusable(true);

        setPreferredSize(new Dimension(850, 500));
    }

    public void paintComponent(Graphics g) {
        // Scene Elements
        engine.drawBall(g);
        engine.drawPaddle(g);
        engine.drawObstacles(g);

        // GUI
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        engine.drawTimer(g);
        engine.drawRound(g);
        engine.drawScore(g);
        engine.drawLives(g);
    }
}
