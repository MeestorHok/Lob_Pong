public class GameEngine {
    Canvas canvas;
    GameManager manager;
    PhysicsEngine physics;

    public GameEngine() {
        canvas = new Canvas();
        manager = new GameManager();
        physics = new PhysicsEngine();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
