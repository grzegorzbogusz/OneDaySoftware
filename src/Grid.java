import java.awt.*;

public class Grid {

    private final int SQUARE_SIDE_LENGTH = 200;
    private final int GAME_WIDTH;
    private final int GAME_HEIGHT;

    public Grid(int gameWidth, int gameHeight) {
        this.GAME_WIDTH = gameWidth;
        this.GAME_HEIGHT = gameHeight;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                g.drawRect((i * SQUARE_SIDE_LENGTH) + GAME_WIDTH/2 - (SQUARE_SIDE_LENGTH + SQUARE_SIDE_LENGTH/2), (j * SQUARE_SIDE_LENGTH) + GAME_HEIGHT/2 - (SQUARE_SIDE_LENGTH + SQUARE_SIDE_LENGTH/2), SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH);
            }
        }
    }
}
