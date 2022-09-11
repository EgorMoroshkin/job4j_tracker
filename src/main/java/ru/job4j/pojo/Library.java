package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        int temp = 0;
        Book bookOne = new Book("Красная шапочка", 23);
        Book bookTwo = new Book("Колобок", 5);
        Book bookThree = new Book("Волшебник изумрудного города", 99);
        Book bookFour = new Book("Clean code", 777);
        Book[] books = new Book[]{bookOne, bookTwo, bookThree, bookFour};
        Book[] booksTemp = new Book[1];
        for (Book bk : books) {
            System.out.println("Имя:" + bk.getNameBook() + "; количество страниц: " + bk.getCountPage());
        }
        System.out.println();
        booksTemp[0] = books[3];
        books[3] = books[0];
        books[0] = booksTemp[0];
        for (Book bk : books) {
            System.out.println("Имя:" + bk.getNameBook() + "; количество страниц: " + bk.getCountPage());
        }
        System.out.println();
        for (Book bk : books) {
            if ("Clean code".equals(bk.getNameBook())) {
                System.out.println("Имя:" + bk.getNameBook() + "; количество страниц: " + bk.getCountPage());
            }
        }
    }
}
