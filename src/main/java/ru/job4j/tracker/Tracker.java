package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids);
        ids++;
        items[size] = item;
        size++;
        return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int resultCurrentIndex = 0;
        for (Item elem : items) {
            if (elem != null) {
                result[resultCurrentIndex] = elem;
                resultCurrentIndex++;
            }
        }
        return Arrays.copyOf(result, resultCurrentIndex);
    }

    public Item[] findByName(String key) {
        Item[] list = new Item[size];
        int listCurrentIndex = 0;
        for (Item elem : items) {
            if (elem.getName().equals(key)) {
                list[listCurrentIndex] = elem;
                listCurrentIndex++;
            }
        }
        return Arrays.copyOf(list, listCurrentIndex);
    }

    public Item findById(int id) {
        Item result = null;
        for (Item elem : items) {
            if (elem.getId() == id) {
                result = elem;
                break;
            }
        }
        return result;
    }
}