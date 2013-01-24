import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Beschreiben Sie hier die Klasse Collider.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Collider extends Scrollable
{
    /**
     * Eine HashMap um unsere Kollisionen zu protokolieren.
     */
    private HashMap<Class, Actor> collisions = new HashMap();
    
    /**
     * Testmodus, der die Überschneidenden Pixel rot färbt.
     */
    private boolean testMode = false;
    
    /**
     * Liefert das Objekt der Klasse cls, mit dem eine Kolliosion besteht.
     * @param cls die Klasse, nach dessen Kollision geprüft wird
     * @return das Objekt, mit dem Kollidiert wurde
     */
     public Actor getCollidingObject(Class cls){
        List<Actor> objects = getIntersectingObjects(cls);
        for (Actor object : objects){
            resetImageInTestMode();   
            
            for (int x = 0; x < this.getImage().getWidth(); x++){
                for (int y = 0; y < this.getImage().getHeight(); y++){
                    if (this.getImage().getColorAt(x, y).getAlpha() > 0){
                        //umrechnung zu Weltkoordinaten
                        int dx = x - this.getImage().getWidth() / 2;
                        int dy = y - this.getImage().getHeight() / 2;
                        double theta = Math.toRadians(this.getRotation());
                        int xInWorld= (int)(this.getX() + dx * Math.cos(theta) - dy * Math.sin(theta));
                        int yInWorld= (int)(this.getY() + dx * Math.sin(theta) + dy * Math.cos(theta));
                        
                        //umrechnung in Bildkoordinaten des Objectes
                        int dx2 = xInWorld - object.getX();
                        int dy2 = yInWorld - object.getY();
                        double theta2 = Math.toRadians(object.getRotation());
                        int xInObject = (int) (object.getImage().getWidth()/2 + dx2 * Math.cos(theta2) + dy2*Math.sin(theta2));
                        int yInObject= (int) (object.getImage().getHeight()/2 - dx2 * Math.sin(theta2) + dy2*Math.cos(theta2));
                        if (pixelsWithinImageBounds(object, xInObject, yInObject) &&
                            object.getImage().getColorAt(xInObject, yInObject).getAlpha() > 0){
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
     * Prüft ob ein die Koordinaten innerhalb des Bildes eines Objektes liegen
     * @param obj Das zu Prüfende Objekt
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @return true, wenn die Koordinaten innerhalb des Bildes liegen
     */
    private boolean pixelsWithinImageBounds(Actor obj, int xInObject, int yInObject){
        if(xInObject >=0 && xInObject < obj.getImage().getWidth() &&
           yInObject >=0 && yInObject < obj.getImage().getHeight()) {
            return true; }
        else{
            return false;}
    }
    
    /**
     * Ersetzt das Bild dieses Objekts wieder durch das zuletzt geladene.
     * Das funktioniert nur, wenn der Dateiname des Bildes keine zwei aufeinander
     * folgenden Leerzeichen enthält.
     */
    private void resetImageInTestMode()
    {
        if (testMode) {
            String description = getImage().toString();
            int endIndex = description.indexOf("  ");
            String filename = description.substring(17, endIndex);
            setImage(filename);
        }
    }
}
