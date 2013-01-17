/**
 * Definiert die Methodenaufrufe auf Klient-Seite, die zwischen Server und Klient 
 * übertragen werden. Hauptaufgabe von Klassen, die dieses Interface 
 * implementieren, ist es, die hier übergebenen Identifikationsnummern mit den
 * in der Anzeige verwendeten Avataren zu assoziieren und die Methodenaufrufe
 * auf die Avatare anzuwenden.
 * 
 * @author Thomas Röfer 
 * @version 18.12.2012
 */
public interface Client
{
    /**
     * Löscht einen Avatar aus der Anzeige.
     * @param id Die eindeutige Identifikationsnummer des Avatars.
     */
    void removeObject(int id);
    
    /**
     * Platziert einen Avatar an eine bestimmte Position in der Anzeige.
     * @param id Die eindeutige Identifikationsnummer des Avatars. Wenn es keinen
     *           Avatar mit dieser Id gibt, wird einer erzeugt.
     * @param x Die x-Koordinate, an der der Avatar platziert wird.
     * @param y Die y-Koordinate, an der der Avatar platziert wird.
     */
    void setLocation(int id, int x, int y);
    
    /**
     * Bringt einen Avatar in eine bestimmte Orientierung in der Anzeige.
     * @param id Die eindeutige Identifikationsnummer des Avatars.
     * @param rotation Die neue Orientierung des Avatars (in Grad).
     */
    void setRotation(int id, int rotation);
    
    /**
     * Setzt das Bild eines Avatars.
     * @param id Die eindeutige Identifikationsnummer des Avatars.
     * @param filename Der Name der Bilddatei.
     */
    void setImage(int id, String filename);
    
    /**
     * Schreibt einen Text in das Bild des Avatars. Wo und wie geschrieben wird,
     * bestimmt der Client. Wenn Bedarf besteht, könnte die Signatur dieser Methode
     * auch erweitert werden (Position, Farbe, Font usw.). 
     * @param id Die eindeutige Identifikationsnummer des Avatars.
     * @param text Der Text, der geschrieben werden soll.
     */
    void setText(int id, String text);
    
    /**
     * Setzt das Hintergrundbild der Welt in der Anzeige.
     * @param filename Der Name der Bilddatei.
     */
    void setBackground(String filename);
    
    /**
     * Fragt ab, ob die übergebene Taste gedrückt ist. Die Methode sollte
     * immer sofort zurückkehren, also den Zustand der Tasten schon kennen, 
     * wenn er nicht durch einen lokalen Aufruf von Greenfoot.isKeyDown
     * bestimmt werden kann.
     * @param key Der Name der Taste, wie in der Klasse Greenfoot definiert.
     */
    boolean isKeyDown(String key);
    
    /**
     * Spielt einen Sound ab.
     * @param filename Der Name der Sound-Datei.
     */
    void playSound(String filename);
}
