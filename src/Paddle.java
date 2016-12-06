import java.awt.Graphics;

class Paddle {
    private static final int HEIGHT = 5;
    private static final int WIDTH = 50;

    private int y;
    private int x;

    Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void updatePosition(int newX, int canvasWidth) {
        // Constrain to within frame
        newX = Math.max(WIDTH / 2, Math.min(canvasWidth - (WIDTH / 2), newX));

        x = newX;
    }

    void draw(Graphics g) {
        g.fillRect(x - (WIDTH / 2), y, WIDTH, HEIGHT);
    }
}
