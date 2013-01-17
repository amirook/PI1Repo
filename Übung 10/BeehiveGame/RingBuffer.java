/**
 * Die Klasse implementiert einen Ringpuffer, d.h. einen Puffer, der eine
 * bestimmte Menge von Werten zwischenspeichern kann. Man kann mit
 * {@link push(int)} Werte hinzufügen und mit {@link pop()} wieder entnehmen.
 * Dabei liefert {@link pop()} die Werte in derselben Reihenfolge zurück, in
 * der sie mit {@link push(int)} eingefügt wurden, d.h. {@link pop()} liefert
 * immer das Element zurück, das schon am längsten im Puffer gespeichert ist.
 * Wird ein neues Element in den Puffer eingefügt, wenn seine Kapazität bereits
 * erreicht ist, geht das älteste Element verloren. (Übungsblatt 6)
 */
public class RingBuffer
{
    /** Der eigentliche Puffer, der die Werte speichert. */
    private int[] buffer;
    
    /** Der Kopf des Ringpuffers, d.h. die Stelle, an der als Nächstes etwas geschrieben wird. */
    private int head;

    /** Der Füllstand des Puffers. */
    private int entries;

    /**
     * Erzeugt einen Ringpuffer.
     * @param capacity Die maximale Anzahl von Einträgen, die gepuffert werden können.
     */
    public RingBuffer(int capacity)
    {
        buffer = new int[capacity];
        head = 0;
        entries = 0;
    }
    
    /**
     * Fügt ein neues Element in den Ringpuffer ein.
     * @param value Der Wert, der eingefügt werden soll.
     */
    public void push(int value)
    {
        if (buffer.length > 0)
        {
            buffer[head] = value;
            head = (head + 1) % buffer.length;
            if (entries < buffer.length) {
               ++entries;
            }
        }
    }
    
    /**
     * Entnimmt das älteste Element aus dem Ringpuffer.
     * @return Das Element, das entnommen wurde.
     */
    public int pop()
    {
        int value = peek();
        --entries;
        return value;
    }
    
    /**
     * Liefert das älteste Element aus dem Ringpuffer zurück, ohne es zu entnehmen.
     * @return Das älteste Element im Ringpuffer.
     */
    public int peek()
    {
        return buffer[(head - entries + buffer.length) % buffer.length];
    }
    
    /**
     * Liefert die Anzahl der Elemente zurück, die sich im Puffer befinden, d.h. die
     * mit {@link pop()} entnommen werden könnten.
     * @return Die Anzahl der belegten Einträge im Puffer.
     */
    public int size()
    {
        return entries;
    }
}