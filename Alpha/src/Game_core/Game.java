package Game_core;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JComponent {

    private Image background = new ImageIcon("src\\Images\\background.png").getImage();
    private java.util.Timer timer = new Timer();
    private MouseComponents mouseComponent = new MouseComponents();
    private int period = 1000;

    Game() {
        addMouseListener(mouseComponent);
        startGame();
    }

    /**
     * @important
     * looks like we don't need repaint() anymore,
     * please confirm that
     */

    public void startGame() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mouseComponent.getMole().setRectanglePoint(getRandomNumber(200), getRandomNumber(100));
                //repaint(); //We don't need repaint anymore. How is it possible?!
                if(mouseComponent.getScore()==50) {
                    this.cancel();
                    period = 200;
                    mouseComponent.setScore(1);
                    startGame();
                }
            }
        }, 100, period);
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(background, 0, 0, 900, 544, this);
        Font f = new Font("Serif", Font.BOLD, 20);
        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawImage(mouseComponent.getMole().getMoleImage(), mouseComponent.getMole().getX(), mouseComponent.getMole().getY(), 99, 99, this);
        g.drawString("Score: "+mouseComponent.getScore(),50, 450);

    }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

}
