package controller;

import processing.core.PApplet;

/**
 * Diese Classe stelt das ende Des Spiels dar.
 * @author Wendelin
 *
 */
public class EndViewController implements ViewInterface {

	@Override
	public void setup(PApplet window) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PApplet window) {
		// TODO Auto-generated method stub
		window.background(0);
		window.fill(255);
		window.textSize(30);
		window.text("ENDE", 20,30);
	}

}