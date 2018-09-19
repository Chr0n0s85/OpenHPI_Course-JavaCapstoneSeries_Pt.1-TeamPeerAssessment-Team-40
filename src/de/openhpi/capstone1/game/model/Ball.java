package de.openhpi.capstone1.game.model;

import java.util.ArrayList;
import java.util.List;


import de.openhpi.capstone1.game.view.AbstractView;


public class Ball implements Subject{
	private float rad = 20;
	private float xPos = 50;
	private float yPos = 50;
	private int maxWidth = 100;
	private int maxHeight = 100;
	private double xSpeed = 2.2;
	private double ySpeed = 2.8;
	private int xDirection = 1;
	private int yDirection = 1;
	
	private float[] Pos = {xPos,yPos};
	
	
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
	public void freefly(){
		  xPos = xPos + ( (float)xSpeed * xDirection );
		  yPos = yPos + ( (float)ySpeed * yDirection );
		  
		  // Test to see if the shape exceeds the boundaries of the screen
		  // If it does, reverse its direction by multiplying by -1
		  if (xPos > maxWidth-rad || xPos < rad) {
		    xDirection *= -1;
		  }
		  if (yPos > maxHeight-rad || yPos < rad) {
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
			AbstractView.update(xPos,yPos,rad);
		}
	}
}
