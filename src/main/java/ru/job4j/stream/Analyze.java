package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream())
                .mapToInt(x -> x.score())
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.name(),
                        x.subjects()
                                .stream()
                                .mapToInt(t -> t.score())
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.name(),
                        x.subjects()
                                .stream()
                                .mapToInt(t -> t.score())
                                .sum()))
                .max(new Comparator<Tuple>() {
                    @Override
                    public int compare(Tuple o1, Tuple o2) {
                        return Double.compare(o1.score(), o2.score());
                    }
                })
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(new Comparator<Tuple>() {
                    @Override
                    public int compare(Tuple o1, Tuple o2) {
                        return Double.compare(o1.score(), o2.score());
                    }
                })
                .orElse(null);
    }
}


