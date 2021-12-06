package model;

import processing.core.PApplet;

public abstract class Figur {

	private int hp;
	private float speed;
	private int size;
	private float x;
	private float y;

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
	public Figur(int hp, float speed, int size, float x, float y, Direction direction) {
		this.hp = hp;
		this.speed = speed;
		this.size = size;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public abstract void draw(PApplet window);

	public void move(PApplet window) {
		switch(direction) {
		case N: y = Math.max(0, y - speed); break;
		case E: x = Math.min(window.width, x + speed); break;
		case S: y = Math.min(window.height, y + speed); break;
		case W: x = Math.max(0, x - speed);
		}
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
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
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
