import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cave2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cave2 extends ServerWorld
{

    /**
     * Constructor for objects of class Cave2.
     * 
     */
    public Cave2()
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
        Entrance entrance1 = new Entrance(921,386,180, Cave1.class);
        addObject(entrance1,4,157);
        
        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(98, 456, 0, Cave4.class);
        addObject(entrance,  1000, 474);
        
        // Der Dunkelheitslevel in der Hölle
        CaveShade caveshade= new CaveShade(150);
        addObject(caveshade,500,350);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        Mine mine1 = new Mine(9);
        addObject(mine1,762,513);
        
        Mine mine2 = new Mine(9);
        addObject(mine2,106,591);
        
        Mine mine3 = new Mine(9);
        addObject(mine3,421,491);
        
        Mine mine4 = new Mine(9);
        addObject(mine4,521,258);
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
