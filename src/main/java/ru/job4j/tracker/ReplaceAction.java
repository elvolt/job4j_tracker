package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter item's id that you want change: ");
        String name = input.askStr("Enter name of new Item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Successfully!");
        } else {
            System.out.println("Error! Program Can't Edit Item");
        }
        return true;
    }
}
