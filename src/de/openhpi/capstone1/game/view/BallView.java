package de.openhpi.capstone1.game.view;


import de.openhpi.capstone1.game.model.*;
import processing.core.PApplet;

public class BallView extends AbstractView{

		public BallView(PApplet display, Subject subject) {
			super(display, subject);
			update();
		}
		public void update(float x, float y, float ra, float rb) {
			display.fill(10);
			display.ellipse(x, y, ra, rb);
			this.update();
		}
		public void update(Object x) {
			Ball ball = new Ball(); 
			try {
			ball = (Ball)x;
			}
			catch(ClassCastException e) {
				System.out.println(e.getMessage());
			}			
			display.fill(10);
			display.ellipse(ball.getXPos(), ball.getYPos(), ball.getrad(), ball.getrad());
			this.update();
		}
		public void update() {
			display.redraw();
		}
}
