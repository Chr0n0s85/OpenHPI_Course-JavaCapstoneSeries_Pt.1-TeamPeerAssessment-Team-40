package de.openhpi.capstone1.game.starter;

import processing.core.PApplet;
import de.openhpi.capstone1.game.model.*;
import de.openhpi.capstone1.game.view.*;
import de.openhpi.capstone1.game.controller.*;

public class TheApp extends PApplet {

	private Ball ball;
	private AbstractView ballView;
	private BallController ballController;
	private int maxWidth = 1000;
	private int maxHeight = 1000;
	
	private Counter counter;
	private AbstractView counterView;
	private CounterController counterController;
	
	@Override
	public void settings() {
		size(maxWidth, maxHeight);
	}

	@Override
	public void setup() {  // setup() runs once
		noStroke();
		frameRate(30);
		counter = new Counter();
		counter.setxPos(10);
		counterController = new CounterController(counter);
		counterView = new CounterView(this,counter);

		ball = new Ball();
		ball.setmaxHeight(maxHeight);
		ball.setmaxWidth(maxWidth);
		ball.setCounter(counter);
		ballController = new BallController(ball);
		ballView = new BallView(this,ball);

	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(205);
		ballController.handleEvent();
		counterController.handleEvent();
	}
	
	//Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		ball.setxSpeed(4);
		ball.setySpeed(5);
	}
	public void keyPressed() {
		if (key != CODED) {return;}

	    if (keyCode == LEFT) {
	    	counterController.moveLeft();
	    } 
	    else if (keyCode == RIGHT) {
	    	counterController.moveRight();
	    } 
	}
}
