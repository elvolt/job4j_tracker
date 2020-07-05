package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item());
        tracker.add(new Item());
        Item itemById = tracker.findById(2);
        System.out.println("Name: " + itemById.getName() + ", id: " + itemById.getId());
    }
}
