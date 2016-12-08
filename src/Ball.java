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
    void updatePosition(PhysicsEngine physics, int canvasWidth, int canvasHeight) {
        x = Math.max(0, Math.min(canvasWidth - DIAMETER, physics.getX(x))); // keep within right boundary
        y = Math.max(0, physics.getY(y)); // don't let it pass the top

        physics.checkCollision(x, y, canvasWidth, canvasHeight, DIAMETER, null);
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
