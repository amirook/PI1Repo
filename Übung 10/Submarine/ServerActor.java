import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
/**
 * Beschreiben Sie hier die Klasse ServerActor.
 * 
 * Alle Aktoren müssen hiervon erben
 * setLocation überschreiben!!!!!
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */

public abstract class ServerActor extends Actor
{
    public void setLocation(int x, int y){
        WorldManager.heldInServer.setLocation(this, x, y);
        super.setLocation(x, y);
    }
    
    public void setImage(String filename){
        WorldManager.heldInServer.setImage(this, filename);
        super.setImage(filename);
    }
    
    public void setImage(GreenfootImage image){
        WorldManager.heldInServer.setImage(this, image);
        super.setImage(image);
    }
    
    public void setRotation(int rotation){
        WorldManager.heldInServer.setRotation(this, rotation);
        super.setRotation(rotation);
    }
    
    public void setText(String string, int x, int y){
        WorldManager.heldInServer.setText(this, string, x, y);
    }
    
    public void setWorld(World world){
        WorldManager.heldInServer.setWorld(world);
    }
}
