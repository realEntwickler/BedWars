package de.nilskoeb.bedwars.commands;

import de.nilskoeb.bedwars.utilities.$;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage($.PREFIX + "Benutzung von §c/map");
            commandSender.sendMessage("§8» §c/map add <Name> <Material> <Data>");
            commandSender.sendMessage("§8» §c/map tp <Name>");
            commandSender.sendMessage("§8» §c/map remove <Name>");
        } else if (strings.length == 2) {
            switch (strings[0]) {
                case "tp":
                    if (!(commandSender instanceof Player)) {
                        commandSender.sendMessage($.PREFIX + "Dieses Kommando kann nur als §eSpieler §7ausgeführt werden.");
                        break;
                    }

                    World world = Bukkit.createWorld(WorldCreator.name(strings[1]));
                    ((Player) commandSender).teleport(world.getSpawnLocation());
                    commandSender.sendMessage($.PREFIX + "Du befindest dich nun auf der Welt §e" + world.getName() + "§7.");
                    break;
                default:
                    commandSender.sendMessage($.PREFIX + "Bitte beachte die §eBenutzung §7dieses Kommandos.");
                    break;
            }
        }
        return false;
    }
}
