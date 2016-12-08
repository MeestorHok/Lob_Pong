class PhysicsEngine {
    private GameEngine engine;
    private int signX = 1;
    private int signY = 1;

    private int angle = 55;
    private double velocity = 3;
//    private double time = 1;

    PhysicsEngine(GameEngine engine) {
        this.engine = engine;
    }

    // Parabolic equations for projectile motion
    int getX(int x) {
//        return x + signX * (int) Math.round(velocity * Math.cos(Math.toRadians(angle)) * time);
        return x + signX * (int) Math.round(velocity * Math.cos(Math.toRadians(angle)));
    }
    int getY(int y) {
//        return y - signY * (int) Math.round(velocity * Math.sin(Math.toRadians(angle)) * time - (0.5 * 9.81 * time * time));
        return y - signY * (int) Math.round(velocity * Math.sin(Math.toRadians(angle)));
    }

    // See if we've collided with anything
    void checkCollision(int currentX, int currentY, int canvasWidth, int canvasHeight, int diameter, Obstacle[] obs) {
        // hit left wall
        if (currentX <= 0) {
            bounce(true);
        }

        // hit right wall
        if (currentX >= canvasWidth - diameter) {
            bounce(true);
        }

        // hit top
        if (currentY <= 0) {
            bounce(false);
        }

        // Bottom: hit paddle or die
        if (currentY >= canvasHeight - 25 - diameter) {
            if (engine.isAtPaddlePosition(currentX)) {
                bounce(false);
                engine.addPoints();
                velocity += 0.3;
            } else {
                engine.loseLife();
            }
        }

        // any obstacles
//        for (Obstacle o : obs) {
//            if (o.isColliding(currentX, currentY, diameter)) {
//                bounce(o.isCollisionVertical(currentX));
//            }
//        }
    }

    // Bounce off a surface (true means bouncing off of a vertical wall)
    private void bounce(boolean vertical) {
        if (vertical) {
            this.signX *= -1;
        } else {
            this.signY *= -1;
        }

//        angle = (180 - angle) % 180;
    }
}
