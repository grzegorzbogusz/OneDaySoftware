import java.awt.*;
import java.util.Random;

public class Grid {

    private final int GAME_WIDTH;
    private final int GAME_HEIGHT;
    private Square[] squares;
    private int currentMolePosition;

    public Grid(int gameWidth, int gameHeight) {
        this.GAME_WIDTH = gameWidth;
        this.GAME_HEIGHT = gameHeight;
        squares = new Square[9];
        int squareIndex = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int x = (i * 200) + GAME_WIDTH/2 - 300;
                int y = (j * 200) + GAME_HEIGHT/2 - 300;
                squares[squareIndex] = new Square(x, y);
                squareIndex++;
            }
        }
        setRandomMolePosition();
    }

    public void render(Graphics g) {
        setRandomMolePosition();
        g.setColor(Color.BLACK);
        for(Square square : squares) {
            square.render(g);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setRandomMolePosition() {
        for(Square square : squares) {
            square.setMole(false);
        }

        int n;
        do {
            Random r = new Random();
            n = r.nextInt(9);
        } while(currentMolePosition == n);

        squares[n].setMole(true);
        currentMolePosition = n;
    }

    public Square[] getSquares() {
        return squares;
    }
}
