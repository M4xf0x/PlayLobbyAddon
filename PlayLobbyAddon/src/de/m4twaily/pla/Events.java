package de.m4twaily.pla;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.m4twaily.mysql.Points;

public class Events implements Listener {

	@EventHandler
	public void onClickSponge(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.SPONGE) {
				Player p = e.getPlayer();

				Points.addCoins(p.getUniqueId(), 1);

				Actionbar.sendActionBar(p, "§6§lCoins: §a§l" + Points.getPoints(p.getUniqueId()));

			}
		}
	}
}
