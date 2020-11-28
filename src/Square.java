import java.awt.*;

public class Square {

    private final int squareSize = 200;

    private boolean isMole = false;
    private Mole mole = new Mole();
    private int x;
    private int y;


    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {

        if(isMole) {
            g.drawImage(mole.getMoleImage(), x, y, mole.getImageSize(), mole.getImageSize(), null);
        } else {
            g.drawRect(x, y, squareSize, squareSize);
        }
    }



    public void setMole(boolean mole) {
        isMole = mole;
    }

    public boolean isMole() {
        return isMole;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSquareSize() {
        return squareSize;
    }
}
