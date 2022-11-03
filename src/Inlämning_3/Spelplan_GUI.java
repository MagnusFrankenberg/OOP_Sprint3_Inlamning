package Inlämning_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spelplan_GUI extends JFrame implements ActionListener {

    int boardsize;
    int squares;




    JPanel klickedPosition;

    JPanel bottomPanel = new JPanel();

    JPanel panel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();

    JButton buttonNewGame = new JButton("Nytt spel");
    JButton buttomQuitGame = new JButton("Avsluta spel");


    Font myFont1 = new Font("Ink Free", Font.PLAIN, 27);

    Color BlueGreen = new Color(100, 230, 220);

    List<JButton> buttons = new ArrayList<>();
    List<JPanel> positions = new ArrayList<>();


    public Spelplan_GUI() {

        this.boardsize = sizeChooser();
        this.squares = boardsize * boardsize;

        add(panel);
        panel.add(bottomPanel);

        panel.setLayout(new BorderLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);

        bottomPanel.setLayout(new GridLayout(boardsize, boardsize, 3, 3));
        southPanel.setLayout(new FlowLayout());

        northPanel.add(bottomPanel);
        southPanel.add(buttonNewGame);
        southPanel.add(buttomQuitGame);


        buttomQuitGame.addActionListener(this);
        buttonNewGame.addActionListener(this);


        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //frame.pack();
        setVisible(true);


        //lägger till x st positioner (JPanel-objekt) på bottomPanel och lägger dem i listan positions
        for (int i = 0; i < squares; i++) {
            positions.add(new JPanel());
            positions.get(i).setName(String.valueOf(i + 1));  //ger varje JPanel ett namn från "1"-"16"
            positions.get(i).setLayout(new GridLayout());
            bottomPanel.add(positions.get(i));
        }

        //skapar upp x st buttons-objekt och lägger i listan buttons
        for (int i = 0; i < squares; i++) {
            buttons.add(new JButton(String.valueOf(i)));   //ger varje JButton en knapptext från "1"-"16"
            buttons.get(i).setFont(myFont1);
            buttons.get(i).setBackground(BlueGreen);
            buttons.get(i).addActionListener(this);
            buttons.get(i).addMouseListener(muspressed);

        }
        //sätter button 0 == osynlig, detta blir den tomma rutan
        buttons.get(0).setVisible(false);

        //shufflar buttons-listan
        Collections.shuffle(buttons);

        //lägger till shufflade buttons på positionerna (en button på varje JPanel)
        for (int i = 0; i < squares; i++) {
            positions.get(i).add(buttons.get(i));
        }
        pack();
    }

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

    MouseListener muspressed = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            for (int i = 0; i < buttons.size(); i++) {
                if (e.getSource() == buttons.get(i)) {
                    buttons.get(i).setForeground(Color.orange);
                    buttons.get(i).revalidate();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < buttons.size(); i++) {
                if (e.getSource() == buttons.get(i)) {
                    buttons.get(i).setForeground(Color.black);
                    buttons.get(i).revalidate();
                }
            }
        }
    };


    //hitta tom position (=hitta button med text "0" och returnera JPanel som den ligger på)
    public JPanel findEmptyPosition() {
        JPanel emptyposition = null;
        JButton button;
        for (int i = 0; i < squares; i++) {
            button = ((JButton) positions.get(i).getComponent(0));  //här castar man från Component-type till JButton-type
            if (button.getText().equals("0")) {
                emptyposition = positions.get(i);
            }
        }
        return emptyposition;
    }

    //kollar om det är tillåtet att flytta från en position till den tomma positionen
    public boolean isPermittedSwap(JPanel emptyposition, JPanel tryFromPosition) {
        //skapar integers av positionsnumren
        int emptyPos = Integer.parseInt(emptyposition.getName());
        int tryFromPos = Integer.parseInt(tryFromPosition.getName());

        // identifierar rad och kolumn för tom ruta:
        int emptyPosRow = ((emptyPos - 1) / boardsize) + 1;
        int emptyPosCol = ((emptyPos - 1) % boardsize) + 1;

        // identifierar rad och kolumn för tryfrom position:
        int tryFromRow = ((tryFromPos - 1) / boardsize) + 1;
        int tryFromCol = ((tryFromPos - 1) % boardsize) + 1;

        //endast tillåtet att flytta 1 steg på spelplanen (horisontellt eller vertikalt)
        boolean isPermitted = false;
        if (emptyPosCol == tryFromCol) {
            if (Math.abs(emptyPosRow - tryFromRow) == 1) {
                isPermitted = true;
            }
        } else if (emptyPosRow == tryFromRow) {
            if (Math.abs(emptyPosCol - tryFromCol) == 1) {
                isPermitted = true;
            }
        }
        return isPermitted;
    }

    public boolean makeAMove(JPanel klickedPos) {
        boolean movedSuccesfully = false;
        if (isPermittedSwap(findEmptyPosition(), klickedPos)) {
            JButton empty = ((JButton) findEmptyPosition().getComponent(0));
            JButton klicked = ((JButton) klickedPos.getComponent(0));

            empty.setText(klicked.getText());
            empty.setVisible(true);

            klicked.setText("0");
            klicked.setVisible(false);

            movedSuccesfully = true;
        }
        return movedSuccesfully;
    }

    public boolean gameCompleted() {
        boolean completed = true;
        for (int i = 0; i < squares - 1; i++) {
            String buttonNo = ((JButton) positions.get(i).getComponent(0)).getText();
            String positionNo = String.valueOf(i + 1);
            if (!buttonNo.equals(positionNo)) {
                completed = false;
                break;
            }
        }
        return completed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //kollar vilken knapp tom tryckts, identifierar knappens position
        for (int i = 0; i < squares; i++) {
            if (buttons.get(i) == e.getSource()) {
                klickedPosition = (JPanel) buttons.get(i).getParent(); //castar Component-type till JPanel-type

                makeAMove(klickedPosition);
                if (gameCompleted()) {
                    dispose();
                    winningTheGame();
                }
            }
        }
        if (e.getSource() == buttomQuitGame) {
            System.exit(0);
        }
        if (e.getSource() == buttonNewGame) {
            dispose();
            new Spelplan_GUI();
        }
    }

    public void winningTheGame() {
        Color myColor = new Color(0,150,0);
        JLabel label = new JLabel("Grattis, du vann!");
        label.setFont(new Font("Ink Free", Font.PLAIN, 24));
        label.setForeground(myColor);
        JOptionPane.showMessageDialog(null,label);

        int dialogbutton;
        dialogbutton = JOptionPane.showConfirmDialog(null, "Vill du spela igen?", "", JOptionPane.YES_NO_OPTION);
        if (dialogbutton == JOptionPane.YES_OPTION) {
            dispose();
            new Spelplan_GUI();
        } else if (dialogbutton == JOptionPane.NO_OPTION) {
            dispose();
            System.exit(0);
        }
    }
}


