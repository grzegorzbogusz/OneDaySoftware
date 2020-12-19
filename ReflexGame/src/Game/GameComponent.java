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

    private final ArrayList<Figure> invisible;
    private ArrayList<Figure> figures;
    private Color[] colors = {Color.BLUE, Color.RED};

    private Figure current;
    private Rectangle rectangle = new Rectangle(250, 280, 100, 25);
    private Player player;

    private int delay;
    private int deleterDelay;

    private Timer timer;
    private ShapesDeleter shapesDeleter;

    public GameComponent() {
        addMouseListener(new MouseComponent());

        figures = new ArrayList<>();
        invisible = new ArrayList<>();

        delay = 1000;
        deleterDelay = 1300;

        timer = new Timer(delay, this);
        shapesDeleter = new ShapesDeleter();

        player = new Player();
        startGame();
    }

    private void startGame() {
        player.resetStats();
        figures.clear();
        timer.start();
        shapesDeleter.getDeleter().start();
    }

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
            graphics2D.drawString("GAME OVER", 250, 250);
            graphics2D.draw(rectangle);
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
        for(Figure shape : figures) {
            if(shape.getShape().contains(p)) return shape;
        }
        return null;
    }

    private void removeShape(Figure s) {
        if(s==null) return;
        if(s==current) current = null;
        figures.remove(s);
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
        shapesDeleter.deleter.setDelay(deleterDelay);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.rollShapes();
        figures.add(invisible.get(getRandomNumber(2)));
        if(player.getMisses()>=10) {
            this.timer.stop();
            this.shapesDeleter.getDeleter().stop();
        }
        repaint();
    }

    public class MouseComponent extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if(timer.isRunning()) {
                current = find(e.getPoint());
                if (current != null) {
                    if (current.isPositive()) {
                        player.setScore(5);
                    }
                    else
                        player.setScore(-5);
                        player.setNewRecord();
                    reduceDelays();
                    removeShape(current);
                } else
                    player.countMisses();
            } else if(rectangle.contains(e.getPoint())) {
                startGame();
                repaint();
            }
        }
    }

    public class ShapesDeleter implements ActionListener {

        private Timer deleter;

        public ShapesDeleter() {
            deleter = new Timer(deleterDelay, this);
            deleter.start();
        }

        public Timer getDeleter() {
            return this.deleter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(figures.isEmpty()==false) {
                figures.remove(0);
                figures.trimToSize();
            }
            repaint();
        }
    }
}