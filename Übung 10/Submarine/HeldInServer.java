import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Beschreiben Sie hier die Klasse HeldInServer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class HeldInServer extends Server
{
    private HashMap<Actor, Integer> actorMap;
    private LocalClient client;
    private int idCounter = 0;
    
    public HeldInServer(LocalClient client){
        actorMap = new HashMap();
        this.client = client;
    }
    
    private void ensureMapContains(Actor actor){
        if(!actorMap.containsKey(actor)){
            actorMap.put(actor, idCounter);
            idCounter++;
        }
    }
    
    public void setWorld(World world){
        List<Actor> actors = client.getObjects(null);
        for (Actor a : actors){
            client.removeObject(a);
        }
        client.setBackground(world.getBackground());
        actors = world.getObjects(null);
        for (Actor a : actors){
            client.addObject(actorMap.get(a), a.getX(), a.getY());
        }
    }
    
    public void removeObject(Actor actor){
        ensureMapContains(actor);
        client.removeObject(actorMap.get(actor));
    }
    
    public void addObject(Actor actor, int x, int y){
        ensureMapContains(actor);
        client.addObject(actorMap.get(actor), x, y);
    }
    
    public void setLocation(Actor actor, int x, int y){
        ensureMapContains(actor);
        client.setLocation(actorMap.get(actor), x, y);
    }
    
    public void setRotation(Actor actor, int rotation){
        ensureMapContains(actor);
        client.setRotation(actorMap.get(actor), rotation);
    }
    
    public void setImage(Actor actor, String filename){
        ensureMapContains(actor);
        client.setImage(actorMap.get(actor), filename);
    }
    
    public void setImage(Actor actor, GreenfootImage image){
        ensureMapContains(actor);
        client.setImage(actorMap.get(actor), image);
    }
    
    public void setText(Actor actor, String text, int x, int y){
        ensureMapContains(actor);
        client.setText(actorMap.get(actor), text, x, y);
    }
    
    public void setBackground(String filename){
        client.setBackground(filename);
    }
    
    public boolean isKeyDown(String key){
        return client.isKeyDown(key);
    }
    
    public void playSound(String filename){
    
    }
}
