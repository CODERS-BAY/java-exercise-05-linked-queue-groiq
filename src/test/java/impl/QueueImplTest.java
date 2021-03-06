package impl;

import org.junit.jupiter.api.Test;
import skeleton.Person;
import skeleton.Queue;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    private static Person testPerson1 = new Employee("person 1", "x", "x", LocalDate.now(), "x", "x");
    private static Person testPerson2 = new Employee("person 2", "x", "x", LocalDate.now(), "x", "x");

    @Test
    void testSizeOfEmptyQueue() {
        Queue given = new QueueImpl();

        int actual = given.size();

        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testAddingFirstPerson() {
        Queue given = new QueueImpl();

        given.add(testPerson1);

        int actualSize = given.size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldRetrieveFromSingleNodeQueue() {
        Queue given = new QueueImpl();
        given.add(testPerson1);

        Person actualPerson = given.retrieve();

        Person expectedPerson = testPerson1;
        assertSame(expectedPerson, actualPerson);
    }

    @Test
    void shouldRetrieveFirstOfTwo() {
        Queue given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);

        Person actualPerson = given.retrieve();

        Person expectedPerson = testPerson1;
        assertSame(expectedPerson, actualPerson);
    }

    @Test
    void shouldDecreaseSizeOnRetrieve() {
        Queue given = new QueueImpl();
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
        Queue given = new QueueImpl();
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
        Queue given = new QueueImpl();

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            given.retrieve();
        });

        String expectedMessage = "queue is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowErrorOnRetrievingFromEmptiedQueue() {
        Queue given = new QueueImpl();
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
        Queue given = new QueueImpl();
        given.add(testPerson1);

        given.retrieve();
        given.add(testPerson2);
        Person actual = given.retrieve();

        Person expected = testPerson2;
        assertSame(expected, actual);
    }

    @Test
    void testClear() {
        Queue given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);

        given.clear();

        assertEquals(0, given.size());
        assertThrows(NoSuchElementException.class, () -> {
            given.retrieve();
        });
    }

    @Test
    void testIterator() {
        QueueImpl given = new QueueImpl();
        given.add(testPerson1);
        given.add(testPerson2);

        Iterator<Person> givenIterator = given.iterator();

        assertTrue(givenIterator.hasNext());
        Person actual = givenIterator.next();
        assertSame(testPerson1, actual);

        assertTrue(givenIterator.hasNext());
        actual = givenIterator.next();
        assertSame(testPerson2, actual);

        assertFalse(givenIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> {
            givenIterator.next();
        });
    }

    @Test
    void testIteratorOnEmpty() {
        QueueImpl given = new QueueImpl();
        Iterator<Person> givenIterator = given.iterator();

        assertFalse(givenIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> {
            givenIterator.next();
        });
    }

    @Test
    void testToString() {
        QueueImpl given = new QueueImpl();

        String actual = given.toString();

        String expected = "empty list";
        assertEquals(expected, actual);

        Person p1 = new Employee("Adam","One", "adam@host", LocalDate.of(1991, 12, 14), "Accounting", "accountant");
        Person p2 = new Employee("Bertie","Two", "bertie@host", LocalDate.of(1978, 11, 24), "Backoffice", "bost obener");
        given.add(p1);
        given.add(p2);

        actual = given.toString();

        expected = "Adam One, born 1991-12-14, email: adam@host, accountant in Accounting -> " +
                "Bertie Two, born 1978-11-24, email: bertie@host, bost obener in Backoffice ";
        assertEquals(expected, actual);
    }
}