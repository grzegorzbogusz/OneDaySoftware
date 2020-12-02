import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JComponent implements MouseListener {

    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;
    private int leftX = 180;
    private int topY = 180;
    private int moleX = 0;
    private int moleY = 0;
    private int score = 0;

    private JFrame frame;

    private Image moleImage = new ImageIcon("src\\images\\mole1.jpg").getImage();

    public Game() {
        frame = new JFrame();
        frame.setBounds(10, 10, 700, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new Game(1));
        frame.setVisible(true);
    }

    public Game(int i) {
        this.addMouseListener(this);
        this.startGame();
    }

    public void startGame() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                moleX+=50;
                moleY+=50;
                repaint();
            }
        }, 2*1000, 2*1000);
    }

    @Override
    public void paintComponent(Graphics graphics) {

        for(int i=0; i<=2; i++) {
            topY+=DEFAULT_WIDTH*i;
            for (int j=0; j<=2; j++) {
                leftX+=DEFAULT_WIDTH*j;
                graphics.drawRect(leftX, topY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                leftX=180;
            }
            topY=180;
        }
        Font f = new Font("Serif", Font.BOLD, 36);
        Font f1 = new Font("Serif", Font.BOLD, 20);

        graphics.setFont(f);
        graphics.drawString("WHACK A MOLE", 180, 100);
        graphics.setFont(f1);
        graphics.drawString("Score: "+score,50, 600 );
        graphics.drawImage(moleImage, moleX, moleY, 100, 100, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX()>moleX && e.getX()<=(moleX+100) && e.getY()>moleY && e.getY()<=(moleY+100)) {
            this.score += 5;
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
