package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import processing.core.PApplet;
import processing.core.PVector;
import view.GameStates;
import controller.Game;

public class GameTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}

	/**
	 * Die Schlange fährt in die Wand
	 */
	@Test
	public void testCheckGameOverWhenSnakeHitsWall() {

		game.getSnakeElements().clear();
		game.getSnakeElements().add(new PVector(780, 100));
		game.setDirection('d');

		game.checkGameOver();

		assertTrue(game.gamestates.gameOver);
	}

	/**
	 * Die Schlange trifft sich selbst
	 */
	@Test
	public void testCheckGameOverWhenSnakeHitsItself() {

		ArrayList<PVector> snakeElements = new ArrayList<>();
		snakeElements.add(new PVector(100, 100));
		snakeElements.add(new PVector(100, 120));
		snakeElements.add(new PVector(100, 140));
		snakeElements.add(new PVector(80, 140)); // add extra element to make the snake hit itself
		game.setSnakeElements(snakeElements);
		game.setDirection('d');

		game.checkGameOver();

		assertTrue(game.gamestates.gameOver);
	}
}