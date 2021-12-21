import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, ActionListener {

    private final Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;
            default:
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Restart":
                model.restart();
                break;
            case "Exit":
                model.exit();
                break;
            case "1":
                model.setLevel(1);
                break;
            case "2":
                model.setLevel(2);
                break;
            case "3":
                model.setLevel(3);
                break;
            case "4":
                model.setLevel(4);
                break;
            case "5":
                model.setLevel(5);
                break;
            case "6":
                model.setLevel(6);
                break;
            case "7":
                model.setLevel(7);
                break;
            case "8":
                model.setLevel(8);
                break;
            case "9":
                model.setLevel(9);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    public Model getModel() {
        return model;
    }
}
