package dev.mrshawn.damageorbs;

import org.bukkit.plugin.java.JavaPlugin;

public final class DamageOrbs extends JavaPlugin {

	private static DamageOrbs instance;

	@Override
	public void onEnable() {
		instance = this;
		getCommand("orb").setExecutor(new GiveCMD());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static DamageOrbs getInstance() {
		return instance;
	}
}
