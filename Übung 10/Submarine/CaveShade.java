import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaveShade extends ServerActor
{
    /**bestimmt ob es eine Lichtquelle im Level gibt*/
    private boolean lighted=false;//wird durch get LightHolder gesetzt
    /**bestimmt den Level der Dunkelheit*/
    private int degreeOfVisibility;
    
    /**der aktuelle "lampenträger"*/
    private Actor lampHolder;
    
    /** 
    * jeder Grad vermindert die Sichtbarkeit der Umgebung
    * erschafft bei präsenz einer Lampe einen Lichtpegel
    * @integer (0 bis 255)= Sichtbarkeit der Umgebung 
    * (für 100% sicht 255 eingeben oder Klasse nicht verwenden)
    */
    CaveShade(int degreeOfVisibility)
    {
        this.degreeOfVisibility = degreeOfVisibility;
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        lampHolder = getLightHolder();
        centerOnObject(lampHolder);
        setPropertys();
        
    }    
    
    /**
     * die Methode welche das Bild der Overlayer anpasst
     */
    private void setPropertys()
    {
        getWorld().setPaintOrder(Inventory.class,ScoreBoard.class,CaveShade.class);//garantiert das die Dunkelheit alles überdeckt
        String status= lighted ? "lighted2" :  ""  ;
        setImage("CaveShade" + status + ".png");
        getImage().setTransparency(degreeOfVisibility);
    
    }
    
    public void centerOnObject(Actor sub)
    {
        if(sub!=null) {
            setLocation(sub.getX(),sub.getY());
        }
    }
    
    /**
     * liefert einen Spieler in der Welt zurück der eine lampe im Inventar trägt
     * oder eine klasse Lampe auf dem Spielfeld
     * existiert beides nicht,ist die Welt momentan unbeleuchted
     */
    private Actor getLightHolder()
    {
        List<Submarine> subs = getWorld().getObjects(Submarine.class);
        for(Submarine sub : subs) {
            if (sub!=null && sub.getInventory().contains(Lamp.class))
            {
                lighted=true;
                return sub;
            }
        }
        
        List<Actor> lamps = getWorld().getObjects(Lamp.class);
        for(Actor lamp : lamps) {
             if (lamp!=null){
                lighted=true;
                return lamp;
            }
        }
        lighted=false;
        return null;
    }
}
