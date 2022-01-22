package controller;

import model.Raumschiff;
import model.AsteroidenWand;
import model.EndPortal;
import model.Figur.Direction;
import model.Gegner;
import processing.core.PApplet;

/**
 * Das ist die Level1-Klasse und zeichnet das erste Level.<br>
 * Diese Klasse erbt von der LevelViewController-Klasse
 * @author Wendelin
 *
 */
public class Level1 extends LevelViewController{

	/**
	 * Konstruktor der Level1-Klasse<br>
	 * Es wird der Konstrukter der Eltern-Klasse aufgerufen sonst nichts.
	 */
	public Level1() {
		super();
	}

	/**
	 * Die restart-Methode wird nur einmal ausgefürt befohr das erste Level angezeigt wirt und ladet dan das Hintergrundbild
	 * und resetet alle Gegner und erstelt alle AsteoiderWende.<br>
	 * Auch das Raumschiff wird zurükgesetzt.
	 * @param window : PApplet
	 */
	@Override
	public void restart(PApplet window) {
		setBg(window.loadImage("/img/level1_bg.png"));

		getGegnerListe().clear();
		getAsteroidenListe().clear();

		setRaumschiff(new Raumschiff(3, 20, 680, Direction.N, window));
		setEndPortal(new EndPortal(700, 0));

		setLevelCompleat(false);
		setGameOver(false);

		Gegner g1 = new Gegner("Hans", 1, 0, 60, Direction.S, 190, window);
		Gegner g2 = new Gegner("Peter", 2, 160, 175, Direction.E, 290, window);
		Gegner g3 = new Gegner("Pan", 2, 450, 230, Direction.W, 290, window);
		Gegner g4 = new Gegner("Ueli", 1, 110, 115, Direction.S, 135, window);
		Gegner g5 = new Gegner("Gary", 1, 355, 650, Direction.N, 120, window);
		Gegner g6 = new Gegner("Ralf", 4, 700, 580, Direction.W, 260, window);
		Gegner g7 = new Gegner("SPEED", 6, 355, 475, Direction.W, 355, window);

		attach(g1);
		attach(g2);
		attach(g3);
		attach(g4);
		attach(g5);
		attach(g6);
		attach(g7);

		AsteroidenWand a1 = new AsteroidenWand(0, 300, 440, 50, window);
		AsteroidenWand a2 = new AsteroidenWand(500, 300, 50, 50, window);
		AsteroidenWand a3 = new AsteroidenWand(500, 50, 250, 250, window);
		for (int i = 0; i < 5; i++) {
			AsteroidenWand a = new AsteroidenWand(70*i, 580, 70, 75, window);
			getAsteroidenListe().add(a);
		}

		AsteroidenWand a4 = new AsteroidenWand(410, 580, 30, 70, window);
		AsteroidenWand a5 = new AsteroidenWand(410, 475, 50, 50, window);
		for (int i = 0; i < 7; i++) {
			AsteroidenWand a = new AsteroidenWand(40*i+460, 475-20*i, 80, 40, window);
			getAsteroidenListe().add(a);
		}
		AsteroidenWand a6 = new AsteroidenWand(60, 60, 440, 50, window);

		getAsteroidenListe().add(a1);
		getAsteroidenListe().add(a2);
		getAsteroidenListe().add(a3);
		getAsteroidenListe().add(a4);
		getAsteroidenListe().add(a5);
		getAsteroidenListe().add(a6);
	}

	/**
	 * Die draw-Methode Zeichnet das erste Level.<br>
	 * Mit Hintergrund und Schriftzug und Gegner, AsteroidenWende, Endportal und das Raumschiff.
	 * @param window : PApplet
	 */
	@Override
	public void draw(PApplet window) {
		window.background(getBg());

		getEndPortal().draw(window);

		for(AsteroidenWand a : getAsteroidenListe()) {
			a.draw(window);
		}
		for(Gegner g : getGegnerListe()) {
			g.move(window);
			g.draw(window);
		}

		checkCollisions();

		getRaumschiff().draw(window);

		if (isGameOver()) {
			gameOver(window);
		}
		if (isLevelCompleat()) {
			levelCompleat(window);
		}

		window.fill(255);
		window.textSize(30);
		window.text("Level 1", 20,30);
	}
}
