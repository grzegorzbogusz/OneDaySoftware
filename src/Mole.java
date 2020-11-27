import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Mole {

    BufferedImage moleImage;

    public Mole() {

    }

    public void render(Graphics g) {

        Random random = new Random();
        int randomPositionX = random.nextInt(3);
        int randomPositionY = random.nextInt(3);

        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\OneDaySoftware\\src\\images\\mole.jpg"));
            g.drawImage(image, (randomPositionX * 200) + 340, (randomPositionY * 200) + 180, 200, 200, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
