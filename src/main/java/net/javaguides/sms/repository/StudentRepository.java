package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Student;

public interface StudentRepository<S> extends JpaRepository<Student<S>, Long>{

}
