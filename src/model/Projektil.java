package model;

import processing.core.PApplet;

/**
 * Die Projektil-Klasse ist einfach en kleines grünes Rechteck das in eine richtung fliegt.<br>
 * Die Klasse erbt von der Figur-Klasse.
 * @author Wendelin
 *
 */
public class Projektil extends Figur{
	
	/**
	 * Konstruktor der Projektil-Klasse
	 * @param speed : int Geschwindikeit des Projektiels
	 * @param width : int breite
	 * @param height : int höhe
	 * @param x : xPosition
	 * @param y : yPosition
	 * @param direction : Direction die richtung in die das Projektiel fliegt.
	 */
	public Projektil(int speed, int width, int height, int x, int y, Direction direction) {
		super(speed, width, height, x, y, direction);
	}
	
	/**
	 * Diese Methode zeichnet das Projektil.
	 * @param window : PApplet
	 */
	public void draw(PApplet window) {
		window.stroke(100, 200, 100);
		window.fill(100, 200, 100);
		window.rect(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Die Methode bewegt das Projektil in eine richtung.
	 * @param window : PApplet
	 */
	@Override
	public void move(PApplet window) {
		switch(direction) {
		case N: setY(getY() - getSpeed()); break;
		case E: setX(getX() + getSpeed()); break;
		case S: setY(getY() + getSpeed()); break;
		case W: setX(getX() - getSpeed()); break;
		}
	}
}
