package net.javaguides.sms.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public record StudentController<K extends Long, E extends Model, T extends Student<K>>(StudentService<Student<K>, K> studentService) {
	static final String REDIRECT_STUDENTS = "redirect:/students";

	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public @NotNull String listStudents(@NotNull E model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public @NotNull String createStudentForm(@NotNull E model) {

		// create student object to hold student form data
		Student<Long> student = new Student<>();
		model.addAttribute("student", student);
		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") T student) {
		studentService.saveStudent(student);
		return REDIRECT_STUDENTS;
	}

	@GetMapping("/students/edit/{id}")
	public @NotNull String editStudentForm(@PathVariable K id, @NotNull E model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable K id,
								@ModelAttribute("student") @NotNull T student,
								Model model) {

		// get student from database by id
		Student<K> existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save updated student object
		studentService.updateStudent(existingStudent);
		return REDIRECT_STUDENTS;
	}

	// handler method to handle delete student request

	@GetMapping("/students/{id}")
	public @NotNull String deleteStudent(@PathVariable K id) {
		studentService.deleteStudentById(id);
		return REDIRECT_STUDENTS;
	}

}
