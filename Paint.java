import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Paint extends JPanel {
    ArrayList<Bahnhof> alleBahnhoefe;
    int maxX;
    int maxY;


    public Paint(ArrayList<Bahnhof> alleBahnhoefe,int maxX,int maxY){
        this.alleBahnhoefe=alleBahnhoefe;
        this.maxX=maxX;
        this.maxY=maxY;

    }


    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawRect(30,30,maxX,maxY);

        g.setColor(Color.gray);
        for (Bahnhof b:alleBahnhoefe) {

            int absulutPosX=b.getPosX()+30;
            int absulutPosY=b.getPosY()+30;

            for (Bahnhof b2: b.getVerbundenZu()){
                g.drawLine(absulutPosX,absulutPosY,b2.getPosX()+30,b2.getPosY()+30);
            }
        }


        g.setColor(Color.blue);
        for (Bahnhof b:alleBahnhoefe) {
            int width=10*b.getAnzahlVerbindungen();
            int heigth=10*b.getAnzahlVerbindungen();
            int absulutPosX=b.getPosX()+30;
            int absulutPosY=b.getPosY()+30;

            g.fillOval(((int)(absulutPosX-0.5*width)), ((int)(absulutPosY-0.5*heigth)), width, heigth);
            g.drawString(b.getName(),(int)(absulutPosX-b.getName().length()*2.8),absulutPosY+5+10*b.getAnzahlVerbindungen());
        }


    }
}
