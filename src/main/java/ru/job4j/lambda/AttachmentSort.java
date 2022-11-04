package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> comparatorName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                for (int i = 0; i < Math.min(o1.getName().length(), o2.getName().length()); i++) {
                    if (o1.getName().charAt(i) != o2.getName().charAt(i)) {
                        return Character.compare(o1.getName().charAt(i), o2.getName().charAt(i));
                    }
                }
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}