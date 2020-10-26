import java.util.ArrayList;
import javax.swing.JFrame;
class Bahnhof{
  int posX;
  int posY;
  String name;
  ArrayList<Bahnhof> verbundenZu;
  
  
  Bahnhof(int posX,int posY,String name){
    verbundenZu=new ArrayList<Bahnhof>() ;
    
    this.posX=posX;
    this.posY=posY;
    this.name=name;
    
  
  }
  
  public void bahnhoefeVerbinden(Bahnhof a){
    verbundenZu.add(a);
    }
  
  public String einzelnToString(){
    return this.name+"\t Adresse:"+this.posX+" "+this.posY; 
    }
  
  public String toString(){
    String a= this.name+"\t Adresse:"+this.posX+" "+this.posY+"\n";
    for (Bahnhof b:verbundenZu) {
      a+="\t\t"+b.einzelnToString()+"\n";
    } // end of for
    a+="\n";
    return a;
    }
  
  
  
  
  
  
  }
