package net.javaguides.sms;

import net.javaguides.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication<S extends Long> implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository<S> studentRepository;
	
	@Override
	public void run(String... args) throws Exception {


		 Student<S> student1 = new Student<>("Ramesh", "Fadatare", "ramesh@gmail.com");
		 studentRepository.save(student1);

		 Student<S> student2 = new Student<>("Sanjay", "Jadhav", "sanjay@gmail.com");
	 		studentRepository.save(student2);

		 Student<S> student3 = new Student<>("tony", "stark", "tony@gmail.com");
		 studentRepository.save(student3);


	}

}
