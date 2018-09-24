package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.*;

public class CounterController {

	Counter counter;
	
	public CounterController(Counter counter) {
		this.counter = counter;
	}
	
	public void handleEvent() {
		counter.setxPos(counter.getxPos()+counter.getdirection()*counter.getspeed());
	}
	public void moveLeft() {
		counter.setdirection(-1);
	}
	public void moveRight() {
		counter.setdirection(1);
	}
	public void stop() {
		counter.setdirection(0);
	}
}
