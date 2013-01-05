import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.ArrayList;

/**
 * Das Spiel. Erzeugt alle Welten und bietet eine Klassenmethode, 
 * die zu einer Klasse die passende Welt heraussucht. (Übungsblatt 4)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Game extends World
{
    /** Alle Welten. */
    private static ArrayList<World> worlds;

    /**
     * Der Konstruktor fügt alle Objekte der Welt hinzu.
     */
    public Game()
    {    
        super(600, 420, 1); // Passend zur Größe der angezeigten Welten
        worlds = new ArrayList<World>();
        worlds.add(new Level1());
        worlds.add(new Level2());
        Greenfoot.setWorld(worlds.get(0));
    }
    
    /**
     * Sucht die Instanz einer bestimmten Weltenklasse heraus und liefert diese zurück.
     * Falls sie nicht gefunden wird, ist das Ergebnis null.
     * @param worldClass Die Klasse der Welt, nach deren Instanz gesucht wird.
     */
    public static World getWorld(Class worldClass)
    {
        for (World world : worlds) {
            if (world.getClass() == worldClass) {
                return world;
            }
        }
        return null;
    }
}
