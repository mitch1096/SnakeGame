package controller;

import java.util.ArrayList;

import model.Apple;
import model.Snake;
import processing.core.PApplet;
import processing.core.PVector;
import view.GameStates;

/**
 * Klasse Game Hauptklasse mit Main Methode
 * 
 * @author mitch
 *
 */
public class Game extends PApplet {

	private char direction = 'd';
	private ArrayList<PVector> snakeElements;
	private Snake snake;
	private Apple apple;
	public GameStates gamestates;

	public static void main(String[] args) {
		PApplet.main("controller.Game");
	}

	/**
	 * Setup wiederholt das Bild zehnmal pro Sekunde um es flüssiger darzustellen
	 */
	public void setup() {
		frameRate(10);
	}

	/**
	 * In den Settings wird die Fenstergrösse definiert und das Spiel gestartet
	 */
	public void settings() {
		size(800, 600);
		initGame();

	}

	/**
	 * In der Draw Funktion wird die Hintergrundfarbe gewählt und die Funktion
	 * drawGame ausgeführt
	 */
	public void draw() {
		background(0);
		drawGame();
//		checkGameOver();
	}

	/**
	 * Snake intialisieren und Startposition festlegen, Apfel initialisieren
	 * frameRate definieren
	 */
	public void initGame() {
		snake = new Snake(this, 100, 100);
		snakeElements = new ArrayList<>();
		snakeElements.add(new PVector(100, 100));
		snakeElements.add(new PVector(100, 120));
		snakeElements.add(new PVector(100, 140));

		int randomX = (int) random(0, width / 20) * 20;
		int randomY = (int) random(0, height / 20) * 20;

		apple = new Apple(this, randomX, randomY);

		gamestates = new GameStates(this);
	}

	/**
	 * In drawGame werden die einzelnen Elemente der Schlange gezeichnet und die
	 * moveSnake, draw, checkGameOver Funktionen ausgeführt
	 */
	public void drawGame() {
		for (PVector el : snakeElements) {
			snake.drawSnakeElement(el);

		}
		moveSnake();
		apple.draw();
		checkGameOver();

	}

	/**
	 * Schlangenbewegung wenn sich die Schlange um ein Feld bewegt verschwindet das
	 * hinterste Element und wird wieder vorne hinzugefügt
	 */
	public void moveSnake() {
		PVector lastElement = new PVector(100, 140);
		snakeElements.remove(0);
		PVector firstElement = snakeElements.get(snakeElements.size() - 1);

		// kopiere Koordinaten von ersten Element und bewege

		switch (direction) {
		case 'd':
			lastElement.x = firstElement.x + 20;
			lastElement.y = firstElement.y;
			break;
		case 'a':
			lastElement.x = firstElement.x - 20;
			lastElement.y = firstElement.y;
			break;
		case 'w':
			lastElement.x = firstElement.x;
			lastElement.y = firstElement.y - 20;
			break;
		case 's':
			lastElement.x = firstElement.x;
			lastElement.y = firstElement.y + 20;
			break;
		}
		snakeElements.add(lastElement);
		if (lastElement.x == apple.getX() && lastElement.y == apple.getY()) {

			snakeElements.add(0, new PVector(firstElement.x, firstElement.y));
			apple.generateApple();
		}
	}

	/**
	 * Überprüft ob die Schlange in den Rand fährt oder in sich selbst fährt und
	 * gibt wen das der Fall ist eine Game Over Meldung aus
	 */
	public void checkGameOver() {
		PVector head = snakeElements.get(snakeElements.size() - 1);
		if (head.x < 0 || head.x >= width || head.y < 0 || head.y >= height) {
			gamestates.drawGameOver();
		}
		for (int i = 0; i < snakeElements.size() - 1; i++) {
			PVector el = snakeElements.get(i);
			if (el.x == head.x && el.y == head.y) {
				gamestates.drawGameOver();
			}
		}
	}

	/**
	 * Legt fest das wenn die Schlange beispielsweise nach oben fährt nicht in die
	 * entgegengesetzte Richtung fahren kann da Sie dann über sich selbst fahren
	 * würde und ein Game Over erscheinen würde
	 */
	public void keyPressed() {
		switch (key) {
		case 'w':
			if (direction != 's')
				direction = 'w';
			break;

		case 'a':
			if (direction != 'd')
				direction = 'a';
			break;

		case 's':
			if (direction != 'w')
				direction = 's';
			break;

		case 'd':
			if (direction != 'a')
				direction = 'd';
			break;
		}
	}

	/**
	 * getter für direction
	 * 
	 * @return
	 */
	public char getDirection() {
		return direction;
	}

	/**
	 * setter für direction
	 * 
	 * @param direction
	 */
	public void setDirection(char direction) {
		this.direction = direction;
	}
}
