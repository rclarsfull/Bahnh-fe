
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;




class Container {


  public static void addBahnhofToMap(int posX,int posY,String name,String verbindenMit,Map map){
    map.addNewBahnhof(posX,posY,name);

    if(verbindenMit.equalsIgnoreCase("")){

    }else{
      String[] verbundenZu=verbindenMit.split(";");
      for (String x:verbundenZu) {
        map.verbindeBahnhoefe(name,x);
      }
    }

  }

  public static ArrayList<String> getBahnhofsNamen(){
    ArrayList<String>ausgabe =new ArrayList<String>();
    File file=new File("DB-Netz_INSPIRE_20200217.txt");
   // if ((!file.canRead())||(file.isFile())){
    //  System.out.println("Fehler beim Import der .xml");
     // return ausgabe;
   // }
    BufferedReader br=null;
    try{
      br=new BufferedReader(new FileReader("DB-Netz_INSPIRE_20200217.txt"));
      String zeile=null;
      while((zeile = br.readLine())!=null){
        if (zeile.contains("<gn:text>")){
          zeile=zeile.split(">")[1];
          zeile=zeile.split("<")[0];
          ausgabe.add(zeile);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      if (br!=null){
        try{
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }
    return ausgabe;
  }

  public static void main(String[] args) {


    int maxX = 400;
    int maxY = 400;

    Map map=new Map(maxX,maxY);
    Random rand=new Random();
    ArrayList<String> bahnhofnamenListeDB=getBahnhofsNamen();

    for (String a:bahnhofnamenListeDB) {
      System.out.println(a);
    }



     addBahnhofToMap(rand.nextInt(400),rand.nextInt(400), "Erbach","",map );
     addBahnhofToMap(rand.nextInt(400),rand.nextInt(400), "Erbach Nord","Erbach",map );
     addBahnhofToMap(rand.nextInt(400),rand.nextInt(400), "Michelstadt","Erbach Nord",map );

   // System.out.println(map.getAlleBahnhoefe().get(5));
   // System.out.println(map.getAbstand(map.getAlleBahnhoefe().get(5),map.getAlleBahnhoefe().get(4)));

    /*
    ArrayList<Integer[]> test= map.getAllCordinatesBahnhoefe();
    for (Integer[] a:
         test) {
      System.out.println(a[0]+" "+a[1]);
    }
    */

    JFrame frame = new JFrame("Map");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(maxX+100,maxY+100);
    frame.setVisible(true);
    Paint paint=new Paint(map.getAlleBahnhoefe(),maxX,maxY);
    frame.add(paint);
    frame.setVisible(true);



  }




}
