package Inlämning_3;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spela extends JFrame implements ActionListener {

    Spelplan_GUI sp;

    JFrame frame = new JFrame();

    JPanel panelDemo = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JLabel headLable = new JLabel("15-spelet", SwingConstants.CENTER);
    JLabel textLable = new JLabel("Sortera brickorna i rätt nummerordning", SwingConstants.CENTER);

    //JLabel pic = new JLabel("src/Inlämning_3/15-spel");

    JButton buttomDemo = new JButton("DEMO");
    JButton buttomPlay = new JButton("SPELA");


    public Spela(){

        frame.add(panelDemo);
        panelDemo.add(headLable);
        panelDemo.add(buttomDemo);
        panelDemo.add(buttomPlay);

        panelDemo.setLayout(new BorderLayout());
        panelDemo.add(northPanel, BorderLayout.CENTER);
        panelDemo.add(southPanel, BorderLayout.SOUTH);

        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(headLable);
       // northPanel.add(pic);
        northPanel.add(textLable);
        southPanel.add(buttomDemo);
        southPanel.add(buttomPlay);

        buttomDemo.addActionListener(this);
        buttomPlay.addActionListener(this);

        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        headLable.setFont(new Font("Ink Free", Font.PLAIN, 24));
        textLable.setFont(new Font("Ink Free", Font.PLAIN, 18));
        buttomDemo.setFont(new Font("Ink Free", Font.PLAIN, 18));
        buttomPlay.setFont(new Font("Ink Free", Font.PLAIN, 18));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttomDemo){
            DemoCompleteGame dg = new DemoCompleteGame();
        }
        if (e.getSource()==buttomPlay){
            int storlek = Integer.parseInt(JOptionPane.showInputDialog("Ange önskat antal rutor (ange antal rutor per rad)"));
            sp = new Spelplan_GUI(storlek);
        }
        if ((e.getSource()==buttomPlay ||e.getSource() == buttomDemo)){
            frame.dispose();
        }
    }





    public static void main(String[] args) {
        Spela spela = new Spela();
    }


}

//Tar in önskad storlek på spelet vi spelets början
//  int storlek = Integer.parseInt(JOptionPane.showInputDialog("Ange önskat antal rutor (ange antal rutor per rad)"));

//skapar upp ett objekt av Spelplan_GUI-klassen
//  sp = new Spelplan_GUI(storlek);

//behöver while-loop som kontrollerar ifall spelet är completed efter en knapptryckning

//behöver metod som kontrollerar om JButton "1" ligger på JPanel "1" osv...

//behöver metod som avslutar spelet eller "Nytt spel" etc.. Grattis du vann! "game over  etc...

//färger, storlek, etc etc....

// behöver kod som flyttar en brickas position

//en demoinställning som lägger brickorna en position från vinst så vinst kan demonstreras.

// makeAMove(sp.klickedPosition);

//
