package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Морошкин Егор Владимирович");
        student.setGroupNumber(3547);
        student.setDataHit(new Date(1659818510000L));
        System.out.println("Student - " + student.getFullName() + "\n" + "Группа - " + student.getGroupNumber()
                + "\n" + "Дата поступления - " + student.getDataHit());
    }
}
