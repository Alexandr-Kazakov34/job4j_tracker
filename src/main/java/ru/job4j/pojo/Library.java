package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book[] arrayBoor = new Book[4];
        arrayBoor[0] = book1;
        arrayBoor[1] = book2;
        arrayBoor[2] = book3;
        arrayBoor[3] = book4;
        book1.setName("aaa");
        book2.setName("bbb");
        book3.setName("Clean code");
        book4.setName("ccc");

        for (int i = 0; i < arrayBoor.length; i++) {
            System.out.println(arrayBoor[i].getName() + " " + arrayBoor[i].getCountPage());
        }
        System.out.println("-----------------------");

        Book temp = new Book();
        temp = arrayBoor[0];
        arrayBoor[0] = arrayBoor[2];
        arrayBoor[2] = temp;

        for (int i = 0; i < arrayBoor.length; i++) {
            System.out.println(arrayBoor[i].getName() + " " + arrayBoor[i].getCountPage());
        }
        System.out.println("-----------------------");

        for (int i = 0; i < arrayBoor.length; i++) {
            if (arrayBoor[i].getName().equals("Clean code")) {
                System.out.println(arrayBoor[i].getName() + " " + arrayBoor[i].getCountPage());
            }
        }
    }
}
