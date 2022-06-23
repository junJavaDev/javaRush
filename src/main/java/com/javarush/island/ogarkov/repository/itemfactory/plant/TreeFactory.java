package com.javarush.island.ogarkov.repository.itemfactory.plant;

import com.javarush.island.ogarkov.entity.plant.Tree;
import com.javarush.island.ogarkov.settings.Items;

public class TreeFactory extends PlantFactory {
    @Override
    public Tree createItem() {
        addCreatedItem(Items.TREE);
        return new Tree();
    }
}
