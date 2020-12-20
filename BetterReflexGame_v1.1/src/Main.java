import Game.GameComponent;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        new GameFrame();
    }


    private static class GameFrame extends JFrame {

        public GameFrame() {
            this.setBounds(10, 10, 600, 600);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.add(new GameComponent());
            this.setVisible(true);
        }
    }
}
