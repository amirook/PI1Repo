import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Definiert die Methodenaufrufe auf Server-Seite, die zwischen Server und Klient 
 * übertragen werden. Hauptaufgabe von Klassen, die von dieser abstrakten Klasse 
 * erben, ist es, die hier übergebenen Actoren in eindeutige Identifikationsnummern
 * der Avatare zu übersetzen, die die Schnittstelle Client verwendet.
 * 
 * @author Thomas Röfer 
 * @version 18.12.2012
 */
public abstract class Server
{
    /**
     * Entfernt alle Avatare aus der Anzeige und platziert stattdessen alle 
     * Avatare der Actoren aus der neuen Welt. Spielstände und Inventare sollten
     * nur angezeigt werden, wenn sie zu der Instanz der HeldIn gehören, zu der 
     * auch dieser Server gehört.
     * @param world Die Welt, die als nächstes angezeigt werden soll.
     */
    public abstract void setWorld(World world);

    /**
     * Löscht einen Avatar aus der Anzeige.
     * @param actor Der Actor, dessen Avatar gelöscht wird.
     */
    public abstract void removeObject(Actor actor);

    /**
     * Platziert einen Avatar an eine bestimmte Position in der Anzeige. Dabei
     * kann auch ein neuer Avatar in der Anzeige erzeugt werden, wenn der
     * Aufruf dieser Methode eigentlich auf den Aufruf von addObject aus der
     * Klasse World zurückgeht. Letzterer ruft nämlich immer setLocation auf.
     * In diesem Fall sollte auch das Bild gesetzt werden, da dies nämlich
     * normalerweise vor dem Hinzufügen zu einer Welt passiert und es der
     * Server deshalb gar nicht mitbekommt.
     * @param actor Der Actor auf Server-Seite, den der Avatar repräsentiert.
     * @param x Die x-Koordinate, an der der Avatar platziert wird.
     * @param y Die y-Koordinate, an der der Avatar platziert wird.
     */
    public abstract void setLocation(Actor actor, int x, int y);
    
    /**
     * Bringt einen Avatar in eine bestimmte Orientierung in der Anzeige.
     * @param actor Der Actor auf Server-Seite, den der Avatar repräsentiert.
     * @param rotation Die neue Orientierung des Avatars (in Grad).
     */
    public abstract void setRotation(Actor actor, int rotation);
    
    /**
     * Setzt das Bild eines Avatars. Die Methode extrahiert den Namen der Datei,
     * aus der das Bild erzeugt wurde und ruft damit setImage(String) auf.
     * Wenn kein Dateiname bestimmt werden kann, wird null als Dateiname
     * übergeben.
     * @param actor Der Actor auf Server-Seite, den der Avatar repräsentiert.
     * @param image Das Bild.
     */
    public abstract void setImage(Actor actor, GreenfootImage image);  

    /**
     * Setzt das Bild eines Avatars.
     * @param actor Der Actor auf Server-Seite, den der Avatar repräsentiert.
     * @param filename Der Dateiname des Bildes oder null, wenn das Bild leer ist.
     *                 Ein leeres Bild kann als GreenfootImage(1, 1) dargestellt
     *                 werden.
     */
    public abstract void setImage(Actor actor, String filename);
    
    /**
     * Schreibt einen Text in das Bild eines Avatars. Wo und wie geschrieben wird,
     * bestimmt der Klient. Wenn Bedarf besteht, könnte die Signatur dieser Methode
     * auch erweitert werden (Position, Farbe, Font usw.). 
     * @param actor Der Actor auf Server-Seite, den der Avatar repräsentiert.
     * @param text Der Text, der geschrieben werden soll.
     */
    public abstract void setText(Actor actor, String text, int x, int y);

    /**
     * Setzt das Hintergrundbild der Welt in der Anzeige.
     * @param filename Der Name der Bilddatei.
     */
    public abstract void setBackground(String filename);

    /**
     * Fragt ab, ob die übergebene Taste gedrückt ist.
     * @param key Der Name der Taste, wie in der Klasse Greenfoot definiert.
     */
    public abstract boolean isKeyDown(String key);

    /**
     * Spielt einen Sound ab.
     * @param filename Der Name der Sound-Datei.
     */
    public abstract void playSound(String filename);
}
