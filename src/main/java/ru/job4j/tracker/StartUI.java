package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            switch (select) {
                case 0 -> {
                    System.out.println("=== Create a new Item ====");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                }
                case 1 -> {
                    System.out.println("=== All Items: ====");
                    Item[] items = tracker.findAll();
                    if (items.length == 0) {
                        System.out.println("No Items");
                        break;
                    }
                    for (Item item : items) {
                        System.out.println(item.getId() + ": " + item.getName());
                    }
                }
                case 2 -> {
                    System.out.println("=== Edit Item ====");
                    int id = Integer.valueOf(input.askStr("Enter item's id that you want change: "));
                    String name = input.askStr("Enter name of new Item: ");
                    Item newItem = new Item(name);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Successfully!");
                    } else {
                        System.out.println("Error! Program Can't Edit Item");
                    }
                }
                case 3 -> {
                    System.out.println("=== Delete Item ====");
                    int id = Integer.valueOf(input.askStr("Enter items's id: "));
                    if (tracker.delete(id)) {
                        System.out.println("Successfully!");
                    } else {
                        System.out.println("Error. Incorrect ID");
                    }
                }
                case 4 -> {
                    System.out.println("=== Find Item By ID ====");
                    int id = Integer.valueOf(input.askStr("Enter item's id: "));
                    Item item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("No Item With This ID");
                        break;
                    }
                    System.out.println(item.getId() + ": " + item.getName());
                }
                case 5 -> {
                    System.out.println("=== Find Item By Name ====");
                    String name = input.askStr("Enter item's name: ");
                    Item[] items = tracker.findByName(name);
                    if (items.length == 0) {
                        System.out.println("No Items With This Name");
                        break;
                    }
                    for (Item itemByName : items) {
                        System.out.println(itemByName.getId() + ": " + itemByName.getName());
                    }
                }
                case 6 -> run = false;
                default -> {
                    System.out.println("Incorrect Select");
                    run = false;
                }
            }
            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
