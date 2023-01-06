package org.mineacademy.server.entity;

public abstract class Entity {

	private final String name;
	private int health;

	public Entity(String name, int health) {
		this.name = name;
		this.health = health;
	}

	public final String getName() {
		return name;
	}

	public final int getHealth() {
		return health;
	}

	public final void setHealth(int health) {
		this.health = health;
	}

	@Override
	public final boolean equals(Object obj) {
		return obj instanceof Entity && ((Entity) obj).getName().equals(this.getName());
	}

	@Override
	public String toString() {
		return "Entity{" +
				"name='" + name + '\'' +
				", health=" + health +
				'}';
	}
}
