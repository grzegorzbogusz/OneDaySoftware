package MGS_Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Components contained in the Major_Frame;
 */

public class RectS extends JComponent implements MouseListener {

    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;
    private int leftX = 180;
    private int topY = 180;
    private int moleX = 0;
    private int moleY = 0;
    private int score = 0;
    private int period = 2*1000;
    Random rand = new Random();

    private int[]positions = new int[3];

    Timer timer = new Timer();

    Image moleImage = new ImageIcon("src\\mole.jpg").getImage();

    public RectS() {
        addMouseListener(this);
        startGame();
    }

    public void startGame() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                positions[0] = leftX;
                positions[1] = leftX+DEFAULT_WIDTH*1;
                positions[2] = leftX+DEFAULT_WIDTH*2;

                moleX=positions[rand.nextInt(3)];
                moleY=positions[rand.nextInt(3)];
                repaint();
                if(score==50) {
                    this.cancel();
                    period = 200;
                    score++;
                    startGame();
                }
            }
        }, 10, period);
    }

    @Override
    public void paintComponent(Graphics g) {

        for(int i=0; i<=2; i++) {
            topY+=DEFAULT_WIDTH*i;
            for (int j=0; j<=2; j++) {
                leftX+=DEFAULT_WIDTH*j;
                g.drawRect(leftX, topY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                leftX=180;
            }
            topY=180;
        }

        Font f = new Font("Serif", Font.BOLD, 36);
        Font f1 = new Font("Serif", Font.BOLD, 20);

        g.setFont(f);
        g.drawString("WHACK A MOLE", 180, 100);
        g.setFont(f1);
        g.drawString("Score: "+score,50, 600 );
        g.drawImage(moleImage, moleX, moleY, 99, 99, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getX()>moleX && e.getX()<=(moleX+100) && e.getY()>moleY && e.getY()<=(moleY+100)) {
            this.score += 5;

            positions[0] = leftX+DEFAULT_WIDTH*0;
            positions[1] = leftX+DEFAULT_WIDTH*1;
            positions[2] = leftX+DEFAULT_WIDTH*2;

            moleX=positions[rand.nextInt(3)];
            moleY=positions[rand.nextInt(3)];
            repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
