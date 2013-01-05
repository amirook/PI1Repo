import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die zweite Welt (Level 2). (Übungsblatt 4)
 * 
 * @author Thomas Röfer 
 * @version 06.11.2012
 */
public class Level2 extends World
{
    /**
     * Konstruktor für Objekte der Klasse Level2.
     */
    public Level2()
    {    
        super(600, 420, 1);
        prepare();
    }

    /**
     * Bereite die Welt für den Programmstart vor. Das heißt: Erzeuge die Anfangs-
     * Objekte und füge sie der Welt hinzu.
     */
    private void prepare()
    {
        Wall wall23 = new Wall();
        addObject(wall23, 570, 90);
        Wall wall24 = new Wall();
        addObject(wall24, 510, 90);
        Wall wall25 = new Wall();
        addObject(wall25, 450, 90);
        Wall wall26 = new Wall();
        addObject(wall26, 510, 150);
        Wall wall27 = new Wall();
        addObject(wall27, 450, 210);
        Wall wall28 = new Wall();
        addObject(wall28, 510, 210);
        Wall wall29 = new Wall();
        addObject(wall29, 390, 210);
        Wall wall30 = new Wall();
        addObject(wall30, 330, 210);
        Wall wall31 = new Wall();
        addObject(wall31, 270, 210);
        Wall wall32 = new Wall();
        addObject(wall32, 210, 210);
        Wall wall33 = new Wall();
        addObject(wall33, 210, 150);
        Wall wall34 = new Wall();
        addObject(wall34, 210, 90);
        Wall wall35 = new Wall();
        addObject(wall35, 90, 90);
        Wall wall36 = new Wall();
        addObject(wall36, 30, 90);
        Wall wall37 = new Wall();
        addObject(wall37, 30, 150);
        Wall wall38 = new Wall();
        addObject(wall38, 90, 150);
        Wall wall39 = new Wall();
        addObject(wall39, 90, 210);
        Wall wall40 = new Wall();
        addObject(wall40, 30, 330);
        Wall wall41 = new Wall();
        addObject(wall41, 90, 270);
        Wall wall42 = new Wall();
        addObject(wall42, 90, 330);
        Wall wall43 = new Wall();
        addObject(wall43, 150, 330);
        Wall wall44 = new Wall();
        addObject(wall44, 210, 330);
        Wall wall45 = new Wall();
        addObject(wall45, 330, 270);
        Wall wall46 = new Wall();
        addObject(wall46, 330, 330);
        Wall wall47 = new Wall();
        addObject(wall47, 510, 270);
        Wall wall48 = new Wall();
        addObject(wall48, 570, 270);
        Wall wall49 = new Wall();
        addObject(wall49, 390, 330);
        Wall wall50 = new Wall();
        addObject(wall50, 150, 390);
        Door door3 = new Door();
        addObject(door3, 450, 30);
        Door door4 = new Door();
        addObject(door4, 210, 270);
        Key key4 = new Key();
        addObject(key4, 30, 210);
        Bomb bomb2 = new Bomb();
        addObject(bomb2, 390, 270);
        Bomb bomb3 = new Bomb();
        addObject(bomb3, 30, 30);
        Smiley smiley3 = new Smiley();
        addObject(smiley3, 30, 270);
        Smiley smiley4 = new Smiley();
        addObject(smiley4, 210, 390);
        Smiley smiley5 = new Smiley();
        addObject(smiley5, 570, 210);
        Smiley smiley6 = new Smiley();
        addObject(smiley6, 450, 150);
        Skull skull3 = new Skull();
        addObject(skull3, 330, 60);
        Exit exit = new Exit(Level2.class, 30, 390);
        addObject(exit, 570, 150);
        Exit exit2 = new Exit(Level1.class, 30, 150);
        addObject(exit2, 90, 390);
    }
}
