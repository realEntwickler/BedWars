package de.nilskoeb.bedwars;

import de.nilskoeb.bedwars.commands.MapCommand;
import de.nilskoeb.bedwars.launcher.Launcher;
import de.nilskoeb.bedwars.manager.LocationManager;
import de.nilskoeb.bedwars.manager.MapManager;
import de.nilskoeb.bedwars.manager.TeamManager;

public class BedWars {

    private static BedWars instance;

    private final Launcher launcher;
    private final TeamManager teamManager;
    private final LocationManager locationManager;
    private final MapManager mapManager;

    public BedWars(Launcher launcher) {
        instance = this;

        this.launcher = launcher;
        this.locationManager = new LocationManager();
        this.teamManager = new TeamManager();
        this.mapManager = new MapManager();

        launcher.getCommand("map").setExecutor(new MapCommand());
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public static BedWars getInstance() {
        return instance;
    }

    public Launcher getLauncher() {
        return launcher;
    }
}
