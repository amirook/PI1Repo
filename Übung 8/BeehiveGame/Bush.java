import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Das Gebüsch ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Bush extends Obstacle
{
    /**
     * Konstruktor von Bush. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * Bush überwunden wird.
     */
    public Bush(){
        super(Scissor.class);
        beatenSound = "Song.wav";
    }
}
