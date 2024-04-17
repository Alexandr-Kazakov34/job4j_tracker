package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        var priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("low", 5));
        priorityQueue.put(new Task("urgent", 1));
        priorityQueue.put(new Task("middle", 3));
        var resultTask = priorityQueue.take();
        assertThat(resultTask.getDescription()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityEquals() {
        var priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("low", 5));
        priorityQueue.put(new Task("urgent", 5));
        priorityQueue.put(new Task("middle", 5));
        var resultTask = priorityQueue.take();
        assertThat(resultTask.getDescription()).isEqualTo("low");
    }
}