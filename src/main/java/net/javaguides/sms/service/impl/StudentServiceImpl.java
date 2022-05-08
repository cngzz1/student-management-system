package net.javaguides.sms.service.impl;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Service
public record StudentServiceImpl<S extends Long>(
        StudentRepository<S> studentRepository) implements StudentService<Student<S>, S> {

    @Override
    public List<Student<S>> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public @NotNull Student<S> saveStudent(Student<S> student) {
        return studentRepository.save(student);
    }

    @Override
    public Student<S> getStudentById(Long id) {
        return studentRepository.findById(id).orElseGet(Student::new);
    }

    @Override
    public @NotNull Student<S> updateStudent(Student<S> student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
