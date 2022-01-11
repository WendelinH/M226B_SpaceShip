package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import model.Figur.Direction;
import model.Raumschiff;
import processing.core.PApplet;
import processing.core.PImage;

public class TestRaumschiff {
	
	PApplet window = null;
	Raumschiff r = null;

	@Before
	public void setUp() throws Exception {
		window = Mockito.mock(PApplet.class);
		when(window.loadImage(null)).thenReturn(new PImage());
		window.width = 750;
		window.height = 750;
		/**
		 * speed = 3
		 * x = 20
		 * y = 680
		 * direction = Direction.N
		 * 
		 * width = 50
		 * height = 50
		 */
		r = new Raumschiff(3, 20, 680, Direction.N, window);
	}

	@Test
	public void testConstruktor() {
		assertEquals("Der Speed des Raumschiff soll 3 sein!", 3, r.getSpeed(), 0);
		assertEquals("Die x Position soll 20 sein!", 20, r.getX(), 0);
		assertEquals("Die y Position soll 680 sein!", 680, r.getY(), 0);
		assertEquals("Die direction soll Direction.N sein!", Direction.N, r.getDirection());
		assertEquals("Die width soll 50 sein!", 50, r.getWidth(), 0);
		assertEquals("Die height soll 50 sein!", 50, r.getHeight(), 0);
	}
	
	@Test
	public void testMove() {
		
		int x = r.getX();
		int y = r.getY();
		
		int y1 = 0;
		r.setDirection(Direction.N);
		for (int n = 0;n < 5;n++) {
			r.move(window);
			y1 = y - (n+1) * r.getSpeed();
			if (y1 < 0) {
				y1 = 0;
			}
		}
		assertEquals("Die x Position soll "+x+" sein! nach dem nach oben moven.", x, r.getX(), 0);
		assertEquals("Die y Position soll "+y1+" sein!  nach dem nach oben moven.", y1, r.getY(), 0);
		
		
		int y2 = 0;
		r.setDirection(Direction.S);
		for (int n = 0;n < 5;n++) {
			r.move(window);
			y2 = y1 + (n+1) * r.getSpeed();
			if (y1 > 750) {
				y1 = 750;
			}
		}
		assertEquals("Die x Position soll "+x+" sein!  nach dem nach unten moven", 20, r.getX(), 0);
		assertEquals("Die y Position soll "+y2+" sein! nach dem nach unten moven", y2, r.getY(), 0);

		
		int x1 = 0;
		r.setDirection(Direction.W);
		for (int n = 0;n < 5;n++) {
			r.move(window);
			x1 = x - (n+1) * r.getSpeed();
			if (x1 < 0) {
				x1 = 0;
			}
		}
		assertEquals("Die x Position soll "+x1+" sein!  nach dem nach links moven", x1, r.getX(), 0);
		assertEquals("Die y Position soll "+y2+" sein! nach dem nach links moven", y2, r.getY(), 0);

		
		int x2 = 0;
		r.setDirection(Direction.E);
		for (int n = 0;n < 5;n++) {
			r.move(window);
			x2 = x1 + (n+1) * r.getSpeed();
			if (x2 > 700) {
				x2 = 700;
			}
		}
		assertEquals("Die x Position soll "+x2+" sein!  nach dem nach rechts moven", x2, r.getX(), 0);
		assertEquals("Die y Position soll "+y2+" sein! nach dem nach rechts moven", y2, r.getY(), 0);
	}

}
