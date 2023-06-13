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
import my.edu.utem.ftmk.dad.examination.model.subject;

@Controller
public class subjectMenuController {
	
private String defaultURI = "http://localhost:8080/examinationAttendance/api/subjects";
	
	@GetMapping("/subject/list")
	public String getSubject(Model model)
	{
		String uri = "http://localhost:8080/examinationAttendance/api/subjects";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<subject[]>response = restTemplate.getForEntity(uri, subject[].class);
		subject Subject[] = response.getBody();
		List<subject>subjectList = Arrays.asList(Subject);
		model.addAttribute("Subject",subjectList);
		return "subjects";
		
	}
	
	@RequestMapping("Subject/save")
	public String updateSubject (@ModelAttribute subject Subject) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <subject>request = new HttpEntity <subject>(Subject);
		String subjectResponse = "";
		
		if (Subject.getSubjectId()>0) {
			restTemplate.put(defaultURI, request,subject.class);
			
		}else {
			subjectResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(subjectResponse);
		return "redirect:/Subject/list";
	}
	@GetMapping("/Subject/{SubjectId}")
	public String getSubject(@PathVariable Integer SubjectId, Model model) {
		String pageTitle = "New Subject";
		subject Subject = new subject();
		if (SubjectId > 0) {
			String uri = defaultURI + "/" + SubjectId;
			RestTemplate restTemplate = new RestTemplate();
			Subject = restTemplate.getForObject(uri, subject.class);
			pageTitle ="Edit Subject";
			
		}
		model.addAttribute("Subject",Subject);
		model.addAttribute("pageTitle",pageTitle);
		return "subjectinfo";
	}
	
	@RequestMapping("/Subject/delete/{SubjectId}")
	public String deleteSubject(@PathVariable Integer SubjectId) {
		String uri = defaultURI + "/{SubjectId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("SubjectId", Integer.toString(SubjectId)));
		return "redirect:/Subject/list";
	}
	
}

