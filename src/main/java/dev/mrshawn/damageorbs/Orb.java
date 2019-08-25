package dev.mrshawn.damageorbs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Orb {

	private DamageOrbs main;
	private ItemStack item;
	private List<String> lore;
	private int level;

	public Orb(int level) {
		this.level = level;
		main = DamageOrbs.getInstance();
		item = new ItemStack(Material.valueOf(main.getConfig().getString("orbs.material")));
		ItemMeta meta = item.getItemMeta();
		lore = new ArrayList<>();
		meta.setDisplayName(Utils.colorize(main.getConfig().getString("orbs.name").replace("%level%", String.valueOf(level))));
		for (String s : main.getConfig().getStringList("orbs.lore")) {
			lore.add(Utils.colorize(s).replace("%level%", String.valueOf(level)));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
	}

	public ItemStack getItem() {
		return item;
	}
}
