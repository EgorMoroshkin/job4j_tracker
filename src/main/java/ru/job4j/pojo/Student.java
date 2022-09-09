package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fullName;
    private int groupNumber;
    private Date dataHit;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Date getDataHit() {
        return dataHit;
    }

    public void setDataHit(Date datahit) {
        this.dataHit = datahit;
    }
}
