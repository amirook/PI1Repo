import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestGif extends GifActor
{
    public TestGif() 
    {
        this.setImage("bomb.gif");
    }   
    
    /**
     * Act - do whatever the Test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act(); //You MUST keep this in your act method for your animation to work!
        if(Greenfoot.isKeyDown("p")) {
            pause();
        }
        if(Greenfoot.isKeyDown("r")) {
            resume();
        }
    }
}
