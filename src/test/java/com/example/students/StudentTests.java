package com.example.students;

import com.example.students.data.Student;
import com.example.students.data.StudentUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {

    @Test
    public void phoneNumberShouldBeValid() {
        Student student = new Student("John Doe", StudentUnit.GDANSK, 123L, "john.doe@example.com", "123456789");
        String phoneNumber = student.getPhoneNumber();
        assertNotNull(phoneNumber);
        assertEquals("123456789", phoneNumber);
    }

    @Test
    public void emailShouldBeValid() {
        Student student = new Student("Jane Doe", StudentUnit.GDANSK, 456L, "jane.doe@example.com", "987654321");

        String email = student.getEmail();
        assertNotNull(email);
        assertEquals("jane.doe@example.com", email);
    }

    @Test
    public void phoneNumberShouldBeNullIfNotProvided() {
        Student student = new Student("Alice Doe", StudentUnit.GDANSK, 789L, null, null);

        String phoneNumber = student.getPhoneNumber();
        assertNull(phoneNumber);
    }

    @Test
    public void emailShouldBeNullIfNotProvided() {
        Student student = new Student("Bob Doe", StudentUnit.GDANSK, 101L, null, null);

        String email = student.getEmail();

        assertNull(email);
    }
}
