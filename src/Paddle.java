import java.awt.Color;
import java.awt.Graphics;

class Paddle {
    private static final int SPEED = 50;
    private static final int STEPS = 10;
    private static final int STEP_SIZE = SPEED / STEPS;
    private static final int HEIGHT = 10;
    private static final int WIDTH = 100;

    private int startingX;
    private int y;
    private int x;
    private int bufferedX;

    Paddle(int x, int y) {
        this.x = bufferedX = startingX = x;

        this.y = y;
    }

    // true is right, false is left
    void updatePosition(boolean direction, int canvasWidth) {
        int newX = x + (SPEED * (direction ? 1 : -1));
        updatePosition(newX, canvasWidth);
    }

    // Reposition paddle
    void updatePosition(int newX, int canvasWidth) {
        // Constrain to within frame
        x = Math.max(WIDTH / 2, Math.min(canvasWidth - (WIDTH / 2), newX));
    }

    // Put paddle back at center
    void resetPosition() {
        x = bufferedX = startingX;
    }

    // Draw paddle onto canvas
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        //System.out.println((x-(WIDTH / 2)) + " " + y);
        g.fillRect(bufferedX - (WIDTH / 2), y, WIDTH, HEIGHT);

        // animate toward x position
        if (bufferedX < x - STEP_SIZE) {
            bufferedX += STEP_SIZE;
        } else if (bufferedX > x + STEP_SIZE) {
            bufferedX -= STEP_SIZE;
        }
    }
}
