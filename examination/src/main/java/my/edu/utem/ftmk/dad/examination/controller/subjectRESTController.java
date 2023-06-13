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

import my.edu.utem.ftmk.dad.examination.model.subject;
import my.edu.utem.ftmk.dad.examination.repository.subjectRepository;

@RestController
@RequestMapping("/api/subjects")
public class subjectRESTController {

	@Autowired
	private subjectRepository SubjectRepository;
	
	@GetMapping
	public List<subject> getSubject(){
		return SubjectRepository.findAll();
	}
	
	@GetMapping("{SubjectId}")
	public subject getSubject(@PathVariable long SubjectId) {
		subject Subject = SubjectRepository.findById(SubjectId).get();
		return Subject;
	}
	
	@PostMapping()
	public subject insertSubject(@RequestBody subject Subject) {
		return SubjectRepository.save(Subject);
	}
	
	@PutMapping()
	public subject updateSubject(@RequestBody subject Subject) {
		return SubjectRepository.save(Subject);
	}
	
	@DeleteMapping("{SubjectId}")
	public ResponseEntity<HttpStatus> deleteSubject(@PathVariable long SubjectId){
		SubjectRepository.deleteById(SubjectId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
