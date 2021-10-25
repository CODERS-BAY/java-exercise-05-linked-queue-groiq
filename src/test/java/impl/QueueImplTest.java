package impl;

import org.junit.jupiter.api.Test;
import skeleton.Person;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    private static Person boilerplatePerson1 = new Employee("bp1", "x", "x", LocalDate.now(), "x", "x");
    private static Person boilerplatePerson2 = new Employee("bp2d", "x", "x", LocalDate.now(), "x", "x");

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
    void testAddingFirstPerson() {
        // Given
        QueueImpl given = new QueueImpl();

        // When
        given.add(boilerplatePerson1);

        // Then
        int actualSize = given.size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldRetrieveFromSingleNodeQueue() {
        // Given
        QueueImpl given = new QueueImpl();
        given.add(boilerplatePerson1);

        // When
        Person actualPerson = given.retrieve();

        // Then
        Person expectedPerson = boilerplatePerson1;
        assertSame(expectedPerson, actualPerson);
    }

    @Test
    void shouldRetrieveFirstOfTwo() {
        // Given
        QueueImpl given = new QueueImpl();
        given.add(boilerplatePerson1);
        given.add(boilerplatePerson2);

        // When
        Person actualPerson = given.retrieve();

        // Then
        Person expectedPerson = boilerplatePerson1;
        assertSame(expectedPerson, actualPerson);
    }

    @Test
    void shouldDecreaseSizeOnRetrieve() {
        // Given
        QueueImpl given = new QueueImpl();
        given.add(boilerplatePerson1);
        given.add(boilerplatePerson2);

        // When
        given.retrieve();

        // Then
        int expected = 1;
        int actual = given.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRetrieveFirstBeforeSecond() {
        // should retrieve first the first node, then the second

        // Given
        QueueImpl given = new QueueImpl();
        given.add(boilerplatePerson1);
        given.add(boilerplatePerson2);

        // When
        Person actual1 = given.retrieve();

        // Then
        Person expected1 = boilerplatePerson1;
        assertSame(expected1, actual1);

        // When
        Person actual2 = given.retrieve();

        // Then
        Person expected2 = boilerplatePerson2;
        assertSame(expected2, actual2);
    }
    // should retrieve first node, then second node

    // should throw exception on empty queue

    @Test
    void testToString() {
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