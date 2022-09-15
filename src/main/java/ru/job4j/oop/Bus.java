package ru.job4j.oop;

public class Bus extends Transport implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по дорогам");
    }

    @Override
    public void accelerationSpeed() {
        System.out.println("Автобус разогоняется до 100км/ч за 20 секунд");
    }
}
