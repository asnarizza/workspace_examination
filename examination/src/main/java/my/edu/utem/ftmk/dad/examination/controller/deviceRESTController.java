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

import my.edu.utem.ftmk.dad.examination.model.device;
import my.edu.utem.ftmk.dad.examination.repository.deviceRepository;

@RestController
@RequestMapping("/api/device")
public class deviceRESTController {
	
	@Autowired
	private deviceRepository DeviceRepository;
	
	@GetMapping
	public List<device> getDevice(){
		return DeviceRepository.findAll();
	}
	
	@GetMapping("{deviceId}")
	public device getDevice(@PathVariable long deviceId) {

		device Device=DeviceRepository.findById(deviceId).get();
		
		return Device;
	}
	
	@PostMapping()
	public device insertDevice(@RequestBody device Device) {
		return DeviceRepository.save(Device);
		
	}
	
	@PutMapping()
	public device updateDevice(device Device) {
		return DeviceRepository.save(Device);
	}
	
	@DeleteMapping("{deviceId}")
	public ResponseEntity<HttpStatus> deleteDevice(@PathVariable long deviceId){
		
		DeviceRepository.deleteById(deviceId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
