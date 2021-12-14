package controller;

import java.util.ArrayList;

import model.AsteroidenWand;
import model.Raumschiff;
import processing.core.PApplet;

/**
 * Diese Classe stelt das erste Level dar.
 * @author Wendelin
 *
 */
public abstract class LevelViewController extends View{
	
	private Raumschiff r;
	private ArrayList<AsteroidenWand> asteroidenListe = new ArrayList<>();
	private boolean levelCompleat = false;

	@Override
	public abstract void restart(PApplet window);
	@Override
	public abstract void draw(PApplet window);

	/**
	 * @param r the r to set
	 */
	public void setR(Raumschiff r) {
		this.r = r;
	}

	/**
	 * @return the r
	 */
	public Raumschiff getR() {
		return r;
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

}
