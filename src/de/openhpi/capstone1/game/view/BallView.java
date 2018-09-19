package de.openhpi.capstone1.game.view;


import de.openhpi.capstone1.game.model.*;
import processing.core.PApplet;

public class BallView extends AbstractView{

		public BallView(PApplet display, Subject subject) {
			super(display, subject);
			update();
		}
		public void update(float x, float y, float r) {
			display.fill(10);
			display.ellipse(x, y, r, r);
			this.update();
		}
		public void update(Object x) {
			Ball ball = (Ball)x;
			
			display.fill(10);
			display.ellipse(ball.getXPos(), ball.getYPos(), ball.getrad(), ball.getrad());
			this.update();
		}
		public void update() {
			display.redraw();
		}
}
