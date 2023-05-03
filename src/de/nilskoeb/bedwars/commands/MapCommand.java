package de.nilskoeb.bedwars.commands;

import de.nilskoeb.bedwars.utilities.$;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage($.PREFIX + "Benutzung von §c/map");
            commandSender.sendMessage("§8» §c/map add <Name> <Material> <Data>");
            commandSender.sendMessage("§8» §c/map tp <Name>");
            commandSender.sendMessage("§8» §c/map remove <Name>");
        } else if (strings.length == 1) {

        }
        return false;
    }
}
