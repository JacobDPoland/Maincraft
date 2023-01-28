package org.mineacademy.server.block;

public abstract class Block {

	private final Material material;

	protected Block(Material material) {
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "Block{" +
				"material='" + material + '\'' +
				'}';
	}
}
