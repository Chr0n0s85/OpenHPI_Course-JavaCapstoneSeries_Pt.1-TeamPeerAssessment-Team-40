package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Subject;

import processing.core.PApplet;

public abstract class AbstractView {
	protected PApplet display;
	
	public AbstractView(PApplet display, Subject subject) {
		this.display = display;
		subject.attach(this);
	}
	public abstract void update(float a, float b, float c, float d);
	public abstract void update(Object x);
	public abstract void update();
}
