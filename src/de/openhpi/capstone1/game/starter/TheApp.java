package de.openhpi.capstone1.game.starter;

import processing.core.PApplet;
import de.openhpi.capstone1.game.model.*;
import de.openhpi.capstone1.game.view.*;

public class TheApp extends PApplet {

	private Ball ball;
	private AbstractView BallView;
	
	@Override
	public void settings() {
		size(1000, 1000);
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);
		ball = new Ball();
		BallView = new BallView(this,ball);
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped

	}
	
	//Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		background(205);
	}
}
