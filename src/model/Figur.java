package model;

import processing.core.PApplet;
import java.awt.Rectangle;

public abstract class Figur {

	private int hp;
	private int speed;
	private int size;
	private int x;
	private int y;

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
	public Figur(int hp, int speed, int size, int x, int y, Direction direction) {
		this.hp = hp;
		this.speed = speed;
		this.size = size;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public abstract void draw(PApplet window);

	public abstract void move(PApplet window);
	
	public Rectangle getBounds() {
	    return new Rectangle(x, y, size, size);
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
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
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
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

}
