public class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;

    Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Check if the ball is colliding with this
    boolean isColliding(int ballX, int ballY, int diameter) {
        // if the ball's coordinates are within the bounds, it should collide
        return (ballX <= x + width // right side
                && ballX + diameter >= x // left side
                && ballY <= y + height // bottom
                && ballY + diameter >= y); // top
    }

    // Checks where the ball on the obstacle. True if hitting a side
    boolean isCollisionVertical(int ballX) {
        return (ballX == x + width || ballX == x);
    }
}
