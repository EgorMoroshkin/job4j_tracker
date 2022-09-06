package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error errorExample = new Error();
        Error errorCrtitical = new Error(true, 500, "Сервер не доступен");
        errorExample.printInfo();
        System.out.println();
        errorCrtitical.printInfo();
    }
}
