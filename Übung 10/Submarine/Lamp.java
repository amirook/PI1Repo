import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lamp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lamp extends Collectable
{ 
    public Lamp()
    {
        stack = 0;
        usable= false;
        fired = false;
    }
    
    /**
     * standart Bewegung der Lampe
     * kreisförmige schwimmbewegung
     */
    public void act()
    {
        setImageDependingOnRotation();
        move(2);
        turn(1);
        //verhindert das die Lampe durch Hindernisse schwimmt
        if(this.collidesWith(Obstacle.class)||exitingWorld()) {
            this.setRotation(this.getRotation());
        }
        
        //verhindert das die Lampe mit dem verkehrten Bild ins Inventar gesetz wird
        if(collidesWith(Submarine.class)) {
            this.setImage("2lampsmile.png");
        }
    }
    
    /**
     * erfasst den momentanen winkel dieses Aktors und setzt dazu das passende Bild
     * (verhindert dass der Fisch auf dem Kopf schwimmt)
     * 
     */
    public void setImageDependingOnRotation()
    {
        int arc = this.getRotation();
        if (arc >90&& arc <270){
            this.setImage("2lampsmile2.png");
        }
        else{
            this.setImage("2lampsmile.png");
        }
    }
}
