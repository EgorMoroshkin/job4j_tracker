package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String answerQuestion = scr.nextLine();
        String answerClient = "";
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                answerClient = "Да";
                break;
            case 1:
                answerClient = "Нет";
                break;
            default:
                answerClient = "Может быть";
                break;
        }
        System.out.println(answerClient);
    }
}
