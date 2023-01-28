package org.mineacademy.server.entity;

import java.util.Objects;

public abstract class Monster extends Entity implements Hostile {

	private Entity target;

	public Monster(String name, int health) {
		super(name, health);
	}

	//	@java.lang.Override
	@Override
	public void damageTarget(int damage) throws Exception {
		checkTarget();

		decreaseTargetHealth(damage);
	}

	private void decreaseTargetHealth(int damage) {
		target.setHealth(getHealth() - damage);

		if (target.getHealth() < 0)
			System.out.println(getName() + " killed " + target.getName());
		else
			System.out.println(getName() + " attacked " + target.getName() + ", left " + target.getHealth() + " hp.");
	}

	private void checkTarget() throws Exception {
		Objects.requireNonNull(target, "This " + getName() + " has no target");

		if (target.getHealth() < 0)
			throw new Exception("The target of " + getName() + " is dead already");
	}

	public abstract void playAttackSound();

	//	@java.lang.Override
	@Override
	public Entity getTarget() {
		return target;
	}

	//	@java.lang.Override
	@Override
	public void setTarget(Entity target) {
		this.target = target;
	}
}
