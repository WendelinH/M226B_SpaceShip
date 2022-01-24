package controller;

import model.AsteroidenWand;
import model.EndPortal;
import model.Gegner;
import model.Raumschiff;
import model.Figur.Direction;
import processing.core.PApplet;

/**
 * Das ist die Level2-Klasse und zeichnet das zweite Level.<br>
 * Diese Klasse erbt von der LevelViewController-Klasse
 * @author Wendelin
 *
 */
public class Level2 extends LevelViewController{

	/**
	 * Konstruktor der Level2-Klasse<br>
	 * Es wird der Konstrukter der Eltern-Klasse aufgerufen sonst nichts.
	 */
	public Level2() {
		super();
	}
	
	/**
	 * Die restart-Methode wird nur einmal ausgefürt befohr das zweiten Level angezeigt wirt und ladet dan das Hintergrundbild
	 * und resetet alle Gegner und erstelt alle AsteoiderWende.<br>
	 * Auch das Raumschiff wird zurükgesetzt.
	 * @param window : PApplet
	 */
	@Override
	public void restart(PApplet window) {
		setBg(window.loadImage("/img/level1_bg.png"));

		getGegnerListe().clear();
		getAsteroidenListe().clear();

		setRaumschiff(new Raumschiff(3, 83, 613, Direction.N, window));
		setEndPortal(new EndPortal(700, 0));

		setLevelCompleat(false);
		setGameOver(false);

		Gegner g1 = new Gegner("Willi 1", 1, 240, 150, Direction.S, 250, window);
		Gegner g2 = new Gegner("Willi 2", 1, 200, 395, Direction.E, 250, window);
		Gegner g3 = new Gegner("Willi 3", 1, 500, 245, Direction.W, 350, window);
		Gegner g4 = new Gegner("Willi 4", 1, 90, 525, Direction.N, 450, window);
		Gegner g5 = new Gegner("Willi 5", 5, 540, 90, Direction.S, 600, window);
		Gegner g6 = new Gegner("Willi 6", 10, 690, 690, Direction.N, 600, window);
		attach(g1);
		attach(g2);
		attach(g3);
		attach(g4);
		attach(g5);
		attach(g6);

		int x = 0;
		int y = 0;
		int size = 75;
		for(int i = 0; i<=25; i++){
			AsteroidenWand a1 = new AsteroidenWand(x, y, size, size, window);
			getAsteroidenListe().add(a1);
			x = x + size + size;
			if(i%5 == 0 && i != 0){
				y = y + size + size;
				x = 0;
				if(i%25 == 0){
					x = size;
				}
			}
		}
	}
	
	/**
	 * Die draw-Methode Zeichnet das zweite Level.
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
		window.text("Level 2", 20,30);
	}
}
