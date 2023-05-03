package de.nilskoeb.bedwars.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationManager {

    public boolean saveLocation (Location location, String savename) {
        File file = new File(location.getWorld().getWorldFolder(), savename + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }

        configuration.set("x", location.getX());
        configuration.set("y", location.getY());
        configuration.set("z", location.getZ());
        configuration.set("yaw", location.getYaw());
        configuration.set("pitch", location.getPitch());
        configuration.set("world", location.getWorld().getName());

        try {
            configuration.save(file);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public Location getLocation (String world, String savename) {
        File file = new File(world + "/" + savename + ".yml");

        if (file.exists()) {
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

            double x, y, z;
            float yaw, pitch;

            x = configuration.getDouble("x");
            y = configuration.getDouble("y");
            z = configuration.getDouble("z");

            yaw = configuration.getFloatList("yaw").get(0);
            pitch = configuration.getFloatList("pitch").get(0);

            return new Location(Bukkit.getWorld(configuration.getString("world")), x, y, z, yaw, pitch);
        } else
            return null;
    }
}
