import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends ServerWorld
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
        addObject(submarinesInventory, 98, 25);
        submarine.setInventory(submarinesInventory);

        // Das ScoreBoard wird erzeugt und dem U-Boot zugeordnet
        ScoreBoard scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 41, 78);
        submarine.setScoreBoard(scoreBoard);

        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(91,466,0,Ocean1.class);
        addObject(entrance,1000,460);

        // Alle weiteren Hindernisse, Werkzeuge und weitere sammelbare Objekte werden erzeugt und positionoert
        
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
}
