package de.openhpi.capstone1.game.view;


import de.openhpi.capstone1.game.model.*;
import processing.core.PApplet;

public class BallView extends AbstractView{

		public BallView(PApplet display, Subject subject) {
			super(display, subject);
			update();
		}
		public void update() {
			display.fill(10);
			display.ellipse(20, 20, 20, 20);
			display.redraw();
		}
}
