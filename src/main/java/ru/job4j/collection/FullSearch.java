package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public static Set<String> extractNumber(List<Task> tasks) {
        Set<String> set = new HashSet<>();
        for (Task s : tasks) {
            set.add(s.getNumber());
        }
        return set;
    }
}
