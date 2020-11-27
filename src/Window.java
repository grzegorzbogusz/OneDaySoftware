import javax.swing.*;

public class Window extends JFrame{

    public Window(int width, int height, String title, Game game) {
        // Creating a window
        setTitle(title);
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(game);
        game.start();
    }
}
