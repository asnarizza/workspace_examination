package my.edu.utem.ftmk.dad.examination.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="examination_attendance")
public class examination_attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="examinationAttendanceId")
	private int examinationAttendanceId;
	
	@Column(name="Student")
	private student Student;
	
	@Column(name="Examination")
	private examination Examination;
	
	@Column(name="checkInTime")
	private Date checkInTime;
	
	@Column(name="venue")
	private Date venue;
	
	@Column(name="Device")
	private device Device;
	
	
	public int getExaminationAttendance() {
		return getExaminationAttendance();
	}
	public void setExaminationAttendance(int examinationAttendance) {
		this.examinationAttendanceId = examinationAttendance;
	}
	public student getStudent() {
		return Student;
	}
	public void setStudent(student student) {
		Student = student;
	}
	public examination getExamination() {
		return Examination;
	}
	public void setExamination(examination examination) {
		Examination = examination;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getVenue() {
		return venue;
	}
	public void setVenue(Date venue) {
		this.venue = venue;
	}
	public device getDevice() {
		return Device;
	}
	public void setDevice(device device) {
		Device = device;
	}
}
