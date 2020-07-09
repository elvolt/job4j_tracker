package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find Item By ID ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item By ID ====");
        int id = input.askInt("Enter item's id: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("No Item With This ID");
            return true;
        }
        System.out.println(item.getId() + ": " + item.getName());
        return true;
    }
}
