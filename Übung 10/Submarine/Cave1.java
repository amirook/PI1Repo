import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cave1e here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cave1 extends ServerWorld
{
    private boolean imageset=false;
    /**
     * Constructor for objects of class Cave1e.
     * 
     */
    public Cave1()
    {  
        prepare();
    }
    
     /**
     * Bereitet die Welt vor. Benötigte Actors werden instanziert und 
     * in die Welt gesetzt.
     */
    public void prepare()
    {
        // Der Weg um zum vorherigen Level zu gelangen
        Entrance entrance1 = new Entrance(693,620,195, Ocean3.class);
        addObject(entrance1,292,367);

        // Der Weg um zum nächsten Level zu gelangen
        Entrance entrance2 = new Entrance(126, 170, 26,Cave2.class);
        addObject(entrance2,1000,460);
        
        // Der Dunkelheitslevel in der Hölle
        CaveShade caveshade= new CaveShade(110);
        addObject(caveshade,500,350);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        
        this.setPaintOrder(Submarine.class, Cave2.class);
    }
}
