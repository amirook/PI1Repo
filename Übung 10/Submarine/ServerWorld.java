import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Beschreiben Sie hier die Klasse ServerWorld.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public abstract class ServerWorld extends World
{

    /**
     * Konstruktor für Objekte der Klasse ServerWorld.
     */
    public ServerWorld()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(1000, 700, 1);
    }
    
    public void removeObject(Actor actor){
        WorldManager.heldInServer.removeObject(actor);
        super.removeObject(actor);
    }
    
    public void addObject(Actor actor, int x, int y){
        if (this.getClass() == WorldManager.currentWorld){
            WorldManager.heldInServer.addObject(actor, x, y);
        }
        super.addObject(actor, x, y);
    }
}
