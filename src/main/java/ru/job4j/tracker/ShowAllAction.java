package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== All Items: ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("No Items");
            return true;
        }
        for (Item item : items) {
            System.out.println(item.getId() + ": " + item.getName());
        }
        return true;
    }
}
