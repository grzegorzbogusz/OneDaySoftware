import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JFrame implements ActionListener {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private JLabel title;
    private JTextPane authors;
    private JButton goBack;
    private JPanel panel;


    public Credits(){

        this.setUndecorated(true);

        this.setTitle("Credits");
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        panel = new JPanel();
        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#3d3d3d"));

        title = new JLabel();
        title.setIcon(new ImageIcon("src\\images\\PWSZ.png"));
        title.setBounds(WIDTH/2 - 111,30 , 222, 227);
        title.setVisible(true);

        authors = new JTextPane();
        authors.setText("Grzegorz Bogusz\nEryk Hryńczuk\nSzymon Michno\nSamuel Leończyk\nJakub Zakowicz");
        authors.setFont(new Font("Arial", Font.PLAIN,24));
        authors.setBounds(WIDTH/2 - 100, HEIGHT/2 ,400,200);
        authors.setForeground(Color.WHITE);
        authors.setBackground(null);
        authors.setVisible(true);
        authors.setEditable(false);


        goBack = new JButton();
        goBack.setBounds(WIDTH/2 - 100, HEIGHT/2 + 200,200,50);
        goBack.setBackground(Color.decode("#4b4b4b"));
        goBack.setForeground(Color.WHITE);
        goBack.setBorderPainted(false);
        goBack.setText("Back");
        goBack.addActionListener(this);

        panel.add(title);
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
