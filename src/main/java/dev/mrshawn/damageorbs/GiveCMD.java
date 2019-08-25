package dev.mrshawn.damageorbs;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class GiveCMD implements CommandExecutor {

	String usage = "Usage: /orb <level> [<player>]";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("orbs.give")) {
			if (args.length > 0) {
				if (args.length == 1) {
					if (sender instanceof Player) {
						Player player = (Player) sender;
						if (NumberUtils.isNumber(args[0])) {
							int level = Integer.parseInt(args[0]);
							Orb orb = new Orb(level);
							player.getInventory().addItem(orb.getItem());
							sender.sendMessage(Utils.colorize(DamageOrbs.getInstance().getConfig().getString("give-orb-message")));
						} else {
							sender.sendMessage(usage);
						}
					} else {
						sender.sendMessage("You must be a player to give yourself an orb!");
					}
				} else {
					if (NumberUtils.isNumber(args[0])) {
						int level = Integer.parseInt(args[0]);
						Orb orb = new Orb(level);
						if (Bukkit.getPlayer(args[1]) != null) {
							Player player = Bukkit.getPlayer(args[1]);
							player.getInventory().addItem(orb.getItem());
							sender.sendMessage(Utils.colorize(DamageOrbs.getInstance().getConfig().getString("give-orb-message")));
						} else {
							sender.sendMessage(usage);
						}
					} else {
						sender.sendMessage(usage);
					}
				}
			} else {
				sender.sendMessage(usage);
			}
		} else {
			sender.sendMessage(Utils.colorize("&cYou do not have permission to use this command!"));
		}
		return false;
	}
}
