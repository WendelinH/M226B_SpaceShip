package controller;

import processing.core.PApplet;

/**
 * Dieses Interface ist f�r alle Views zust�ndig.
 * @author Wendelin
 *
 */
public interface ViewInterface {
	
	abstract void setup();
	
	abstract void draw(PApplet window);
	
}
