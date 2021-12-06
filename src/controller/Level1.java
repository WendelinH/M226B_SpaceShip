package controller;

import processing.core.PApplet;

public class Level1 extends LevelViewController{

	@Override
	public void setup(PApplet window) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PApplet window) {
		// TODO Auto-generated method stub
		window.background(0);
		window.fill(255);
		window.textSize(30);
		window.text("Level 1", 20,30);
	}

}
