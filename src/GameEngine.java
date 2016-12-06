import javax.swing.Timer;
import java.awt.Graphics;

class GameEngine {
    private Canvas canvas;
    private GameManager manager;
    private PhysicsEngine physics;
    private Timer aTimer;

    private Ball ball;
    private Paddle paddle;

    private GameEngine() {
        // Game Managers
        canvas = new Canvas(this);
        manager = new GameManager();
        physics = new PhysicsEngine();

        // Game Components
        int middle = (int) Math.round(canvas.getWidth() / 2.0);
        ball = new Ball(middle, canvas.getHeight() - 15);
        paddle = new Paddle(middle, canvas.getHeight() - 10);

        // Animation Timer (using lambda expression)
        aTimer = new Timer(100, e -> {
            ball.updatePosition(physics.getBallX(), physics.getBallY());
            canvas.repaint();
        });

        aTimer.start();
    }

    Canvas getCanvas() {
        return canvas;
    }

    void drawBall(Graphics g) {
        ball.draw(g);
    }

    void updatePaddle(int x) {
        paddle.updatePosition(x, canvas.getWidth());
    }

    void drawPaddle(Graphics g) {
        paddle.draw(g);
    }
}
