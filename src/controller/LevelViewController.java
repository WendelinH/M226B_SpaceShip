package controller;

import model.Raumschiff;
import processing.core.PApplet;

/**
 * Diese Classe stelt das erste Level dar.
 * @author Wendelin
 *
 */
public abstract class LevelViewController extends View{
	
	private Raumschiff r;
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
