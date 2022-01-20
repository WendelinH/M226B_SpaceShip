package model;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Die Raumschiff-Klasse erbt von der Figur-Klasse und representiert den Spieler im Spiel.
 * @author Wendelin
 *
 */
public class Raumschiff extends Figur{
	
	/**
	 * Konstruktor der Raumschiff-Klasse
	 * @param speed : int Geschwindikeit des Raumschiff
	 * @param width : int breite
	 * @param height : int höhe
	 * @param x : xPosition
	 * @param y : yPosition
	 * @param direction : Direction die richtung in die das Raumschiff fliegt.
	 */
	public Raumschiff(int speed, int x, int y, Direction direction, PApplet window) {
		super(speed, 50, 50, x, y, direction);
		setImg_N(window.loadImage("/img/spaceship_N.png"));
		setImg_E(window.loadImage("/img/spaceship_E.png"));
		setImg_S(window.loadImage("/img/spaceship_S.png"));
		setImg_W(window.loadImage("/img/spaceship_W.png"));
	}
	
	/**
	 * Diese Methode zeichnet das Raumschiff.
	 * @param window : PApplet
	 */
	@Override
	public void draw(PApplet window) {
		window.stroke(0, 100, 200);
		window.strokeWeight(1);
		window.noFill();
		window.rect(getX(), getY(), getWidth(), getHeight());
		PImage img = null;
		switch (getDirection()) {
		case N: img = getImg_N(); break; 
		case E: img = getImg_E(); break; 
		case S: img = getImg_S(); break; 
		case W: img = getImg_W(); break; 			
		}
		
		for (Projektil p : getProjektilListe()) {
			p.move(window);
			p.draw(window);
		}
		
		window.image(img, getX(), getY());
	}
	
	/**
	 * Die Methode bewegt das Raumschiff.
	 * @param window : PApplet
	 */
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
