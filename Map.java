import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;

public class Map  {

    private int maxX;
    private int maxY;

    private ArrayList<Bahnhof> alleBahnhoefe;
    private ArrayList<Integer[]> allCordinatesBahnhoefe;

    Map(int maxX,int maxY){
        this.maxX=maxX;
        this.maxY=maxY;
        allCordinatesBahnhoefe= new ArrayList<Integer[]>();
        alleBahnhoefe=new ArrayList<Bahnhof>();
    }

    public boolean addNewBahnhof(int posX, int posY, String name){
        Bahnhof a=new Bahnhof(posX,posY,name);
        if ((a.getPosY()<maxX)&&(a.getPosY()<maxY)&&(a.getPosY()>=0)&&(a.getPosX()>=0)){//test Feldgröße
            boolean frei=true;
            for (Integer[] b:allCordinatesBahnhoefe) {
                if ((b[0]==a.getPosX())||(b[1]==a.getPosY())){
                    frei=false;
                    break;
                }
            }
            if (frei){
                alleBahnhoefe.add(a);
                allCordinatesBahnhoefe.add(new Integer[]{a.getPosX(),a.getPosY()});
                return true;
            } else{
                System.out.println("Fehler Bahnhof konnte nicht auf der Karte Plaziert werden, da der Platz schon belegt ist");
            }
        }else {
            System.out.println("Fehler Bahnhof konnte nicht zur Karte hinzugefügt werden, der Bahnhof befindet sich auserhalb der Karte");
        }
       return false;
    }

    public boolean removeBahnhof(Integer[] cordinaten){
        boolean da=false;
        for (Integer [] adressen:allCordinatesBahnhoefe) {
            if (adressen==cordinaten){
                da=true;
            }
        }
        for (int i = 0; i <alleBahnhoefe.size() ; i++) {
            if ((alleBahnhoefe.get(i).getPosX()==cordinaten[0])&&(alleBahnhoefe.get(i).getPosY()==cordinaten[1])){
                alleBahnhoefe.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer[]> getAllCordinatesBahnhoefe() {
        return allCordinatesBahnhoefe;
    }

    public void verbindeBahnhoefe(String nameBahnhof1,String nameBahnhof2){
        Bahnhof bahnhof1=null;
        Bahnhof bahnhof2=null;
        for (int i = 0; i <alleBahnhoefe.size() ; i++) {
            if (alleBahnhoefe.get(i).getName().equalsIgnoreCase(nameBahnhof1)){
                bahnhof1=alleBahnhoefe.get(i);
            }
            if (alleBahnhoefe.get(i).getName().equalsIgnoreCase(nameBahnhof2)){
                bahnhof2=alleBahnhoefe.get(i);
            }
        }
        for (int i = 0; i <alleBahnhoefe.size() ; i++) {
            if (alleBahnhoefe.get(i).getName().equalsIgnoreCase(nameBahnhof1)){
                alleBahnhoefe.get(i).helferVerbindung(bahnhof2);
            }
            if (alleBahnhoefe.get(i).getName().equalsIgnoreCase(nameBahnhof2)){
                alleBahnhoefe.get(i).helferVerbindung(bahnhof1);
            }
        }

    }
}
