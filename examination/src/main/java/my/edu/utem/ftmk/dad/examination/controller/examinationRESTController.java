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

import my.edu.utem.ftmk.dad.examination.model.examination;
import my.edu.utem.ftmk.dad.examination.repository.examinationRepository;

@RestController
@RequestMapping("/api/examinations")
public class examinationRESTController {

	@Autowired
	private examinationRepository examinationRepository;
	
	@GetMapping
	public List<examination> getExamination(){
		return examinationRepository.findAll();
	}
	
	@GetMapping("{examinationId}")
	public examination getExamination(@PathVariable long examinationId) {
		examination Examination = examinationRepository.findById(examinationId).get();
		return Examination;
	}
	
	@PostMapping()
	public examination insertExamination(@RequestBody examination Examination) {
		return examinationRepository.save(Examination);
	}
	
	@PutMapping()
	public examination updateExamination(@RequestBody examination Examination) {
		return examinationRepository.save(Examination);
	}
	
	@DeleteMapping("{examinationId}")
	public ResponseEntity<HttpStatus> deleteExamination(@PathVariable long examinationId){
		examinationRepository.deleteById(examinationId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
