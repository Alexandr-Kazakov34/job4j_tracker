package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] split = left.split("\\.");
        String[] split2 = right.split("\\.");

        int i = Integer.parseInt(split[0]);
        int i2 = Integer.parseInt(split2[0]);

        return Integer.compare(i, i2);
    }
}