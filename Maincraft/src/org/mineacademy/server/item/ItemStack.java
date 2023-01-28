package org.mineacademy.server.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStack {

	private String name;
	private int amount;
	private int damage;
	private List<String> enchants;

	public ItemStack(String name) {
		this(name, 1);
	}

	public ItemStack(String name, int amount) {
		this(name, amount, 0);
	}

	public ItemStack(String name, int amount, int damage) {
		this(name, amount, damage, new ArrayList<>());
	}

	public ItemStack(String name, int amount, int damage, List<String> enchants) {
		this.name = name;
		this.amount = amount;
		this.damage = damage;
		this.enchants = enchants;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public List<String> getEnchants() {
		return enchants;
	}

	public void setEnchants(List<String> enchants) {
		this.enchants = enchants;
	}

	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<>();

		map.put("Name", name);
		map.put("Amount", amount);
		map.put("Damage", damage);
		map.put("Enchants", enchants);

		return map;
	}

	public static ItemStack deserialize(Map<String, Object> map) {
		String name = (String) map.get("Name");
		int amount = (int) map.get("Amount");
		int damage = (int) map.get("Damage");
		List<String> enchants = (List<String>) map.get("Enchants");

		return new ItemStack(name, amount, damage, enchants);
	}

	@Override
	public String toString() {
		return "ItemStack{" +
				"name='" + name + '\'' +
				", amount=" + amount +
				", damage=" + damage +
				", enchants=" + enchants +
				'}';
	}
}
