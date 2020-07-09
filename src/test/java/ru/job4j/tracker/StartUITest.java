package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        int id = item.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(id).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        int id = item.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator() + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item 1"));
        Item item2 = tracker.add(new Item("Item 2"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== All Items: ====" + System.lineSeparator()
                        + item1.getId() + ": " + item1.getName() + System.lineSeparator()
                        + item2.getId() + ": " + item2.getName() + System.lineSeparator()
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator() + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item 1"));
        Item item2 = tracker.add(new Item("Item 2"));
        int id = item2.getId();
        String name = item2.getName();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find Item By ID ====" + System.lineSeparator()
                        + id + ": " + name + System.lineSeparator()
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator() + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item 1"));
        Item item2 = tracker.add(new Item("Item 2"));
        int id = item2.getId();
        String name = item2.getName();
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find Item By Name ====" + System.lineSeparator()
                        + id + ": " + name + System.lineSeparator()
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator() + System.lineSeparator()
        ));
    }
}