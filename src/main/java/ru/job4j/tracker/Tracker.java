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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                result[resultSize] = item;
                resultSize++;
            }
        }
        return Arrays.copyOf(result, resultSize);
    }

    public Item findById(int id) {
        Item result = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }
}