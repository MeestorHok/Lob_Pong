import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class Pong extends JFrame {
    GameEngine engine;

    private Pong() {
        setTitle("Lob Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        engine = new GameEngine();
        add(engine.getCanvas(), BorderLayout.CENTER);

        pack();

        engine.start();
    }

    public static void main(String[] args) {
        new Pong().setVisible(true);
    }
}
