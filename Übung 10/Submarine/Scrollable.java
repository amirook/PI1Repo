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
    
    public void removeIfExitingWorld()
    {
        int width = getWorld().getWidth();
        int height = getWorld().getHeight();
        int imagew = getImage().getWidth();
        int imageh = getImage().getHeight();
        int myX = this.getX();
        int myY = this.getY();
        if (myX>=width-(imagew/2) || myX<=0+(imagew/2) || myY>=height-(imageh/2) || myY<=0+(imageh/2)){
            getWorld().removeObject(this);
        }
    }
}
