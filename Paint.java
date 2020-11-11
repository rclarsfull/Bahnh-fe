import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Paint extends JPanel {
    ArrayList<Integer[]> cordinaten;


    public Paint(ArrayList<Integer[]> cordinaten){
        this.cordinaten=cordinaten;

    }


    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);



        for (Integer[]cordinaten:cordinaten) {

            g.fillOval(cordinaten[0], cordinaten[1], 10, 10);
        }

    }
}
