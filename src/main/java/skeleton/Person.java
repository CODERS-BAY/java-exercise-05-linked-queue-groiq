package skeleton;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Model an abstract person class.
 *
 * @author your name
 *
 */
public abstract class Person {
    private final UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private final LocalDate birthdate;

    protected Person(String firstName, String lastName, String email, LocalDate birthdate) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
    }

    private StringBuilder getFullNameBuilder() {
        return new StringBuilder(firstName)
                .append(" ")
                .append(lastName);
    }

    public String getFullName() {
        return getFullNameBuilder().toString();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return getFullNameBuilder()
                .append("born ")
                .append(birthdate)
                .append(", mail: ")
                .append(email)
                .toString();
    }
}
