package de.nilskoeb.bedwars.listener;

import de.nilskoeb.bedwars.BedWars;
import de.nilskoeb.bedwars.enums.EGameState;
import de.nilskoeb.bedwars.interfaces.ITeam;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit (PlayerQuitEvent event) {
        Player player = event.getPlayer();
        ITeam team = BedWars.getInstance().getTeamManager().getTeam(player);

        if (BedWars.getInstance().getGameStateManager().getCurrentState() == EGameState.LOBBY) {
            event.setQuitMessage("§c« §7" + player.getName());

            if (team != null)
                team.getPlayers().remove(player);
        }
    }
}
