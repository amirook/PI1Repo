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
    /**Liste, in der die Referenzen auf die Welten gespeichert werden*/
    public static List<World> myWorlds;
    
    /**Variable, um auf das Spielende zu prüfen*/
    public static boolean gameOver;
    
    /**Wasserpegel der Aktuellen Welt*/
    public static int surfaceY=0;
    
    /**gibt an ob Bubbles in dieser Welt beim zerbersten ein Geräusch von sich geben*/
    public static boolean bubbleNoise=true;
    
    /**
     * Konstruktor für Objekte der Klasse WorldManager. Hier werden alle gebrauchten Welten
     * instanziert und zur Weltenliste myWorlds hinzugefügt. Beginnende Welt wird gesetzt.
     */
    public WorldManager()
    {    
        super(600,400,1);
        
        myWorlds = new ArrayList<World>();
        
        myWorlds.add(new Ocean());
        myWorlds.add(new Meadows());
        Greenfoot.setWorld(myWorlds.get(1));
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
    
    
    /**gibt an ob sich der Aktor über der Wasseroberfläche befindet und wenn ja
     * schaltet er in folgenden Tests erst auf false sobald der aktor unter surfaceY+depth ankommt
     * hierdurch kann eine minimale Eintauchtiefe für die Aktoren festgelegt werden
     * @actor der geprüft wird
     * @zusätzliche Tiefe die der Aktor unter der Oberfläche erreichen muss,
     */ 
    public static boolean overTheTop(Actor actor,int depth)
    {
        boolean onAir=true;
        if(actor.getY()<surfaceY) {
            onAir=true;
        }
        
        if(actor.getY()>surfaceY+depth){
            onAir=false;
        }
        return onAir;
    }
    
    /**
     * verfahren welches für Aktoren einen visuellen Sprung zurück ins wasser simuliert
     * wenn diese die Oberfläche durchschreiten
     */
    public static void reactToSurface(Actor actor)
    {
        int arc = actor.getRotation();
        if(arc< 270 && arc >=90){
            actor.turn(-1);
            actor.move(3);
        }
        else{
            actor.turn(1);
            actor.move(3);
        }
        if(arc == 270)
        {
            actor.move(4);
        }
    }
    
}
