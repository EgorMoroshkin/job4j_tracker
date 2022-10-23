package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        rsl = Integer.compare(left.length(), right.length());
        if (rsl == 0) {
            for (int i = 0; i < left.length(); i++) {
                if (Character.compare(left.charAt(i), right.charAt(i)) > 0) {
                    rsl = 1;
                    break;
                } else if (Character.compare(left.charAt(i), right.charAt(i)) < 0) {
                    rsl = -1;
                    break;
                }
            }
        } else if (rsl != 0) {
            rsl = Character.compare(left.charAt(0), right.charAt(0)) > 0 ? 1 : -1;
        }
        return rsl;
    }
}