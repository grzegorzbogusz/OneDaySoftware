package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
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

    protected ArrayList<Shape> shapes = new ArrayList<>();
    protected ArrayList<Shape> unvisible = new ArrayList<>();
    protected Shape current; //the clicked shape
    protected int score=0;
    protected int tick = 0;

    private int delay=1000;
    private Timer timer;

    public GameComponent() {
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
        graphics2D.setColor(Color.BLUE);
        for(Shape shape : shapes) {
            graphics2D.fill(shape);
            graphics2D.draw(shape);
            graphics2D.setColor(Color.RED);
            graphics2D.drawString(""+shapes.indexOf(shape), (int)shape.getBounds().getX(), (int)shape.getBounds().getY());
        }
    }

    /**
     * @rollShapes:
     * adds new shapes with random x & y to the 'unvisible' ArrayList
     */

    public void rollShapes() {
        unvisible.clear();
        unvisible.add(new Rectangle(getRandomNumber(500), getRandomNumber(500), 100, 100));
        unvisible.add(new Ellipse2D.Double(getRandomNumber(500), getRandomNumber(500), 100, 100));
    }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    public Shape find(Point p) {
        for(Shape shape : shapes) {
            if(shape.contains(p)) return shape;
        }
        return null;
    }

    public void removeShape(Shape s) {
        if(s==null) return;
        if(s==current) current = null;
        shapes.remove(s);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rollShapes(); //take new shapes with new x & y;
        shapes.add(unvisible.get(getRandomNumber(2))); //add one of them to the main ArrayList of shapes
        repaint();
    }

    public class MouseComponent extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            current = find(e.getPoint());
            if(current!=null) {
                removeShape(current);
                score+=5;
            }
        }

    }

    public class ShapesDeleter implements ActionListener {

        Timer deleter; //idc of encapsulation, the program is like a rough concept sketch
        ShapesDeleter() {
            deleter = new Timer(4500, this);
            deleter.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(shapes.get(shapes.size()-3)!=null) {
                shapes.remove(shapes.size()-3); //it throws an error if you delete the specific shape with a click
                shapes.trimToSize();
            }
            repaint();
        }
    }
}