package org.mineacademy.server.entity;

import org.mineacademy.server.item.ItemStack;

public class Player extends Entity {

	private Armor armor;

	public Player(String name) {
		super(name, 20);

	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public int getExpLevel() {
		return 0;
	}

	public static class Armor {
		private final ItemStack helmet, chestplate, leggins, boots;

		public Armor(ItemStack helmet, ItemStack chestplate, ItemStack leggins, ItemStack boots) {
			this.helmet = helmet;
			this.chestplate = chestplate;
			this.leggins = leggins;
			this.boots = boots;


		}

		public ItemStack getHelmet() {
			return helmet;
		}

		public ItemStack getChestplate() {
			return chestplate;
		}

		public ItemStack getLeggins() {
			return leggins;
		}

		public ItemStack getBoots() {
			return boots;
		}
	}
}
