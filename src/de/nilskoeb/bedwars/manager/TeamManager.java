package de.nilskoeb.bedwars.manager;

import de.nilskoeb.bedwars.interfaces.ITeam;
import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeamManager {

    private final ArrayList<ITeam> teams;

    public TeamManager() {
        this.teams = new ArrayList<>();

        teams.add(new ITeam("§cRot", 2, Color.RED));
        teams.add(new ITeam("§9Blau", 2, Color.BLUE));
        teams.add(new ITeam("§eGelb", 2, Color.YELLOW));
        teams.add(new ITeam("§aGrün", 2, Color.GREEN));

        checkForTeamSpawns();
    }

    private void checkForTeamSpawns() {
        //TODO
    }

    public ITeam getTeam (Player player) {
        return teams.stream().filter(filter -> filter.getPlayers().contains(player)).findFirst().orElse(null);
    }

    public ArrayList<ITeam> getTeams() {
        return teams;
    }
}
