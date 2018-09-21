package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.view.AbstractView;

public interface Subject {
	void attach(AbstractView AbstractView);
	void notifyAllViews();
}