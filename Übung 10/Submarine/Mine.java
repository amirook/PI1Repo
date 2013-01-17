import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ein Stein. Ein Hindernis für die Heldin, das sich mit einem Hammer entfernen lässt.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Mine extends Obstacle
{
    /**
     * Konstruktor von Mine. Die Klasse der Objekte, die dieses Hindernis
     * übwerwinden können, werden dem Konstruktor der Superklasse Obstacle
     * übergeben. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * das Hindernis überwunden wird.
     */
    public Mine(){
        super(Hammer.class);
        beatenSound = "explosion.wav";
    }
}
