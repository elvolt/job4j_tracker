package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {String.valueOf(id), "replaced item"};
        Input input = new StubInput(answers);
        StartUI.replaceItem(input, tracker);
        Item edited = tracker.findById(id);
        assertThat(edited.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {String.valueOf(id)};
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}