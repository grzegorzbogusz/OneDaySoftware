import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Handler extends MouseAdapter {

    private Square[] squares;

    public Handler(Square[] squares) {
        this.squares = squares;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(Square square : squares) {
            int x = e.getX();
            int y = e.getY();

            if(x >= square.getX() && x <= square.getX() + square.getSquareSize()) {
                if(y >= square.getY() && y <= square.getY() + square.getSquareSize()) {
                    if(square.isMole()) {

                    }
                }
            }

        }
    }
}
