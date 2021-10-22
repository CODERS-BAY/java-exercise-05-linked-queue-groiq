package impl;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testToString() {
        // Given
        Employee given = new Employee("Fritz", "Huber", "fh@company", LocalDate.of(1948, 10, 23), "Accounting", "accountant");

        // When
        String actual = given.toString();

        // Then
        String expected = "Fritz Huber, born 1948-10-23, email: fh@company, accountant in Accounting";
        assertEquals(expected, actual);
    }
}