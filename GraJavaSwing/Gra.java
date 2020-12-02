import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gra {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, hpPanel, mainTextPanel, choiceButtonPanel;
    JLabel titleNameLabel, hpNak, hpNakZmienna, weaponLabel, weaponLabelNazwa;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font( "Times New Roman", Font.PLAIN, 35);
    JButton startButton, wyb1, wyb2, wyb3, wyb4;
    JTextArea mainTextArea;
    int hpGracza, hpGoblin, pierscien;
    String bron, position;

    AktEkranGry tsAkt = new AktEkranGry();
    WybOgarniacz wybOgarniacz = new WybOgarniacz();



    public static  void main(String[] args)

    {
        new Gra();
    }

    public Gra(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();


        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Uncharted 7");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);


        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsAkt);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);
        titleNamePanel.add(titleNameLabel);


        con.add(startButtonPanel);
        con.add(titleNamePanel);
        window.setVisible(true);

    }

    public void ekranGry(){


        window.setVisible(false);
        window.setVisible(true);


        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);


        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(165, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);


        mainTextArea = new JTextArea("BARDZO PROSZĘ O 3 ");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextPanel.add(mainTextArea);
        mainTextArea.setEditable(false);


        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(175, 350, 450, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);


        wyb1 = new JButton("1");
        wyb1.setBackground(Color.black);
        wyb1.setForeground(Color.white);
        wyb1.setFont(normalFont);
        wyb1.setFocusPainted(false);
        wyb1.addActionListener(wybOgarniacz);
        wyb1.setActionCommand("c1");

        choiceButtonPanel.add(wyb1);

        wyb2 = new JButton("2");
        wyb2.setBackground(Color.black);
        wyb2.setForeground(Color.white);
        wyb2.setFont(normalFont);
        wyb2.setFocusPainted(false);
        wyb2.addActionListener(wybOgarniacz);
        wyb2.setActionCommand("c2");

        choiceButtonPanel.add(wyb2);

        wyb3 = new JButton("3");
        wyb3.setBackground(Color.black);
        wyb3.setForeground(Color.white);
        wyb3.setFont(normalFont);
        wyb3.setFocusPainted(false);
        wyb3.addActionListener(wybOgarniacz);
        wyb3.setActionCommand("c3");

        choiceButtonPanel.add(wyb3);

        wyb4 = new JButton("4");
        wyb4.setBackground(Color.black);
        wyb4.setForeground(Color.white);
        wyb4.setFont(normalFont);
        wyb4.setFocusPainted(false);
        wyb4.addActionListener(wybOgarniacz);
        wyb4.setActionCommand("c4");

        choiceButtonPanel.add(wyb4);

        hpPanel = new JPanel();
        hpPanel.setBounds(100, 1, 600, 50);
        hpPanel.setBackground(Color.black);
        hpPanel.setLayout(new GridLayout(1, 4));
        con.add(hpPanel);
        hpNak = new JLabel("HP: ");
        hpNak.setFont(normalFont);
        hpNak.setForeground(Color.WHITE);
        hpPanel.add(hpNak);
        hpNakZmienna = new JLabel();
        hpNakZmienna.setFont(normalFont);
        hpNakZmienna.setForeground(Color.WHITE);
        hpPanel.add(hpNakZmienna);

        weaponLabel = new JLabel("Broń: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        hpPanel.add(weaponLabel);

        weaponLabelNazwa = new JLabel();
        weaponLabelNazwa.setFont(normalFont);
        weaponLabelNazwa.setForeground(Color.white);
        hpPanel.add(weaponLabelNazwa);

        ustGracza();
    }
    public void ustGracza(){
        hpGracza = 15;
        hpGoblin = 20;
        bron = "Sztylet";
        weaponLabelNazwa.setText(bron);
        hpNakZmienna.setText("" + hpGracza);

        bramaMiasta();
    }
    public void bramaMiasta(){
        position = "bramaMiasta";
        mainTextArea.setText("Jesteś przed bramą miasta.\nStrażnik stoi przed tobą. \n\nCo robisz?");
        wyb1.setText("Porozmawiaj ze strażnikiem");
        wyb2.setText("Zatakuj strażnika");
        wyb3.setText("Odejdź");
        wyb4.setText("");
    }

    public  void rozmStraz(){
        position = "rozmStraz";
        mainTextArea.setText("Witaj Nieznajomy.\n\nPrzepraszam Cię, lecz nie\nwpuszczamy nieznajomych\ndo miasta.");
        wyb1.setText(">");
        wyb2.setText("");
        wyb3.setText("");
        wyb4.setText("");

    }
    public void atStraz(){
        position = "atStraz";
        mainTextArea.setText("Pajacu co robisz!? Odejdź stąd.\n\n        -   Dostajesz bencki   -\n              -3HP");
        hpGracza = hpGracza -3;
        hpNakZmienna.setText(""+hpGracza);
        wyb1.setText(">");
        wyb2.setText("");
        wyb3.setText("");
        wyb4.setText("");

    }
    public void rozdroze(){
        position = "rozdroze";
        mainTextArea.setText("Znalazłeś się na rozdrożu.\nJeżeli pójdziesz na północ wrócisz do miasta.");
        wyb1.setText("Idź na Północ.");
        wyb2.setText("Idź na Południe.");
        wyb3.setText("Idź na Wschód.");
        wyb4.setText("Idź na Zachód.");
    }
    public void poludnie(){
        position = "poludnie";
        mainTextArea.setText("Dotarłeś do rzeki.\nNapisałeś się wody i odpocząłeś na łonie natury.\n\n  -   HP+2    -   ");
        hpGracza = hpGracza +2;
        hpNakZmienna.setText(""+hpGracza);
        wyb1.setText("Idź na Północ.");
        wyb2.setText("");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void wschod(){
        position = "wschod";
        mainTextArea.setText("Zagubiłeś się w lesie. Pomiędzy\ndrzewami zauważasz przebiegającą\nnimfę. Podążasz za nią aż do jeziora\npo środku lasu. Spotkałeś Panią Jeziora, która obdarowuję Cię magicznym\nMieczem Excalibur.");
        bron = "Excalibur";
        weaponLabelNazwa.setText(bron);
        wyb1.setText("Idź na Zachód.");
        wyb2.setText("");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void zachod(){
        position = "zachod";
        mainTextArea.setText("Zauważasz Goblina!");
        wyb1.setText("Zaatakuj gnoja!.");
        wyb2.setText("Spierdzielaj..");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void walcz(){
        position = "walcz";
        mainTextArea.setText("  -   HP GOBLINA  -   :"+ hpGoblin +"\n Co robisz?");
        wyb1.setText("Lecimy w Tango.");
        wyb2.setText("Oj nie, nie byczqu.");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void tango(){
        position = "tango";

        int obrGracza = 0;

        if(bron.equals("Sztylet")) {

            obrGracza = new java.util.Random().nextInt(3);
        }

        else if(bron.equals("Excalibur")) {

            obrGracza = new java.util.Random().nextInt(10);
        }

        mainTextArea.setText("Wywaliłeś Goblinowi gonga za " + obrGracza + ".");

        hpGoblin -= obrGracza;

        wyb1.setText(">");
        wyb2.setText("");
        wyb3.setText("");
        wyb4.setText("");

    }
    public void atakGoblina(){
        position = "atakGoblina";

        int obrGoblina;

        obrGoblina = new java.util.Random().nextInt(4);

        mainTextArea.setText("Goblin zadał Ci " + obrGoblina + ".");

        hpGracza -= obrGoblina;
        hpNakZmienna.setText(""+hpGracza);

        wyb1.setText(">");
        wyb2.setText("");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void decyzja(){
        position = "decyzja";
        mainTextArea.setText("  -   HP GOBLINA  -   :"+ hpGoblin +"\n Co robisz?");
        wyb1.setText("Walcz Dalej.");
        wyb2.setText("Ratuj się kto może!");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void  smierc(){
        position = "smierc";

        mainTextArea.setText("Twoje nieruchome ciało leży w kałuży \nkrwi. Nie podołałeś swemu preznaczeniu.\nCzy zawiódł Cię twój intelekt, czy\nmoże to droga, którą dane było Ci\nprzejść była zbyt trudna?");
        wyb1.setText("Zagraj ponownie.");
        wyb2.setText("Wyjdź.");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void wygrana(){
        position = "wygrana";
        mainTextArea.setText("Pokonałeś krwawą bestię. Na jej zwłokach\nzauważyłeś błysk srebrnego pierścienia,\nktóry postanowiłeś zagarnąć.\nMoże uda Ci się wymienić go za wstęp do miasta?");
        pierscien = 1;
        wyb1.setText("Wróc na rozdroże.");
        wyb2.setText(".");
        wyb3.setText("");
        wyb4.setText("");
    }
    public void zakonczenie(){
        position = "zakonczenie";
        mainTextArea.setText(" - Czy to pierścień Goblina? Udało Ci\nsię go pokonać? Chodź do nas, musimy to\n uczcić.\nUdało Ci się ukończyć grę\n____THE-END____");
        wyb1.setVisible(false);
        wyb2.setVisible(false);
        wyb3.setVisible(false);
        wyb4.setVisible(false);

    }




    public class AktEkranGry implements ActionListener{


        public void actionPerformed(ActionEvent event) {
        ekranGry();
        }
    }
    public class WybOgarniacz implements ActionListener{

        public void  actionPerformed (ActionEvent event){

            String twojWyb = event.getActionCommand();

            switch (position){
                case "bramaMiasta":
                    if (pierscien == 1){
                        switch(twojWyb){
                        case "c1": zakonczenie(); break;
                        case "c2": atStraz(); break;
                        case "c3": rozdroze(); break;
                        case "c4": break;
                    }}else {
                            switch(twojWyb){
                            case "c1": rozmStraz(); break;
                            case "c2": atStraz(); break;
                            case "c3": rozdroze(); break; case "c4": break;

                            }
                        }

                    break;
                case "rozmStraz":
                case "atStraz":
                    switch (twojWyb) {
                    case "c1": bramaMiasta(); break;
                    case "c2":
                    case "c3":
                    case "c4":
                        break;
                }
                  break;
                case "rozdroze":
                    switch (twojWyb){
                        case "c1": bramaMiasta(); break;
                        case "c2": poludnie(); break;
                        case "c3": wschod(); break;
                        case "c4": zachod(); break;
                    }
                    break;
                case "poludnie":
                case "wschod":
                    switch (twojWyb){
                        case "c1": rozdroze(); break;
                        case "c2":
                        case "c3":
                        case "c4": break;
                    }
                    break;
                case "zachod":
                    switch (twojWyb){
                        case "c1": walcz(); break;
                        case "c2": rozdroze(); break;
                        case "c3":
                        case "c4": break;
                    }
                    break;

                case "walcz":
                case "decyzja":
                    switch (twojWyb){
                        case "c1": tango(); break;
                        case "c2": rozdroze(); break;
                    }
                    break;
                case "tango":
                    switch (twojWyb){
                        case "c1":
                            if (hpGoblin<1){
                                wygrana(); break;
                            }
                                atakGoblina(); break;
                        case "c2": break;
                    }
                    break;
                case "atakGoblina":
                    switch (twojWyb){
                        case "c1":
                        if(hpGracza<1){
                            smierc();
                        }
                        else
                        decyzja(); break;

                        }

                    break;
                case "wygrana":
                    switch (twojWyb){
                        case "c1": rozdroze(); break;

                    }
                    break;
            }


            }
        }
    }
