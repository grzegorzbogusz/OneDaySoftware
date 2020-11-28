import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Mole extends MouseAdapter {

    private ImageIcon moleImage;
    private final int IMAGE_SIZE = 190;
    private int currentPositionX = 0;
    private int currentPositionY = 0;
    private Game game;

    public Mole(Game game) {

        moleImage = new ImageIcon("src\\images\\mole.jpg");

        this.game = game;

    }

    public void tick() {

    }

    public void render(Graphics g) {

        Random random = new Random();
        int randomPositionX;
        int randomPositionY;
        do {
            randomPositionX = (random.nextInt(3) * 200) + 350;
            randomPositionY = (random.nextInt(3) * 200) + 180;
        } while(currentPositionX == randomPositionX && currentPositionY == randomPositionY);

        currentPositionX = randomPositionX;
        currentPositionY = randomPositionY;

        g.drawImage(moleImage.getImage(), currentPositionX, currentPositionY, IMAGE_SIZE, IMAGE_SIZE, null);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if(mouseOver(mx, my, currentPositionX, currentPositionY, IMAGE_SIZE)) game.setScore(game.getScore() + 1);
    }


    private boolean mouseOver(int mx, int my, int x, int y, int size) {
        if(mx > x && mx < x + size) {
            return my > y && my < y + size;
        } return false;
    }
}
