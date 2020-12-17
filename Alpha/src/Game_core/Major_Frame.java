package Game_core;

import javax.swing.*;

public class Major_Frame extends JFrame {

    public Major_Frame() {

        this.setBounds(10, 10, 900, 544);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new Game());
        this.setVisible(true);

    }

}
