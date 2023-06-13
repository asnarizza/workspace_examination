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

import my.edu.utem.ftmk.dad.examination.model.staff;
import my.edu.utem.ftmk.dad.examination.repository.staffRepository;

@RestController
@RequestMapping("/api/staffs")
public class staffRESTController {

	@Autowired
	private staffRepository StaffRepository;
	
	@GetMapping
	public List<staff> getStaff(){
		return StaffRepository.findAll();
	}
	
	@GetMapping("{StaffId}")
	public staff getStaff(@PathVariable long StaffId) {
		staff Staff = StaffRepository.findById(StaffId).get();
		return Staff;
	}
	
	@PostMapping()
	public staff insertStaff(@RequestBody staff Staff) {
		return StaffRepository.save(Staff);
	}
	
	@PutMapping()
	public staff updateStaff(@RequestBody staff Staff) {
		return StaffRepository.save(Staff);
	}
	
	@DeleteMapping("{StaffId}")
	public ResponseEntity<HttpStatus> deleteStaff(@PathVariable long StaffId){
		StaffRepository.deleteById(StaffId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
