package model;

import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

public class EndPortal {
	
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * @param x
	 * @param y
	 */
	public EndPortal(int x, int y) {
		this.x = x;
		this.y = y;
		width = 50;
		height = 50;
	}
	
	public void draw(PApplet window) {
		window.strokeWeight(1);
		window.noFill();
		window.rect(x, y, width, height);
		PImage img = null;
		img = window.loadImage("/img/endPortal.png");
		window.image(img, x, y);
	}
	
	public Rectangle getBounds() {
	    return new Rectangle(x, y, width, height);
	}
}
