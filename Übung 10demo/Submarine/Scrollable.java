import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Beschreiben Sie hier die Klasse Scrollable.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Scrollable extends ServerActor
{
    /**
     * Act - Tue was immer Scrollable tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        // Fügen Sie Ihren Aktions-Code hier ein.
    }
    
    public void scroll(int direction){
        this.setLocation(this.getX()+direction, this.getY());
    }
}
