package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private Item[] rsl = new Item[items.length];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        size = 0;
        for (Item item : items) {
            if (item != null) {
                rsl[size] = item;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public Item[] findByName(String key) {
        size = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            } else if (key.equals(item.getName())) {
                rsl[size] = item;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }
}