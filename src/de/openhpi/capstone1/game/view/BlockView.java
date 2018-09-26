package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.model.Subject;
import processing.core.PApplet;

public class BlockView extends AbstractView {

	public BlockView(PApplet display, Subject subject) {
		super(display, subject);
		update(10);
	}
	public void update(float a, float b, float c, float d) {
		display.fill(10);
		display.rect(a, b, c, d);
		update();
		
	}

	public void update(Object a) {
		Counter counter = new Counter(); 
		try {
		counter = (Counter)a;
		}
		catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}			
		display.fill(10);
		display.rect(counter.getxPos(), counter.getyPos(), counter.getlength(), counter.getheight());
		this.update();
	}

	public void update() {
		display.redraw();		
	}
}
