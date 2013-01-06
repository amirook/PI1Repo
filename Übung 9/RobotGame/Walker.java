import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Walker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Walker extends Enemy
{
    private boolean rotationComplete = true;
    private int nextDirection;
    private int nextAngle;

    
    /**
     * Act - do whatever the Walker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (newCollisionWith(Robot.class)) {
            Greenfoot.playSound("sad-trombone.wav");
        }
        
        int width  = getWorld().getWidth();
        int height = getWorld().getHeight();
        int iwidth  = getImage().getWidth();
        int iheight = getImage().getHeight();
        //kollision mit den Spielfeldgrenzen oder einer Wand
        if ((collidesWith(Obstacle.class)&& rotationComplete)
            || (this.getX()-(iwidth/2)<=0 && rotationComplete)
            || (this.getX()+(iwidth/2)>= width && rotationComplete)
            || (this.getY()-(iheight/2)<=0 && rotationComplete)
            || (this.getY()+(iheight/2)>=height)&& rotationComplete) {
                
            rotationComplete = false;
            move(-1);
            while(nextAngle == this.getRotation()){
               nextDirection = Greenfoot.getRandomNumber(4);
               nextAngle = nextDirection*90;
            }
            //System.out.println(nextAngle);
        }
        
        if(!rotationComplete) {
            turn(5);
            if(nextAngle == this.getRotation()){
                rotationComplete = true;
            }
        }
        else{move(1);}
        
    }
}
