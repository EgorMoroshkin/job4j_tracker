package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. + " + eng;
    }

    public static void main(String[] args) {
        DummyDic jim = new DummyDic();
        String fullPhrase = jim.engToRus("eng");
        System.out.print(fullPhrase);
    }
}
