package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.Figur;
import processing.core.PApplet;

/**
 * Dies ist die MainController Classe
 * @author Wendelin
 *
 */
public class MainController extends PApplet{

	private StartViewController startView = new StartViewController();
	private Level1 level1View = new Level1();
	private Level2 level2View = new Level2();
	private EndViewController endView = new EndViewController();

	enum SpielZustand{
		Start, Level1, Level2, SpielEnde;

	}

	SpielZustand state = SpielZustand.Start;

	public static void main(String[] args) {
		//startet das Fenster
		PApplet.main("controller.MainController");
	}

	public void settings() {
		size(750,750);
	}

	@Override
	public void setup() {
		startView.restart(this);
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

	public void mouseClicked() {
		switch (state) {
		case Start: mouseClickedStart(); break;
		case SpielEnde: mouseClickedEnde(); break;
		default: mouseClickedInGame(); break;
		}
	}

	public void mouseClickedStart() {

	}

	public void mouseClickedInGame() {
		LevelViewController level = null;

		switch (state) {
		case Level1: level = level1View; break;
		case Level2: level = level2View; break;
		default: level = null; break;
		}

		level.getRaumschiff().shoot();
	}

	public void mouseClickedEnde() {

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
	public void keyPressedStart() {
		if (keyCode == 49) {// KeyCode 49 ist '1'
			level1View.restart(this);
			state = SpielZustand.Level1;
		}
		if (keyCode == 50) {// KeyCode 50 ist '2'
			level2View.restart(this);
			state = SpielZustand.Level2;
		}
	}

	/**
	 * Das ist die keyPressed wärent dem Spielen.
	 */
	public void keyPressedInGame() {
		LevelViewController level = null;

		switch (state) {
		case Level1: level = level1View; break;
		case Level2: level = level2View; break;
		default:
			level = null;
			break;
		}
		if (!level.isGameOver() && !level.isLevelCompleat()) {
			switch (key) {
			case 'w': level.getRaumschiff().setDirection(Figur.Direction.N); level.getRaumschiff().move(this); break; 
			case 's': level.getRaumschiff().setDirection(Figur.Direction.S); level.getRaumschiff().move(this); break; 
			case 'a': level.getRaumschiff().setDirection(Figur.Direction.W); level.getRaumschiff().move(this); break; 
			case 'd': level.getRaumschiff().setDirection(Figur.Direction.E); level.getRaumschiff().move(this); break;
			}
		}

		if (level.isLevelCompleat() || level.isGameOver()) {
			if (keyCode == 10) {// KeyCode 10 ist "Enter"
				endView.restart(this);
				state = SpielZustand.SpielEnde;
			}
		}

		System.out.println("Kordinaten (" + level.getRaumschiff().getX() + "/" + level.getRaumschiff().getY() + ")");
		System.out.println("ProjektileAnzahl " + level.getRaumschiff().getProjektilListe().size());

	}

	/**
	 * Das ist die keyPressed am Ende des Spieles. 
	 */
	public void keyPressedEnde() {
		if (keyCode == 10) {// KeyCode 10 ist "Enter"
			startView.restart(this);
			state = SpielZustand.Start;
		}
	}

}
