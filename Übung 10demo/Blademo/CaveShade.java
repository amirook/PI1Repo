import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaveShade extends Actor
{
    /**bestimmt ob es eine Lichtquelle im Level gibt*/
    private boolean lighted=true;//testweise auf true soll später durch getLampHolder gesetzt werden
    
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
        lampHolder = getCurrentLampholder();
        centerOnObject(lampHolder);
        setPropertys();
        
    }    
    
    /**
     * die Methode welche das Bild der Overlayer anpasst
     */
    private void setPropertys()
    {
        getWorld().setPaintOrder(CaveShade.class);//garantiert das die Dunkelheit alles überdeckt
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
     * liefert einen Spieler in der Welt zurück der eine lampe im Inventar hat
     * existieren hierbei mehrere Spieler mit lampen
     * so liefert er immer einen der grade nicht als "lampholder" definiert ist
     * !!!!!!!soll später inventarinhalt überprüfen!!!!!!!!!!
     */
    private Actor getCurrentLampholder()
    {
        List<Actor> subs = getWorld().getObjects(Submarine.class);
        for(Actor sub : subs) {
            if (sub!=null){ //if(bee.myInventory.getInventory==Lamp.class){}
                //if (sub!= lampHolder){    // if() wechselt den Pegel zwischen potentiellen lampenträgern
                    return sub;
                //}
            }
        }
        return null;
    }
}
