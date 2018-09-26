package de.openhpi.capstone1.game.starter;

import processing.core.PApplet;

import de.openhpi.capstone1.game.model.*;
import de.openhpi.capstone1.game.view.*;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<AbstractView> blockView;
	private BlockController blockController;
	
	@Override
	public void settings() {
		size(maxWidth, maxHeight);
	}

	@Override
	public void setup() {  // setup() runs once
		noStroke();
		frameRate(60);
		counter = new Counter();
		counter.setxPos(10);
		counterController = new CounterController(counter);
		counterView = new CounterView(this,counter);
		
		blockView = new ArrayList<AbstractView>();
		for(int i = 0; i < 15; i++)
			for(int j = 0; j < 5; j++)
				blockView.add(new BlockView(this,Block.addBlock(50+60*i, 200+j*30)));

		blockController = new BlockController();
		
		ball = new Ball();
		ball.setmaxHeight(maxHeight);
		ball.setmaxWidth(maxWidth);
		ball.setCounter(counter);
		ballController = new BallController(ball);
		ballView = new BallView(this,ball);
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(205);  // removes existing drawing and produces a plain background 
		ballController.handleEvent();
		counterController.handleEvent();
		blockController.handleEvent();
	}
	
	//Add further user interaction as necessary
	public void keyPressed() {
		if (key != CODED) {return;}

	    if (keyCode == LEFT) {
	    	counterController.moveLeft();
	    } 
	    else if (keyCode == RIGHT) {
	    	counterController.moveRight();
	    } 
	}
	public void keyReleased() {
		if (keyCode == LEFT || keyCode == RIGHT) {
	    	counterController.stop();
	    } 
	}	
}
