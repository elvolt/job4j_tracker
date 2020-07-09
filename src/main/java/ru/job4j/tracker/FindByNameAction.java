package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item By Name ====");
        String name = input.askStr("Enter item's name: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            out.println("No Items With This Name");
            return true;
        }
        for (Item itemByName : items) {
            out.println(itemByName.getId() + ": " + itemByName.getName());
        }
        return true;
    }
}
