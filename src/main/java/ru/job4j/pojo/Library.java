package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("aaa", 0);
        Book book2 = new Book("bbb", 0);
        Book book3 = new Book("Clean code", 0);
        Book book4 = new Book("ccc", 0);
        Book[] arrayBoor = new Book[4];
        arrayBoor[0] = book1;
        arrayBoor[1] = book2;
        arrayBoor[2] = book3;
        arrayBoor[3] = book4;

        for (int i = 0; i < arrayBoor.length; i++) {
            System.out.println(arrayBoor[i].getName() + " " + arrayBoor[i].getCountPage());
        }
        System.out.println("-----------------------");

        Book temp = arrayBoor[0];
        arrayBoor[0] = arrayBoor[2];
        arrayBoor[2] = temp;

        for (int i = 0; i < arrayBoor.length; i++) {
            System.out.println(arrayBoor[i].getName() + " " + arrayBoor[i].getCountPage());
        }
        System.out.println("-----------------------");

        for (int i = 0; i < arrayBoor.length; i++) {
            if ("Clean code".equals(arrayBoor[i].getName())) {
                System.out.println(arrayBoor[i].getName() + " " + arrayBoor[i].getCountPage());
            }
        }
    }
}
