package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {
    @Test
    void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenMinus23to45then2Dot32() {
        double expected = 6.32;
        Point a = new Point(3, -2);
        Point b = new Point(5, 4);
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenMinus12to26then5() {
        double expected = 5;
        Point a = new Point(2, -1);
        Point b = new Point(6, 2);
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when34to57then3Dot60() {
        double expected = 3.60;
        Point a = new Point(4, 3);
        Point b = new Point(7, 5);
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }
}