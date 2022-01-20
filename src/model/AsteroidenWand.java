package model;

import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Die AsteroidenWand-Klasse ist ein hindernis für das Raumschiff in form eines Asteroiden.
 * @author Wendelin
 *
 */
public class AsteroidenWand {
	
	private int width;
	private int height;
	private int x;
	private int y;
	
	PImage img = null;
	
	/**
	 * Dieser Konstrukor erstellt ein AsteroidenWand-Object mit den Attributen und den Werten der Parameter.
	 * @param x : int xPosition
	 * @param y : int yPosition
	 * @param width : int breite
	 * @param height : int höhe
	 * @param window : PApplet
	 */
	public AsteroidenWand(int x, int y, int width, int height, PApplet window) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.img = window.loadImage("/img/asteroid.png");
	}
	
	/**
	 * Diese draw-Methode zeichnet die AsteroidenWand.
	 * @param window : PApplet
	 */
	public void draw(PApplet window) {
		window.stroke(100, 0, 0);
		window.strokeWeight(1);
		window.noFill();
		window.rect(x, y, width, height);
		window.image(img,x,y,width,height);
	}
	
	/**
	 * Diese Methode giebt ein Ractangle-Object zurück das die Collisionbox der AsteroidenWand darstellt.
	 * @return new Rectangle(x, y, width, height)
	 */
	public Rectangle getBounds() {
	    return new Rectangle(x, y, width, height);
	}

	/**
	 * @return the weight
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
