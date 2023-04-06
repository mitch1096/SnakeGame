package view;

import processing.core.PApplet;

/**
 * Klasse GameStates für die Game Over Funktion
 * 
 * @author mitch
 *
 */
public class GameStates {
	private PApplet window;
	public Object gameOver;

	/**
	 * Konstruktor mit Parameter window
	 * 
	 * @param window
	 */
	public GameStates(PApplet window) {
		this.window = window;
	}

	/**
	 * Graphische Darstellung mit Game Over Meldung
	 */
	public void drawGameOver() {
		window.fill(255);
		window.textSize(32);
		window.textAlign(window.CENTER);
		window.text("GAME OVER", window.width / 2, window.height / 2);
		window.stop();
	}
}
