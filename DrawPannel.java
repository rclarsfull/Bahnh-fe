import javax.swing.*;
import java.awt.*;

public class DrawPannel extends JPanel {
    public void paintComponent(Graphics g,Map map){
        for (Integer[]cordinaten:map.getAllCordinatesBahnhoefe()) {
            g.fillOval(cordinaten[0], cordinaten[1], 5, 5);
        }
    }
}
