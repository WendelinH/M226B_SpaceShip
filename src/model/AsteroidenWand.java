package model;

import processing.core.PApplet;
import processing.core.PImage;

public class AsteroidenWand {
	
	private int width;
	private int height;
	private float x;
	private float y;
	
	PImage img = null;
	
	/**
	 * 
	 * @param weight
	 * @param height
	 * @param x
	 * @param y
	 */
	public AsteroidenWand(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(PApplet window) {
		img = window.loadImage("/img/asteroid.png");
		window.stroke(100, 0, 0);
		window.strokeWeight(1);
		window.noFill();
		window.rect(x, y, width, height);
		window.image(img,x,y,width,height);
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
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	
	
}
