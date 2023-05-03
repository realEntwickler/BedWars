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

    private ArrayList<IMap> maps;
    private IMap selectedMap;

    public MapManager() {
        this.maps = new ArrayList<>();
        this.selectedMap = null;

        setupMaps();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void setupMaps() {
        maps.clear();
        selectedMap = null;

        File dataFolder = BedWars.getInstance().getLauncher().getDataFolder();
        File configFile = new File(dataFolder, "config.yml");
        if (!dataFolder.exists())
            dataFolder.mkdirs();

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(configFile);
        List<String> savedMaps = yamlConfiguration.getStringList("maps");

        if (savedMaps != null && savedMaps.size() > 0) {
            savedMaps.forEach(map -> {
                String[] arguments = map.split(":");
                maps.add(new IMap(arguments[0], Material.valueOf(arguments[1]), Byte.parseByte(arguments[2])));
            });
        } else
            System.out.printf($.PREFIX + "Es wurden keine Maps registriert!");
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
