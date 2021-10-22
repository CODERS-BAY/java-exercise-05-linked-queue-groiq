package impl;

import org.junit.jupiter.api.Test;
import skeleton.Person;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    private static Person boilerplatePerson1 = new Employee("x", "x", "x", LocalDate.now(), "x", "x");

    @Test
    void testSizeOfEmptyQueue() {
        // Given
        QueueImpl given = new QueueImpl();

        // When
        int actual = given.size();

        // Then
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testAddingIncreasesSize() {
        // Given
        QueueImpl given = new QueueImpl();

        // When
        given.add(boilerplatePerson1);

        // Then
//        int actual =
    }

    @Test
    void testToString() {
    }

    @Test
    void testRetrieve() {
    }

    @Test
    void testClear() {
    }

    @Test
    void testIterator() {
    }

    @Test
    void testToString1() {
    }
}