import Interfaces.MenuInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements MenuInterface {

    private final int WIDTH = 1280;
    private final int HEIGHT = 800;

    private final JButton startButton;
    private final JButton creditsButton;
    private final JButton exitButton;

    private JLabel title;
    private JPanel panel;


    public Menu(){

        this.setUndecorated(true);

        this.setTitle("Menu");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        panel = new JPanel();
        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setBackground(Color.decode("#3d3d3d"));
        panel.setLayout(null);

        title = new JLabel("Whack a mole!");
        title.setBounds(WIDTH/2 - 250,-100,500,500);
        title.setFont(new Font("Arial", Font.BOLD, 64));
        title.setForeground(Color.WHITE);
        title.setVisible(true);

        startButton = new JButton();
        startButton.setBounds(WIDTH/2 - 125,HEIGHT/2,200,50);
        startButton.setBackground(Color.decode("#4b4b4b"));
        startButton.setForeground(Color.WHITE);
        startButton.setBorderPainted(false);
        startButton.setText("Start");
        startButton.addActionListener(this);

        creditsButton = new JButton();
        creditsButton.setBounds(WIDTH/2 - 125,HEIGHT/2 + 51,200,50);
        creditsButton.setBackground(Color.decode("#4b4b4b"));
        creditsButton.setForeground(Color.WHITE);
        creditsButton.setBorderPainted(false);
        creditsButton.setText("Credits");
        creditsButton.addActionListener(this);

        exitButton = new JButton();
        exitButton.setBounds(WIDTH/2 - 125,HEIGHT/2 + 102,200,50);
        exitButton.setBackground(Color.decode("#4b4b4b"));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorderPainted(false);
        exitButton.setText("Exit");
        exitButton.addActionListener(this);

        panel.add(title);
        panel.add(startButton);
        panel.add(creditsButton);
        panel.add(exitButton);

        add(panel);
        this.setVisible(true);
    }


    @Override
    public void Start() {
        this.dispose();
        new Game();
    }

    @Override
    public void Credits() {
        this.dispose();
        new Credits();

    }

    @Override
    public void Exit() {
        this.dispose();
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) Start();
        if(e.getSource() == creditsButton) Credits();
        if(e.getSource() == exitButton) Exit();
    }
}
