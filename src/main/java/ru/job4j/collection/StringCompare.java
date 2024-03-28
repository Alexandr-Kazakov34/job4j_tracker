package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            char c = left.charAt(i);
            char c1 = right.charAt(i);
            if (c != c1) {
                return Character.compare(c, c1);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}