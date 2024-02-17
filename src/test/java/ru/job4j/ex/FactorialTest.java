package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    public void whenException() {
        Factorial factorial = new Factorial();
        int factorialNumber = -1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(factorialNumber);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenException2() {
        Factorial factorial = new Factorial();
        int factorialNumber = 5;
        int expected = 120;
        int result = factorial.calc(factorialNumber);
        assertThat(result).isEqualTo(expected);
    }
}