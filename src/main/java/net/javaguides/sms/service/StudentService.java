package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Student;

public interface StudentService<E extends Student<S>, S> {
	List<E> getAllStudents();
	
	E saveStudent(E student);
	
	E getStudentById(Long id);
	
	E updateStudent(E student);
	
	void deleteStudentById(Long id);
}
