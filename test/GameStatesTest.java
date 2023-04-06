package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import processing.core.PApplet;
import view.GameStates;

/**
 * testet die Funktion DrawGameOver der Klasse GameState
 * 
 * @author mitch
 *
 */
public class GameStatesTest {
	private PApplet window;
	private GameStates gameStates;

	@Before
	public void setUp() {
		PApplet window = Mockito.mock(PApplet.class);
		gameStates = new GameStates(window);
	}

	@Test
	public void testDrawGameOver() {
		gameStates.drawGameOver();
		Mockito.verify(window).fill(255);
		Mockito.verify(window).textSize(32);
		Mockito.verify(window).textAlign(window.CENTER);
		Mockito.verify(window).text("GAME OVER", window.width / 2, window.height / 2);
		Mockito.verify(window).stop();
	}
}