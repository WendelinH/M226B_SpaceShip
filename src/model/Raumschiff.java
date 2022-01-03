package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Raumschiff extends Figur{

	public Raumschiff(int speed, int x, int y, Direction direction) {
		super(speed, 50, 50, x, y, direction);
	}

	@Override
	public void draw(PApplet window) {
		window.stroke(0, 100, 200);
		window.strokeWeight(1);
		window.noFill();
		window.rect(getX(), getY(), getWidth(), getHeight());
		PImage img = null;
		switch (getDirection()) {
		case N: img = window.loadImage("/img/spaceship_N.png"); break; 
		case E: img = window.loadImage("/img/spaceship_E.png"); break; 
		case S: img = window.loadImage("/img/spaceship_S.png"); break; 
		case W: img = window.loadImage("/img/spaceship_W.png"); break; 			
		}
		
		for (Projektil p : getProjektilListe()) {
			p.draw(window);
			p.move(window);
		}
		
		window.image(img, getX(), getY());
	}

	@Override
	public void move(PApplet window) {
		switch(direction) {
		case N: setY(Math.max(0, getY() - getSpeed())); break;
		case E: setX(Math.min(window.width - getWidth(), getX() + getSpeed())); break;
		case S: setY(Math.min(window.height - getHeight(), getY() + getSpeed())); break;
		case W: setX(Math.max(0, getX() - getSpeed())); break;
		}
	}

}
