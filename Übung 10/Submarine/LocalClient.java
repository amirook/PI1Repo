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
    private HashMap<Integer, Avatar> actorMap;
    int idCounter;
    
    /**
     * Konstruktor für Objekte der Klasse LocalClient.
     */
    public LocalClient()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(600, 400, 1);
        actorMap = new HashMap();
    }
    
//     public void addObject(Actor actor, int x, int y){
//         Avatar avatar = new Avatar();
//         avatar.setImage(actor.getImage());
//         actorMap.put(idCounter, avatar);
//         idCounter++;
//         super.addObject(avatar, x, y);
//     }
    
    public void playSound(String str){
        //super.playSound(str);
    }
    
    public boolean isKeyDown(String str){
        return false;
    }
    
    public void setText(int i, String str){
        //super.setText(i, str);
    }
    
    public void setImage(int i, String str){
        //super.setImage(i, str);
    }
    
    public void setRotation(int i, int j){
        //super.setRotation(i,j);
    }
    
    public void setLocation(int i, int j, int k){
        //super.setLocation(i,j, k);
    }
    
    public void removeObject(int i){
        //super.removeObject(i);
    }
}
