package ru.job4j.oop;

public class Train extends Transport implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд двигается по рельсам");
    }

    @Override
    public void accelerationSpeed() {
        System.out.println("Самолет разогоняется до 100км/ч за 30 секунд");
    }
}
