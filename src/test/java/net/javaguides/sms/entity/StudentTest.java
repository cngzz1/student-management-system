package net.javaguides.sms.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testStudentConstructor(){
        Student student = new Student("", "", "");
        assertEquals(Student.class, student.getClass());
    }
    @Test
    void given_setId_then_getId_return_true() {
        Student student = new Student();
        var expected = 0L;
        student.setId(expected);
        var actual = student.getId();
        assertEquals(expected, actual);
    }

    @Test
    void getFirstName() {
        Student student = new Student();
        var expected = "";
        student.setFirstName(expected);
        var actual = student.getFirstName();
        assertEquals(expected, actual);
    }


    @Test
    void getLastName() {
        Student student = new Student();
        var expected = "";
        student.setLastName(expected);
        var actual = student.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        Student student = new Student();
        var expected = "";
        student.setEmail(expected);
        var actual = student.getEmail();
        assertEquals(expected, actual);
    }

}