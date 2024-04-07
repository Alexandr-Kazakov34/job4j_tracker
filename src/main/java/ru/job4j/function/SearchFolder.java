package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        List<Folder> result = new ArrayList<>();
        Predicate<Folder> predicate = folder -> folder.getSize() > 100;
        filter(list, predicate);

        return result;
    }

    public static List<Folder> filterName(List<Folder> list) {
        List<Folder> result = new ArrayList<>();
        Predicate<Folder> predicate = folder -> folder.getName().contains("bug");
        filter(list, predicate);

        return result;
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        ArrayList<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (folder.getSize() > 100 || folder.getName().contains("bug")) {
                result.add(folder);
            }
        }
        return result;
    }
}