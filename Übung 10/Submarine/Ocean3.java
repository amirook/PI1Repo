import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ocean3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ocean3 extends ServerWorld
{

    /**
     * Constructor for objects of class Ocean3.
     * 
     */
    public Ocean3()
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
        Entrance entrance1 = new Entrance(905, 459,180,Ocean2.class,"exitvert.png");
        addObject(entrance1,0,460);

        // Der Weg um zum nächsten Level zu gelangen
        Entrance entrance2 = new Entrance(382,373, 5,Cave1.class,"exitcirc100x100.png");
        addObject(entrance2,867,644);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        
        //Obstacles
        Rockwall rock1=new Rockwall();
        addObject(rock1,943,552);
        
        Rock2 rock2=new Rock2();
        addObject(rock2,556,687);
        
        this.setPaintOrder(Submarine.class, Cave1.class);
    }
}
