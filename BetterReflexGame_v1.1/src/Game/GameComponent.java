package Game;

import Figures.Figure;
import Figures.Circle;
import Figures.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameComponent extends JComponent implements ActionListener {

    private final ArrayList<Figure> invisible;
    private ArrayList<Figure> figures;
    private Figure currentFigure;

    private final Rectangle area;

    private final Color[] colors = {Color.BLUE, Color.RED};
    private Player player;

    private int delay;
    private int deleterDelay;

    private Timer timer;
    private Timer figuresDeleter;

    public GameComponent() {

        this.addMouseListener(new MouseComponent());

        figures = new ArrayList<>();
        invisible = new ArrayList<>();
        area = new Rectangle(250, 280, 100, 25);

        delay = 1000;
        deleterDelay = 1300;

        timer = new Timer(delay, this);
        figuresDeleter = new Timer(delay,event -> initDeleter());

        player = new Player();
        startGame();
    }

    private void startGame() {

        player.resetStats();
        figures.clear();
        timer.start();
        figuresDeleter.start();
    }

    @Override
    public void paintComponent(Graphics graphic) {

        Graphics2D graphics2D = (Graphics2D) graphic;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Serif", Font.BOLD, 20);
        graphics2D.setFont(font);

        if(timer.isRunning()) {
            graphics2D.drawString("Score: " + player.getScore(), 10, 50);

            for (Figure figure : figures) {
                graphics2D.setColor(figure.getColor());
                graphics2D.fill(figure.getShape());
                graphics2D.draw(figure.getShape());
            }
        } else {
            graphics2D.drawString("GAME OVER", 250, 250);
            graphics2D.draw(area);
            graphics2D.drawString("start again", 250, 300);
            graphics2D.drawString("record: "+player.getRecord(), 250, 325);
        }
    }

    private void rollShapes() {

        invisible.clear();
        invisible.add(new Square(getRandomColor(), 50,50));
        invisible.add(new Circle(getRandomColor(), 50,50));
    }

    private int getRandomNumber(int limit) {

        Random random = new Random();
        return random.nextInt(limit);
    }

    private Color getRandomColor() {
        return colors[getRandomNumber(2)];
    }

    private Figure find(Point p) {

        for(Figure figure : figures) {
            if(figure.getShape().contains(p))
                return figure;
        }
        return null;
    }

    private void removeShape(Figure figure) {

        if(figure==null)
            return;
        else if(figure== currentFigure)
            currentFigure = null;

        figures.remove(figure);
        repaint();
    }

    private void reduceDelays() {

        delay -= 10;
        deleterDelay -= 10;

        if (delay <= 200)
            delay = 200;
        timer.setDelay(delay);

        if (deleterDelay <= 250)
            deleterDelay = 250;
        figuresDeleter.setDelay(deleterDelay);
    }

    private void initDeleter() {

        if(!(figures.isEmpty())) {
            figures.remove(0);
            figures.trimToSize();
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        rollShapes();
        figures.add(invisible.get(getRandomNumber(2)));

        if(player.getMisses()>=10) {
            timer.stop();
            figuresDeleter.stop();
        }
        repaint();
    }

    /**
     * Inner class
     */

    private class MouseComponent extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent event) {

            if(timer.isRunning()) {
                currentFigure = find(event.getPoint());

                if (currentFigure != null) {
                    if (currentFigure.isPositive()) {
                        player.setScore(5);
                    } else
                        player.setScore(-5);

                    player.setNewRecord();
                    reduceDelays();
                    removeShape(currentFigure);
                } else
                    player.countMisses();

            } else if(area.contains(event.getPoint())) {
                startGame();
                repaint();
            }
        }

    }
}