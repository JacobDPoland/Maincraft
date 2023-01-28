package org.mineacademy.server.entity;

public class Zombie extends Monster {

	public Zombie(String name, int health) {
		super(name, health);
	}

	@Override
	public void playAttackSound() {
		System.out.println("Urrrr!");
	}
}
