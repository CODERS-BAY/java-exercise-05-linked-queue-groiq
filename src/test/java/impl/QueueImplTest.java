package impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
        QueueImpl myQueue = new QueueImpl();

        String output = myQueue.toString();

        assertEquals("Hello world", output);
    }

    @Test
    void retrieve() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }

    @Test
    void testToString() {
    }
}