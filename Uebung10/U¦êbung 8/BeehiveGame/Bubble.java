import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    /** time-delay before this bubble pops **/
    private int lifetime;
    
    /**
     * erfasst die überlebensDauer und größe die die erstellte blase besitzt
     * übergibt man lifetime 0 so ist die Blase permanent
     * (sie bleibt erhalten bis sie die Wasseroberfläche erreicht)
     */
    public Bubble (int lifetime,int scale)
    {
        this.lifetime = lifetime==0? 1000000000 : lifetime;
        getImage().scale(scale,scale);
    }
    
    /**
     * Bewegung der Blase in Richtung der Oberfläche
     * Entfernt diese wenn lifetime<=0 ist
     */
    public void act() 
    {
        //links rechts varianz von (X+-1) während der Bewegung der Blase
        int nextX = this.getX()+ Greenfoot.getRandomNumber(4)-2;
        
        //bewegt die Blase
        this.setLocation(nextX,this.getY()-1);
        
        lifetime--;
        
        if (lifetime<=0 || WorldManager.overTheTop(this,0)){
            getWorld().removeObject(this);
            //spielt einen zufälligen der 3 pop sounds ab
            if(WorldManager.bubbleNoise){
                Greenfoot.playSound("bubblepop"+(Greenfoot.getRandomNumber(1)+1)+".wav");
            }
        }
    }    
}
