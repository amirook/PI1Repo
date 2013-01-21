import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A simple message dialog. 2 constructors, white text, click to get rid of it.
 * 
 * @author Michael
 */
public class MessageDialog extends ServerActor
{

    private String message;
    private String title;
    private final int width = 200, height = 50;
    private static final int titleHeight = 20;
    
    /**
     * Create a new MessageDialog with a message and a title
     */
    public MessageDialog(String message, String title)
    {
        this.message = message;
        this.title = title;
        makeFrame();
    }
    
    /**
     * Get rid of the box if someone clicks on it
     */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse==null) return;
        if(mouse.getActor()==this && mouse.getButton()==1) getWorld().removeObject(this);
    }
    
    /**
     * Create a new MessageDialog with a message and a default title
     */    
    public MessageDialog(String message)
    {
        this.message = message;
        title = "Greenfoot";
        makeFrame();
    }
    
    private void makeFrame()
    {
        GreenfootImage frame = new GreenfootImage(width, height+titleHeight);
        GreenfootImage title = new GreenfootImage(width, titleHeight);
        GreenfootImage body = new GreenfootImage(width, height);
        
        //Now fill in the colours
        title.setColor(java.awt.Color.BLUE);
        body.setColor(java.awt.Color.GRAY);
        title.fill();
        body.fill();
        
        //Now write the text onto the frame
        body.setColor(java.awt.Color.WHITE);
        title.setColor(java.awt.Color.WHITE);
        title.drawString(this.title, 0, titleHeight/2+5);
        body.drawString(message, 10, body.getHeight()/2);
        
        //Now add the parts of the frame onto the frame
        frame.drawImage(title, 0, 0);
        frame.drawImage(body, 0, titleHeight);
        
        setImage(frame);
    }
}
