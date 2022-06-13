package ru.javarush.ogarkov.islandsimulation.factory.herbivore;

import ru.javarush.ogarkov.islandsimulation.factory.Factory;
import ru.javarush.ogarkov.islandsimulation.item.abstracts.Animal;
import ru.javarush.ogarkov.islandsimulation.item.herbivore.Goat;
import ru.javarush.ogarkov.islandsimulation.settings.Items;

public class GoatFactory implements Factory {
    @Override
    public Animal createItem(Items item) {
        return new Goat();
    }
}
