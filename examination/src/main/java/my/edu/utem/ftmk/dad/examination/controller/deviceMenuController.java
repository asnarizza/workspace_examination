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
import my.edu.utem.ftmk.dad.examination.model.device;

@Controller
public class deviceMenuController {
	
private String defaultURI = "http://localhost:8080/examinationAttendance/api/devices";
	
	@GetMapping("/device/list")
	public String getDevice(Model model)
	{
		String uri = "http://localhost:8080/examinationAttendance/api/devices";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<device[]>response = restTemplate.getForEntity(uri, device[].class);
		device Device[] = response.getBody();
		List<device>deviceList = Arrays.asList(Device);
		model.addAttribute("Device",deviceList);
		return "devices";
		
	}
	
	@RequestMapping("Device/save")
	public String updateDevice (@ModelAttribute device Device) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <device>request = new HttpEntity <device>(Device);
		String deviceResponse = "";
		
		if (Device.getDeviceId()>0) {
			restTemplate.put(defaultURI, request,device.class);
			
		}else {
			deviceResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(deviceResponse);
		return "redirect:/Device/list";
	}
	@GetMapping("/Device/{DeviceId}")
	public String getDevice(@PathVariable Integer DeviceId, Model model) {
		String pageTitle = "New Device";
		device Device = new device();
		if (DeviceId > 0) {
			String uri = defaultURI + "/" + DeviceId;
			RestTemplate restTemplate = new RestTemplate();
			Device = restTemplate.getForObject(uri, device.class);
			pageTitle ="Edit Device";
			
		}
		model.addAttribute("Device",Device);
		model.addAttribute("pageTitle",pageTitle);
		return "deviceinfo";
	}
	
	@RequestMapping("/Device/delete/{DeviceId}")
	public String deleteDevice(@PathVariable Integer DeviceId) {
		String uri = defaultURI + "/{DeviceId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("DeviceId", Integer.toString(DeviceId)));
		return "redirect:/Device/list";
	}
	
}

