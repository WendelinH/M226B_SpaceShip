package controller;

import processing.core.PApplet;

/**
 * Diese Classe stelt den start des Spiels dar.
 * @author Wendelin
 *
 */
public class StartViewController implements ViewInterface{

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PApplet window) {
		// TODO Auto-generated method stub
		window.background(0);
		window.fill(255);
		window.textSize(30);
		window.text("Start", 20,30);
	}

}
