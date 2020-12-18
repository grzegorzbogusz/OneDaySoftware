package Game;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        this.setBounds(10, 10, 1024, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(new GameComponent());
        this.setVisible(true);

    }

}
