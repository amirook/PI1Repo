import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Instanzen dieser Klasse empfangen Daten von einem Socket und stellen diese
 * als Scanner zur Verfügung. Die Kommunikation ist nicht-blockierend.
 * 
 * @author Thomas Röfer
 * @version 21.12.2012
 */
public class Receiver
{
    /** Der Kanal, auf dem die Daten empfangen werden. */
    private SocketChannel channel;
    
    /** Ein Puffer, der zum Empfang verwendet wird. */
    private ByteBuffer buffer;
    
    /**
     * Erzeugt ein neues Objekt zum Empfangen von Daten.
     * @param channel Der Kanal, auf dem die Daten empfangen werden.
     * @param bufferSize Die Größe des Puffers, der zum Empfangen genutzt wird.
     *                   Diese muss mindestens so gewählt werden, dass alle
     *                   Daten zwischen zwei Zeilenvorschüben in den Puffer passen. 
     *                   Besser ist es allerdings, wenn alle Daten eines 
     *                   Kommunikationszyklus in den Puffer passen (z.B. 10000).
     * @throws IOException Ein Problem beim Wechsel in den nicht-blockierenden
     *                     Modus ist aufgetreten.
     */
    public Receiver(SocketChannel channel, int bufferSize) throws IOException
    {
        this.channel = channel;
        channel.configureBlocking(false);
        buffer = ByteBuffer.allocate(bufferSize);
        assert System.getProperty("line.separator").endsWith("\n")
                : "Dieser Code erwartet \\n für Zeilenvorschübe"; 
    }
    
    /**
     * Testet, ob Daten zum Empfang bereitstehen und liefert diese in Form eines
     * Scanners. Es werden immer nur Daten bis einschließlich des letzten
     * Zeilenvorschubs geliefert. Wenn man Informationseinheiten beim Senden
     * mit Zeilenvorschüben abschließt, sie aber selbst keinen enthalten, kann man
     * davon ausgehen, dass diese nur vollständig geliefert werden.
     * @return Einen Scanner, wenn Daten empfangen wurden. Über den Scanner können
     *         die Daten gelesen werden. null, wenn keine neuen Daten vorhanden
     *         sind.
     * @throws IOException Beim Lesen ist ein Fehler aufgetreten.
     */
    public Scanner receive() throws IOException
    {
        if (channel.read(buffer) > 0) {
            // Wir wollen die Daten lesen
            buffer.flip();
            
            // Letzten Zeilenvorschub finden
            int index = buffer.limit();
            while (index > 0 && buffer.get(index - 1) != '\n') {
                --index;
            }
            
            if (index > 0) {
                // Wenn Daten mit Zeilenvorschub vorhanden, dann liefern
                byte[] data = new byte[index];
                
                // Daten auslesen
                buffer.get(data);
                
                // Ausgelesene Daten verwerfen, restliche Daten erhalten
                buffer.compact();
                
                return new Scanner(new ByteArrayInputStream(data));
            }
        }
        return null;
    }
}