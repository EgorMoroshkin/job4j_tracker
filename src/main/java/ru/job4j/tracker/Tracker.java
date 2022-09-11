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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] rsl = new Item[items.length];
        for (Item item : items) {
            if (item != null) {
                rsl[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                break;
            } else if (key.equals(items[i].getName())) {
                rsl[count] = items[i];
                count++;
            }

        }
        return Arrays.copyOf(rsl, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            return true;
        }
        return false;
    }
}