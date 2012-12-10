import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Wabe ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Comb extends Obstacle
{
    /**
     * Konstruktor von Comb. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * Comb überwunden wird.
     */
    public Comb(){
        super(Scissor.class);
        beatenSound = "Something.wav";
    }
}
