package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Raumschiff extends Figur{

	public Raumschiff(int hp, float speed, float x, float y, Direction direction) {
		super(hp, speed, 50, x, y, direction);
	}

	@Override
	public void draw(PApplet window) {
		PImage img = null;
		switch (getDirection()) {
		case N: img = window.loadImage("/img/spaceship_N.png"); break; 
		case E: img = window.loadImage("/img/spaceship_E.png"); break; 
		case S: img = window.loadImage("/img/spaceship_S.png"); break; 
		case W: img = window.loadImage("/img/spaceship_W.png"); break; 			
		}
		window.image(img, getX(), getY());
	}

}
