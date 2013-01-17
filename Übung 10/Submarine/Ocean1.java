import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * 
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Ocean1 extends ServerWorld
{
 

    /**
     * Konstruktor für Objekte der Klasse Ocean.
     */
    public Ocean1()
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
        Entrance entrance1 = new Entrance(905, 459,180,Start.class);
        addObject(entrance1,0,460);

        // Der Weg um zum nächsten Level zu gelangen
        Entrance entrance2 = new Entrance(91,466, 0,Ocean2.class);
        addObject(entrance2,1000,460);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
