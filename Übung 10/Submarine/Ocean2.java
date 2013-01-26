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
        
        //Obstacles
        Kelp kelp1 = new Kelp("seetang23.png");
        addObject(kelp1,767,458);
        
        Kelp kelp2 = new Kelp("seetang3.png");
        addObject(kelp2,767,458);
        
        Rock2 rock1=new Rock2();
        addObject(rock1,619,674);
        
        Kelp kelp3 = new Kelp("seetang3.png");
        addObject(kelp3,651,486);
        
        //Collectables
        Scissor scissor=new Scissor();
        addObject(scissor,363,427);
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
