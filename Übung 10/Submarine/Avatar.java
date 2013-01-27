import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.awt.*;

/**
 * Beschreiben Sie hier die Klasse Avatar.
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class Avatar extends Actor
{
    /**
     * Act - Tue was immer Avatar tun möchte. Diese Methode wird aufgerufen,
     * wenn die 'Act'- oder 'Run'-Knöpfe in der Umgebung gedrückt werden.
     */
    public void act() 
    {
        // Fügen Sie Ihren Aktions-Code hier ein.
    } 
    
    public void setText(String text, int x, int y)
    {
        GreenfootImage image = getImage();
        image.setColor(Color.WHITE);
        image.setFont(new Font("Monospaced", Font.PLAIN, 20));
        image.drawString(text, x, y);
    }
}
