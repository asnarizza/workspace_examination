package my.edu.utem.ftmk.dad.examination.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "studentId")
	private int subjectId;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "student")
	private List<student> Student;
	
	@Column (name = "teachingLecturer")
	private staff teachingLecturer;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<student> getStudent() {
		return Student;
	}
	public void setStudent(List<student> student) {
		Student = student;
	}
	public staff getTeachingLecturer() {
		return teachingLecturer;
	}
	public void setTeachingLecturer(staff teachingLecturer) {
		this.teachingLecturer = teachingLecturer;
	}
	
	
}
