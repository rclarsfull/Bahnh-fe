import java.awt.*;
import javax.swing.JFrame;
import java.util.Random;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

//mapObjekt erstellen
class Main extends Canvas{
  
  public static void main(String[]args){
    
    
    int maxX=400;
    int maxY=400;
    
    ArrayList<Bahnhof> alleBahnhoefe=new ArrayList<Bahnhof>();
    boolean[][] map=new boolean[maxX][maxY];
    
    JFrame frame=new JFrame("Map");
    Canvas canvas=new Main();
    canvas.setSize(maxX,maxY);
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    
    
    //Testbanhöfe erstellen
    alleBahnhoefe.add(new Bahnhof(100,200,"Erbach"));
    
    alleBahnhoefe.add(new Bahnhof(150,100,"Michelstadt"));
    
    alleBahnhoefe.get(0).bahnhoefeVerbinden(alleBahnhoefe.get(1));
    alleBahnhoefe.get(1).bahnhoefeVerbinden(alleBahnhoefe.get(0));
    
    alleBahnhoefe.add(new Bahnhof(140,250,"Höchst"));
    
    alleBahnhoefe.get(1).bahnhoefeVerbinden(alleBahnhoefe.get(2));
    alleBahnhoefe.get(2).bahnhoefeVerbinden(alleBahnhoefe.get(1));
    
    alleBahnhoefe.add(new Bahnhof(200,300,"Darmstadt"));
    
    alleBahnhoefe.get(2).bahnhoefeVerbinden(alleBahnhoefe.get(3));
    alleBahnhoefe.get(3).bahnhoefeVerbinden(alleBahnhoefe.get(2));
    
    }
  
  public void paint(Graphics g,){
    //g.fillOval(posX,posY,5,5);
    
    }
  
  public boolean baueBahnhof(int posX,int posY,String name){
    if (((posX<0)||(posX>=400))&&((posY<0)||(posY>=400))) {
      return false;
    } // end of if
    
    
    
    }
  
  
  }
