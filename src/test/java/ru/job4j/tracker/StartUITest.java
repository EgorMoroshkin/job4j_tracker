package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = Arrays.asList(new EditAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new ShowAllAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindByItemIdAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find by Item id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find by Item id" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindByItemsNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", one.getName(), "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindByItemsNameAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find by Item name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find by Item name" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenDeleteItemIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new DeleteAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Delete Item" + ln
                        + "1. Exit" + ln
                        + "=== Delete item ===" + ln
                        + "Заявка удалена успешно." + ln
                        + "Menu." + ln
                        + "0. Delete Item" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String newName = "Item name";
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        List<UserAction> actions = Arrays.asList(new CreateAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        List<Item> one = tracker.findByName(newName);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Add new Item" + ln
                        + "1. Exit" + ln
                        + "=== Create a new Item ===" + ln
                        + "Добавленная заявка: " + one.get(0) + ln
                        + "Menu." + ln
                        + "0. Add new Item" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
        );
    }
}