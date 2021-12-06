package controller;

import processing.core.PApplet;

/**
 * Dies ist die MainController Classe
 * @author Wendelin
 *
 */
public class MainController  extends PApplet{

	StartViewController startView = new StartViewController();
	Level1 level1View = new Level1();
	Level2 level2View = new Level2();
	EndViewController endView = new EndViewController();

	enum SpielZustand{
		Start, Level1, Level2, SpielEnde;

	}

	SpielZustand state = SpielZustand.Start;

	public static void main(String[] args) {
		//startet das Fenster
		PApplet.main("controller.MainController");
	}

	public void settings() {
		size(800,700);
	}

	@Override
	public void setup() {
		switch (state) {
		case Start: startView.setup(); break;
		case Level1: level1View.setup(); break;
		case Level2: level2View.setup(); break;
		case SpielEnde: endView.setup(); break;
		}
	}

	@Override
	public void draw() {
		switch (state) {
		case Start: startView.draw(this); break;
		case Level1: level1View.draw(this); break;
		case Level2: level2View.draw(this); break;
		case SpielEnde: endView.draw(this); break;
		}
	}

	@Override
	public void keyPressed() {

		switch (state) {
		case Start: keyPressedStart(); break;
		case SpielEnde: keyPressedEnde(); break;
		default: keyPressedInGame(); break;
		}

		System.out.println(state +" "+ key +" "+ str(keyCode));
	}
	
	/**
	 * Das ist die keyPressed am Anfang des Spieles.
	 */
	private void keyPressedStart() {
		if (keyCode == 49) {// KeyCode 49 ist '1'
			state = SpielZustand.Level1;
			level1View.setLevelCompleat(false);
		}
		if (keyCode == 50) {// KeyCode 50 ist '2'
			state = SpielZustand.Level2;
			level2View.setLevelCompleat(false);
		}
	}
	
	/**
	 * Das ist die keyPressed wärent dem Spielen.
	 */
	private void keyPressedInGame() {
		LevelViewController level = null;
		
		switch (state) {
		case Level1: level = level1View; break;
		case Level2: level = level2View; break;
		}
		
		if (level.isLevelCompleat()) {
			if (keyCode == 10) {// KeyCode 10 ist "Enter"
				state = SpielZustand.SpielEnde;
			}
		}else if (keyCode == 32) {// KeyCode 32 ist Lertaste
			level.setLevelCompleat(true);
		}
		
	}
	
	/**
	 * Das ist die keyPressed am Ende des Spieles. 
	 */
	private void keyPressedEnde() {
		if (keyCode == 10) {// KeyCode 10 ist "Enter"
			state = SpielZustand.Start;
		}
	}

}
