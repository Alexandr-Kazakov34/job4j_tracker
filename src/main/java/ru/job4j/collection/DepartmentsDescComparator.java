package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] split1 = left.split("/");
        String[] split2 = right.split("/");

        int comparison = split2[0].compareTo(split1[0]);
        return comparison != 0 ? comparison : left.compareTo(right);
    }
}