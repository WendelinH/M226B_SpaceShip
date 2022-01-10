package controller;

import model.AsteroidenWand;
import model.EndPortal;
import model.Gegner;
import model.Raumschiff;
import model.Figur.Direction;
import processing.core.PApplet;

public class Level2 extends LevelViewController{

	/**
	 * Konstruktor
	 */
	public Level2() {
		super();
	}

	@Override
	public void restart(PApplet window) {
		setBg(window.loadImage("/img/level1_bg.png"));

		getGegnerListe().clear();
		getAsteroidenListe().clear();

		setRaumschiff(new Raumschiff(3, 83, 613, Direction.N, window));
		setEndPortal(new EndPortal(700, 0));

		setLevelCompleat(false);
		setGameOver(false);

		Gegner g1 = new Gegner("Walter 1", 1, 240, 150, Direction.S, 250, window);
		Gegner g2 = new Gegner("Walter 2", 1, 200, 395, Direction.E, 250, window);
		Gegner g3 = new Gegner("Walter 3", 1, 500, 245, Direction.W, 350, window);
		Gegner g4 = new Gegner("Walter 4", 1, 90, 525, Direction.N, 450, window);
		attach(g1);
		attach(g2);
		attach(g3);
		attach(g4);

		int x = 0;
		int y = 0;
		int size = 75;
		for(int i = 0; i<=25; i++){
			AsteroidenWand a1 = new AsteroidenWand(x, y, size, size, window);
			System.out.println(i+". ("+x+"/"+y+")");
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
