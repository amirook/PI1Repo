import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Eine Wiese mit Blumen, Steinen und Büschen sowie einem Eingang zu einem Bienenstock.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Ocean extends ServerWorld
{
 

    /**
     * Konstruktor für Objekte der Klasse Meadow.
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
        // Heldin Bee wird kreiert
        Submarine submarine = new Submarine();
        addObject(submarine, 156, 359);

        // Weise Bee ihr Inventar zu.
        Inventory beesInventory = new Inventory();
        addObject(beesInventory, 75, 25);
        submarine.setInventory(beesInventory);
        
        // Das ScoreBoard wird erzeugt und der Biene zugeordnet
        ScoreBoard scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 200, 25);
        submarine.setScoreBoard(scoreBoard);

        // Der Eingang um zum nächsten Level zu gelangen
        Entrance entrance = new Entrance(56, 159, Beehive.class);
        addObject(entrance, 548, 47);
        
        // Alle weiteren Hindernisse, Werkzeuge und Blumen werden erzeugt und positioniert
        Stone stone = new Stone();
        addObject(stone, 495, 38);
        Stone stone2 = new Stone();
        addObject(stone2, 577, 146);
        stone.setLocation(443, 32);
        Bush bush = new Bush();
        addObject(bush, 524, 129);
        Bush bush2 = new Bush();
        addObject(bush2, 500, 80);
        bush2.setLocation(489, 79);
        Stone stone3 = new Stone();
        addObject(stone3, 35, 299);
        Stone stone4 = new Stone();
        addObject(stone4, 100, 306);
        stone4.setLocation(112, 301);
        Stone stone5 = new Stone();
        addObject(stone5, 208, 309);
        stone5.setLocation(193, 302);
        Stone stone6 = new Stone();
        addObject(stone6, 278, 306);
        stone6.setLocation(275, 302);
        Bush bush3 = new Bush();
        addObject(bush3, 353, 306);
        bush3.setLocation(345, 301);
        Stone stone7 = new Stone();
        addObject(stone7, 421, 311);
        Stone stone8 = new Stone();
        addObject(stone8, 496, 313);
        Stone stone9 = new Stone();
        addObject(stone9, 575, 314);
        stone9.setLocation(575, 308);
        stone7.setLocation(416, 302);
        stone8.setLocation(493, 302);
        stone9.setLocation(569, 302);
        Scissor scissor = new Scissor();
        addObject(scissor, 516, 370);
        scissor.setLocation(505, 368);
        Hammer hammer = new Hammer();
        addObject(hammer, 96, 209);
        Hammer hammer2 = new Hammer();
        addObject(hammer2, 551, 233);
        Scissor scissor2 = new Scissor();
        addObject(scissor2, 494, 199);
        Stone stone10 = new Stone();
        addObject(stone10, 439, 120);
        Stone stone11 = new Stone();
        addObject(stone11, 440, 214);
        Flower flower = new Flower();
        addObject(flower, 556, 372);
        Flower flower2 = new Flower();
        addObject(flower2, 64, 102);
        Flower flower3 = new Flower();
        addObject(flower3, 300, 100);
        Flower flower4 = new Flower();
        addObject(flower4, 222, 216);
        this.setPaintOrder(Submarine.class, Crashable.class);
    }
    
}
