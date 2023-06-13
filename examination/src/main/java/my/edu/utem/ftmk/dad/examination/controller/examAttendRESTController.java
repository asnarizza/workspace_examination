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

import my.edu.utem.ftmk.dad.examination.model.examination_attendance;
import my.edu.utem.ftmk.dad.examination.repository.examination_attendanceRepository;

@RestController
@RequestMapping("/api/examination_attendance")
public class examAttendRESTController {
	
	@Autowired
	private examination_attendanceRepository Examination_AttendanceRepository;
	
	@GetMapping
	public List<examination_attendance> getSubject(){
		return Examination_AttendanceRepository.findAll();
	}
	
	@GetMapping("{examinationAttendanceId}")
	public examination_attendance getExamination_Attendance(@PathVariable long examinationAttendanceId) {
		examination_attendance Examination_Attendance = Examination_AttendanceRepository.findById(examinationAttendanceId).get();
		return Examination_Attendance;
	}
	
	@PostMapping()
	public examination_attendance insertExamination_Attendance(@RequestBody examination_attendance Examination_Attendance) {
		return Examination_AttendanceRepository.save(Examination_Attendance);
	}
	
	@PutMapping()
	public examination_attendance updateExamination_Attendance(@RequestBody examination_attendance Examination_Attendance) {
		return Examination_AttendanceRepository.save(Examination_Attendance);
	}
	
	@DeleteMapping("{examinationAttendanceId}")
	public ResponseEntity<HttpStatus> deleteExamination_Attendance(@PathVariable long examinationAttendanceId){
		Examination_AttendanceRepository.deleteById(examinationAttendanceId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
