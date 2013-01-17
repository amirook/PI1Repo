import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrapnel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrapnel extends Obstacle
{
    /**
     * Konstruktor von Shrapnel. Die Klasse der Objekte, die dieses Hindernis
     * übwerwinden können, werden dem Konstruktor der Superklasse Obstacle
     * übergeben. Die Sounddatei wird gesetzt, die abgespielt wird, wenn
     * das Hindernis überwunden wird.
     */
    public Shrapnel(){
        super(Scissor.class);
        beatenSound = "Something.wav";
    }
}
