import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Beschreiben Sie hier die Klasse ServerActor.
 * 
 * Alle Aktoren müssen hiervon erben
 * setLocation überschreiben!!!!!
 * 
 * @author (Ihr Name) 
 * @version (Eine Versionsnummer oder ein Datum)
 */
public class ServerActor extends Actor
{
    public void setLocation(int x, int y){
        System.out.println(this);
        super.setLocation(x, y);
    }  
}
