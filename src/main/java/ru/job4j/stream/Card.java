package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        Suit[] suitArray = Suit.values();
        Value[] valueArray = Value.values();
        Stream.of(suitArray)
                .flatMap(suit1 -> Stream.of(valueArray)
                        .map(value1 -> new Card(suit1, value1)))
                .forEach(System.out::println);
    }
}