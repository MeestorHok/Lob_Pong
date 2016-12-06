import java.awt.Graphics;

class Ball {
    private static final int RADIUS = 5;

    private int x;
    private int y;

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Graphics g) {
        g.fillOval(x, y, RADIUS, RADIUS);
    }
}
