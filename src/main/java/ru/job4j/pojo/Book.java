package ru.job4j.pojo;

public class Book {
    private String nameBook;
    private int countPage;

    public Book(String nameBook, int countPage) {
        this.nameBook = nameBook;
        this.countPage = countPage;

    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public String getNameBook() {
        return nameBook;
    }

    public int getCountPage() {
        return countPage;
    }
}
