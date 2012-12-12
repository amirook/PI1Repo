import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Collider.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Collider extends Actor
{
    private HashMap<Class, Actor> collisions;
    
    /**
     * Act - Tue was immer Collider tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        // Fügen Sie Ihren Aktions-Code hier ein.
    }
    
    private Actor getCollidingActor(Class actorClass){
        return getOneIntersectingObject(actorClass);
    }
    
    private boolean isColliding(Class actorClass){
        return getCollidingActor(actorClass) != null;
    }
    
    private boolean newCollision(Class actorClass) {
        Actor actorObject =  getCollidingActor(actorClass);
        if ( isColliding(actorClass) ){
            if (collisions.get(actorClass) == null || collisions.get(actorClass) != actorObject ){
                collisions.put(actorClass, actorObject);
                return true;
            }
        }
        return false;
    }
}
