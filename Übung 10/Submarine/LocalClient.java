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
    private HashMap<Integer, Avatar> avatarMap;
    int idCounter;
    
    /**
     * Konstruktor für Objekte der Klasse LocalClient.
     */
    public LocalClient()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(600, 400, 1);
        avatarMap = new HashMap();
    }
    
    public void playSound(String filename){
        //super.playSound(str);
    }
    
    public boolean isKeyDown(String key){
        return false;
    }
    
    public void setText(int id, String text){
        //super.setText(i, str);
    }
    
    public void setImage(int id, String filename){
        //super.setImage(i, str);
    }
    
    public void setRotation(int id, int rotation){
        //super.setRotation(i,j);
    }
    
    public void setLocation(int id, int x, int y){
        
    }
    
    public void removeObject(int id){
        
    }
}
