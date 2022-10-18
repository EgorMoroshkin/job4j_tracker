package ru.job4j.map;

import java.lang.reflect.Array;
import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pup : pupils) {
            for (Subject sub : pup.subjects()) {
                sum += sub.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        List<Label> label = new ArrayList<>();
        for (Pupil pup : pupils) {
            for (Subject sub : pup.subjects()) {
                sum += sub.score();
                count++;
            }
            label.add(new Label(pup.name(), sum / count));
            sum = 0;
            count = 0;
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pup : pupils) {
            for (Subject sub : pup.subjects()) {
                int temp = map.getOrDefault(sub.name(), 0);
                map.put(sub.name(), sub.score() + temp);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            label.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        List<Label> label = new ArrayList<>();
        for (Pupil pup : pupils) {
            count++;
            for (Subject sub : pup.subjects()) {
                sum += sub.score();
            }
            label.add(new Label(pup.name(), sum));
            sum = 0;
        }
        label.sort(Comparator.naturalOrder());
        return label.get(count - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        int count = 0;
        List<Label> label = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pup : pupils) {
            count++;
            for (Subject sub : pup.subjects()) {
                int temp = map.getOrDefault(sub.name(), 0);
                map.put(sub.name(), sub.score() + temp);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            label.add(new Label(entry.getKey(), entry.getValue()));
        }
        label.sort(Comparator.naturalOrder());
        return label.get(count - 1);
    }
}
