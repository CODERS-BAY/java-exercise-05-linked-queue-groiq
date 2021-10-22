package skeleton;

import impl.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testGetFullName() {
        // Given
        Person given = new Employee("Fritz", "Huber", "dummy@email", LocalDate.now(), "dummy dept", "dummy job");

        // When
        String actual = given.getFullName();

        // Then
        String expected = "Fritz Huber";
        assertEquals(expected, actual);
    }
}