package controller;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Rectangle;

import model.AsteroidenWand;
import model.EndPortal;
import model.Gegner;
import model.Projektil;
import model.Raumschiff;
import processing.core.PApplet;

/**
 * Diese Classe stelt das erste Level dar.
 * @author Wendelin
 *
 */
public abstract class LevelViewController extends View implements Subject{

	private Raumschiff raumschiff;
	private EndPortal endPortal;
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
	public void levelCompleat(PApplet window) {
		window.fill(0, 100, 1);
		window.textSize(60);
		window.text("Level Compleat", 200,100);
	}

	public void checkCollisions() {

		Rectangle rBounds = raumschiff.getBounds();
		Rectangle eBounds = endPortal.getBounds();
		
		if (rBounds.intersects(eBounds)) {
			setLevelCompleat(true);
			System.out.println("Level Compleat.!");
		}

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
					notifyAllObserver("Jemand ist KO gegangen.");
				}
			}
			
			for (Projektil p : g.getProjektilListe()) {

				Rectangle pBounds = p.getBounds();

				if (pBounds.intersects(rBounds)) {
					setGameOver(true);
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
	 * @return the endPortal
	 */
	public EndPortal getEndPortal() {
		return endPortal;
	}
	/**
	 * @param endPortal the endPortal to set
	 */
	public void setEndPortal(EndPortal endPortal) {
		this.endPortal = endPortal;
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
	
	/**
	 * Das sind die Funktionen die das Subject braucht.
	 */

	@Override
	public void attach(Observer observer) {
		gegnerListe.add((Gegner) observer);
	}

	@Override
	public void detach(Observer observer) {
		gegnerListe.remove((Gegner) observer);
	}

	@Override
	public void notifyAllObserver(String nachricht) {
		for(Gegner g : gegnerListe) {
			g.update(nachricht);
		}
	}

}
