package ru.job4j.tracker;

public class FindByItemsNameAction implements UserAction {
    private final Output out;

    public FindByItemsNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Item name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
