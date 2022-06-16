package ru.javarush.ogarkov.island.entity;

import javafx.scene.image.Image;
import ru.javarush.ogarkov.island.location.Territory;
import ru.javarush.ogarkov.island.settings.Items;

public abstract class Item {
    public Items getItem() {
        return item;
    }

    protected String name;
    protected final Items item;
    protected final Image icon;
    protected final double weight;
    protected final int maxPerLocation;
    protected Territory territory;

    public Item() {
        item = Items.valueOf(getClass().getSimpleName().toUpperCase());
        icon = item.getIcon();
        weight = item.getWeight();
        maxPerLocation = item.getMaxPerLocation();
    }

    public Item terminated() {
        System.out.println("умирает (от голода или съедено)");
        return Items.LANDFORM.getFactory().createItem();
    }

    public Image getIcon() {
        return icon;
    }

    public double getWeight() {
        return weight;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }
}