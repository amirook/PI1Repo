import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Klasse implementiert das rechte Paddle. Bevor sie benutzt wird, muss der
 * Tastatur-Manager gesetzt werden.
 */
public class RightPaddle extends Actor
{
  /** Der Manager für die Tastatursteuerung. */
  private Ball keyboardManager;

  /**
   * Der Konstruktor dreht das Paddle nach unten.
   */
  public RightPaddle()
  {
    setRotation(-90);
  }
    
  /** 
   * Setzt den den Manager für die Tastatursteuerung.
   * @param keyboardManager Das Objekt, das ab jetzt die Tastatursteuerung
   *                        für dieses Paddle übernimmt.
   */
  public void setKeyboardManager(Ball keyboardManager)
  {
    this.keyboardManager = keyboardManager;
  }
    
  /**
   * Diese Methode wird aufgerufen, wenn die 'Act'- oder 'Run'-Knöpfe
   * in der Umgebung gedrückt werden. Sie nutzt den Tastaturmanager,
   * um das Paddle zu bewegen.
   */
  public void act() 
  {
    keyboardManager.handleRightPaddle(this);
  }    
}