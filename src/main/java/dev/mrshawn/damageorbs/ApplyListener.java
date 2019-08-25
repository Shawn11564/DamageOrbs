package dev.mrshawn.damageorbs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ApplyListener implements Listener {

	@EventHandler
	public void onApply(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getClickedInventory();

		if (inventory == null || e.getAction() == null) {
			return;
		}
	}

}
