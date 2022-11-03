package Inlämning_3;

import javax.swing.*;
import java.awt.*;


public class Spela {

    Spelplan_GUI sp;


    public Spela() {

        //tar in input för spelets storlek
        int storlek = sizeChooser();

        //skapar upp ett objekt av Spelplan_GUI-klassen
        sp = new Spelplan_GUI(storlek);


    }

    //tar in och returnerar storlek på spelet
    public int sizeChooser() {
        JLabel label1 = new JLabel("<html>Ange antal rutor per rad:<html>");
        JLabel label2 = new JLabel("Du måste ange en siffra");
        label2.setForeground(Color.RED);
        label2.setVisible(false);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label1, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.CENTER);

        int storlek;
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(panel, panel, "Hur stort ska spelbrädet vara?", 3);
                if (input == null) {
                    System.exit(0);
                } else {
                    storlek = Integer.parseInt(input);
                    break;
                }
            } catch (Exception e) {
                label2.setVisible(true);
            }
        }
        return storlek;
    }

    public static void main(String[] args) {
        Spela spela = new Spela();
    }

}
