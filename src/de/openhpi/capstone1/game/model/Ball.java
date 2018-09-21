package de.openhpi.capstone1.game.model;

import java.util.ArrayList;
import java.util.List;


import de.openhpi.capstone1.game.view.AbstractView;


public class Ball implements Subject{
	private int xPos = 0;
	private int yPos = 0;
	private int[] Pos = {xPos,yPos};
	
	
	private List<AbstractView> AbstractViews = new ArrayList<AbstractView>();
	
	public int[] getPos() {
		return Pos;
	}
	
	public void setPos(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		notifyAllViews();
	}
	
	@Override
	public void attach(AbstractView AbstractView) {
		AbstractViews.add(AbstractView);	
	}
	
	@Override
	public void notifyAllViews() {
		for (AbstractView AbstractView : AbstractViews) {
			AbstractView.update();
		}
	}
}
