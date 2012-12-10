import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ein Stein. Ein Hindernis für die Heldin, das sich mit einem Hammer entfernen lässt.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Stone extends Obstacle
{
    /**
     * Konstruktor von Stone. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * Stone überwunden wird.
     */
    public Stone(){
        super(Hammer.class);
        beatenSound = "explosion.wav";
    }
}
