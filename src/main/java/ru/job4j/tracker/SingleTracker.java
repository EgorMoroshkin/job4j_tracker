package ru.job4j.tracker;

public final class SingleTracker {
    private Tracker tracker = new Tracker();

    private static SingleTracker track = null;

    private SingleTracker() {

    }

    public static SingleTracker getTrack() {
        if (track == null) {
            track = new SingleTracker();
        }
        return track;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

}
