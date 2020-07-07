package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0 -> {
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
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
                    System.out.print("Enter item's id that you want change: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    System.out.print("Enter name of new Item: ");
                    String name = scanner.nextLine();
                    Item newItem = new Item(name);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Successfully!");
                    } else {
                        System.out.println("Error! Program Can't Edit Item");
                    }
                }
                case 3 -> {
                    System.out.println("=== Delete Item ====");
                    System.out.print("Enter items's id: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("Successfully!");
                    } else {
                        System.out.println("Error. Incorrect ID");
                    }
                }
                case 4 -> {
                    System.out.println("=== Find Item By ID ====");
                    System.out.print("Enter item's id: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    Item item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("No Item With This ID");
                        break;
                    }
                    System.out.println(item.getId() + ": " + item.getName());
                }
                case 5 -> {
                    System.out.println("=== Find Item By Name ====");
                    System.out.print("Enter item's name: ");
                    String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
