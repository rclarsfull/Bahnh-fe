import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;



class Main  {



  public static void main(String[] args) {


    int maxX = 400;
    int maxY = 400;

    Map map=new Map(maxX,maxY);

    map.addNewBahnhof(20,30,"Michelstadt");
    map.addNewBahnhof(40,220,"Erbach");
    map.addNewBahnhof(70,120,"Badkönig");
    map.addNewBahnhof(200,200,"Darmstadt");

    map.verbindeBahnhoefe("Michelstadt","Erbach");
    map.verbindeBahnhoefe("Michelstadt","Badkönig");
    map.verbindeBahnhoefe("Badkönig","Darmstadt");

    System.out.println(map.getAlleBahnhoefe().get(1));

    /*
    ArrayList<Integer[]> test= map.getAllCordinatesBahnhoefe();
    for (Integer[] a:
         test) {
      System.out.println(a[0]+" "+a[1]);
    }
    */

    JFrame frame = new JFrame("Map");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //Canvas canvas = new Paint();
    frame.setSize(400,400);
    //frame.pack();
    frame.setVisible(true);
    Paint paint=new Paint(map.getAlleBahnhoefe());
    frame.add(paint);
    //frame.repaint();
    frame.setVisible(true);



  }




}
