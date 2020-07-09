package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        int id = input.askInt("Enter item's id that you want change: ");
        String name = input.askStr("Enter name of new Item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("Successfully!");
        } else {
            out.println("Error! Program Can't Edit Item");
        }
        return true;
    }
}
