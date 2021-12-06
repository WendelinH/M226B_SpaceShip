package controller;

import processing.core.PApplet;

/**
 * Dieses Interface ist für alle Views zuständig.
 * @author Wendelin
 *
 */
public interface ViewInterface {
	
	abstract void setup(PApplet window);
	
	abstract void draw(PApplet window);
	
}
