import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Entrance ist das Tor zum nächsten Level. Wenn die Biene mit dem Entance kollidiert,
 * enfternt diese die Biene und ihr Inventar aus der aktuellen Welt und setzt sie wieder
 * in der neuen Welt ein.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Entrance extends Crashable
{
    /**
     * Die Klasse der Welt, in die das Entrance führt.
     */
    private Class nextWorldClass;
    
    /**w
     * x-Koordinate, an der die Biene in der neuen Welt positioniert werden soll.
     */
    private int xInNewWorld;
    
    /**
     * y-Koordinate, an der die Biene in der neuen Welt positioniert werden soll.
     */
    private int yInNewWorld;
    
    /**
     * Rotation, in der die Biene in der neuen Welt positioniert werden soll.
     */
    private int arcInNewWorld;
    
    /**
     * Array, in der die Klassen, der zu übertragenen Objekte gespeichert werden
     */
    private Class[] classesToMove = {Inventory.class, ScoreBoard.class,};
    
    /**
     * Konstruktor von Entrance. Die Klasse der neuen Welt und die neuen Koordinaten der
     * Biene werden initialisiert.
     * @param x x-Koordinate, an der die Biene in der neuen Welt positioniert werden soll.
     * @param y y-Koordinate, an der die Biene in der neuen Welt positioniert werden soll.
     * @param worldClass Die Klasse der Welt, in die das Entrance führt.
     */
    public Entrance(int x, int y,int arc, Class worldClass,String imagename)
    {
        xInNewWorld = x;
        yInNewWorld = y;
        arcInNewWorld = arc;
        nextWorldClass = worldClass;
        this.setImage(imagename);
    }
    
    /**
     * Entrance wird genutzt um in die nächste Welt zu gelangen
     * 
     * hierbei wird außerdem die Position der Wasseroberfläche der neuen Weltzu setzen
     * 
     * @param bee Die Biene
     */
    public void handleCrash(Submarine submarine)
    {
        World nextWorld = WorldManager.getWorldReference(nextWorldClass);
        int nextSurfaceY = WorldManager.getNextSurface(nextWorldClass);
        World currentWorld = getWorld();
        // NUR wenn eine nächste Welt gefunden wird.
        if (nextWorld != null){
            for (Class classToMove: classesToMove){
                if(classToMove != Submarine.class){
                    List<Actor> actors = currentWorld.getObjects(classToMove);
                    for (Actor actor: actors){
                        int x = actor.getX();
                        int y = actor.getY();
                        currentWorld.removeObject(actor);
                        nextWorld.addObject(actor, x, y);
                    }
                }
            } 
            currentWorld.removeObject(submarine);
            nextWorld.addObject(submarine, xInNewWorld, yInNewWorld);
            submarine.setRotation(arcInNewWorld);
            Greenfoot.setWorld(nextWorld);
            WorldManager.surfaceY = nextSurfaceY;
        }
    }
}
