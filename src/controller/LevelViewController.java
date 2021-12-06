package controller;

import model.Raumschiff;
import processing.core.PApplet;

/**
 * Diese Classe stelt das erste Level dar.
 * @author Wendelin
 *
 */
public abstract class LevelViewController implements ViewInterface{
	
	public Raumschiff r;
	private boolean levelCompleat = false;

	@Override
	public abstract void draw(PApplet window);

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
