package my.edu.utem.ftmk.dad.examination.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="device")
public class device {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deviceId")
	private int deviceId;
	
	@Column(name="locationNo")
	private int locationNo;
	
	@Column(name="deviceType")
	private String deviceType;
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
}
