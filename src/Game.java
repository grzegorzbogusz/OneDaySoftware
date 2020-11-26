public class Game {

    private final int WIDTH = 1024;
    private final int HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "Whack a Mole", this);
    }
}
