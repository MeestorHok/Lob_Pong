import java.awt.Color;
import java.awt.Graphics;

class Paddle {
    private static final int SPEED = 50;
    private static final int STEPS = 10;
    private static final int STEP_SIZE = SPEED / STEPS;
    private static final int HEIGHT = 10;
    private static final int STARTING_WIDTH = 140;
    private static final double DIFFICULTY_FACTOR = 0.75;

    private int startingX;
    private int width;
    private int y;
    private int x;
    private int bufferedX;

    Paddle(int x, int y) {
        this.x = bufferedX = startingX = x;
        this.y = y;

        width = STARTING_WIDTH;
    }

    // true is right, false is left
    void updatePosition(boolean direction, int canvasWidth) {
        int newX = x + (SPEED * (direction ? 1 : -1));
        updatePosition(newX, canvasWidth);
    }

    // Reposition paddle
    void updatePosition(int newX, int canvasWidth) {
        // Constrain to within frame
        x = Math.max(width / 2, Math.min(canvasWidth - (width / 2), newX));
    }

    // Put paddle back at center
    void resetPosition() {
        x = bufferedX = startingX;
    }

    // make the width a little smaller after each round
    void shrink() {
        width = (int) Math.round(width * DIFFICULTY_FACTOR);
    }

    // Draw paddle onto canvas
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(bufferedX - (width / 2), y, width, HEIGHT);

        // animate toward x position
        if (bufferedX < x - STEP_SIZE) {
            bufferedX += STEP_SIZE;
        } else if (bufferedX > x + STEP_SIZE) {
            bufferedX -= STEP_SIZE;
        }
    }
}
