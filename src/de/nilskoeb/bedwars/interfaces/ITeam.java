package de.nilskoeb.bedwars.interfaces;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ITeam {


    private final String displayname;
    private final int maxPlayers;
    private final Color teamColor;
    private Location teamSpawn;
    private ArrayList<Player> players;

    public ITeam(String displayname, int maxPlayers, Color teamColor) {
        this.displayname = displayname;
        this.maxPlayers = maxPlayers;
        this.teamColor = teamColor;
    }

    public void setTeamSpawn(Location teamSpawn) {
        this.teamSpawn = teamSpawn;
    }

    public String getDisplayname() {
        return displayname;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public Color getTeamColor() {
        return teamColor;
    }

    public Location getTeamSpawn() {
        return teamSpawn;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
