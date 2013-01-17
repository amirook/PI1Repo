import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * WorldManager ist die Verwaltungsinstanz aller Welten, die nach ihrer Instanziierung 
 * in einer Liste verwaltet werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class WorldManager extends World
{
    /**
     * Liste, in der die Referenzen auf die Welten gespeichert werden
     */
    public static List<World> myWorlds;
    
    /**
     * Variable, um auf das Spielende zu prüfen
     */
    public static boolean gameOver;
    
    /**
     * Konstruktor für Objekte der Klasse WorldManager. Hier werden alle gebrauchten Welten
     * instanziert und zur Weltenliste myWorlds hinzugefügt. Beginnende Welt wird gesetzt.
     */
    public WorldManager()
    {    
        super(1000,700,1);
        
        myWorlds = new ArrayList<World>();
        myWorlds.add(new Ocean());
        myWorlds.add(new Beehive());
        Greenfoot.setWorld(myWorlds.get(0));
    }
    
    /**
     * Liefert die Referenz auf die Welt zurück, die als Nächstes verwendet werden muss.
     * @param worldClass Klassenname der Welt, die bei Kollision des Entrance aktiviert werden soll.
     * @return Referenz auf die nächste Welt oder null, wenn gesuchte Welt nie instanziiert wurde.
     */
    public static World getWorldReference(Class worldClass){
        for(World myWorld : myWorlds){
            if( isOfClass(myWorld,worldClass )){
                return myWorld;
            }
        }
        return null;
    }
    
    /**
     * Hilfsmethode um Instanzen auf Ihre Klasse zu prüfen.
     * 
     * @param w die Welt, die geprüft werden soll
     * @param c die Klasse auf die die Welt geprüft wird
     * @return true, wenn die Welt w eine Instanz von c ist. Andernfalls false.
     */
    public static boolean isOfClass(World w, Class c) {
        return w.getClass() == c;
    }
}
