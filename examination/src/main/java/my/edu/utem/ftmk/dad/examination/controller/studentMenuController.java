package my.edu.utem.ftmk.dad.examination.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.ui.Model;
import my.edu.utem.ftmk.dad.examination.model.student;

@Controller
public class studentMenuController {
	
private String defaultURI = "http://localhost:8080/examinationAttendance/api/students";
	
	@GetMapping("/student/list")
	public String getStudent(Model model)
	{
		String uri = "http://localhost:8080/examinationAttendance/api/students";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<student[]>response = restTemplate.getForEntity(uri, student[].class);
		student studObject[] = response.getBody();
		List<student>studentList = Arrays.asList(studObject);
		model.addAttribute("studObject",studentList);
		return "students";
		
	}
	
	@RequestMapping("student/save")
	public String updateStudent (@ModelAttribute student Student) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <student>request = new HttpEntity <student>(Student);
		String studentResponse = "";
		
		if (Student.getStudentId()>0) {
			restTemplate.put(defaultURI, request,student.class);
			
		}else {
			studentResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(studentResponse);
		return "redirect:/student/list";
	}
	
	@GetMapping("/student/{StudentId}")
	public String getStudent(@PathVariable Integer StudentId, Model model) {
		String pageTitle = "New Student";
		student studObject = new student();
		if (StudentId > 0) {
			String uri = defaultURI + "/" + StudentId;
			RestTemplate restTemplate = new RestTemplate();
			studObject = restTemplate.getForObject(uri, student.class);
			pageTitle ="Edit Student";
			
		}
		model.addAttribute("Student",studObject);
		model.addAttribute("pageTitle",pageTitle);
		return "studentinfo";
	}
	
	@RequestMapping("/student/delete/{StudentId}")
	public String deleteStudent(@PathVariable Integer StudentId) {
		String uri = defaultURI + "/{StudentId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("StudentId", Integer.toString(StudentId)));
		return "redirect:/student/list";
	}
	
	@GetMapping("/Student/list")	
	public ResponseEntity<String> getStudent(){
		
		String uri = "http://localhost:8080/examinationAttendance/api/students";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<student[]> response = restTemplate.getForEntity(uri,student[].class);
		student studArray[] = response.getBody();
		
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Total record:"+ studArray.length + "\n");
		
		for (student Student:studArray) {
			System.out.print(Student.getStudentId() + "-");
			System.out.print(Student.getStudentName() + "-");
			System.out.println(Student.getCourse() + "-");
			System.out.println(Student.getSession() + "-");
			System.out.println(Student.getPhoneNumber() + "-");
			System.out.println(Student.getEmail());
			
		}
		String message = "Check out the message in the console";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}

