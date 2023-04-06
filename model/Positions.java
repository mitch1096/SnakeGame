package model;

import processing.core.PApplet;

/**
 * Abstrakte Klasse Positions welche die Positionswerte beinhaltet
 * 
 * @author mitch
 *
 */
public abstract class Positions {

	protected int x;
	protected int y;
	protected PApplet window;

	/**
	 * Konstruktor Positions der die Parameter window, xPos und yPos beinhaltet
	 * 
	 * @param window Processing-Fenster
	 * @param xPos   Position
	 * @param yPos   Position
	 */
	public Positions(PApplet window, int xPos, int yPos) {
		this.window = window;

		x = xPos;
		y = yPos;
	}

	/**
	 * getter für Position
	 * 
	 * @return
	 */

	public int getX() {
		return x;
	}

	/**
	 * getter für Position
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

}
