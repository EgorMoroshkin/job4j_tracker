package ru.job4j.early;

import java.util.Scanner;

public class PasswordValidator {
    public static String validate(String password) {
        String rls = "Success";
        String[] array = new String[]{"qwerty", "12345", "password", "admin", "user"};
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Пароль не задан");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля должна находится в диапазоне [8, 32]");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в нижнем регистре");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в верхнем регистре");
        }
        for (String arr : array) {
            if (password.toLowerCase().contains(arr)) {
                throw new IllegalArgumentException("Пароль содержит подстроки без учета регистра: qwerty, 12345, password, admin, user.");
            }
        }
        char[] arrayChar = password.toCharArray();
        boolean num = true;
        boolean symbol = true;
        for (char arr : arrayChar) {
            if (Character.isDigit(arr)) {
                num = false;
                break;
            }
        }
        if (num) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну цифру");
        }
        for (int i = 0; i < arrayChar.length; i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                symbol = false;
                break;
            }
        }
        if (symbol) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)");
        }
        return rls;
    }

    public static String input() {
        return new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Введите пароль: ");
        System.out.println(validate(input()));
    }
}