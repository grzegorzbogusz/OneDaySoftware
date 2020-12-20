import Game.GameComponent;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setBounds(10, 10, 600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new GameComponent());
        this.setVisible(true);
    }

}
