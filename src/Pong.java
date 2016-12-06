import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class Pong extends JFrame {
    private Pong() {
        setTitle("Lob Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        add(new GameEngine().getCanvas(), BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args) {
        new Pong().setVisible(true);
    }
}
