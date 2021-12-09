package controller;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Dieses Interface ist f�r alle Views zust�ndig.
 * @author Wendelin
 *
 */
public abstract class View {
	
	private PImage bg;

	public abstract void restart(PApplet window);
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
