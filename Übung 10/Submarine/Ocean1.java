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
    private void prepare()
    {
        // Der Weg um zum vorherigen Level zu gelangen
        Entrance entrance1 = new Entrance(905, 459,180,Start.class,"exitvert.png");
        addObject(entrance1,0,350);

        // Der Weg um zum nächsten Level zu gelangen
        Entrance entrance2 = new Entrance(91,466, 0,Ocean2.class,"exitvert.png");
        addObject(entrance2,1000,350);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        
        //Obstacles
        Rock rock1=new Rock();
        addObject(rock1,451,656);
        
        //Creatures
        Mine mine1=new Mine(9);
        addObject(mine1,330,391);
        
        Mine mine2=new Mine(9);
        addObject(mine2,615,563);
        
        Mine mine3=new Mine(9);
        addObject(mine3,784,628);
        
        Mine mine4=new Mine(9);
        addObject(mine4,809,373);
        
        //Collectables
        Scissor scissor1 = new Scissor();
        addObject(scissor1,416,318);
        
        Scissor scissor2 = new Scissor();
        addObject(scissor2,681,642);
    }
}
