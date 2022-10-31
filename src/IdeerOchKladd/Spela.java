package IdeerOchKladd;

import javax.swing.*;

public class Spela {

    Spelplan_GUI sp;

    public Spela(){

        //Tar in önskad storlek på spelet vi spelets början
        int storlek = Integer.parseInt(JOptionPane.showInputDialog("Ange önskat antal rutor (ange antal rutor per rad)"));

        //skapar upp ett objekt av Spelplan_GUI-klassen
       sp = new Spelplan_GUI(storlek);

       //behöver while-loop som kontrollerar ifall spelet är completed efter en knapptryckning

       //behöver metod som kontrollerar om JButton "1" ligger på JPanel "1" osv...

        //behöver metod som avslutar spelet eller "Nytt spel" etc.. Grattis du vann! "game over  etc...

        //färger, storlek, etc etc....

        // behöver kod som flyttar en brickas position

        //en demoinställning som lägger brickorna en position från vinst så vinst kan demonstreras.

       // makeAMove(sp.klickedPosition);

        //



    }





    public static void main(String[] args) {
        Spela spela = new Spela();
    }

}
