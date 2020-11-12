import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Paint extends JPanel {
    ArrayList<Bahnhof> alleBahnhoefe;


    public Paint(ArrayList<Bahnhof> alleBahnhoefe){
        this.alleBahnhoefe=alleBahnhoefe;

    }


    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);



        for (Bahnhof b:alleBahnhoefe) {

            g.fillOval(b.getPosX(), b.getPosY(), 10*b.getAnzahlVerbindungen(), 10*b.getAnzahlVerbindungen());
            g.drawString(b.getName(),b.getPosX(),b.getPosY()+10+10*b.getAnzahlVerbindungen());
        }

    }
}
