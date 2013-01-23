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
    private void prepare()
    {
        // Der Weg um zum vorherigen Level zu gelangen
        Entrance entrance1 = new Entrance(905, 459,180, Cave1.class,"exitcirc500x500.png");
        addObject(entrance1,0,0);
        
        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(98, 456, 0, Cave3.class,"exitvert.png");
        addObject(entrance,  1000, 474);
        
        // Der Dunkelheitslevel in der Hölle
        CaveShade caveshade= new CaveShade(150);
        addObject(caveshade,500,350);

        // Alle weiteren Hindernisse werden erzeugt und positioniert
        InvCircle5 circle1= new InvCircle5();
        addObject(circle1,900,0);
        
        //Alle Feinde werden platziert
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
