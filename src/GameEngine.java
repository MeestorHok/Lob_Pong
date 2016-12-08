import exceptions.RoundCompleteException;

import javax.swing.Timer;
import java.awt.Graphics;

class GameEngine {
    private Canvas canvas;
    private GameManager manager;
    private PhysicsEngine physics;
    private Timer aTimer;
    private boolean playing;

    private Ball ball;
    private Paddle paddle;

    GameEngine() {
        // Game Managers
        canvas = new Canvas(this);
        manager = new GameManager();
        physics = new PhysicsEngine(this);
    }

    // Start a game
    void start() {
        // Game Components
        int middle = (int) Math.round(canvas.getWidth() / 2.0);
        ball = new Ball(middle, canvas.getHeight() - 100);
        paddle = new Paddle(middle, canvas.getHeight() - 30);
        playing = false;

        // Animation Timer (using lambda expression)
        aTimer = new Timer(10, e -> {
            // If round is over, go to the next one.
            try {
                if (playing) {
                    manager.countdown();
                    ball.updatePosition(physics, canvas.getWidth(), canvas.getHeight());
                }
            } catch (RoundCompleteException ex) {
                manager.nextRound(true);
                paddle.shrink();
                resetBallAndPaddle();
                playing = false;
            }
            canvas.repaint();
        });

        aTimer.start();
    }

    Canvas getCanvas() {
        return canvas;
    }

    // Check if ball is bouncing on paddle
    boolean isAtPaddlePosition(int x) {
        return paddle.isColliding(x);
    }

    // allow user to move the paddle either via left-right keys or mouse cursor
    void updatePaddleViaKey(boolean direction) {
        if (playing) {
            paddle.updatePosition(direction, canvas.getWidth());
        }
    }
    void updatePaddleViaMouse(int x) {
        if (playing) {
            paddle.updatePosition(x, canvas.getWidth());
        }
    }

    // Lose a life
    void loseLife() {
        manager.loseLife();

        if(manager.hasLives()) {
            manager.nextRound(false);
            resetBallAndPaddle();
        }

        manager.stop();
        playing = false;
    }

    void addPoints() {
        manager.hitBonus();
    }

    // Start round
    void startRound() {
        playing = true;
        manager.start();
    }

    // Reset positions for begininning of round
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
        //
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
