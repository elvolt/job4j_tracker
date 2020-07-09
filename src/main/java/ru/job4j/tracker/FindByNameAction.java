package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item By Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item's name: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("No Items With This Name");
            return true;
        }
        for (Item itemByName : items) {
            System.out.println(itemByName.getId() + ": " + itemByName.getName());
        }
        return true;
    }
}
