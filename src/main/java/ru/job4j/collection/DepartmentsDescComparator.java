package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] split1 = left.split("/");
        String[] split2 = right.split("/");
        int minLength = Math.min(split1.length, split2.length);

        int comparison = split1[0].compareTo(split2[0]);
        if (comparison != 0) {
            return right.compareTo(left);
        }
        for (int i = 1; i < minLength; i++) {
            int comparison2 = split1[i].compareTo(split2[i]);
            if (comparison2 != 0) {
                return comparison2;
            }
        }
        return split1.length - split2.length;
    }
}