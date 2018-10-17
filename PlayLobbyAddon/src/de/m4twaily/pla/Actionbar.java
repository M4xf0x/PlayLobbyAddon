package de.m4twaily.pla;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Actionbar {

	public static void sendActionBar(Player p, String msg) {

		PacketPlayOutChat pc = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer
				.a("{'text': '" + ChatColor.translateAlternateColorCodes('&', msg) + "'}"), (byte) 2);

		((CraftPlayer) p).getHandle().playerConnection.sendPacket(pc);

	}

}
