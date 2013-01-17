import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * 
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Ocean extends ServerWorld
{
 

    /**
     * Konstruktor für Objekte der Klasse Ocean.
     */
    public Ocean()
    {    
        super(1000, 700, 1);
        prepare();
    }
    
    /**
     * Bereitet die Welt vor. Benötigte Actors werden instanziert und 
     * in die Welt gesetzt.
     */
    public void prepare()
    {
        // HeldIn U-Boot wird kreiert
        Submarine submarine = new Submarine();
        addObject(submarine, 156, 359);

        // Weise U-Boot sein Inventar zu.
        Inventory submarinesInventory = new Inventory();
        addObject(submarinesInventory, 75, 25);
        submarine.setInventory(submarinesInventory);

        // Das ScoreBoard wird erzeugt und dem U-Boot zugeordnet
        ScoreBoard scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 200, 25);
        submarine.setScoreBoard(scoreBoard);

        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(56, 159, Beehive.class);
        addObject(entrance, 548, 47);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und 
        //positioniert
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
    
}
