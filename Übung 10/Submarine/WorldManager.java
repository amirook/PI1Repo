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
    
    /**Liste, in der die Wasserpegel der Welten gespeichert werden*/
    public static List<Integer> mySurfaces;
    
    /**Variable, um auf das Spielende zu prüfen*/
    public static boolean gameOver;
    
    /**Wasserpegel der Aktuellen Welt*/
    public static int surfaceY=0;
    
    /**
     * Konstruktor für Objekte der Klasse WorldManager. Hier werden alle gebrauchten Welten
     * instanziert und zur Weltenliste myWorlds hinzugefügt. Beginnende Welt wird gesetzt.
     */
    public WorldManager()
    {    
        super(600,400,1);
        
        myWorlds = new ArrayList<World>();
        
        myWorlds.add(new Start());
        myWorlds.add(new Ocean1());
        myWorlds.add(new Ocean2());
        myWorlds.add(new Ocean3());
        myWorlds.add(new Cave1());
        myWorlds.add(new Cave2());
        myWorlds.add(new Cave3());
        myWorlds.add(new Cave4());
        myWorlds.add(new Aquarium());
        Greenfoot.setWorld(myWorlds.get(0));
        
        mySurfaces = new ArrayList<Integer>();
        mySurfaces.add(270);//start1
        mySurfaces.add(270);//Ocean1
        mySurfaces.add(270);//Ocean2
        mySurfaces.add(270);//Ocean3
        mySurfaces.add(1);//Cave1
        mySurfaces.add(1);//Cave2
        mySurfaces.add(1);//Cave3
        mySurfaces.add(1);//Cave4
        mySurfaces.add(255);//Aquarium
        surfaceY =(mySurfaces.get(0));
    }
    
    /**
     * Liefert die Referenz auf die Welt zurück, die als Nächstes verwendet werden muss.
     * 
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
     * liefert die Wasseroberfläche für die übergebene Welt zurück
     * 
     * @param worldClass Klassenname der Welt, die bei Kollision des Entrance aktiviert werden soll.
     * @return Wasserpegel der nächsten Welt oder null,
     * wenn der gesuchte Pegel nie instanziiert wurde.
     */
    public static int getNextSurface(Class worldClass){
        int index=0;
        for(World myWorld : myWorlds){
            if( isOfClass(myWorld,worldClass )){
                return mySurfaces.get(index);
            }
            index++;
        }
        return 0;
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
    
    
    /**gibt an ob sich der Aktor über der Wasseroberfläche befindet
     * @actor der geprüft wird
     */ 
    public static boolean overTheTop(Actor actor)
    {
        boolean onAir=true;
        if(actor.getY()<surfaceY) {
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * verfahren welches für Aktoren einen visuellen Sprung zurück ins wasser simuliert
     * wenn diese die Oberfläche durchschreiten
     * @Actor für die Simulation
     * @bewegungsgeschwindigkeit, drehgeschwindigkeit an der Oberfläche
     */
    public static void reactToSurface(Actor actor, int movementspeed, int turnspeed)
    {
        int arc = actor.getRotation();
        if(arc< 270 && arc >=90){
            actor.turn(-turnspeed);
            actor.move(movementspeed);
        }
        else{
            actor.turn(turnspeed);
            actor.move(movementspeed);
        }
        if(arc == 270)
        {
            actor.move(movementspeed+1);
        }
    }
    
}
