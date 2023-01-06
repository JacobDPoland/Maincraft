package org.mineacademy.server;

public class Block {
	private final String name;

	public Block(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Block{" +
				"name='" + name + '\'' +
				'}';
	}
}
