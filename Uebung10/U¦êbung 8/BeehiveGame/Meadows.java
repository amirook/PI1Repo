import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Eine Wiese mit Blumen, Steinen und Büschen sowie einem Eingang zu einem Bienenstock.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Meadows extends World
{
    /**
     * Konstruktor für Objekte der Klasse Meadow.
     */
    public Meadows()
    {    
        // Erzeuge eine neue Welt mit 600x400 Zellen und einer Zellgröße von 1x1 Pixeln.
        super(600, 900, 1);
        prepare();
    }
    
    /**
     * Bereitet die Welt vor. Benötigte Actors werden instanziert und 
     * in die Welt gesetzt.
     */
    public void prepare()
    {
        this.setBackground("wasser1.png");
        
        // Setzt die Koordinate der Oberfläche
        WorldManager.surfaceY = 460;
        
        // Setzt das noise Setting von erzeugten Blasen
        WorldManager.bubbleNoise=true;
        
        // Heldin Bee wird kreiert
        Bee bee = new Bee();
        addObject(bee, 56, 359);

        // Weise Bee ihr Inventar zu.
        Inventory beesInventory = new Inventory();
        addObject(beesInventory, 75, 25);
        bee.setInventory(beesInventory);
        
        // Das ScoreBoard wird erzeugt und der Biene zugeordnet
        ScoreBoard scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 200, 25);
        bee.setScoreBoard(scoreBoard);

        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(56,159,Ocean.class);
        addObject(entrance, 543, 805);
        
        // Alle weiteren Hindernisse, Werkzeuge und Blumen werden erzeugt und positioniert
        
        // Gegner werden erzeugt und positioniert
        Tracker tracker1 = new Tracker();
        addObject (tracker1,526,675);
        
        Tracker tracker2 = new Tracker();
        addObject (tracker2,418,736);
        
        Tracker tracker3 = new Tracker();
        addObject (tracker3,349,817);
        
        Tracker tracker4 = new Tracker();
        addObject (tracker4,202,732);
        
        Tracker tracker5 = new Tracker();
        addObject (tracker5,144,824);
        
        Tracker tracker6 = new Tracker();
        addObject (tracker6,100,773);
        
        this.setPaintOrder(Bee.class, Crashable.class);
    }
}
