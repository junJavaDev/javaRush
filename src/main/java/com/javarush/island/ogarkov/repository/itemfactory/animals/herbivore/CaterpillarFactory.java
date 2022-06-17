package com.javarush.island.ogarkov.repository.itemfactory.animals.herbivore;

import com.javarush.island.ogarkov.entity.animals.herbivore.Caterpillar;
import com.javarush.island.ogarkov.repository.itemfactory.AbstractFactory;
import com.javarush.island.ogarkov.repository.itemfactory.Factory;
import com.javarush.island.ogarkov.settings.Items;

public class CaterpillarFactory extends AbstractFactory {
    @Override
    public Caterpillar createItem() {
        Factory parentFactory = Items.CATERPILLAR.getParent().getFactory();
        created.incrementAndGet();
        parentFactory.addCreatedItem();
        return new Caterpillar();
    }
}
