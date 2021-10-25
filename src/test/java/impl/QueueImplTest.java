package impl;

import org.junit.jupiter.api.Test;
import skeleton.Person;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    private static Person testPerson1 = new Employee("person 1", "x", "x", LocalDate.now(), "x", "x");
    private static Person testPerson2 = new Employee("person 2", "x", "x", LocalDate.now(), "x", "x");

    @Test
    void testSizeOfEmptyQueue() {
        QueueImpl given = new QueueImpl();

        int actual = given.size();

        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testAddingFirstPerson() {
        QueueImpl given = new QueueImpl();

        given.add(testPerson1);

        int actualSize = given.size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldRetrieveFromSingleNodeQueue() {
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);

        Person actualPerson = given.retrieve();

        Person expectedPerson = testPerson1;
        assertSame(expectedPerson, actualPerson);
    }

    @Test
    void shouldRetrieveFirstOfTwo() {
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);

        Person actualPerson = given.retrieve();

        Person expectedPerson = testPerson1;
        assertSame(expectedPerson, actualPerson);
    }

    @Test
    void shouldDecreaseSizeOnRetrieve() {
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);

        given.retrieve();

        int expected = 1;
        int actual = given.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRetrieveFirstBeforeSecond() {
        // should retrieve first the first node, then the second

        // Given
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);

        // When
        Person actual1 = given.retrieve();

        // Then
        Person expected1 = testPerson1;
        assertSame(expected1, actual1);

        // When
        Person actual2 = given.retrieve();

        // Then
        Person expected2 = testPerson2;
        assertSame(expected2, actual2);
    }

    @Test
    void shouldThrowErrorOnRetrievingFromUnfilledQueue() {
        QueueImpl given = new QueueImpl();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            given.retrieve();
        });

        String expectedMessage = "queue is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowErrorOnRetrievingFromEmptiedQueue() {
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);
        given.retrieve();
        given.retrieve();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            given.retrieve();
        });

        String expectedMessage = "queue is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldHandleFillEmptyRefill() {
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);

        given.retrieve();
        given.add(testPerson2);
        Person actual = given.retrieve();

        Person expected = testPerson2;
        assertSame(expected, actual);
    }

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