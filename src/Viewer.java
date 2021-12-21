import javax.swing.*;
import java.awt.*;

public class Viewer {

    private final Canvas canvas;
    private final JFrame frame;

    public Viewer() {
        Controller controller = new Controller(this);

        Model model = controller.getModel();
        canvas = new Canvas(model);
        canvas.setBackground(Color.black);

        JMenuItem level1 = new JMenuItem("Level 1");
        level1.addActionListener(controller);
        level1.setActionCommand("1");
        JMenuItem level2 = new JMenuItem("Level 2");
        level2.addActionListener(controller);
        level2.setActionCommand("2");
        JMenuItem level3 = new JMenuItem("Level 3");
        level3.addActionListener(controller);
        level3.setActionCommand("3");
        JMenuItem level4 = new JMenuItem("Level 4");
        level4.addActionListener(controller);
        level4.setActionCommand("4");
        JMenuItem level5 = new JMenuItem("Level 5");
        level5.addActionListener(controller);
        level5.setActionCommand("5");
        JMenuItem level6 = new JMenuItem("Level 6");
        level6.addActionListener(controller);
        level6.setActionCommand("6");
        JMenuItem level7 = new JMenuItem("Level 7");
        level7.addActionListener(controller);
        level7.setActionCommand("7");
        JMenuItem level8 = new JMenuItem("Level 8");
        level8.addActionListener(controller);
        level8.setActionCommand("8");
        JMenuItem level9 = new JMenuItem("Level 9");
        level9.addActionListener(controller);
        level9.setActionCommand("9");
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(controller);
        restart.setActionCommand("Restart");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(controller);
        exit.setActionCommand("Exit");

        JMenu levelMenu = new JMenu("Levels");
        JMenu menu = new JMenu("Menu");
        levelMenu.add(level1);
        levelMenu.add(level2);
        levelMenu.add(level3);
        levelMenu.add(level4);
        levelMenu.add(level5);
        levelMenu.add(level6);
        levelMenu.add(level7);
        levelMenu.add(level8);
        levelMenu.add(level9);
        menu.add(restart);
        menu.add(exit);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(levelMenu);

        frame = new JFrame("Sokoban Game MVC Pattern");
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.add("Center", canvas);
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update() {
        canvas.repaint();
    }

    public boolean showDialogWon() {
        JOptionPane.showMessageDialog(frame, "You are won!!!");
        return true;
    }


}
