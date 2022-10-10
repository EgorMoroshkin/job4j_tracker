package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> stringMap = new HashMap<>();
        stringMap.put("123@mail.ru", "Moroshkin E V");
        stringMap.put("123@mail.ru", "Moroshkin Egor Vladimirovich");
        stringMap.put("456@mail.ru", "Ivanov Ivan Ivanovich");
        stringMap.put("789@mail.ru", "Petrov Petr Petrovich");

        for (Map.Entry<String, String> str : stringMap.entrySet()) {
            String key = str.getKey();
            String value = str.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
