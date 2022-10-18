package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest {

    @Test
    public void whenAscSortByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Zatata"));
        items.add(new Item("Ratata"));
        items.add(new Item("Atata"));
        items.add(new Item("Datata"));

        List<Item> expected = new ArrayList<>();
        items.add(new Item("Atata"));
        items.add(new Item("Datata"));
        items.add(new Item("Ratata"));
        items.add(new Item("Zatata"));
        Collections.sort(items, new ItemAscByName());

        assertThat(items.equals(expected));
    }

    @Test
    public void whenDescSortByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Datata"));
        items.add(new Item("Zatata"));
        items.add(new Item("Atata"));
        items.add(new Item("Ratata"));

        List<Item> expected = new ArrayList<>();
        items.add(new Item("Zatata"));
        items.add(new Item("Ratata"));
        items.add(new Item("Datata"));
        items.add(new Item("Atata"));

        Collections.sort(items, new ItemDescByName());

        assertThat(items.equals(expected));
    }
}
