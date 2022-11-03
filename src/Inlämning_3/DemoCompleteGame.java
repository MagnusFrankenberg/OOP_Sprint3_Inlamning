package Inlämning_3;

import javax.swing.*;

public class DemoCompleteGame {



    public DemoCompleteGame(){
        int storlek = Integer.parseInt(JOptionPane.showInputDialog("Ange önskat antal rutor (ange antal rutor per rad)"));

       Spelplan_GUI demo = new Spelplan_GUI(storlek);
        for (int i = 0; i < demo.squares-2; i++) {
            JPanel position = demo.positions.get(i);
            JButton button = (JButton) demo.positions.get(i).getComponent(0);
            button.setText(position.getName());
            button.setVisible(true);
        }
        JButton buttonZero = (JButton) demo.positions.get(demo.squares-2).getComponent(0);
        buttonZero.setText("0");
        buttonZero.setVisible(false);

        JButton buttonLast = (JButton) demo.positions.get(demo.squares-1).getComponent(0);
        buttonLast.setText(String.valueOf(demo.squares-1));
        buttonLast.setVisible(true);


    }
}
