import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Das Gebüsch ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Bomb extends Collectable
{
    
    /**
     * der Benutzer des Topedos
     */
    private boolean arcset=false;
    
    /**
     * setzt dieses Item aufnehmbar oder aktiviert in die Welt
     * aufnehmbar = false
     * aktiviert = true
     * und setzt den Spieler von dem er den Abschusswinkel bezieht
     */
    public Bomb()
    {
        stack = 15;
        usable=true;
        fired = false;
    }
    
    /**
     * entfernt die Mine und erzeugt 8 Splitter die in alle Richtungen fliegen
     * soll später zusätzlich sound abspielen und explosion darstellen
     */
    public void detonate()
    {
        Greenfoot.playSound("explosion.wav");
        getWorld().removeObject(this);
    }
    
    /**
     * setzt einmalig den Rotationswinkel und bewegt den Torpedo
     */
    public void act()
    {
        if(user!=null && !arcset) {
            arcset=true;
        }
        if(fired) {
            move(4);
            removeIfExitingWorld();
        }
    }
}