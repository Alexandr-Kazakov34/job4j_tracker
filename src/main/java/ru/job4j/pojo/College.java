package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alexandr");
        student.setSurName("Kazakov");
        student.setPatronymic("Sergeevich");
        student.setGroup(1);
        student.setDateEnter(new Date());

        System.out.println(student.getName());
        System.out.println(student.getSurName());
        System.out.println(student.getPatronymic());
        System.out.println(student.getGroup());
        System.out.println(student.getDateEnter());
    }
}
