import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Beschreiben Sie hier die Klasse LocalClient.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class LocalClient extends World implements Client
{
    public HashMap<Integer, Avatar> avatarMap;
    private WorldManager worldManager;
    
    /**
     * Konstruktor für Objekte der Klasse LocalClient.
     */
    public LocalClient(WorldManager worldManager)
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(1000, 700, 1);
        avatarMap = new HashMap();
        this.worldManager = worldManager;
    }
    
    /**
     * Stellt sicher, dass ein Eintrag mit zu der id bereits in der HashMap existiert.
     */
    private void ensureMapContains(int id, int x, int y){
        if(!avatarMap.containsKey(id)){
            avatarMap.put(id, new Avatar());
        }
    }
    
    /**
     * Führt im worldManager act() auf, um die act() Methoden aller Actors aller Welten auszuführen.
     */
    public void act(){
        worldManager.act();
    }
    
    public boolean isKeyDown(String key){
        return Greenfoot.isKeyDown(key);
    }
    
    public void setText(int id, String text, int x, int y){
        ensureMapContains(id, 0, 0);
        avatarMap.get(id).setText(text, x, y);
    }
    
    public void setImage(int id, String filename){
        ensureMapContains(id, 0, 0);
        avatarMap.get(id).setImage(filename);
    }
    
    public void setImage(int id, GreenfootImage image){
        ensureMapContains(id, 0, 0);
        avatarMap.get(id).setImage(image);
    }
    
    public void setRotation(int id, int rotation){
        ensureMapContains(id,0,0);
        avatarMap.get(id).setRotation(rotation);
    }
    
    public void setLocation(int id, int x, int y){
        ensureMapContains(id, x, y);
        avatarMap.get(id).setLocation(x, y);
    }
    
    public void removeObject(int id){
        ensureMapContains(id,0,0);
        removeObject(avatarMap.get(id));
    }
    
    public void addObject(int id, int x, int y){
        ensureMapContains(id, x, y);
        addObject(avatarMap.get(id), x, y);
    }
}
