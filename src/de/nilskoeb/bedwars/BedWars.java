package de.nilskoeb.bedwars;

import de.nilskoeb.bedwars.launcher.Launcher;
import de.nilskoeb.bedwars.manager.TeamManager;

public class BedWars {

    private static BedWars instance;

    private final Launcher launcher;
    private final TeamManager teamManager;

    public BedWars(Launcher launcher) {
        instance = this;

        this.launcher = launcher;
        this.teamManager = new TeamManager();

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
