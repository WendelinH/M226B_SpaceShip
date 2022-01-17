package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Figur.Direction;
import model.Projektil;

import static org.mockito.Mockito.when;

import processing.core.PApplet;
import processing.core.PImage;

public class TestProjektil {
	
	PApplet window = null;
	Projektil p = null;

	@Before
	public void setUp() throws Exception {
		window = Mockito.mock(PApplet.class);
		when(window.loadImage(null)).thenReturn(new PImage());
		window.width = 750;
		window.height = 750;
		p = new Projektil(3, 5, 15, 250, 200, Direction.E);
	}

	@Test
	public void testConstruktor() {
		assertEquals("Der Speed des Projektils soll 3 sein!", 3, p.getSpeed(), 0);
		assertEquals("Die x Position soll 250 sein!", 250, p.getX(), 0);
		assertEquals("Die y Position soll 200 sein!", 200, p.getY(), 0);
		assertEquals("Die direction soll Direction.E sein!", Direction.E, p.getDirection());
		assertEquals("Die width soll 5 sein!", 5, p.getWidth(), 0);
		assertEquals("Die height soll 15 sein!", 15, p.getHeight(), 0);
	}

	@Test
	public void testMoveRight() {
		p.setDirection(Direction.E);
		for (int n = 0;n<400;n++) {
			p.move(window);
		}
		assertEquals("Die x Position soll 1450 sein!", 1450, p.getX(), 0);
	}

	@Test
	public void testMoveLeft() {
		p.setDirection(Direction.W);
		for (int n = 0;n<400;n++) {
			p.move(window);
		}
		assertEquals("Die x Position soll -950 sein!", -950, p.getX(), 0);
	}

	@Test
	public void testMoveUp() {
		p.setDirection(Direction.N);
		for (int n = 0;n<400;n++) {
			p.move(window);
		}
		assertEquals("Die y Position soll -1000 sein!", -1000, p.getY(), 0);
	}

	@Test
	public void testMoveDown() {
		p.setDirection(Direction.S);
		for (int n = 0;n<400;n++) {
			p.move(window);
		}
		assertEquals("Die y Position soll 1400 sein!", 1400, p.getY(), 0);
	}

}
