package model;

import processing.core.PApplet;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Figur {

	private int speed;
	private int width;
	private int height;
	private int x;
	private int y;
	
	private ArrayList<Projektil> projektilListe = new ArrayList<>();

	Direction direction = Direction.N;

	/**
	 * dient der Darstellung der Richtung
	 * @author Wendelin
	 *
	 */
	public enum Direction {
		N,E,S,W;
	}

	/**
	 * @param hp
	 * @param speed
	 * @param size
	 * @param x
	 * @param y
	 * @param direction
	 */
	public Figur(int speed, int width, int height, int x, int y, Direction direction) {
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void shoot() {
		switch(direction) {
		case N: projektilListe.add(new Projektil(6, 5, 15, x + width/2, y + height/3, direction)); break;
		case E: projektilListe.add(new Projektil(6, 15, 5, x + width/2, y + height/3, direction)); break;
		case S: projektilListe.add(new Projektil(6, 5, 15, x + width/2, y + height/3, direction)); break;
		case W: projektilListe.add(new Projektil(6, 15, 5, x + width/2, y + height/3, direction)); break;
		}
	}

	public abstract void draw(PApplet window);

	public abstract void move(PApplet window);
	
	public Rectangle getBounds() {
	    return new Rectangle(x, y, width, height);
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
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
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return the projektilListe
	 */
	public ArrayList<Projektil> getProjektilListe() {
		return projektilListe;
	}

	/**
	 * @param projektilListe the projektilListe to set
	 */
	public void setProjektilListe(ArrayList<Projektil> projektilListe) {
		this.projektilListe = projektilListe;
	}

}
