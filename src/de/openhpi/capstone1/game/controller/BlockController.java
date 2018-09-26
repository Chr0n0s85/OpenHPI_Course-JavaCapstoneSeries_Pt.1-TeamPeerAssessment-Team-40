package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Block;

public class BlockController implements Controller {

	@Override
	public void handleEvent() {
		Block.updateAll();
	}

}
