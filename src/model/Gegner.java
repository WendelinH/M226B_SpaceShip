package model;

import java.util.Timer;
import java.util.TimerTask;

import controller.Observer;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Gegner extends Figur implements Observer{

	private String name;
	private boolean broken;
	private int startXPos;
	private int startYPos;
	private int endXPos;
	private int endYPos;

	public Gegner(String name, int speed, int x, int y, Direction direction, int moveDistanc) {
		super(speed, 50, 50, x, y, direction);
		this.name = name;
		this.startXPos = x;
		this.startYPos = y;
		this.broken = false;

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
	}

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
		case N: img = window.loadImage("/img/gegner_N.png"); break; 
		case E: img = window.loadImage("/img/gegner_E.png"); break; 
		case S: img = window.loadImage("/img/gegner_S.png"); break; 
		case W: img = window.loadImage("/img/gegner_W.png"); break; 			
		}

		for (Projektil p : getProjektilListe()) {
			p.draw(window);
			p.move(window);
		}

		window.image(img, getX(), getY());

		PFont f = window.createFont("Consolas",16,true);
		window.textFont(f,16);
		window.textSize(16);
		window.text(name, getX(), getY());
	}

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
	 * Das sind die Funktionen die ein Observer braucht.
	 */

	@Override
	public void update(String nachricht) {
		if(nachricht == "Jemand ist KO gegangen.") {
			Timer timer = new Timer();
			int defaultSpeed = getSpeed();
			//vor Sekunde 1
			setSpeed(getSpeed() * 6);

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
