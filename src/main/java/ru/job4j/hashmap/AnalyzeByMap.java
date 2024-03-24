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
        int countSubject = 0;
        Map<String, Integer> mapTemp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            String name = null;
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                name = subject.name();
                score = subject.score();
                mapTemp.put(name, score);
                countSubject++;
            }
            countSubject = 0;
        }
        ArrayList<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapTemp.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            labels.add(new Label(key, value));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
