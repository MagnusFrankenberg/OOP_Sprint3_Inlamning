package Inlämning_3;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spela extends JFrame implements ActionListener {

    JFrame frame = new JFrame();

    JPanel panelDemo = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JLabel headLable = new JLabel("15-spelet", SwingConstants.CENTER);
    JLabel textLable = new JLabel("Sortera brickorna i rätt nummerordning", SwingConstants.CENTER);

    JButton buttomDemo = new JButton("DEMO");
    JButton buttomPlay = new JButton("SPELA");


    public Spela() {

        frame.add(panelDemo);
        panelDemo.add(headLable);
        panelDemo.add(buttomDemo);
        panelDemo.add(buttomPlay);

        panelDemo.setLayout(new BorderLayout());
        panelDemo.add(northPanel, BorderLayout.CENTER);
        panelDemo.add(southPanel, BorderLayout.SOUTH);

        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(headLable);
        northPanel.add(textLable);
        southPanel.add(buttomDemo);
        southPanel.add(buttomPlay);

        buttomDemo.addActionListener(this);
        buttomPlay.addActionListener(this);

        frame.setSize(400, 200);
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
        if (e.getSource() == buttomDemo) {
            DemoCompleteGame dg = new DemoCompleteGame();
        }
        if (e.getSource() == buttomPlay) {
            new Spelplan_GUI(new SizeChooser().SizeChooser());
        }
        if ((e.getSource() == buttomPlay || e.getSource() == buttomDemo)) {
            frame.dispose();
        }
    }

        public static void main(String[] args) {
            Spela spela = new Spela();
        }


    }

