package org.mineacademy.server;

import org.mineacademy.server.block.Block;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class World {

	private final Map<Location, Block> blocks = new HashMap<>();

	public void add(Location loc, Block block) {
		blocks.put(loc, block);
	}

	public void remove(Block block) {
		blocks.remove(block);
	}

	public void removeBlock(int x, int y, int z) {
		// CAUTION: Concurrency exception, do not remove elements while in loops
		/*for (Map.Entry<Location, Block> entry : blocks.entrySet()) {
			Location loc = entry.getKey();

			if (loc.getX() == x && loc.getY() == y && loc.getZ() == z)
				blocks.remove(loc);
		}*/

		Iterator<Map.Entry<Location, Block>> it = blocks.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Location, Block> entry = it.next();

			Location loc = entry.getKey();

			if (loc.getX() == x && loc.getY() == y && loc.getZ() == z)
				it.remove();
		}
	}

	public Map<Location, Block> getBlocks() {
		return blocks;
	}
}
