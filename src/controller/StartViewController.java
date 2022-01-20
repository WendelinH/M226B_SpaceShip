package controller;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Diese Klasse stelt den start des Spiels dar.
 * Diese Klasse erbt von der View-Klasse
 * @author Wendelin
 *
 */
public class StartViewController extends View{

	/**
	 * Konstruktor
	 */
	public StartViewController() {
		super();
	}
	
	/**
	 * Das ist eine Methode die nur einmahl ausgeführt wird um alles zurück zu setzen 
	 * oder neu zu erstellen befor der Startbildschirm angezeigt wird.
	 * @param window : PApplet
	 */
	@Override
	public void restart(PApplet window) {
		setBg(window.loadImage("/img/bg_start.jpg"));
	}
	
	/**
	 * Das ist eine Methode die den Startbildschirm zeichnen soll.
	 * @param window : PApplet
	 */
	@Override
	public void draw(PApplet window) {
		window.background(getBg());
		window.fill(255);
		PFont f = window.createFont("Consolas",16,true);
		window.textFont(f,36);
		window.textSize(60);
		window.text("SpaceShip", 20,60);
		
		window.textSize(30);
		window.text("Level 1", 30,120);
		window.textSize(15);
		window.text("press '1'", 160,120);
		
		window.textSize(30);
		window.text("Level 2", 30,155);
		window.textSize(15);
		window.text("press '2'", 160,155);
	}

}
