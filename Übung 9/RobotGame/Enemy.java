import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.List;
/**
 * Beschreiben Sie hier die Klasse Enemy.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Leopold schulz-Hanke (Leo) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Enemy extends Collider
{
    /**
     * Act - Tue was immer Enemy tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        // Fügen Sie Ihren Aktions-Code hier ein.
    }    
    
    protected Object ObjectInRange(int range, Class cls)
    {
        List<Actor> objects = getObjectsInRange(range,cls);
        for (Actor object : objects) {
            if(object.getClass()== cls) {
                return object;
            }
        }
        return null;
    }
    
    /**
     * Dreht das Objekt in Richtung eine Actors. Im Moment werden die Objekte
     * in Richtung des Roboters gedreht.
     * @param actor in dessen Richtung sich der Gegner dreht
     */
    public void turnTowardsObject(Actor actor){
        turnTowards(actor.getX(),actor.getY());
    }
}
