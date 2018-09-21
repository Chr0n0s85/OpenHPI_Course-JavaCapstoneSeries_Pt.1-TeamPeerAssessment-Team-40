package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Subject;

import processing.core.PApplet;

public abstract class AbstractView {
	protected PApplet display;
	
	public AbstractView(PApplet display, Subject subject) {
		this.display = display;
		subject.attach(this);
	}

	public abstract void update();
}
