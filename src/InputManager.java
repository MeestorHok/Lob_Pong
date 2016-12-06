import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class InputManager implements MouseMotionListener, KeyListener {
    GameEngine engine;

    InputManager(GameEngine engine) {
        this.engine = engine;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle input
        int x = 0;

        movePaddle(x);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        // Handle input
        int x = 0;

        movePaddle(x);
    }

    void movePaddle(int x) {
        engine.updatePaddle(x);
    }
}
