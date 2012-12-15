import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
import java.awt.*;
/**
 * Beschreiben Sie hier die Klasse Collider.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Collider extends Actor
{
    /**
     * Eine HashMap um unsere Kollisionen zu protokolieren.
     */
    private HashMap<Class, Actor> collisions = new HashMap();

    /**
     * Act - Tue was immer Collider tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        // Fügen Sie Ihren Aktions-Code hier ein.
    }
    
//     /**
//      * Liefert das Objekt der Klasse cls mit dem eine Kolliosion besteht.
//      * @param cls die Klasse, nach dessen Kollision geprüft wird
//      * @return das Objekt, mit dem Kollidiert wurde
//      */
//     public Actor getCollidingObject(){
//         for (Map.Entry<Class, Actor> entry : collisions.entrySet()){
//             Actor obj = getOneIntersectingObject(entry.getKey());
//             if (obj != null){
//                 for (int x = 0; x < this.getImage().getWidth(); x++){
//                     for (int y = 0; y < this.getImage().getHeight(); y++){
//                         if (this.getImage().getColorAt(x, y).getAlpha() > 0){
//                             int xWorld = (int) (this.getX() + (x - this.getImage().getWidth() / 2) * Math.cos(Math.toRadians(this.getRotation())) - (y - this.getImage().getHeight() / 2) * Math.sin(Math.toRadians(this.getRotation())));
//                             int yWorld = (int) (this.getY() + (x - this.getImage().getWidth() / 2) * Math.sin(Math.toRadians(this.getRotation())) - (y - this.getImage().getHeight() / 2) * Math.cos(Math.toRadians(this.getRotation())));
//                             if (visiblePixelAt(xWorld, yWorld, obj)){
//                                 return obj;
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return null;
//     }

     public Actor getCollidingObject(Class cls){
        return getOneIntersectingObject(cls);
    }

    /**
     * Prüft ob gerade eine Kollision besteht
     * @param cls die Klasse, nach dessen Kollision geprüft wird
     * @return ob gerade eine Kollision mit einer Instanz der Klasse cls besteht
     */
    public boolean collidesWith(Class cls){
        if(getCollidingObject(cls) != null){
            return getCollidingObject(cls).getClass() == cls;
        }
        return false;
    }

    /**
     * Prüft, ob gerade eine neue Kollision mit einer Instanz
     * der Klasse cls begonnen hat.
     * @param cls die Klasse, nach dessen Kollision geprüft wird
     * @return ob gerade eine neue Kollision mit einer Instanz der Klasse cls begonnen hat
     */
    public boolean newCollisionWith(Class cls) {
        Crashable obj =  null;
        if ( collidesWith(cls) ){
            if (collisions.get(cls) == null || collisions.get(cls) != obj ){
                collisions.put(cls, obj);
                return true;
            }
        } else {
            collisions.remove(cls);
        }
        return false;
    }
    
//     private boolean visiblePixelAt(int xWorld, int yWorld, Actor obj){
//         int xInObject = (int) (obj.getImage().getWidth() / 2 + (xWorld - obj.getX()) * Math.cos(Math.toRadians(obj.getRotation())) + (yWorld - obj.getY()) * Math.sin(Math.toRadians(obj.getRotation())));    
//         int yInObject = (int) (obj.getImage().getHeight() / 2 + (xWorld - obj.getX()) * Math.sin(Math.toRadians(obj.getRotation())) + (yWorld - obj.getY()) * Math.cos(Math.toRadians(obj.getRotation())));    
//         return (obj.getImage().getColorAt(xInObject, yInObject).getAlpha() > 0 );
//     }
}
