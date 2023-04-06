package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Snake;
import processing.core.PApplet;

/**
 * Klasse SnakeTest überprüft ob der Konstruktor von Snake korrekt arbeitet und
 * die X- und Y-Positionen korrekt zurückgibt
 * 
 * @author mitch
 *
 */
public class SnakeTest {
	Snake sut;

	@Test
	public void testSnakeConstructor() {
		PApplet window = new PApplet();
		int xPos = 10;
		int yPos = 20;
		Snake snake = new Snake(window, xPos, yPos);
		assertEquals(xPos, snake.getX());
		assertEquals(yPos, snake.getY());
	}

	@Test
	public void testGetX() {

		// create a PApplet instance for testing
		PApplet window = new PApplet();

		// create a Snake instance with x = 50
		Snake snake = new Snake(window, 50, 100);

		// check if getX() returns 50
		assertEquals(50, snake.getX());
	}

}
