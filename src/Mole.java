import javax.swing.*;
import java.awt.*;

public class Mole {

    private final int imageSize = 200;

    private Image moleImage;

    public Mole() {

        moleImage = new ImageIcon("src\\images\\mole.jpg").getImage();
    }
    public Image getMoleImage() {
        return moleImage;
    }

    public int getImageSize() {
        return imageSize;
    }
}
