package ru.job4j.tracker;

public class Item implements Comparable<Item> {
    private int id;
    private String name;

    public Item() {
    }

    public Item(int id) {
        setId(id);
    }

    public Item(String name) {
        setName(name);
    }

    public Item(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.getId());
    }
}