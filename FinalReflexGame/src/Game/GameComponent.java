package Game;

import ClickableObjects.Circle;
import ClickableObjects.Figure;
import ClickableObjects.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameComponent extends JComponent implements ActionListener {

    private ArrayList<Figure> figures; //list with figures to draw taken from 'invisible'
    private ArrayList<Figure> invisible; //additional list with possible types of figures to draw

    private final Color[] colors = {Color.BLUE, Color.RED};
    private final Rectangle startAgainButton;
    private final Rectangle exitButton;

    private Figure currentFigure; //currently clicked figure

    private Player player;

    private int delay;
    private int deleterDelay;

    private Timer timer;
    private Timer deleter;

    public GameComponent() {

        addMouseListener(new MouseComponent());

        startAgainButton = new Rectangle(245, 250, 100, 25);
        exitButton = new Rectangle(245, 280, 100, 25);

        figures = new ArrayList<>();
        invisible = new ArrayList<>();

        delay = 1000;
        deleterDelay = 1300;

        timer = new Timer(delay, this);
        deleter = new Timer(deleterDelay, event -> initDeleter());

        player = new Player();
        startGame();
    }

    private void startGame() {
        player.resetStats();
        figures.clear();
        timer.start();
        deleter.start();
    }


    /**
     * responsible for drawing every component
     * @param g draw every component (required by definition)
     */

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Serif", Font.BOLD, 20);
        graphics2D.setFont(font);

        if(timer.isRunning()) {
            graphics2D.drawString("Score: " + player.getScore(), 10, 50);
            for (Figure shape : figures) {
                graphics2D.setColor(shape.getColor());
                graphics2D.fill(shape.getShape());
                graphics2D.draw(shape.getShape());
            }
        } else {
            graphics2D.drawString("GAME OVER", 235, 225);
            graphics2D.draw(startAgainButton);
            graphics2D.draw(exitButton);
            graphics2D.drawString("start again", 250, 270);
            graphics2D.drawString("exit", 275, 300);
            graphics2D.drawString("record: " + player.getRecord(), 255, 335);
        }
    }

    /**
     * clear the invisible list
     * add Figure objects with new colors and
     */

    private void rollShapes() {
        invisible.clear();
        invisible.add(new Square(getRandomColor(), 50,50));
        invisible.add(new Circle(getRandomColor(), 50,50));
    }

    /**
     * return random number
     * @param limit defines the range of random number
     */

    private int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    /**
     *
     * @return random color from 'color' array
     */

    private Color getRandomColor() {
        return colors[getRandomNumber(2)];
    }

    /**
     * find figure which contains the clicked point in its area
     * @param p point the method is looking for
     */

    private Figure find(Point p) {

        for(Figure shape : figures) {
            if(shape.getShape().contains(p)) return shape;
        }
        return null;
    }

    /**
     * remove the figure if clicked area isn't empty
     * @param s currently clicked figure
     */

    private void removeShape(Figure s) {

        if(s==null) return;
        if(s== currentFigure) currentFigure = null;
        figures.remove(s);
        repaint();
    }

    /**
     * reduce the delays of the timers
     */

    private void reduceDelays() {

        delay -= 10;
        deleterDelay -= 10;
        if (delay <= 200)
            delay = 200;

        timer.setDelay(delay);

        if (deleterDelay <= 250)
            deleterDelay = 250;

        deleter.setDelay(deleterDelay);
    }

    /**
     * run the timer responsible for deleting figures
     */

    private void initDeleter() {

        if(!figures.isEmpty()) {
            figures.remove(0);
            figures.trimToSize();
        }
        repaint();
    }

    /**
     * action performed by the main timer
     * @param e required by definition
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        this.rollShapes();
        figures.add(invisible.get(getRandomNumber(2)));

        if(player.getMisses()>=10) {
            timer.stop();
            deleter.stop();
        }
        repaint();
    }

    /**
     * Inner class for mouse actions;
     */

    private class MouseComponent extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {

            if(timer.isRunning()) {
                currentFigure = find(e.getPoint());

                if (currentFigure != null) {
                    if (currentFigure.isPositive()) {
                        player.setScore(5);
                    }
                    else
                        player.setScore(-5);

                    player.setNewRecord();
                    reduceDelays();
                    removeShape(currentFigure);
                } else
                    player.countMisses();

            } else if(startAgainButton.contains(e.getPoint())) {
                startGame();
                repaint();

            } else if(exitButton.contains(e.getPoint()))
                System.exit(0);
        }
    }
}