import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;
import java.awt.*;///awt.Font,awt.ArrayList
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
    private Collectable collectables[]=new Collectable [4];
    
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
     * solte es jedoch einen aktor der selben Klasse geben und beide usable sein
     * so wird der stack des vorhandenen Objectes erhöhr
     * 
     * handelt es sich um ein Object mit stack und usable
     * 
     * @param collectable Das, im Inventar zu speichernde Objekt.
     */
    public void pushToInventory(Collectable collectable)
    {
        int index =0;//zähler zum bestimmen der collectable Position
        //muss mit while erfolgen da  das item sonst auf jeden freien slot gesetzt wird
        while (collectables[index]!=null && index<=collectables.length) {
            index++;
        }
        if (collectables[index]==null) {
                collectables[index]= (Collectable) collectable;
                getWorld().removeObject(collectable);
                resetImage();
                Greenfoot.playSound("pop.wav");
        }
    }
    
    /**
     * erhöht den stack des im Inventar vorhandenen Items um den Stack des gelieferten
     */
    public void stackStack(Collectable collectable)
    {
        int slotnumber = findSlot(collectable.getClass());
        collectables[slotnumber].stack = collectables[slotnumber].stack + collectable.stack;
        resetImage();
        Greenfoot.playSound("pop.wav");
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
        return 0;
    }
    
    /**
     * Liefert zurück ob sich irgendwo im Inventar ein Objekt der gesuchten Klasse befindet.
     * 
     * @return true wenn es gefunden wurde.
     */
    public boolean contains(Class cls)
    {
        for(Collectable slot : collectables) {
            if (slot!=null && slot.getClass()== cls) {
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
     * verwendung von items mit boolean "usable"(z.B. Torpedos)
     * der übergebene Aktor ist der verwender des items
     */
    public void useSelection(Actor user)
    {
        if( collectables[selectedSlot]!=null &&
        collectables[selectedSlot].usable &&
        collectables[selectedSlot].stack!=0)
        {
            Collectable item= collectables[selectedSlot];
            item.stack--;
            
            if(item instanceof Torpedo) {
                Torpedo bomb=new Torpedo();
                bomb.fired=true;
                bomb.user=user;
                bomb.setRotation(user.getRotation());
                getWorld().addObject(bomb,user.getX(),user.getY());
            }
            
            if(item.stack<1)//entfernen des Items bei unterschreiten von stack=1
            {
               clearSlot(selectedSlot);
               Greenfoot.playSound("out.wav");
            }
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
        for (Collectable collectable: collectables) {
            if(collectable!=null) {
                //relativer Zeichenkoordinaten des items
                //ermittelt die Koordinaten so dass das item später in der mitte des Rahmens sitzt
                int itemx= 2+50*index;
                int itemy= this.getImage().getHeight()/2 - collectable.getImage().getHeight()/2;
                
                //zeichnet den Inhalt des Inventares in dessen Bild
                this.getImage().drawImage(collectable.getImage(),itemx,itemy);
                
                //zeichnet die Itemzahle bei Usables
                if(collectable.usable)
                {
                    this.getImage().setFont(new Font("Monospaced",Font.BOLD,20));
                    this.getImage().setColor(java.awt.Color.RED);
                    
                    this.getImage().drawString(" "+collectable.stack,itemx,22);
                }
            }
            index++;
        }
        //zeichnet die Auswahl über das Inventar
        this.getImage().drawImage(selection,2+50*selectedSlot,0);
    }
}
