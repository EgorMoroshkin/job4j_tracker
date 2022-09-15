package ru.job4j.oop;

public class Airplane extends Transport implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void accelerationSpeed() {
        System.out.println("Самолет разогоняется до 100км/ч за 10 секунд");
    }
}
