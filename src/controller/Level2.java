package controller;

import model.Raumschiff;
import model.Figur.Direction;
import processing.core.PApplet;

public class Level2 extends LevelViewController{

	/**
	 * 
	 */
	public Level2() {
		super();
	}
	
	@Override
	public void restart(PApplet window) {
		r = new Raumschiff(10, 3, 100, 100, Direction.N);
	}

	@Override
	public void draw(PApplet window) {
		// TODO Auto-generated method stub
		window.background(0);
		window.fill(255);
		window.textSize(30);
		window.text("Level 2", 20,30);
		
		r.draw(window);
	}

	

}
