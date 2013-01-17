import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Das Inventar eines Actors. Aktuell kann das Inventar nur ein Objekt der Klasse Actor
 * enthalten. Mit Hilfe dieses Objekts, kann die HeldIn Hindernisse überwinden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Inventory extends ServerActor
{
    
    /**
     * Objekt, welches sich im Inventar befindet.
     */
    private Actor collectable;
    
    /**
     * Fügt einen Actor zum Inventar hinzu, entfernt hinzugefügtes Objekt auch aus der Welt.
     * 
     * @param collectable Das, im Inventar zu speichernde Objekt.
     */
    public void pushToInventory(Actor collectable){
        this.collectable = collectable;
        getWorld().removeObject(collectable);
        this.getImage().drawImage(collectable.getImage(), 10, 0);
        Greenfoot.playSound("pop.wav");
    }
    
    /**
     * Entfernt das Objekt aus dem Inventar und setzt es wieder in die Welt.
     * 
     * @param xPos x-Position des Flappers, an die das Objekt zurück gesetzt wird
     * @param yPos y-Position des Flappers, an die das Objekt zurück gesetzt wird
     */
    public void removeFromInventory(int xPos, int yPos)
    {
        getWorld().addObject(collectable, xPos, yPos);
        collectable = null;
        resetImage();
        Greenfoot.playSound("shutter.wav");
    }
    
    /**
     * Leert das Inventar.
     */
    public void clearInventory()
    {
        collectable = null;
        resetImage();
    }
    
    /**
     * Liefert das im Inventar befindene Objekt zurück.
     * 
     * @return Das Werkzeug, das sich im Inventar bedindet.
     */
    public Actor getInventory()
    {
        return collectable;
    }
    
    /**
     * Prüft, ob das Inventar leer ist.
     * 
     * @return true, wenn das Inventar leer ist, andernfalls false.
     */
    public boolean isEmpty()
    {
        return collectable == null;
    }
    
    /**
     * Zeichnet das Hintergrundbild des Inventars neu.
     */
    private void resetImage()
    {
        this.setImage("inventar_bg.png");
    }
}
