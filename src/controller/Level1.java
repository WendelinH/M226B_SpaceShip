package controller;

import model.Raumschiff;
import model.AsteroidenWand;
import model.Figur.Direction;
import model.Gegner;
import processing.core.PApplet;

public class Level1 extends LevelViewController{
	
	/**
	 * Konstruktor
	 */
	public Level1() {
		super();
	}

	@Override
	public void restart(PApplet window) {
		getGegnerListe().clear();
		getAsteroidenListe().clear();
		
		setRaumschiff(new Raumschiff(3, 100, 650, Direction.N));
		setLevelCompleat(false);
		setGameOver(false);
		
		Gegner g1 = new Gegner("Hans", 3, 465, 100, Direction.S, 500);
		getGegnerListe().add(g1);
		
		AsteroidenWand a1 = new AsteroidenWand(50, 50, 300, 20);
		AsteroidenWand a2 = new AsteroidenWand(50, 100, 60, 60);
		AsteroidenWand a3 = new AsteroidenWand(150, 90, 150, 10);
		AsteroidenWand a4 = new AsteroidenWand(250, 250, 90, 30);
		AsteroidenWand a5 = new AsteroidenWand(500, 100, 240, 240);
		getAsteroidenListe().add(a1);
		getAsteroidenListe().add(a2);
		getAsteroidenListe().add(a3);
		getAsteroidenListe().add(a4);
		getAsteroidenListe().add(a5);
	}

	@Override
	public void draw(PApplet window) {
		window.background(0);
		window.fill(255);
		window.textSize(30);
		window.text("Level 1", 20,30);

		for(AsteroidenWand a : getAsteroidenListe()) {
			a.draw(window);
		}
		for(Gegner g : getGegnerListe()) {
			g.move(window);
			g.draw(window);
			checkCollisions();
		}
		

		getRaumschiff().draw(window);
		
		if (isGameOver()) {
			gameOver(window);
		}
	}

}
