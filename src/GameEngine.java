import exceptions.RoundCompleteException;

import javax.swing.Timer;
import java.awt.Graphics;

class GameEngine {
    private Canvas canvas;
    private GameManager manager;
    private PhysicsEngine physics;
    private Timer aTimer;

    private Ball ball;
    private Paddle paddle;

    GameEngine() {
        // Game Managers
        canvas = new Canvas(this);
        manager = new GameManager();
        physics = new PhysicsEngine();
    }

    // Start a game
    void start() {
        // Game Components
        int middle = (int) Math.round(canvas.getWidth() / 2.0);
        ball = new Ball(middle, canvas.getHeight() - 45);
        paddle = new Paddle(middle, canvas.getHeight() - 30);

        // Animation Timer (using lambda expression)
        aTimer = new Timer(10, e -> {
            // If round is over, go to the next one.
            try {
                manager.countdown();
            } catch(RoundCompleteException ex) {
                manager.nextRound();
                paddle.shrink();
                //resetBallAndPaddle();
            }

            // ball.updatePosition(physics.getBallX(), physics.getBallY());
            canvas.repaint();
        });

        aTimer.start();
    }

    Canvas getCanvas() {
        return canvas;
    }

    // allow user to move the paddle either via left-right keys or mouse cursor
    void updatePaddleViaKey(boolean direction) {
        paddle.updatePosition(direction, canvas.getWidth());
    }
    void updatePaddleViaMouse(int x) {
        paddle.updatePosition(x, canvas.getWidth());
    }

    private void resetBallAndPaddle() {
        paddle.resetPosition();
        ball.resetPosition();
    }

    // Draw stuff
    void drawBall(Graphics g) {
        ball.draw(g);
    }
    void drawPaddle(Graphics g) {
        paddle.draw(g);
    }
    void drawObstacles(Graphics g) {

    }

    // GUI
    void drawTimer(Graphics g) {
        manager.drawTimer(g, canvas.getWidth());
    }
    void drawRound(Graphics g) {
        manager.drawRound(g, canvas.getWidth());
    }
    void drawScore(Graphics g) {
        manager.drawScore(g);
    }
    void drawLives(Graphics g) {
        manager.drawLives(g);
    }
}
