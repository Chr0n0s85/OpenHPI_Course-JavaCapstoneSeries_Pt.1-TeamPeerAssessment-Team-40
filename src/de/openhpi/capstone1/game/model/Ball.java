package de.openhpi.capstone1.game.model;

import java.util.ArrayList;
import java.util.List;


import de.openhpi.capstone1.game.view.AbstractView;


public class Ball implements Subject{
	private float rad = 20;
	private float xPos = 50;
	private float yPos = 50;
	private float maxWidth = 100;
	private float maxHeight = 100;
	private double xSpeed = 4;
	private double ySpeed = 5;
	private int xDirection = 1;
	private int yDirection = 1;
	private Counter counter;
	
	
	private List<AbstractView> AbstractViews = new ArrayList<AbstractView>();
	
	public float getXPos() {
		return xPos;
	}
	public float getYPos() {
		return yPos;
	}
	public float getrad() {
		return rad;
	}
	public void setmaxWidth(int maxW) {
		maxWidth = maxW;
	}
	public void setxSpeed(double xS) {
		xSpeed = xS;
	}
	public void setySpeed(double yS) {
		ySpeed = yS;
	}
	public void setmaxHeight(int maxH) {
		maxHeight = maxH;
	}
	public void setPos(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		notifyAllViews();
	}
	public void setCounter(Counter c) {
		this.counter = c;
	}
	public void freefly(){
		  xPos = xPos + ( (float)xSpeed * (float)xDirection );
		  yPos = yPos + ( (float)ySpeed * (float)yDirection );
		  
		  // Test to see if the shape exceeds the boundaries of the screen
		  // If it does, reverse its direction by multiplying by -1
		  if (xPos > maxWidth-rad || xPos < rad) {
		    xDirection *= -1;
		  }
		  if (yPos < rad) {
		    yDirection *= -1;
		  }		
		  if (yPos > maxHeight-rad) {
			  // game over!!
		  }

		  // hits counter
		  if (yPos+rad >= counter.getyPos() && xPos-rad >= counter.getxPos() && xPos-rad <= counter.getxPos()+counter.getlength()) {
			  yDirection *= -1;
		  }			 
		  notifyAllViews();
	}
	
	@Override
	public void attach(AbstractView AbstractView) {
		AbstractViews.add(AbstractView);	
	}
	
	@Override
	public void notifyAllViews() {
		for (AbstractView AbstractView : AbstractViews) {
			AbstractView.update(xPos,yPos,rad,rad);
		}
	}
}
