package Menu;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JFrame implements ActionListener {

    private JTextPane authors;
    private JButton goBack;
    private JPanel panel;
    private JLabel label;


    public Credits(){

        this.setUndecorated(true);

        this.setTitle("Credits");
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        panel = new JPanel();
        panel.setBounds(0,0, Constants.WIDTH, Constants.HEIGHT);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#3d3d3d"));

        label = new JLabel("Made by:");
        label.setBounds(Constants.WIDTH/2 - 75,Constants.HEIGHT/2 - 200,400,100);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Constants.foregroundColor);
        label.setVisible(true);

        authors = new JTextPane();
        authors.setText("Grzegorz Bogusz\nEryk Hryńczuk\nSzymon Michno\nSamuel Leończyk\nJakub Zakowicz");
        authors.setFont(new Font("Arial", Font.PLAIN,24));
        authors.setBounds(Constants.WIDTH/2 - 100, Constants.HEIGHT/2 - 100,400,200);
        authors.setForeground(Constants.foregroundColor);
        authors.setBackground(null);
        authors.setVisible(true);
        authors.setEditable(false);


        goBack = new JButton();
        goBack.setBounds(Constants.WIDTH/2 - 100, Constants.HEIGHT/2 + 200,200,50);
        goBack.setBackground(Constants.buttonColor);
        goBack.setForeground(Constants.foregroundColor);
        goBack.setBorderPainted(false);
        goBack.setText("Back");
        goBack.addActionListener(this);

        panel.add(label);
        panel.add(authors);
        panel.add(goBack);

        add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goBack)
        {
            this.dispose();
            new Menu();
        }
    }
}
