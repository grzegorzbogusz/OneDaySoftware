package MGS_Classes;

import javax.swing.*;
import java.awt.*;

/**
 * The basement for all components;
 */

public class Major_Frame extends JFrame {

    RectS r = new RectS();

    public Major_Frame() {

        this.setBounds(10, 10, 700, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(r);
        this.setVisible(true);

    }

}
