package controller;

import java.util.ArrayList;
import java.awt.Rectangle;

import model.AsteroidenWand;
import model.Gegner;
import model.Projektil;
import model.Raumschiff;
import processing.core.PApplet;

/**
 * Diese Classe stelt das erste Level dar.
 * @author Wendelin
 *
 */
public abstract class LevelViewController extends View{

	private Raumschiff raumschiff;
	private ArrayList<AsteroidenWand> asteroidenListe = new ArrayList<>();
	private ArrayList<Gegner> gegnerListe = new ArrayList<>();
	private boolean levelCompleat = false;
	private boolean gameOver = false;

	@Override
	public abstract void restart(PApplet window);
	@Override
	public abstract void draw(PApplet window);

	public void gameOver(PApplet window) {
		window.fill(100, 0, 1);
		window.textSize(60);
		window.text("GAME OVER", 200,100);
	}

	public void checkCollisions() {

		Rectangle rBounds = raumschiff.getBounds();

		for (AsteroidenWand a : asteroidenListe) {

			Rectangle aBounds = a.getBounds();

			if (rBounds.intersects(aBounds)) {
				setGameOver(true);
			}
		}

		for (Gegner g : gegnerListe) {
			Rectangle gBounds = g.getBounds();

			if(g.isBroken()) {
				gBounds = new Rectangle(-100, -100, 50, 50);
			}

			for (Projektil p : raumschiff.getProjektilListe()) {

				Rectangle pBounds = p.getBounds();

				if (gBounds.intersects(pBounds)) {
					g.setBroken(true);
				}
			}

			if (rBounds.intersects(gBounds)) {
				setGameOver(true);
			}
		}


	}

	/**
	 * @param raumschiff the raumschiff to set
	 */
	public void setRaumschiff(Raumschiff raumschiff) {
		this.raumschiff = raumschiff;
	}

	/**
	 * @return the r
	 */
	public Raumschiff getRaumschiff() {
		return raumschiff;
	}

	/**
	 * @return the asteroidenListe
	 */
	public ArrayList<AsteroidenWand> getAsteroidenListe() {
		return asteroidenListe;
	}

	/**
	 * @param asteroidenListe the asteroidenListe to set
	 */
	public void setAsteroidenListe(ArrayList<AsteroidenWand> asteroidenListe) {
		this.asteroidenListe = asteroidenListe;
	}

	/**
	 * @return the gegnerListe
	 */
	public ArrayList<Gegner> getGegnerListe() {
		return gegnerListe;
	}

	/**
	 * @param gegnerListe the gegnerListe to set
	 */
	public void setGegnerListe(ArrayList<Gegner> gegnerListe) {
		this.gegnerListe = gegnerListe;
	}

	/**
	 * @param levelCompleat the levelCompleat to set
	 */
	public void setLevelCompleat(boolean levelCompleat) {
		this.levelCompleat = levelCompleat;
	}

	/**
	 * @return the levelCompleat
	 */
	public boolean isLevelCompleat() {
		return levelCompleat;
	}
	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	/**
	 * @param gameOver the gameOver to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
