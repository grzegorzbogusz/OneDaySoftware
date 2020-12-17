package Game_core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Alpha_Game extends JComponent implements ActionListener {

    private Image background = new ImageIcon("src\\Images\\background.png").getImage();

    private Timer timer = new Timer(1000, this);
    private Mole mole;
    private int score;

    Alpha_Game() {
        score = 0;
        mole = new Mole();
        addMouseListener(new Mouse_Component());
        startGame();
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, 900, 544, null);

        /** ----------- **/

        Font f = new Font("Serif", Font.BOLD, 20);
        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawString("Score: "+score,50, 450);

        /** ----------- **/

        g.drawImage(mole.getMoleImage(), mole.getX(), mole.getY(), 99, 99, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.score>50) {
            timer.setDelay(500);
        }
        mole.setRectanglePoint(getRandomNumber(200), getRandomNumber(100));
        repaint();
    }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    /**
     * Inner class
     */

    public class Mouse_Component extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if(mole.getRectangle().contains(e.getPoint())) {
                score += 5;
                repaint();
            }
        }

    }
}
