package my.edu.utem.ftmk.dad.examination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.examination.model.student;
import my.edu.utem.ftmk.dad.examination.repository.studentRepository;

@RestController
@RequestMapping("/api/students")
public class studentRESTController {

	@Autowired
	private studentRepository StudentRepository;
	
	@GetMapping
	public List<student> getStudent(){
		return StudentRepository.findAll();
	}
	
	@GetMapping("{StudentId}")
	public student getStudent(@PathVariable long StudentId) {
		student Student = StudentRepository.findById(StudentId).get();
		return Student;
	}
	
	@PostMapping()
	public student insertStudent(@RequestBody student Student) {
		return StudentRepository.save(Student);
	}
	
	@PutMapping()
	public student updateStudent(@RequestBody student Student) {
		return StudentRepository.save(Student);
	}
	
	@DeleteMapping("{StudentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long StudentId){
		StudentRepository.deleteById(StudentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
