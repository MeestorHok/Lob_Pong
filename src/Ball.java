import java.awt.Color;
import java.awt.Graphics;

class Ball {
    private static final int DIAMETER = 15;

    private int startingY;
    private int startingX;
    private int x;
    private int y;

    Ball(int x, int y) {
        startingX = x;
        this.x = startingX;

        startingY = y;
        this.y = startingY;
    }

    // move ball to position
    void updatePosition(int x, int y, int canvasWidth) {
        this.x = Math.max(0, Math.min(canvasWidth - DIAMETER, x)); // keep within right boundary
        this.y = Math.max(0, y); // don't let it pass the top
    }

    // put ball back at center
    void resetPosition() {
        x = startingX;
        y = startingY;
    }

    // Draw ball onto canvas
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
}
