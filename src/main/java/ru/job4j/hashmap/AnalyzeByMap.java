package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        int countSubject = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                countSubject++;
            }
        }
        return sumScore / countSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sumScorePupil = 0;
        int countSubject = 0;
        ArrayList<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScorePupil += subject.score();
                countSubject++;
            }
            labels.add(new Label(pupil.name(), sumScorePupil / countSubject));
            sumScorePupil = 0;
            countSubject = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> mapTemp = new LinkedHashMap<>();
        int countSub = 0;
        for (Pupil pupil : pupils) {
            countSub++;
            for (Subject subject : pupil.subjects()) {
                mapTemp.put(subject.name(), mapTemp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        ArrayList<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapTemp.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue() / countSub;
            labels.add(new Label(key, value));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sumScorePupil = 0;
        ArrayList<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScorePupil += subject.score();
            }
            labels.add(new Label(pupil.name(), sumScorePupil));
            sumScorePupil = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> mapTemp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                mapTemp.put(subject.name(), mapTemp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        ArrayList<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapTemp.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            labels.add(new Label(key, value));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
