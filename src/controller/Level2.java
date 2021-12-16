package controller;

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
		setRaumschiff(new Raumschiff(10, 3, 100, 100, Direction.N));
		setLevelCompleat(false);
		setGameOver(false);
	}

	@Override
	public void draw(PApplet window) {
		window.background(0);
		window.fill(255);
		window.textSize(30);
		window.text("Level 2", 20,30);
		
		getRaumschiff().draw(window);
		
		if (isGameOver()) {
			gameOver(window);
		}
	}

	

}
