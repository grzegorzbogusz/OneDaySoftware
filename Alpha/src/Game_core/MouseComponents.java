package Game_core;

import Items.Useables;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class MouseComponents implements MouseListener {

    private Mole mole;
    private ArrayList<Useables> items;
    private int score;

    MouseComponents() {
        this.score = 0;
        this.mole = new Mole();
    }

    public Mole getMole() {
        return this.mole;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    /**
     * @important
     * looks like we don't need repaint() anymore,
     * please confirm that
     */

    @Override
    public void mousePressed(MouseEvent e) {
        if(mole.getRectangle().contains(e.getPoint())) {
            this.getMole().setRectanglePoint(getRandomNumber(200), getRandomNumber(100));
            this.setScore(5);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt();
    }

}
