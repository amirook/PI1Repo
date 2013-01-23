import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Eine Welt im Inneren eines Bienenstocks. 
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Ocean2 extends ServerWorld
{
    /**
     * Konstruktor für Objekte der Klasse Beehive.
     */
    public Ocean2()
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
        Entrance entrance1 = new Entrance(905, 459,180,Ocean1.class,"exitvert.png");
        addObject(entrance1,0,350);

        // Der Weg um zum nächsten Level zu gelangen
        Entrance entrance2 = new Entrance(91,466, 0,Ocean3.class,"exitvert.png");
        addObject(entrance2,1000,350);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        Rock2 rock1=new Rock2();
        addObject(rock1,634,649);
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
