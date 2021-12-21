import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {

    private final Model model;
    private Image imagePlayer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;

    public Canvas(Model model) {
        this.model = model;
        setOpaque(true);

        File fileNameImagePlayer = new File("res/images/player.png");
        File fileNameImageWall = new File("res/images/wall.png");
        File fileNameImageBox = new File("res/images/box.png");
        File fileNameImageGoal = new File("res/images/goal.png");
        try {
            imagePlayer = ImageIO.read(fileNameImagePlayer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        int[][] desktop = model.getDesktop();
        int start = 50;
        int x = start;
        int y = start;
        int width = 64;
        int height = 64;
        int offset = 0;

        for (int[] ints : desktop) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    g.drawImage(imagePlayer, x, y, null);
                } else if (anInt == 2) {
                    g.drawImage(imageWall, x, y, null);
                } else if (anInt == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if (anInt == 4) {
                    g.drawImage(imageGoal, x, y, null);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, width, height);
                }
                x = x + width + offset;
            }
            x = start;
            y = y + height + offset;
        }
    }
}
