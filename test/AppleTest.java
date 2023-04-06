package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Apple;
import processing.core.PApplet;

/**
 * Klasse AppleTest überprüft ob die Methode generateApple korrekt arbeitet und
 * eine gültige X- und Y-Position für den Apfel generiert
 * 
 * @author mitch
 *
 */
public class AppleTest {
	@Test
	public void testGenerateApple() {
		PApplet window = new PApplet();
		Apple apple = new Apple(window, 0, 0);
		apple.generateApple();
		assertTrue(apple.getX() >= 0 && apple.getX() < window.width);
		assertTrue(apple.getY() >= 0 && apple.getY() < window.height);
	}
}
