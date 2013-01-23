import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Das Gebüsch ist ein weiteres Hindernis für die Heldin. Es kann mit einer Schere entfernt werden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Torpedo extends Collectable
{
    /**
     * setzt dieses Item aufnehmbar oder aktiviert in die Welt
     * aufnehmbar = false
     * aktiviert = true
     * und setzt den Spieler von dem er den Abschusswinkel bezieht
     */
    public Torpedo()
    {
        stack = 15;
        usable=true;
        fired = false;
    }
    
    /**
     * setzt einmalig den Rotationswinkel und bewegt den Torpedo
     */
    public void act()
    {
        if(fired) {
            blowsmallBubbles();
            if(WorldManager.overTheTop(this)) {
               WorldManager.reactToSurface(this,4,3);
            }
            move(4);
            
            if(exitingWorld()||hitTarget()||this.getOneIntersectingObject(Obstacle.class)!=null) {
                this.detonate();
            }
        }
    }
    
    /**
     * entfernt die Mine und erzeugt 8 Splitter die in alle Richtungen fliegen
     * soll später zusätzlich sound abspielen und explosion darstellen
     */
    public void detonate()
    {
        this.setImage("explosion.gif");
        Greenfoot.playSound("explosion.wav");
        Greenfoot.delay(3);
        getWorld().removeObject(this);
    }
    
    /**
    * Der Torpedo erzeugt wenn abgefeuert in kleinenintervallen Luftblasen
    */
    public void blowsmallBubbles()
    {
        if(Greenfoot.getRandomNumber(20)==1){
            //new bubble with an infinite lifespan and a scale between(2-20)pixels
            Bubble bubble = new Bubble(0,Greenfoot.getRandomNumber(18)+2);
            getWorld().addObject(bubble,this.getX(),this.getY());
        }
    }
    
    /**
     * reaktion auf das treffen einer instanz der Klasse Creature
     * gibt der getroffenen klasse den Spieler weiter der sie getroffen hat
     * und entfernt anschließend den Torpedo
     */
    private boolean hitTarget()
    {
        Creature creature = (Creature) getOneIntersectingObject(Creature.class);
        if(creature !=null && user instanceof Submarine) {
            creature.hitByPlayer = (Submarine)user;
            return true;
        }
        return false;
    }
}