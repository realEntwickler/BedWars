package de.nilskoeb.bedwars;

import de.nilskoeb.bedwars.launcher.Launcher;
import de.nilskoeb.bedwars.manager.LocationManager;
import de.nilskoeb.bedwars.manager.TeamManager;

public class BedWars {

    private static BedWars instance;

    private final Launcher launcher;
    private final TeamManager teamManager;
    private final LocationManager locationManager;

    public BedWars(Launcher launcher) {
        instance = this;

        this.launcher = launcher;
        this.locationManager = new LocationManager();
        this.teamManager = new TeamManager();
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
