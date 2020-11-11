import java.awt.*;
import javax.swing.JFrame;
import java.util.Random;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

//mapObjekt erstellen
class Main extends Canvas {

  public static void main(String[] args) {


    int maxX = 400;
    int maxY = 400;

    Map map=new Map(maxX,maxY);



    JFrame frame = new JFrame("Map");
    Canvas canvas = new Main();
    canvas.setSize(maxX, maxY);
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);


    //Testbanh�fe erstellen


  }

  public void paint(Graphics g) {
    g.fillOval(10, 10, 5, 5);


  }

}
