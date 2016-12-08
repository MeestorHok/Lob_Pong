import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class InputManager implements MouseMotionListener, KeyListener {
    private GameEngine engine;

    InputManager(GameEngine engine) {
        this.engine = engine;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // Move left or right with arrow keys
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                engine.startRound();
                break;
            case KeyEvent.VK_LEFT:
                engine.updatePaddleViaKey(false);
                break;
            case KeyEvent.VK_RIGHT:
                engine.updatePaddleViaKey(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        // Get the position of the mouse
        engine.updatePaddleViaMouse(e.getX());
    }
}
