import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldManager extends World
{
    /**Wasserpegel der Aktuellen Welt*/
    public static int surfaceY=0;
    
    /**gibt an ob Bubbles in dieser Welt beim zerbersten ein Geräusch von sich geben*/
    public static boolean bubbleNoise=true;
    
    /** gibt an ob sich der Aktor über der Wasseroberfläche befindet
     *  @actor der geprüft wird,
     *  @Tiefe hin oder weck von der Oberfläche ab der diese Mthode anschlägt(varianz für Objektgrößen)
     */ 
    public static boolean overTheTop(Actor actor,int depth)
    {
        if(actor.getY()<surfaceY+depth) {//wird vor ausführung der 2.if schleife nicht mehr ausgeführt
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Constructor for objects of class WorldManager.
     * 
     */
    public WorldManager()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
}
