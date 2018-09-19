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
	
	@Override
	public void settings() {
		size(maxWidth, maxHeight);
	}

	@Override
	public void setup() {  // setup() runs once
		noStroke();
		frameRate(30);
		ball = new Ball();
		ball.setmaxHeight(maxHeight);
		ball.setmaxWidth(maxWidth);
		ballController = new BallController(ball);
		ballView = new BallView(this,ball);

	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(205);
		ballController.handleEvent();
	}
	
	//Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		ball.setxSpeed(4);
		ball.setySpeed(5);
		//ballController.handleEvent();
	}
}
