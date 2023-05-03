package de.nilskoeb.bedwars;

import de.nilskoeb.bedwars.launcher.Launcher;

public class BedWars {

    private static BedWars instance;

    private final Launcher launcher;

    public BedWars(Launcher launcher) {
        instance = this;
        this.launcher = launcher;
    }

    public static BedWars getInstance() {
        return instance;
    }

    public Launcher getLauncher() {
        return launcher;
    }
}
