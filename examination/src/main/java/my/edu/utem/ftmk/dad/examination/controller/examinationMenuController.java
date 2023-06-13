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
import my.edu.utem.ftmk.dad.examination.model.examination;

@Controller
public class examinationMenuController {
	
private String defaultURI = "http://localhost:8080/examinationAttendance/api/examinations";
	
	@GetMapping("/examination/list")
	public String getExamination(Model model)
	{
		String uri = "http://localhost:8080/examinationAttendance/api/examinations";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<examination[]>response = restTemplate.getForEntity(uri, examination[].class);
		examination Examination[] = response.getBody();
		List<examination>examinationList = Arrays.asList(Examination);
		model.addAttribute("Examination",examinationList);
		return "examination";
		
	}
	
	@RequestMapping("Examination/save")
	public String updateExamination (@ModelAttribute examination Examination) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <examination>request = new HttpEntity <examination>(Examination);
		String examinationResponse = "";
		
		if (Examination.getExaminationId()>0) {
			restTemplate.put(defaultURI, request,examination.class);
			
		}else {
			examinationResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(examinationResponse);
		return "redirect:/Examination/list";
	}
	@GetMapping("/examination/{examinationId}")
	public String getExamination(@PathVariable Integer examinationId, Model model) {
		String pageTitle = "New Examination";
		examination Examination = new examination();
		if (examinationId > 0) {
			String uri = defaultURI + "/" + examinationId;
			RestTemplate restTemplate = new RestTemplate();
			Examination = restTemplate.getForObject(uri, examination.class);
			pageTitle ="Edit Examination";
			
		}
		model.addAttribute("Examination",Examination);
		model.addAttribute("pageTitle",pageTitle);
		return "examinationinfo";
	}
	
	@RequestMapping("/Examination/delete/{examinationId}")
	public String deleteExamintion(@PathVariable Integer examinationId) {
		String uri = defaultURI + "/{examinationId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("examinationId", Integer.toString(examinationId)));
		return "redirect:/examination/list";
	}
	
}

