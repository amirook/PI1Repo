import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cave5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cave5 extends ServerWorld
{

    /**
     * Constructor for objects of class Cave5.
     * 
     */
    public Cave5()
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
        Entrance entrance1 = new Entrance(905, 459,180,Cave4.class);
        addObject(entrance1,1000,390);
        
        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(219, 591, 304,Start.class);
        addObject(entrance, 452,158);
        
        // Der Helligkeitslevel in der Hölle
        CaveShade caveshade= new CaveShade(150);
        addObject(caveshade,500,350);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
