package org.mineacademy.server.entity;

public class Skeleton extends Monster {

	private int arrows = 0;

	public Skeleton(String name, int health) {
		super(name, health);
	}

	@Override
	public void damageTarget(int damage) throws Exception {
		shootArrow();

		super.damageTarget(damage);
	}

	private void shootArrow() {
		if (arrows == 0)
			System.out.println("This " + getName() + " has no arrows left!");
		else {
			arrows--;

			System.out.println(getName() + " has shoot an arrow, " + arrows + " left!");
		}
	}

	public int getArrows() {
		return arrows;
	}

	public void setArrows(int arrows) {
		this.arrows = arrows;
	}

	@Override
	public void playAttackSound() {
		System.out.println("Drr!");
	}
}
