import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame implements ActionListener{

    private final int WIDTH = 1280;
    private final int HEIGHT = WIDTH / 12 * 9;
    private final int SQUARE_SIDE_SIDE = 200;

    private JButton[] buttons;
    private ImageIcon mole;
    private int currentMolePosition;
    private JLabel scoreLabel;
    private int score = 0;

    public Game() {
        // Creating a window
        setTitle("Whack a Mole");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0,WIDTH, HEIGHT);
        panel.setLayout(null);
        buttons = new JButton[9];

        JLabel welcomeMessage = new JLabel("Whack a Mole");
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 48));
        welcomeMessage.setBounds(500, 25, 400, 100);
        panel.add(welcomeMessage);

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 32));
        scoreLabel.setBounds(20, 100, 200, 50);
        panel.add(scoreLabel);

        mole = new ImageIcon("src\\images\\mole.jpg");

       int index = 0;
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
               int x = (i * SQUARE_SIDE_SIDE) + WIDTH/2 - (SQUARE_SIDE_SIDE + SQUARE_SIDE_SIDE/2);
               int y = (j * SQUARE_SIDE_SIDE) + HEIGHT/2 - (SQUARE_SIDE_SIDE + SQUARE_SIDE_SIDE/2);
               buttons[index] = new JButton();
               buttons[index].setBounds(x, y, 200, 200);
               buttons[index].setBackground(Color.WHITE);
               panel.add(buttons[index]);
               buttons[index].addActionListener(this);
               index++;
           }
       }
        add(panel);

       while(true) {
           getRandomMolePosition();
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    private void getRandomMolePosition() {
        for(JButton button : buttons) {
            button.setIcon(null);
        }

        Random random = new Random();
        int n;
        do {
            n = random.nextInt(9);
        } while(n == currentMolePosition);
        buttons[n].setIcon(mole);
        currentMolePosition = n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        if(button.getIcon() == mole) {
            button.setIcon(null);
            score++;
            scoreLabel.setText("Score: " + score);
        }
    }
}
