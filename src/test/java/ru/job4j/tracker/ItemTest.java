package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testItemAscendingSort() {
        Item item1 = new Item(1, "item1");
        Item item2 = new Item(3, "item3");
        Item item3 = new Item(2, "item2");
        Item item4 = new Item(5, "item5");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
        expected.add(item2);
        expected.add(item4);
        items.sort(new ItemAscendingSort());
        assertEquals(items, expected);
    }

    @Test
    public void testItemDescendingSort() {
        Item item1 = new Item(1, "item1");
        Item item2 = new Item(3, "item3");
        Item item3 = new Item(2, "item2");
        Item item4 = new Item(5, "item5");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        List<Item> expected = new ArrayList<>();
        expected.add(item4);
        expected.add(item2);
        expected.add(item3);
        expected.add(item1);
        items.sort(new ItemDescendingSort());
        assertEquals(items, expected);
    }
}