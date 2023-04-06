package model;

import processing.core.*;

/**
 * Darstellung Schlange Positionsabspeicherung und Richtungsänderung,
 * Movefunktion
 * 
 * @author mitch
 *
 */
public class Snake extends Positions implements Draw {

	private int x;
	private int y;
	private PApplet window;
	private PVector element;

	/**
	 * Konstruktor für Snake mit den Parametern window, xPos und yPos
	 */

	public Snake(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos);
		this.window = window;

		x = xPos;
		y = yPos;

	}

	/**
	 * zeichnen von einzelnen Snake-Elementen mit grüner Farbe und Vektor
	 * 
	 * @param element
	 */

	public void drawSnakeElement(PVector element) {

		window.fill(0, 255, 0);
		window.rect(element.x, element.y, 20, 20);

	}

	/**
	 * getter gibt den Wert x zurück
	 */
	public int getX() {
		return x;
	}

	/**
	 * getter gibt den Wert y zurück
	 */
	public int getY() {
		return y;
	}

	/**
	 * draw Funktion vom Interface draw
	 */
	@Override
	public void draw() {
//		element = new PVector();
//		window.fill(0, 255, 0);
//		window.rect(element.x, element.y, 20, 20);
	}

}
