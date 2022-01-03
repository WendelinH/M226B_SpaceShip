package model;

import processing.core.PApplet;

public class Projektil extends Figur{
	
	public Projektil(int speed, int width, int height, int x, int y, Direction direction) {
		super(speed, width, height, x, y, direction);
		// TODO Auto-generated constructor stub
	}

	public void draw(PApplet window) {
		window.stroke(100, 200, 100);
		window.fill(100, 200, 100);
		window.rect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void move(PApplet window) {
		switch(direction) {
		case N: setY(getY() - getSpeed()); break;
		case E: setX(getX() + getSpeed()); break;
		case S: setY(getY() + getSpeed()); break;
		case W: setX(getX() - getSpeed()); break;
		}
	}
}
