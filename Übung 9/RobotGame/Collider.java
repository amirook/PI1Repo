import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.HashMap;
import java.util.List;
import java.awt.Color;

/**
 * Die Klasse bietet einige Methoden zum Testen auf Kollisionen mit anderen Objekten an. 
 * (Übungsblatt 8)
 * 
 * @author Thomas Röfer 
 * @version 05.12.2012
 */
public class Collider extends Actor
{
    /** Ist der Testmodus aktiv? */
    private static boolean testMode = false;
    
    /** Bild bei der nächsten Kollision im Testmodus zurücksetzen? */
    boolean resetImage;

    /** Merkt sich pro Actor-Klasse, mit welchem Objekt gerade eine Kollision besteht. */
    private HashMap<Class, Actor> activeCollisions = new HashMap<Class, Actor>();

    /**
     * Liefert das erste Objekt der übergebenen Klasse zurück, mit dem dieses kollidiert.
     * @param clazz Die Klasse der Objekte, die auf Kollisionen getestet werden. Falls null,
     *              wird mit allen Objekten getestet.
     * @return Das Objekt, mit dem eine Kollision besteht, oder null, falls es keine
     *         Kollision gibt.
     */
    public Actor getCollidingObject(Class clazz)
    {
        List<Actor> actors = getIntersectingObjects(clazz);
        resetImage = testMode;
        for (Actor actor : actors) {
            if (confirmCollisionWith(actor)) {
                return actor;
            }
        }
        return null;
    }

    /**
     * Stellt fest, ob dieses Objekt mit einer Instanz der übergebenen Klasse kollidiert.
     * @param clazz Die Klasse der Objekte, die auf Kollisionen getestet werden. Falls null,
     *              wird mit allen Objekten getestet.
     * @return Gibt es eine Kollision?
     */
    public boolean collidesWith(Class clazz)
    {
        return getCollidingObject(clazz) != null;
    }

    /**
     * Stellt fest, ob gerade eine Kollision zwischen diesem Objekt und einer Instanz der 
     * übergebenen Klasse begonnen hat.
     * @param clazz Die Klasse der Objekte, die auf Kollisionen getestet werden. Falls null,
     *              wird mit allen Objekten getestet.
     * @return Hat gerade eine neue Kollision begonnen?
     */
    public boolean newCollisionWith(Class clazz) 
    {
        Actor lastCollision = activeCollisions.get(clazz);
        Actor currentCollision = getCollidingObject(clazz);
        activeCollisions.put(clazz, currentCollision);
        return currentCollision != null && currentCollision != lastCollision;
    }

    /**
     * Bestätigen der Kollision zwischen zwei Actoren. Es wird für jedes nicht-transparente
     * Pixel im Bild dieses Actors überprüft, ob sich an derselben Stelle in der Welt im
     * Bild des anderen Actors auch ein nicht-transparentes Pixel befindet. In dem Falle liegt
     * eine Kollision vor.
     * @param other Der andere Actor, mit dem die Kollision überprüft wird.
     * @return Liegt tatsächlich eine Kollision zwischen den sichtbaren Teilen beider Bilder
     *         vor?
     */
    private boolean confirmCollisionWith(Actor other)
    {
        resetImageInTestMode();
        
        for (int y = 0; y < getImage().getHeight(); ++y) {
            for (int x = 0; x < getImage().getWidth(); ++x) {
                if (getImage().getColorAt(x, y).getAlpha() > 0) {
                    int[] inWorld = toWorld(this, new int[] {x, y});
                    int[] inOther = toImage(other, inWorld);
                    if (inOther[0] >= 0 && inOther[0] < other.getImage().getWidth() &&
                        inOther[1] >= 0 && inOther[1] < other.getImage().getHeight() &&
                        other.getImage().getColorAt(inOther[0], inOther[1]).getAlpha() > 0) {
                        if (testMode) {
                            getImage().setColorAt(x, y, Color.RED);
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Transformation der Pixelkoordinaten eines Actors in Weltkoordinaten.
     * @param actor Der Actor, zu dem das Pixel gehört
     * @param inImage Die Koordinaten des Pixels innerhalb des Bildes des Actors.
     * @return Die Koordinaten desselben Pixels innerhalb der Welt.
     */
    private static int[] toWorld(Actor actor, int[] inImage)
    {
        int dx = inImage[0] - actor.getImage().getWidth() / 2;
        int dy = inImage[1] - actor.getImage().getHeight() / 2;
        double theta = Math.toRadians(actor.getRotation());
        return new int[] {
            (int) (actor.getX() + dx * Math.cos(theta) - dy * Math.sin(theta)),
            (int) (actor.getY() + dx * Math.sin(theta) + dy * Math.cos(theta))
        };
    }

    /**
     * Transformation von Weltkoordinaten in die Pixelkoordinaten eines Actors.
     * @param actor Der Actor, in dessen Pixelkoordinaten transformiert wird.
     * @param inWorld Die Weltkoordinaten des Pixels.
     * @return Die Koordinaten desselben Pixels innerhalb des Bilds des Actors.
     */
    private static int[] toImage(Actor actor, int[] inWorld)
    {
        int dx = inWorld[0] - actor.getX();
        int dy = inWorld[1] - actor.getY();
        double theta = Math.toRadians(actor.getRotation());
        return new int[] {
            (int) (actor.getImage().getWidth() / 2 + dx * Math.cos(theta) + dy * Math.sin(theta)),
            (int) (actor.getImage().getHeight() / 2 - dx * Math.sin(theta) + dy * Math.cos(theta))
        };
    }

    /**
     * Aktivieren oder Deaktivieren des Testmodus'. Im Testmodus werden keine Kollisionen
     * mehr gemeldet und alle Kollisionstests zeichnen Überlappungen mit anderen Objekten
     * bei sich in rot ein.
     * @param active Testmodus aktivieren?
     */
    public static void setTestMode(boolean active)
    {
        testMode = active;
    }
    
    /**
     * Ersetzt das Bild dieses Objekts wieder durch das zuletzt geladene.
     * Das funktioniert nur, wenn der Dateiname des Bildes keine zwei aufeinander
     * folgenden Leerzeichen enthält.
     */
    private void resetImageInTestMode()
    {
        if (resetImage) {
            String description = getImage().toString();
            int endIndex = description.indexOf("  ");
            String filename = description.substring(17, endIndex);
            setImage(filename);
            resetImage = false;
        }
    }
}