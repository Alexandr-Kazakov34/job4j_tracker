package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus drive");
    }

    @Override
    public void passengers(int x) {
        System.out.println("Bus drive " + x + "passengers");
    }

    @Override
    public int fillFuel(int y) {
        int price = 50;
        return y * price;
    }
}
