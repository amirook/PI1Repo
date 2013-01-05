import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Verwaltet das Inventar unseres Spielers. (Übungsblatt 3)
 * 
 * @author Thomas Röfer 
 * @version 01.11.2012
 */
public class Inventory extends Actor
{
    /** Der Inhalt des Inventars */
    private Item contents;
    
    /** Der Konstruktor löscht das Inventar. */
    public Inventory()
    {
        clear();
    }
    
    /**
     * Speichern eines Gegenstands im Inventar. Das Inventar sieht nun so aus, wie 
     * der gespeicherte Gegenstand. Der Gegenstand selbst wird aus der Szene entfernt.
     * Sollte sich bereits ein Gegenstand im Inventar befinden, geht dieser verloren.
     */
    public void store(Item object)
    {
        contents = object;
        setImage(object.getImage());
        getWorld().removeObject(object);
    }
    
    /**
     * Legt den Inhalt des Inventars an der angegebenen Position in der Welt ab.
     * Löscht das Inventar.
     */
    public void dropAt(int x, int y)
    {
        getWorld().addObject(contents, x, y);
        clear();
    }
    
    /**
     * Liefert den Inhalt des Inventars. Ist es leer, wird null zurückgeliefert.
     */
    public Item get()
    {
        return contents;
    }
    
    /**
     * Löschen des Inventars. Das Inventar wird als leeres Bild dargestellt.
     */
    public void clear()
    {
        contents = null;
        setImage(new GreenfootImage(60, 60));
    }
    
    /**
     * Liefert zurück, ob das Inventar leer ist.
     */
    public boolean isEmpty()
    {
        return contents == null;
    }
    
    /**
     * 
     */
    public void useInventory(Robot robot){
        if (!isEmpty()){
            Item item = contents.useItem(robot);
            if (item != null){
                store(item);
            } else {
                clear();
            }
        }
    }
}
