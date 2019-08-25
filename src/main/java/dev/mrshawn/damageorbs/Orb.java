package dev.mrshawn.damageorbs;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Orb {

	private DamageOrbs main;
	private ItemStack type;
	private String name;
	private List<String> lore;
	private int level;

	public Orb(int level) {
		this.level = level;
	}
}
