import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Mole extends MouseAdapter {

    private BufferedImage moleImage;
    private final int IMAGE_SIZE = 190;
    private int currentPositionX = 0;
    private int currentPositionY = 0;
    private Game game;

    public Mole(Game game) {

        try {
            moleImage = ImageIO.read(new File("C:\\Users\\user\\Desktop\\OneDaySoftware\\src\\images\\mole.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.game = game;

    }

    public void tick() {
        Random random = new Random();
        int randomPositionX;
        int randomPositionY;
        do {
            randomPositionX = (random.nextInt(3) * 200) + 350;
            randomPositionY = (random.nextInt(3) * 200) + 180;
        } while(currentPositionX == randomPositionX && currentPositionY == randomPositionY);

        currentPositionX = randomPositionX;
        currentPositionY = randomPositionY;
    }

    public void render(Graphics g) {

        g.drawImage(moleImage, currentPositionX, currentPositionY, IMAGE_SIZE, IMAGE_SIZE, null);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println(mx + "|" + my);
        if(mouseOver(mx, my, currentPositionX, currentPositionY, IMAGE_SIZE)) game.setScore(game.getScore() + 1);
    }


    private boolean mouseOver(int mx, int my, int x, int y, int size) {
        if(mx > x && mx < x + size) {
            return my > y && my < y + size;
        } return false;
    }
}
