import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
import java.awt.Color;
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
     * Testmodus, der die Überschneidenden Pixel rot färbt.
     */
    private boolean testMode = true;
    
    /**
     * Liefert das Objekt der Klasse cls, mit dem eine Kolliosion besteht.
     * @param cls die Klasse, nach dessen Kollision geprüft wird
     * @return das Objekt, mit dem Kollidiert wurde
     */
     public Actor getCollidingObject(Class cls){
        List<Actor> objects = getIntersectingObjects(cls);
        
        for (Actor object : objects){
                for (int x = 0; x < this.getImage().getWidth(); x++){
                    for (int y = 0; y < this.getImage().getHeight(); y++){
                        if (this.getImage().getColorAt(x, y).getAlpha() > 0){
                            double rotation = Math.toRadians(this.getRotation());
                            double dx = x - this.getImage().getWidth() / 2;
                            double dy = y - this.getImage().getHeight() / 2;
                            int xWorld = (int) (this.getX() + dx * Math.cos(rotation) - dy * Math.sin(rotation));
                            int yWorld = (int) (this.getY() + dx * Math.sin(rotation) + dy * Math.cos(rotation));
                            if (pixelsWithinImageBounds(object, xWorld, yWorld) && visiblePixelAt(xWorld, yWorld, object)){
                                if (testMode){
                                    this.getImage().setColorAt(x, y, Color.RED);
                                } else {
                                    return object;
                                }
                            }                            
                        }
                    }
                }
            
        }
        return null;
    }

    /**
     * Prüft ob gerade eine Kollision besteht
     * @param cls die Klasse, nach dessen Kollision geprüft wird
     * @return ob gerade eine Kollision mit einer Instanz der Klasse cls besteht
     */
    public boolean collidesWith(Class cls){
        return getCollidingObject(cls) != null;
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
        } 
        return false;
    }
    
    /**
     * Rechnet Weltkoordinaten in die Bildkoordinaten des Actors um und prüft
     * ob dort ein Sichrbarer sichtbarer Pixel ist
     * @param xWorld x-Weltkoordiante
     * @param yWorld y-Weltkoordinate
     * @param obj Das Objekt in dessen Bildkoordinaten umgerechnet werden soll
     * @return true, wenn an den Koordinsten ein Sichtbarer Pixel im Bild ist
     */
    private boolean visiblePixelAt(int xWorld, int yWorld, Actor obj){
        double rotation = Math.toRadians(obj.getRotation());
        int dx = xWorld - obj.getX();
        int dy = yWorld - obj.getY();
        int xInObject = (int) (obj.getImage().getWidth() / 2 + dx * Math.cos(rotation) + dy * Math.sin(rotation));    
        int yInObject = (int) (obj.getImage().getHeight() / 2 - dx * Math.sin(rotation) + dy * Math.cos(rotation));
        return (obj.getImage().getColorAt(xInObject, yInObject).getAlpha() > 0 );
    }
    
    /**
     * Prüft ob ein die Koordinaten innerhalb des Bildes eines Objektes liegen
     * @param obj Das zu Prüfende Objekt
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @return true, wenn die Koordinaten innerhalb des Bildes liegen
     */
    private boolean pixelsWithinImageBounds(Actor obj, int x, int y){
        int xStart = obj.getX() - obj.getImage().getWidth() / 2;
        int xEnd = xStart + obj.getImage().getWidth();
        int yStart = obj.getY() - obj.getImage().getHeight() / 2;
        int yEnd = yStart + obj.getImage().getHeight();
        return x >= xStart && x < xEnd && y >= yStart && y < yEnd;
    }
}
