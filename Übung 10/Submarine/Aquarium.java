import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aquarium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aquarium extends ServerWorld
{

    /**
     * Constructor for objects of class Aquarium.
     * 
     */
    public Aquarium()
    {    
        prepare();
    }
    
    private void prepare()
    {
        InvWall wall1=new InvWall();
        addObject(wall1,281,300);
        
        InvWall wall2=new InvWall();
        addObject(wall2,780,300);
    }
}
