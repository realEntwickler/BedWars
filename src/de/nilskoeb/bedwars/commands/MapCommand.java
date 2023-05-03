package de.nilskoeb.bedwars.commands;

import de.nilskoeb.bedwars.BedWars;
import de.nilskoeb.bedwars.interfaces.IMap;
import de.nilskoeb.bedwars.utilities.$;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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
                case "remove":
                    IMap map = BedWars.getInstance().getMapManager().getMaps().stream().filter(filter -> filter.getName().equalsIgnoreCase(strings[1])).findFirst().orElse(null);
                    if (map == null){
                        commandSender.sendMessage($.PREFIX + "Die angegebene Map existiert §cnicht§7.");
                        break;
                    }

                    Bukkit.getOnlinePlayers().stream().filter(filter -> filter.getWorld().getName().equalsIgnoreCase(map.getName())).forEach(all -> Bukkit.getWorld("world").getSpawnLocation());
                    Bukkit.unloadWorld(map.getName(), false);
                    BedWars.getInstance().getMapManager().deleteMap(map);
                    BedWars.getInstance().getMapManager().setupMaps();
                    commandSender.sendMessage($.PREFIX + "Die Map §e" + map.getName() + " §7wurde §aerfolgreich §7gelöscht.");
                    break;
                default:
                    commandSender.sendMessage($.PREFIX + "Bitte beachte die §eBenutzung §7dieses Kommandos.");
                    break;
            }
        } else if (strings.length == 4) {
            if (!strings[0].equalsIgnoreCase("add")) {
                commandSender.sendMessage($.PREFIX + "Bitte beachte die §eBenutzung §7dieses Kommandos.");
                return true;
            }

            if (BedWars.getInstance().getMapManager().getMaps().stream().filter(filter -> filter.getName().equalsIgnoreCase(strings[1])).findFirst().orElse(null) != null) {
                commandSender.sendMessage($.PREFIX + "Die angegebene Map existiert §cbereits§7.");
                return true;
            }
            Material material = Material.getMaterial(strings[2]);

            if (material == null) {
                commandSender.sendMessage($.PREFIX + "Das angegebene Material wurde §cnicht §7gefunden.");
                return true;
            }

            BedWars.getInstance().getMapManager().addMap(strings[1], material, Byte.parseByte(strings[3]));
            BedWars.getInstance().getMapManager().setupMaps();
            commandSender.sendMessage($.PREFIX + "Du hast die Map §e" + strings[1] + " §7erfolgreich angelegt.");
        } else
            commandSender.sendMessage($.PREFIX + "Bitte beachte die §eBenutzung §7dieses Kommandos.");
        return true;
    }
}
