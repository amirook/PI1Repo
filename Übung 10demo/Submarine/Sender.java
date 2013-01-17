import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Instanzen dieser Klasse können über Aufrufe der Methoden der Superklasse 
 * PrintStream mit Daten befüllt werden. Über einen Aufruf von send() werden diese
 * dann über einen Socket versendet. Die Kommunikation ist nicht-blockierend.
 * 
 * @author Thomas Röfer 
 * @version 21.12.2012
 */
public class Sender extends PrintStream
{
    /** Der Kanal, auf dem die Daten versendet werden. */
    private SocketChannel channel;
    
    /**
     * Erzeugt ein neues Objekt zum Versenden von Daten.
     * @param channel Der Kanal, auf dem die Daten versendet werden.
     * @throws IOException Ein Problem beim Wechsel in den nicht-blockierenden
     *                     Modus ist aufgetreten.
     */
    public Sender(SocketChannel channel) throws IOException
    {
        super(new ByteArrayOutputStream());
        this.channel = channel;
        channel.configureBlocking(false);
    }
    
    /**
     * Versendet alle Daten, die seit dem letzten Versenden an diesen Stream geschickt
     * wurden. Der Aufruf dieser Methode beeinflusst nicht, in welcher Stückelung die
     * Daten beim Empfänger ankommen, d.h. mehrere Aufrufe dieser Methode können beim 
     * Empfänger auch in einem großen Datenpaket ankommen.
     * @throws IOException Beim Versenden ist ein Fehler aufgetreten.
     */
    public void send() throws IOException
    {
        // Alles in den ByteArrayOutputStream schreiben, wenn noch nicht geschehen
        super.flush();
        
        // Daten auslesen
        ByteBuffer buf = ByteBuffer.wrap(((ByteArrayOutputStream) out).toByteArray());
        
        // Über Kanal verschicken
        channel.write(buf);
        
        // Zurücksetzen, weil alle bisherigen Daten schon versendet wurden
        ((ByteArrayOutputStream) out).reset();
    }
}
