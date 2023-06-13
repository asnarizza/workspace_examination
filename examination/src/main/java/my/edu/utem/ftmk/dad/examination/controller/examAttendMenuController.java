package my.edu.utem.ftmk.dad.examination.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.examination.model.examination_attendance;
import my.edu.utem.ftmk.dad.examination.model.student;

@Controller
public class examAttendMenuController {
private String defaultURI = "http://localhost:8080/examinationAttendance/api/examination_attendance";
	
	@GetMapping("/examination_attendance/list")
	public String getExamination_Attendance(Model model)
	{
		String uri = "http://localhost:8080/examinationAttendance/api/examination_attendance";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<examination_attendance[]>response = restTemplate.getForEntity(uri, examination_attendance[].class);
		examination_attendance Examination_Attendance[] = response.getBody();
		List<examination_attendance>examination_attendanceList = Arrays.asList(Examination_Attendance);
		model.addAttribute("Examination_Attendance",examination_attendanceList);
		return "examination_ettendance";
		
	}
	
	@RequestMapping("Examination_Attendance/save")
	public String updateExamination_Attendance (@ModelAttribute examination_attendance Examination_Attendance) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <examination_attendance>request = new HttpEntity <examination_attendance>(Examination_Attendance);
		String examination_attendanceResponse = "";
		
		if (Examination_Attendance.getExaminationAttendance()>0) {
			restTemplate.put(defaultURI, request,examination_attendance.class);
			
		}else {
			examination_attendanceResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(examination_attendanceResponse);
		return "redirect:/Examination_Attendance/list";
	}
	@GetMapping("/Examination_Attendance/{examinationAttendanceId}")
	public String getExamination_Attendance(@PathVariable Integer examinationAttendanceId, Model model) {
		String pageTitle = "New Examination Attendance";
		examination_attendance Examination_Attendance = new examination_attendance();
		if (examinationAttendanceId > 0) {
			String uri = defaultURI + "/" + examinationAttendanceId;
			RestTemplate restTemplate = new RestTemplate();
			Examination_Attendance = restTemplate.getForObject(uri, examination_attendance.class);
			pageTitle ="Edit Examination Attendance";
			
		}
		model.addAttribute("Examination Attendance",Examination_Attendance);
		model.addAttribute("pageTitle",pageTitle);
		return "examination_attendanceinfo";
	}
	
	@RequestMapping("/Examination_Attendance/delete/{examinationAttendanceId}")
	public String deleteExamination_Attendance(@PathVariable Integer examinationAttendanceId) {
		String uri = defaultURI + "/{examinationAttendanceId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("Examination Attendance Id", Integer.toString(examinationAttendanceId)));
		return "redirect:/Examination_Attendance/list";
	}
	
}
