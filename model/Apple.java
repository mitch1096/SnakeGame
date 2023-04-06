package model;

import processing.core.PApplet;

/**
 * Klasse Apple generiert Apfel an zufälliger Position und zeichnet einen Apfel
 * erweitert die abstrakte Klasse Positions und implementiert das Interface Draw
 * 
 * @author mitch
 *
 */
public class Apple extends Positions implements Draw {

	/**
	 * Konstruktor Apple in welchem die Parameter window, xPos und yPos mitgegeben
	 * werden
	 * 
	 * @param window um Apfel im Processing-Fenster darzustellen
	 * @param xPos   um die Position zu ermitteln
	 * @param yPos   um die Position zu ermitteln
	 */
	public Apple(PApplet window, int xPos, int yPos) {
		super(window, xPos, yPos);
	}

	/**
	 * Mit der random Funktion wird eine Zufallsposition für den Apfel generiert
	 */
	public void generateApple() {
		x = (int) window.random(0, window.width / 20) * 20;
		y = (int) window.random(0, window.height / 20) * 20;
	}

	/**
	 * zeichnet einen Apfel
	 */
	public void draw() {
		window.fill(255, 0, 0);
		window.ellipse(x + 10, y + 10, 20, 20);
	}

}
