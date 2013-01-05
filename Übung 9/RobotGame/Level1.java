import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die erste Welt (Level1). (Übungsblatt 3, umbenannt)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Level1 extends World
{
    /**
     * Konstruktor für Objekte der Klasse Level1.
     */
    public Level1()
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
        Wall wall = new Wall();
        addObject(wall, 30, 90);
        Wall wall2 = new Wall();
        addObject(wall2, 90, 90);
        Wall wall3 = new Wall();
        addObject(wall3, 150, 90);
        Wall wall4 = new Wall();
        addObject(wall4, 270, 90);
        Wall wall5 = new Wall();
        addObject(wall5, 330, 90);
        Wall wall6 = new Wall();
        addObject(wall6, 390, 90);
        Wall wall7 = new Wall();
        addObject(wall7, 390, 30);
        Wall wall8 = new Wall();
        addObject(wall8, 510, 30);
        Wall wall9 = new Wall();
        addObject(wall9, 510, 90);
        Wall wall10 = new Wall();
        addObject(wall10, 570, 90);
        Wall wall11 = new Wall();
        addObject(wall11, 30, 210);
        Wall wall12 = new Wall();
        addObject(wall12, 90, 210);
        Wall wall13 = new Wall();
        addObject(wall13, 150, 210);
        Wall wall14 = new Wall();
        addObject(wall14, 210, 210);
        Wall wall15 = new Wall();
        addObject(wall15, 210, 270);
        Wall wall16 = new Wall();
        addObject(wall16, 210, 330);
        Wall wall17 = new Wall();
        addObject(wall17, 270, 330);
        Wall wall18 = new Wall();
        addObject(wall18, 510, 330);
        Wall wall19 = new Wall();
        addObject(wall19, 450, 270);
        Wall wall20 = new Wall();
        addObject(wall20, 390, 210);
        Wall wall21 = new Wall();
        addObject(wall21, 390, 150);
        Wall wall22 = new Wall();
        addObject(wall22, 510, 390);
        Door door = new Door();
        addObject(door, 210, 90);
        Door door2 = new Door();
        addObject(door2, 570, 330);
        Smiley smiley = new Smiley();
        addObject(smiley, 29, 31);
        Smiley smiley2 = new Smiley();
        addObject(smiley2, 450, 30);
        Key key = new Key();
        addObject(key, 331, 31);
        Key key2 = new Key();
        addObject(key2, 450, 150);
        Key key3 = new Key();
        addObject(key3, 390, 390);
        Bomb bomb = new Bomb();
        addObject(bomb, 30, 390);
        Skull skull = new Skull();
        addObject(skull, 90, 360);
        Skull skull2 = new Skull();
        addObject(skull2, 540, 190);
        Exit exit = new Exit(Level2.class, 570, 30);
        addObject(exit, 570, 390);

        Inventory inventory = new Inventory();
        Robot robot = new Robot();
        robot.setInventory(inventory);
        addObject(inventory, 570, 30);
        addObject(robot, 270, 270);
        Score score = new Score();
        addObject(score, 38, 13);
        robot.setScore(score);
        Fire fire = new Fire();
        addObject(fire, 455, 336);
        fire.setLocation(449, 330);
    }
}
