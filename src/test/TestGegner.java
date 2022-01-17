package test;

import static org.junit.Assert.*;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import model.Gegner;
import model.Figur.Direction;
import processing.core.PApplet;
import processing.core.PImage;

public class TestGegner {
	
	PApplet window = null;
	Gegner g = null;
	
	@Before
	public void setUp() throws Exception {
		window = Mockito.mock(PApplet.class);
		when(window.loadImage(null)).thenReturn(new PImage());
		window.width = 750;
		window.height = 750;
		g = new Gegner("Ueli", 1, 250, 200, Direction.S, 50, window);
	}

	@Test
	public void testConstruktor() {
		assertEquals("Der Speed des Gegners soll 1 sein!", 1, g.getSpeed(), 0);
		assertEquals("Die x Position soll 250 sein!", 250, g.getX(), 0);
		assertEquals("Die y Position soll 200 sein!", 200, g.getY(), 0);
		assertEquals("Die direction soll Direction.S sein!", Direction.S, g.getDirection());
		assertEquals("Die width soll 50 sein!", 50, g.getWidth(), 0);
		assertEquals("Die height soll 50 sein!", 50, g.getHeight(), 0);
	}
	
	@Test
	public void testMoveDownAndUp() {
		for (int n = 0;n<60;n++) {
			g.move(window);
		}
		assertEquals("Die y Position soll 240 sein!", 240, g.getY(), 0);
		assertEquals("Die direction soll Direction.N sein!", Direction.N, g.getDirection());
	}
	
	@Test
	public void testMoveUp() {
		g.setY(240);
		g.setDirection(Direction.N);
		
		for (int n = 0;n<40;n++) {
			g.move(window);
		}
		assertEquals("Die y Position soll 200 sein!", 200, g.getY(), 0);
		assertEquals("Die direction soll Direction.S sein!", Direction.S, g.getDirection());
	}
	
	@Test
	public void testMoveDownToPoint() {
		for (int n = 0;n<50;n++) {
			g.move(window);
		}

		assertEquals("Die y Position soll 250 sein!", 250, g.getY(), 0);
		assertEquals("Die direction soll Direction.N sein!", Direction.N, g.getDirection());
	}
	
	@Test
	public void testUpdate() {
		int speed = g.getSpeed();
		int topSpeed = speed * 3;
		
		g.update("Jemand ist KO gegangen.");
		
		assertEquals("Der Speed des Gegners soll 3 sein!", topSpeed, g.getSpeed(), 0);
		
		Timer timer = new Timer();
		// nach 10 Sek geht’s los
		timer.schedule  ( new TimerTask(){
			public void run() {
				assertEquals("Der Speed des Gegners soll 1 sein!", speed, g.getSpeed(), 0);
			}
		}, 10000 );
	}
}
