package controller;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Dieses abstracte Klasse ist für alle Views zuständig(Parent-Class).
 * @author Wendelin
 *
 */
public abstract class View {
	
	private PImage bg;
	
	/**
	 * Diese Methode soll nur einmahl vor der draw-Methode ausgefürt werden um alles zu reseten.
	 * @param window : PApplet
	 */
	public abstract void restart(PApplet window);
	
	/**
	 * Diese Methode zeichnet den View.
	 * @param window : PApplet
	 */
	public abstract void draw(PApplet window);
	
	/**
	 * @return the bg
	 */
	public PImage getBg() {
		return bg;
	}
	/**
	 * @param bg the bg to set
	 */
	public void setBg(PImage bg) {
		this.bg = bg;
	}

}
