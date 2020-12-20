package Menu;

import Interfaces.MenuInterface;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Menu extends JFrame implements MenuInterface {

    private final JButton startButton;
    private final JButton creditsButton;
    private final JButton exitButton;

    private final int buttonWidth = 100;
    private final int buttonHeight = 50;

    private JLabel title;
    private JPanel panel;

    public Menu(){

        this.setUndecorated(true);

        this.setTitle("Menu");
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBounds(0,0, Constants.WIDTH, Constants.HEIGHT);
        panel.setBackground(Constants.backgroundColor);
        panel.setLayout(null);

        title = new JLabel("The Ultimate Reflex Game");
        title.setBounds(Constants.WIDTH/2 - 175, Constants.HEIGHT - 500,400,50);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Constants.foregroundColor);
        title.setVisible(true);

        startButton = new JButton();
        startButton.setBounds(Constants.WIDTH/2 - 50, Constants.HEIGHT/2,buttonWidth,buttonHeight);
        startButton.setOpaque(true);
        startButton.setBackground(Constants.buttonColor);
        startButton.setForeground(Constants.foregroundColor);
        startButton.setBorderPainted(false);
        startButton.setText("Start");
        startButton.addActionListener(this);

        creditsButton = new JButton();
        creditsButton.setBounds(Constants.WIDTH/2 - 50, Constants.HEIGHT/2 + 51,buttonWidth,buttonHeight);
        creditsButton.setBackground(Constants.buttonColor);
        creditsButton.setForeground(Constants.foregroundColor);
        creditsButton.setBorderPainted(false);
        creditsButton.setText("Credits");
        creditsButton.addActionListener(this);

        exitButton = new JButton();
        exitButton.setBounds(Constants.WIDTH/2 - 50, Constants.HEIGHT/2 + 102,buttonWidth,buttonHeight);
        exitButton.setBackground(Constants.buttonColor);
        exitButton.setForeground(Constants.foregroundColor);
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
        new MainFrame();
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
