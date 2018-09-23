package de.openhpi.capstone1.game.model;

import java.util.ArrayList;
import java.util.List;

import de.openhpi.capstone1.game.view.AbstractView;


public class Counter implements Subject {

	private int xPos = 0;
	private int yPos = 950;
	private int length = 200;
	private int height = 15;
	private int speed = 10;
	private int direction = 0; // 0 = stop, 1 = right, -1 = left
	
	private List<AbstractView> AbstractViews = new ArrayList<AbstractView>();
	// get Methods
	public int getxPos() {return xPos;}
	public int getyPos() {return yPos;}
	public int getlength() {return length;}
	public int getheight() {return height;}
	public int getspeed() {return speed;}
	public int getdirection() {return direction;}
	// set Methods, only for writable properties
	public void setxPos(int x) {
		this.xPos = x;
		notifyAllViews();
	}
	public void setdirection(int d) {
		this.direction = d;
	} 
	
	@Override
	public void attach(AbstractView abstractView) {
		AbstractViews.add(abstractView);	
	}
	
	@Override
	public void notifyAllViews() {
		for (AbstractView AbstractView : AbstractViews) {
			AbstractView.update(xPos, yPos, length, height);
		}
	}
}

