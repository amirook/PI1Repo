import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Biene soll Blumen sammeln, um Punkte zu bekommen.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi)
 * @version 1.0.2
 */
public class Fish extends Creature
{
    public void Fish(String imageleft, String imageright)
    {
        
    }
    /**
     * Konstruktor initialisiert die Anfangswerte für die Sound Datei und dem Punktewert für Fish.
     */
    public void act()
    {
        move(2);
        turn(1);
        //verhindert das die Lampe durch Hindernisse und WasserOberfläche schwimmt
        if(this.collidesWith(Obstacle.class)||exitingWorld()||WorldManager.surfaceY>this.getY()) {
            this.setRotation(this.getRotation()+180);
            while(this.collidesWith(Obstacle.class)) {
                this.move(10);
            }
        }
        
        //zufällige Bewegung
        if(Greenfoot.getRandomNumber(200)==1){turn (90);}
        
        //verhindert das die Lampe mit dem verkehrten Bild ins Inventar gesetz wird
        if(collidesWith(Submarine.class)) {
            this.setImage("2lampsmile.png");
        }
    }
    
    protected void reactToObstacles()
    {
        //verhindert das er Fisch durch Hindernisse und WasserOberfläche schwimmt
        if(this.collidesWith(Obstacle.class)||exitingWorld()||WorldManager.surfaceY>this.getY()) {
            this.setRotation(this.getRotation()+180);
            while(this.collidesWith(Obstacle.class)) {
                this.move(10);
            }
        }
    }
    
    /**
     * erfasst den momentanen winkel dieses Aktors und setzt dazu das passende Bild
     * (verhindert dass der Fisch auf dem Kopf schwimmt)
     * 
     */
    protected void setImageDependingOnRotation(Fish fish,String imageleft, String imageright)
    {
        int arc = this.getRotation();
        if (arc >90&& arc <270){
            this.setImage( imageleft+".png");
        }
        else{
            this.setImage(imageright+".png");
        }
    }
}
