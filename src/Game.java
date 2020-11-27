import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    private final int WIDTH = 1280;
    private final int HEIGHT = WIDTH / 12 * 9;


    private Thread thread;
    private boolean running = false;
    private int score = 0;
    Grid grid;
    Mole mole;

    public Game() {
        new Window(WIDTH, HEIGHT, "Whack a Mole", this);
        grid = new Grid(WIDTH, HEIGHT);
        mole = new Mole(this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        mole.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Background creating
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Creating a main title "Whack a mole"
        g.setColor(Color.BLACK);
        Font titleFont = new Font("Arial", Font.BOLD, 48);
        g.setFont(titleFont);
        FontMetrics metrics = g.getFontMetrics(titleFont);

        String title = "Whack a Mole";
        g.drawString(title, WIDTH/2 - metrics.stringWidth(title)/2, 50);

        // Creating a score text
        Font scoreFont = new Font("Arial", Font.BOLD, 24);
        g.setFont(scoreFont);
        g.drawString("Score: " + score, 20, 120);

        // Grid rendering
        grid.render(g);

        mole.render(g);

        g.dispose();
        bs.show();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
