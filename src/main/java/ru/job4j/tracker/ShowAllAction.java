package ru.job4j.tracker;

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
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            out.println("No Items");
            return true;
        }
        for (Item item : items) {
            out.println(item.getId() + ": " + item.getName());
        }
        return true;
    }
}
