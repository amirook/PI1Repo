import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Ghost.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Leopold schulz-Hanke (Leo) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Ghost extends Enemy
{
    private Robot target; 
    
    /**
     * Act - Tue was immer Ghost tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        if (newCollisionWith(Robot.class)) {
            Greenfoot.playSound("sad-trombone.wav");
            target = null;
        }
        move(1);
        
        //kollision mit Spielfeld grenzen
        int width  = getWorld().getWidth();
        int height = getWorld().getHeight();
        int iwidth  = getImage().getWidth();
        int iheight = getImage().getHeight();
        if (this.getX()-(iwidth/2)<=0 || this.getX()+(iwidth/2)>= width||
        this.getY()-(iheight/2)<=0 || this.getY()+(iheight/2)>=height) {
            turn(3);
        }
        
        //warscheinlichkeit sich zum Spieler zu drehen
        if(Greenfoot.getRandomNumber(150)==1) {
            setNextTarget();
            turnTowardsObject(target);
        }
        else{
            turn(Greenfoot.getRandomNumber(6)-3);
        }
    }

    private void setNextTarget(){
        //erfasst den nächsten/neusten Spieler im Radius und setzt den Geist auf diesen an
        Robot obj= (Robot) ObjectInRange(1000,Robot.class);
        if(obj != target && obj != null) {
            target = obj;
        }
    }
}
