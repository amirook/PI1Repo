import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
/**
 * Das Inventar eines Actors. Aktuell kann das Inventar nur ein Objekt der Klasse Actor
 * enthalten. Mit Hilfe dieses Objekts, kann die HeldIn Hindernisse überwinden.
 * 
 * @author Beate Ruffer (Bea), Mohamadreza Khostevan (Amir), Daniel Knobloch (Knobi) 
 * @version 1.0.2
 * 
 */
public class Inventory extends ServerActor
{
    /**
     * enthält die Objekte, welche sich im Inventar befinden
     * die größe des Arrays kann beliebig verändert werden (momentan 4 slots
     */
    private Actor collectables[]=new Actor [4];
    
    /**
     * der Index der Anzeige mit welcher der Spieler seine Items auswählt
     */
    private int selectedSlot=0;
    
    /** 
     * die instanz des auswahl cursors
     */
    private GreenfootImage selection= new GreenfootImage("selection.png");
    
    /**
     * Fügt einen Actor auf den ersten freien Platz insInventar hinzu,
     * es entfernt dabei das hinzugefügte Objekt auch aus der Welt.
     * 
     * @param collectable Das, im Inventar zu speichernde Objekt.
     */
    public void pushToInventory(Actor actor)
    {
        int index =0;//zähler zum bestimmen der collectable Position
        //muss mit while erfolgen da  das item sonst auf jeden freien slot gesetzt wird
        while (collectables[index]!=null && index<=collectables.length) {
            index++;
        }
        if (collectables[index]==null) {
                collectables[index]=actor;
                getWorld().removeObject(actor);
                resetImage();
                Greenfoot.playSound("pop.wav");
        }
    }
    
    /**
     * Entfernt das Objekt aus dem Inventar vom "selectedSlot" und setzt es wieder in die Welt.
     * 
     * @param xPos x-Position des Flappers, an die das Objekt zurück gesetzt wird
     * @param yPos y-Position des Flappers, an die das Objekt zurück gesetzt wird
     */
    public void removeFromInventory(int xPos, int yPos)
    {
        if (collectables[selectedSlot]!=null){
            getWorld().addObject(collectables[selectedSlot], xPos, yPos);
            clearSlot(selectedSlot);
            Greenfoot.playSound("shutter.wav");
        }
    }
    
    /**
     * Leert den passenden Slot des Inventar.
     */
    public void clearSlot(int index)
    {
        collectables[index] = null;
        resetImage();
    }
    
    /**
     * Liefert den Slot der eine Instanz der angegebenen Klasse enthält.
     * 
     * @return de Slot auf dem die Instanz liegt.
     * es muss hier bereits garantiert sein dass ein derartiges item im Inventar existiert
     */
    public int findSlot(Class cls)
    {
        int index =0;//zähler für den Index des Slots
        for(Actor slot : collectables) {
            if (slot.getClass()==cls) {
                return index;
            }
            index++;
        }
        return-1;
    }
    
    /**
     * Liefert zurück ob sich irgendwo im Inventar ein Objekt der gesuchten Klasse befindet.
     * 
     * @return true wenn es gefunden wurde.
     */
    public Boolean Contains(Class cls)
    {
        for(Actor slot : collectables) {
            if (slot.getClass() == cls) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Prüft, ob das Inventar leer ist.
     * 
     * @return true, wenn das gesamte Inventar leer ist, andernfalls false.
     */
    public boolean isEmpty()
    {
        for(Actor slot : collectables) {
            if (slot!=null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Prüft, ob das Inventar noch freie Plätze hat.
     * 
     * @return true, wenn das inventar freie Slots besitzt, andernfalls false.
     */
    public boolean hasSpace()
    {
        for(Actor slot : collectables) {
            if (slot==null) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * is used to move the selection between the item Slots
     * the input is the direction the Slot will move in
     */
    public void setSelection(int moveselection)
    {
        if(selectedSlot+moveselection>=0 && selectedSlot+moveselection<collectables.length) {
            selectedSlot = selectedSlot+moveselection;
        }
        resetImage();
    }
    
    /**
     * Zeichnet das Hintergrundbild des Inventars neu. 
     * zeichnet die Items die im Inventar vorhanden sind
     */
    public void resetImage()
    {
        int index = 0; // dient zum setzen der x coordinate des Bildes(abhängig von der Slotnummer
        this.setImage("inventar2.png");
        for (Actor actor: collectables) {
            if(actor!=null) {
                //zeichnet den Inhalt des Inventares in dessen Bild
                this.getImage().drawImage(actor.getImage(), 10+50*index, 0);
            }
            index++;
        }
        this.getImage().drawImage(selection,50*selectedSlot, 0);
    }
}
