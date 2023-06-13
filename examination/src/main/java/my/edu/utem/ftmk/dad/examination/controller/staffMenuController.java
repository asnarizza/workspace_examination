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
import my.edu.utem.ftmk.dad.examination.model.staff;

@Controller
public class staffMenuController {
	
private String defaultURI = "http://localhost:8080/examinationAttendance/api/staffs";
	
	@GetMapping("/staff/list")
	public String getStaff(Model model)
	{
		String uri = "http://localhost:8080/examinationAttendance/api/staffs";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<staff[]>response = restTemplate.getForEntity(uri, staff[].class);
		staff Staff[] = response.getBody();
		List<staff>staffList = Arrays.asList(Staff);
		model.addAttribute("Staff",staffList);
		return "staffs";
		
	}
	
	@RequestMapping("Staff/save")
	public String updateStaff (@ModelAttribute staff Staff) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <staff>request = new HttpEntity <staff>(Staff);
		String staffResponse = "";
		
		if (Staff.getStaffId()>0) {
			restTemplate.put(defaultURI, request,staff.class);
			
		}else {
			staffResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(staffResponse);
		return "redirect:/Staff/list";
	}
	@GetMapping("/Staff/{StaffId}")
	public String getStaff(@PathVariable Integer StaffId, Model model) {
		String pageTitle = "New Staff";
		staff Staff = new staff();
		if (StaffId > 0) {
			String uri = defaultURI + "/" + StaffId;
			RestTemplate restTemplate = new RestTemplate();
			Staff = restTemplate.getForObject(uri, staff.class);
			pageTitle ="Edit Staff";
			
		}
		model.addAttribute("Staff",Staff);
		model.addAttribute("pageTitle",pageTitle);
		return "staffinfo";
	}
	
	@RequestMapping("/Staff/delete/{StaffId}")
	public String deleteStaff(@PathVariable Integer StaffId) {
		String uri = defaultURI + "/{StaffId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("StaffId", Integer.toString(StaffId)));
		return "redirect:/Staff/list";
	}
	
}

