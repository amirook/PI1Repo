import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Wabe ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Tracker extends Obstacle
{
    /**
     * Konstruktor von Tracker. Die Klasse der Objekte, die dieses Hindernis
     * übwerwinden können, werden dem Konstruktor der Superklasse Obstacle
     * übergeben. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * das Hindernis überwunden wird.
     */
    public Tracker(){
        super(Scissor.class);
        beatenSound = "Something.wav";
    }
}
