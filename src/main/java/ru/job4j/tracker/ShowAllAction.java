package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== All Items: ====");
        ArrayList<Item> items = tracker.findAll();
        if (items.isEmpty()) {
            out.println("No Items");
            return true;
        }
        for (Item item : items) {
            out.println(item.getId() + ": " + item.getName());
        }
        return true;
    }
}
