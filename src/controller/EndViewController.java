package controller;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Diese Classe stelt das ende Des Spiels dar.
 * @author Wendelin
 *
 */
public class EndViewController implements ViewInterface {

	PImage bg;

	@Override
	public void draw(PApplet window) {
		bg = window.loadImage("/img/bg_start.jpg");
		window.background(bg);
		window.fill(255);
		window.textSize(30);
		window.text("ENDE", 20,30);
	}

}
