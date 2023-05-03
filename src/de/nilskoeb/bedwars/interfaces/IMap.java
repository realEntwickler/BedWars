package de.nilskoeb.bedwars.interfaces;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IMap {

    private final String name;
    private final Material material;
    private final byte data;

    public IMap(String name, Material material, byte data) {
        this.name = name;
        this.material = material;
        this.data = data;
    }

    public Material getMaterial() {
        return material;
    }

    public byte getData() {
        return data;
    }

    public String getName() {
        return name;
    }
}
