package de.nilskoeb.bedwars.listener;

import de.nilskoeb.bedwars.BedWars;
import de.nilskoeb.bedwars.enums.EGameState;
import de.nilskoeb.bedwars.utilities.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (BedWars.getInstance().getGameStateManager().getCurrentState() == EGameState.LOBBY) {
            event.setJoinMessage("§a» §7" + player.getName());

            player.setGameMode(GameMode.SURVIVAL);
            player.setAllowFlight(false);
            player.setLevel(0);
            player.getInventory().clear();
            player.setDisplayName("§7" + player.getName());
            player.setPlayerListName("§7" + player.getName());
            player.setFireTicks(0);
            player.resetMaxHealth();
            player.setHealth(20);

            player.getInventory().setItem(0, new ItemBuilder(Material.BED).displayName("§8• §eTeamauswahl §8» §7Rechtsklick").toItemStack());
        } else
            event.setJoinMessage(null);
    }
}
