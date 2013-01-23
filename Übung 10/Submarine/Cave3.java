import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cave4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cave3 extends ServerWorld
{

    /**
     * Constructor for objects of class Cave4.
     * 
     */
    public Cave3()
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
        Entrance entrance1 = new Entrance(905, 459,180,Cave2.class,"exitvert.png");
        addObject(entrance1,0,460);

        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(882,270,164, Cave4.class,"exitcirc100x100.png");
        addObject(entrance, 950,62);
        
        // Der Dunkelheitslevel in der Hölle
        CaveShade caveshade= new CaveShade(175);
        addObject(caveshade,500,350);

        // Alle Gegner werden erzeugt und 
        //positioniert
        Tracker tracker1= new Tracker();
        addObject(tracker1,531,470);
        tracker1.setRotation(90);
        
        Tracker tracker2= new Tracker();
        addObject(tracker2,603,515);
        tracker2.setRotation(90);
        
        Tracker tracker3= new Tracker();
        addObject(tracker3,661,550);
        tracker3.setRotation(90);
        
        Tracker tracker4= new Tracker();
        addObject(tracker4,699,609);
        tracker4.setRotation(90);
        
        Tracker tracker5= new Tracker();
        addObject(tracker5,724,649);
        tracker5.setRotation(90);
        
        Tracker tracker6= new Tracker();
        addObject(tracker6,804,602);
        tracker6.setRotation(90);
        
        Tracker tracker7= new Tracker();
        addObject(tracker7,795,686);
        tracker7.setRotation(90);
        
        Tracker tracker8= new Tracker();
        addObject(tracker8,869,658);
        tracker8.setRotation(90);
        
        Tracker tracker9= new Tracker();
        addObject(tracker9,932,678);
        tracker9.setRotation(90);
        
        Tracker tracker10= new Tracker();
        addObject(tracker10,952,621);
        tracker10.setRotation(90);
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
