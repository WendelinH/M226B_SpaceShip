package controller;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Diese Classe stelt das ende Des Spiels dar.
 * @author Wendelin
 *
 */
public class EndViewController extends View {
	
	@Override
	public void restart(PApplet window) {
		setBg(window.loadImage("/img/bg_start.jpg"));
	}

	@Override
	public void draw(PApplet window) {
		window.background(getBg());
		window.fill(255);
		window.textSize(30);
		window.text("ENDE", 20,30);
	}

}
