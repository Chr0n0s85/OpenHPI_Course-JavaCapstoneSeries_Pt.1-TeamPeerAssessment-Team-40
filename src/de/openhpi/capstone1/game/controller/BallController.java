package de.openhpi.capstone1.game.controller;
import de.openhpi.capstone1.game.model.*;

public class BallController implements Controller {
	Ball ball;
	
	public BallController(Ball ball) {
		this.ball = ball;
	}

	
	public void handleEvent() {
		ball.freefly();	
	}
	
}
