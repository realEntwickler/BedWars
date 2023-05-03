package de.nilskoeb.bedwars.manager;

import de.nilskoeb.bedwars.BedWars;
import de.nilskoeb.bedwars.interfaces.IMap;
import de.nilskoeb.bedwars.utilities.$;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapManager {

    private final File dataFolder;
    private final File configFile;
    private final YamlConfiguration yamlConfiguration;
    private ArrayList<IMap> maps;
    private IMap selectedMap;


    @SuppressWarnings("ResultOfMethodCallIgnored")
    public MapManager() {
        this.dataFolder = BedWars.getInstance().getLauncher().getDataFolder();
        this.configFile = new File(dataFolder, "config.yml");
        this.maps = new ArrayList<>();
        this.selectedMap = null;

        if (!dataFolder.exists())
            dataFolder.mkdirs();

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(configFile);

        setupMaps();
    }

    public void setupMaps() {
        maps.clear();
        selectedMap = null;
        List<String> savedMaps = yamlConfiguration.getStringList("maps");

        if (savedMaps != null && savedMaps.size() > 0) {
            savedMaps.forEach(map -> {
                String[] arguments = map.split(":");
                maps.add(new IMap(arguments[0], Material.valueOf(arguments[1]), Byte.parseByte(arguments[2])));
            });
        } else
            System.out.printf($.PREFIX + "Es wurden keine Maps registriert!");
    }

    public void deleteMap (IMap map) {
        List<String> savedMaps = yamlConfiguration.getStringList("maps");
        savedMaps.removeIf(filter -> filter.split(":")[0].equalsIgnoreCase(map.getName()));
        yamlConfiguration.set("maps", savedMaps);
        try {
            yamlConfiguration.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMap (String name, Material material, byte data) {
        List<String> savedMaps = yamlConfiguration.getStringList("maps");
        savedMaps.add(name + ":" + material.toString() + ":" + data);
        yamlConfiguration.set("maps", savedMaps);
        try {
            yamlConfiguration.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public IMap getSelectedMap() {
        return selectedMap;
    }

    public void setMap(IMap selectedMap) {
        this.selectedMap = selectedMap;
    }

    public ArrayList<IMap> getMaps() {
        return maps;
    }
}