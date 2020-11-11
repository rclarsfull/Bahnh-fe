import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Map {

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

    public boolean addBahnhof(@NotNull Bahnhof a){
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
}
