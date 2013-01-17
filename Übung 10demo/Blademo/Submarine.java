import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Beschreiben Sie hier die Klasse Submarine.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Submarine extends Actor
{
    /**
     * Act - Tue was immer Submarine tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        //this.getImage().scale(80, 50);
        setImageDependingOnRotation();
        
        if(WorldManager.overTheTop(this,30)){
            reactToSurface();
        }
        else{
            if(Greenfoot.isKeyDown("w")){
                move(3);
                randomlyBlowBubbles();
            }
            if(Greenfoot.isKeyDown("s")){
                move(-2);
            }
            if(Greenfoot.isKeyDown("d")){
                turn(1);
            }
            if(Greenfoot.isKeyDown("a")){
                turn(-1);
            }
        }
    }    
    
    /**
     * prüft auf ein Durchbrechen der Wasseroberfläche
     * und reagiert darauf wenn notwendig(
     */
    private void reactToSurface()
    {
        int arc = this.getRotation();
        if(arc< 270 && arc >=90){
            turn(-1);
            move(3);
        }
        
        else{
            turn(1);
            move(3);
        }

        if(arc == 270)
        {
            move(4);
        }
    }

    
    public void setImageDependingOnRotation()
    {
        int arc = this.getRotation();
        if (arc >90&& arc <270){
            this.setImage("sub2.png");
        }
        else{
            this.setImage("sub.png");
        }
    
    }
    
    public void randomlyBlowBubbles()
    {
        if(Greenfoot.getRandomNumber(80)==1){
            //new bubble with lifespan 40 and a scale between(5-40)pixels
            Bubble bubble = new Bubble(100,Greenfoot.getRandomNumber(35)+5);
            getWorld().addObject(bubble,this.getX(),this.getY());
        }
    }
}
