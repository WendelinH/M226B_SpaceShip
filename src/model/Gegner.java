package model;

import java.util.Timer;
import java.util.TimerTask;

import controller.Observer;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Die Gegner-Klasse erbt von der Figur-Klasse und implementiert das Observer-Interface.<br>
 * Diese Klasse ist ein Raumschif das sich auf einer Linie bewegt und ein Hinderniss für das Raumschif ist.
 * @author Wendelin
 *
 */
public class Gegner extends Figur implements Observer{

	private String name;
	private boolean broken;
	private int topSpeed;
	private int startXPos;
	private int startYPos;
	private int endXPos;
	private int endYPos;
	
	/**
	 * Der Konstruktor der Gegner-Klasse
	 * @param name : String der Name des Gegners
	 * @param speed : int die Geschwindikeit des Gegners
	 * @param x : xPosition
	 * @param y : yPosition
	 * @param direction : Direction die richtung in die der Gegner schaut
	 * @param moveDistanc : int die Distanc die der Gegner sich bewegen kann
	 * @param window : PApplet
	 */
	public Gegner(String name, int speed, int x, int y, Direction direction, int moveDistanc, PApplet window) {
		super(speed, 50, 50, x, y, direction);
		this.name = name;
		this.startXPos = x;
		this.startYPos = y;
		this.broken = false;
		this.topSpeed = speed * 3;

		switch (getDirection()) {
		case N: endXPos = x; endYPos = y - moveDistanc; break; 
		case E: endXPos = x + moveDistanc; endYPos = y; break; 
		case S: endXPos = x; endYPos = y + moveDistanc; break; 
		case W: endXPos = x - moveDistanc; endYPos = y; break; 			
		}

		if(startXPos > endXPos) {
			int temp = startXPos;
			startXPos = endXPos;
			endXPos = temp;
		}
		if(startYPos > endYPos) {
			int temp = startYPos;
			startYPos = endYPos;
			endYPos = temp;
		}
		
		setImg_N(window.loadImage("/img/gegner_N.png"));
		setImg_E(window.loadImage("/img/gegner_E.png"));
		setImg_S(window.loadImage("/img/gegner_S.png"));
		setImg_W(window.loadImage("/img/gegner_W.png"));
	}
	
	/**
	 * Das ist eine Abstracte Methode die die Gegner zeichnet.
	 * @param window : PApplet
	 */
	@Override
	public void draw(PApplet window) {
		if(broken) {
			window.stroke(0, 150, 0);
		}else {
			window.stroke(150, 0, 0);
		}
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

		PFont f = window.createFont("Consolas",16,true);
		window.textFont(f,16);
		window.textSize(16);
		if(broken) {
			window.fill(0, 150, 0);
		}else {
			window.fill(150, 0, 0);
		}
		window.text(name, getX(), getY());
	}
	
	/**
	 * Diese Methode bewegen den Gegner.
	 * @param window : PApplet
	 */
	@Override
	public void move(PApplet window) {
		if (!broken) {
			switch(getDirection()) {
			case N: setY(Math.max(startYPos, getY() - getSpeed())); break;
			case E: setX(Math.min(endXPos, getX() + getSpeed())); break;
			case S: setY(Math.min(endYPos, getY() + getSpeed())); break;
			case W: setX(Math.max(startXPos, getX() - getSpeed())); break;
			}

			if (getX() <= startXPos && getY() <= startYPos || getX() >= endXPos && getY() >= endYPos) {
				switch(getDirection()) {
				case N: setDirection(Direction.S); break;
				case E: setDirection(Direction.W); break;
				case S: setDirection(Direction.N); break;
				case W: setDirection(Direction.E); break;
				}
			}
		}
	}

	/**
	 * @return the broken
	 */
	public boolean isBroken() {
		return broken;
	}

	/**
	 * @param broken the broken to set
	 */
	public void setBroken(boolean broken) {
		this.broken = broken;
	}

	/**
	 * Diese Methode übernimt die Nachrichten der Subjekt-Interface und verarbeitet sie dementsprechend.
	 * @param nachricht : String Die Nachricht die übermitelt wird
	 */
	@Override
	public void update(String nachricht) {
		if(nachricht == "Jemand ist KO gegangen.") {
			Timer timer = new Timer();
			int defaultSpeed = getSpeed();
			//vor Sekunde 1
			setSpeed(topSpeed);

			for(int i = 0;i < 9;i ++) {
				// nach i Sek geht’s los
				timer.schedule  ( new TimerTask(){
					public void run() {
						if(!broken) {
							shoot();
						}
					}
				}, 1000 * i);
			}

			// nach 10 Sek geht’s los
			timer.schedule  ( new TimerTask(){
				public void run() {
					setSpeed(defaultSpeed);
				}
			}, 10000 );
		}
	}

}
