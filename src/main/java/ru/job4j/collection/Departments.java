package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String department : departments) {
            String[] start = department.split("/");
            StringBuilder stringBuilder = new StringBuilder();
            for (String st : start) {
                temp.add(stringBuilder.append(st).toString());
                stringBuilder.append("/");
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("/");
                String[] split2 = o2.split("/");
                int minLength = Math.min(split1.length, split2.length);

                for (int i = 0; i < minLength; i++) {
                    int comparison = split1[i].compareTo(split2[i]);
                    if (comparison != 0) {
                        return comparison;
                    }
                }
                return split1.length - split2.length;
            }
        });
    }

    public static void sortDesc(List<String> departments) {
        Collections.sort(departments, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("/");
                String[] split2 = o2.split("/");
                int minLength = Math.min(split1.length, split2.length);

                int comparison = split2[0].compareTo(split1[0]);
                if (comparison != 0) {
                    return comparison;
                }
                for (int i = 1; i < minLength; i++) {
                    comparison = split1[i].compareTo(split2[i]);
                    if (comparison != 0) {
                        return comparison;
                    }
                }
                return split1.length - split2.length;
            }
        });
    }
}
