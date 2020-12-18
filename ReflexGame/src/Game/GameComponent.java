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

/**
 * @WARNING
 * THIS IS KIND OF CONCEPT PROGRAM
 * PLEASE DON'T GET IT SERIOUSLY
 * AND DO NOT HARRAS ME FOR SOME SOLUTIONS!
 * I HOPE YOU'LL GET THE CONCEPT
 */

/**
 * @logbook
 * 22:45 - these shape classes are... useless;
 * @score: OneDay Software 0:1 Java
 * 23:01 - the whole objectivity has been lost;
 * @score: OneDay Software 0:2 Java;
 * 23:30 - it's even difficult to add these shapes correctly...
 * @score: OneDay Software 0:3 Java;
 * 23:35 - After the first half
 * OneDay Software has been verified by a simple game
 * and it lost to java 0:3 so
 * the PHP-team is almost fully confident of the win in the programming contest;
 * 00:00 - WHOOOOA, such a fast response! Shapes has been added correctly!
 * but is only a honorable goal at the moment;
 * @score: OneDay Software 1:3 Java;
 * 00:07 - GOAL! OneDay Software can't be happy of
 * chasing a score with a simple game in Java if
 * they want to conquer the PHP-Team but
 * ArrayList of Shapes finally doesn't throw an error!
 * @score: OneDay Software 2:3 Java;
 * 00:10 IT SHOULD HAVE LOOK LIKE THIS FROM THE BEGINNING!
 * @score: OneDay Software 3:3 Java;
 * 00:18 WHAT THE F*CK IS GOING ON THERE!?!??!?!?!!
 * CO TAM SIĘ DZIEJE???????????????!!!!!!!!!!!!!!!
 * sdjdshdsadshkjsaHGSHFGFDJG!JKG!HJGJHQKFGHJSGHKJDSHJSGKSJ
 * vbgjvchc
 * vcvc
 * xvcCVxnmn
 * @final_score: OneDay Software 4:3 Java;
 */

public class GameComponent extends JComponent implements ActionListener {

    //protected ArrayList<Shape> shapes = new ArrayList<>();
    protected ArrayList<Figure> unvisible;

    protected ArrayList<Figure> figures;

    protected Figure current; //the clicked shape
    protected int score=0;
    protected int tick = 0;

    private int delay=500;
    private int delay2 = 1000;
    private Timer timer;

    public GameComponent() {
        figures = new ArrayList<>();
        unvisible = new ArrayList<>();
        timer = new Timer(delay, this);
        addMouseListener(new MouseComponent());
        startGame(); //the main timer adds new shapes on the screen with specific delay
        new ShapesDeleter(); //another timer that delete shapes with its own delay
    }

    private void startGame() {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Serif", Font.BOLD, 20);
        graphics2D.setFont(font);
        graphics2D.drawString("Score: "+score, 10, 50);
        graphics2D.setColor(Color.BLACK);
        for(Figure shape : figures) {
            graphics2D.setColor(shape.getColor());
            graphics2D.fill(shape.getShape());
            graphics2D.draw(shape.getShape());
            //graphics2D.drawString(""+figures.indexOf(shape), (int)shape.getShape().getBounds().getX(), (int)shape.getShape().getBounds().getY());
        }
    }

    /**
     * @rollShapes:
     * adds new shapes with random x & y to the 'unvisible' ArrayList
     */

    public void rollShapes() {
        unvisible.clear();
        unvisible.add(new Square(Color.BLUE, 50,50));
        unvisible.add(new Circle(Color.RED, 50,50));
    }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    public Figure find(Point p) {
        for(Figure shape : figures) {
            if(shape.getShape().contains(p)) return shape;
        }
        return null;
    }

    public void removeShape(Figure s) {
        if(s==null) return;
        if(s==current) current = null;
        figures.remove(s);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rollShapes(); //take new shapes with new x & y;
        figures.add(unvisible.get(getRandomNumber(2))); //add one of them to the main ArrayList of shapes
        repaint();
    }

    public class MouseComponent extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            current = find(e.getPoint());
            if(current!=null) {
                delay-=10;
                if(delay<=200)
                    delay=200;
                timer.setDelay(delay);
                score+=5;
                removeShape(current);
            }
        }

    }

    public class ShapesDeleter implements ActionListener {

        Timer deleter; //idc of encapsulation, the program is like a rough concept sketch
        ShapesDeleter() {
            deleter = new Timer(delay2, this);
            deleter.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(figures.isEmpty()==false) {
                figures.remove(0); //it throws an error if you delete the specific shape with a click
                figures.trimToSize();
            }
            repaint();
        }
    }
}