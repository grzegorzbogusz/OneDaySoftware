package Game_core;

import javax.swing.*;
import java.awt.*;

public class Mole {

    /**
     * @important
     * We should create a package called 'CLICKABLES'
     * which will contain classes with different types
     * of clickable objects e.g. Mole, RedMole
     */

    private Image moleImage;
    private Rectangle rectangle;
    private int x = 200;
    private int y = 300;

    Mole() {
        rectangle = new Rectangle(x, y, 99, 99);
        moleImage = new ImageIcon("src\\Images\\background.png").getImage();
    }

    public Image getMoleImage() {
        return moleImage;
    }

    public void setRectanglePoint(int x, int y) {
        this.rectangle.setLocation(this.x+x, this.y+y);
    }

    public int getX() {
        return (int) this.rectangle.getX();
    }

    public int getY() {
        return (int) this.rectangle.getY();
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

}

