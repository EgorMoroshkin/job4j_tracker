package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.print(this.name);
        System.out.print(" - ");
        System.out.print(this.food);
        System.out.println();

    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();

    }
}