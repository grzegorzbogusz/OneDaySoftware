package Game;

import java.awt.Shape;

import Figures.Circle;
import Figures.Figure;
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

    protected Color[] colors = {Color.BLUE, Color.RED, Color.GREEN};
    protected ArrayList<Figure> shapes = new ArrayList<>();
    protected ArrayList<Figure> invisible = new ArrayList<>();
    protected Figure currentShape; //the clicked shape
    protected int score=0;
    protected int tick = 0;

    private int delay=getRandomNumber(5)*100+500; /**TO-DO**/
    private Timer timer;
    private ShapesDeleter deleter;

    public GameComponent() {
        timer = new Timer(delay, this);
        deleter = new ShapesDeleter();
        addMouseListener(new MouseComponent());
        startGame(); //the main timer adds new shapes on the screen with specific delay
    }

    private void startGame() {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Serif", Font.BOLD, 20);
        graphics2D.setFont(font);
        graphics2D.drawString("Score: "+score, 10, 50);
        graphics2D.drawRect(125,25,712+50,600+100);
        graphics2D.setColor(Color.BLUE);
        for(Figure shape : shapes) {
            graphics2D.fill(shape.getShape());
            graphics2D.draw(shape.getShape());
            graphics2D.setColor(shape.getColor());
            graphics2D.drawString(""+shapes.indexOf(shape), (int) shape.getShape().getBounds().getX(), (int)  shape.getShape().getBounds().getY());
        }
    }

    /**
     * @rollShapes:
     * adds new shapes with random x & y to the 'invisible' ArrayList
     */

    public void rollShapes() {
        invisible.clear();
        if(getRandomNumber(2) == 1)
        invisible.add(new Square(getRandomColor(), 175+getRandomNumber(712-150), 75+getRandomNumber(600-75), 100,100));
        else
        invisible.add(new Circle(getRandomColor(), 175+getRandomNumber(712-150), 75+getRandomNumber(600-75), 100,100));
    }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    private Color getRandomColor() {
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }

    public Figure find(Point point) {
        for(Figure shape : shapes) {
            if(shape.getShape().contains(point)) return shape;
        }
        return null;
    }

    public void removeShape(Figure shape) {
        if(shape == null) return;
        if(shape == currentShape)
            currentShape = null;
        shapes.remove(shape);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //deleter.startDeleter();
        rollShapes();                 //take new shapes with new x & y;
        shapes.add(invisible.get(0)); //add one of them to the main ArrayList of shapes
        repaint();
    }

    /**
     * Inner class
     */

    private class MouseComponent extends MouseAdapter {

        //handles pressed shapes
        @Override
        public void mousePressed(MouseEvent event) {
            currentShape = find(event.getPoint());
            if(currentShape !=null) {
                removeShape(currentShape);
                score+=5;
            }
        }

    }

    /**
     * Inner class
     */

    private class ShapesDeleter implements ActionListener {

        private Timer deleter; //idc of encapsulation, the program is like a rough concept sketch //chill. encapsulated.
        private ShapesDeleter() {
            deleter = new Timer(delay, this);
            deleter.setRepeats(false);
        }

        public void startDeleter(){
            deleter.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!(shapes.isEmpty())) {
                shapes.remove(0); //fixed
                shapes.trimToSize();
            }
            repaint();
        }
    }
}