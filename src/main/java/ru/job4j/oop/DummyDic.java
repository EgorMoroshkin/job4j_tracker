package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng){
        String phrase = "Неизвестное слово. + ";
        return phrase + eng;
    }

    public static void main(String[] args) {
        DummyDic jim = new DummyDic();
        String fullPhrase = jim.engToRus("eng");
        System.out.println(fullPhrase);
    }
}
