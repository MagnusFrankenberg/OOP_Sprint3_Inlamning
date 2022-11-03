package Inlämning_3;

import javax.swing.*;
import java.awt.*;

public class SizeChooser {



    public int SizeChooser() {
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
}
