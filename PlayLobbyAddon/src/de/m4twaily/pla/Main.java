package de.m4twaily.pla;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.m4twaily.mysql.MySQL;

public class Main extends JavaPlugin {

	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new Events(), this);

		doMySQL();
	}

	public void onDisable() {
		MySQL.disconnect();
	}

	public void doMySQL() {
		try {
			MySQL.connect();

			PreparedStatement ps = MySQL.getConnection()
					.prepareStatement("CREATE TABLE IF NOT EXISTS Points (UUID VARCHAR(100),Value INT(100))");

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
