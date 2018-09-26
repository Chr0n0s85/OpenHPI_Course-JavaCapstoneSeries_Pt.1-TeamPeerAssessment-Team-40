package de.openhpi.capstone1.game.model;

import java.util.ArrayList;
import java.util.List;

import de.openhpi.capstone1.game.view.AbstractView;

public class Block implements Subject {
	final int width = 50;
	final int height = 20;
	int x;
	int y;
	
	private List<AbstractView> AbstractViews = new ArrayList<AbstractView>();
	private static List<Block> Blocks = new ArrayList<Block>();
	
	public static Block addBlock(int x, int y) {
		Block newBlock = new Block(x,y);
		Blocks.add(newBlock);
		return newBlock;
	}
	
	public static void updateAll(){
		for(int i = 0; i < Blocks.size(); i++) {
			Blocks.get(i).notifyAllViews();
		}
	}
	
	public static boolean checkCollisions(int x, int y) {
		boolean isCollided = false;
		for(int i = 0; i < Blocks.size(); i++) {
			isCollided |= Blocks.get(i).checkCollision(x, y);
		}
		return isCollided;
	}
	
	public boolean checkCollision(int x, int y) {
		if(this.x < x & this.y < y & this.x+this.width > x & this.y+height > y) {
			Blocks.remove(this);
			return true;	
		}else{
			return false;
		}
	}
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void attach(AbstractView AbstractView) {
		AbstractViews.add(AbstractView);	
		
	}

	@Override
	public void notifyAllViews() {
		for (AbstractView AbstractView : AbstractViews) {
			AbstractView.update(x, y, width, height);
		}
	}

}
