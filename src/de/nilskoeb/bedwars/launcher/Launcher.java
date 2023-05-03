package de.nilskoeb.bedwars.launcher;

import de.nilskoeb.bedwars.BedWars;
import org.bukkit.plugin.java.JavaPlugin;

public class Launcher extends JavaPlugin {

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        new BedWars(this);
    }
}
