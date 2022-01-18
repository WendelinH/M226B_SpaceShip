package controller;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Diese Klasse stelt das ende des Spiels(den Endbildschirm) dar.<br>
 * Diese Klasse erbt von der View-Klasse
 * @author Wendelin
 *
 */
public class EndViewController extends View {
	
	/**
	 * Konstruktor der EndViewController-Klasse<br>
	 * Es wird der Konstrukter der Eltern-Klasse aufgerufen sonst nichts.
	 */
	public EndViewController() {
		super();
	}
	
	/**
	 * Die restart-Methode wird nur einmal ausgefürt befohr der Endbildschirm angezeigt wirt und ladet dan das Hintergrundbild.
	 * @param window : PApplet
	 */
	@Override
	public void restart(PApplet window) {
		setBg(window.loadImage("/img/bg_start.jpg"));
	}
	
	/**
	 * Die draw-Methode Zeichnet den ganzen EndBildschirm.<br>
	 * Mit Hintergrund und Schriftzug und so.
	 * @param window : PApplet
	 */
	@Override
	public void draw(PApplet window) {
		window.background(getBg());
		window.fill(255);
		window.textSize(30);
		window.text("ENDE", 20,30);
	}
}
