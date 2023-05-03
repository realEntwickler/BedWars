package de.nilskoeb.bedwars.commands;

import de.nilskoeb.bedwars.BedWars;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        switch (strings[0]) {
            case "tp":
                player.teleport(BedWars.getInstance().getLocationManager().getLocation("world", "test"));
                break;
            case "set":
                BedWars.getInstance().getLocationManager().saveLocation(player.getLocation(), "test");
                player.playSound(player.getLocation(), Sound.ARROW_HIT, 1, 1);
                break;
        }
        return false;
    }
}
