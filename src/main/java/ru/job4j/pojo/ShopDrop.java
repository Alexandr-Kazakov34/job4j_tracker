package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        Product[] result = new Product[products.length];
        int count = 0;
        for (int i = 0; i < products.length; i++) {
            if (i != index) {
                result[i - count] = products[i];
            } else {
                count++;
            }
        }
        return result;
    }
}