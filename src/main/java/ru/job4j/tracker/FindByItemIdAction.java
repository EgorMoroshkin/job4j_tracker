package ru.job4j.tracker;

public class FindByItemIdAction implements UserAction {
    private final Output out;

    public FindByItemIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Item id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
