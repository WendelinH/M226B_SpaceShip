package model;

import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Die EndPortal-Klasse ist das Ziel für das Raumschiff.
 * @author Wendelin
 *
 */
public class EndPortal {
	
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * Dieser Konstrukor erstellt ein EndPortal-Object mit den Attributen und den Werten der Parameter.
	 * @param x : int xPosition
	 * @param y : int yPosition
	 */
	public EndPortal(int x, int y) {
		this.x = x;
		this.y = y;
		width = 50;
		height = 50;
	}
	
	/**
	 * Diese draw-Methode zeichnet die EndPortal.
	 * @param window : PApplet
	 */
	public void draw(PApplet window) {
		window.strokeWeight(1);
		window.noFill();
		window.rect(x, y, width, height);
		PImage img = null;
		img = window.loadImage("/img/endPortal.png");
		window.image(img, x, y);
	}
	
	/**
	 * Diese Methode giebt ein Ractangle-Object zurück das die Collisionbox der EndPortal darstellt.
	 * @return new Rectangle(x, y, width, height)
	 */
	public Rectangle getBounds() {
	    return new Rectangle(x, y, width, height);
	}
}
