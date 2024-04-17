package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var personArrayList = phoneDictionary.find("Petr");
        assertThat(personArrayList.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNotFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var personArrayList = phoneDictionary.find("Zzzz");

        assertThat(personArrayList).isEmpty();
    }
}