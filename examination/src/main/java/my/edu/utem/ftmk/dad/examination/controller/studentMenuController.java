package my.edu.utem.ftmk.dad.examination.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
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
		student Student[] = response.getBody();
		List<student>studentList = Arrays.asList(Student);
		model.addAttribute("Student",studentList);
		return "students";
		
	}
	
	@RequestMapping("Student/save")
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
		return "redirect:/Student/list";
	}
	@GetMapping("/Student/{StudentId}")
	public String getStudent(@PathVariable Integer StudentId, Model model) {
		String pageTitle = "New Student";
		student Student = new student();
		if (StudentId > 0) {
			String uri = defaultURI + "/" + StudentId;
			RestTemplate restTemplate = new RestTemplate();
			Student = restTemplate.getForObject(uri, student.class);
			pageTitle ="Edit Student";
			
		}
		model.addAttribute("Student",Student);
		model.addAttribute("pageTitle",pageTitle);
		return "studentinfo";
	}
	
	@RequestMapping("/Student/delete/{StudentId}")
	public String deleteStudent(@PathVariable Integer StudentId) {
		String uri = defaultURI + "/{StudentId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("StudentId", Integer.toString(StudentId)));
		return "redirect:/Student/list";
	}
	
}

