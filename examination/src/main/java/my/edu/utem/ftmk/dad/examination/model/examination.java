package my.edu.utem.ftmk.dad.examination.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "examination")
public class examination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "examinationId")
	private int examinationId;
	
	@Column (name = "dateTime")
	private Date dateTime;
	
	@Column (name = "Subject")
	private subject Subject;
	
	@Column (name = "chiefInvigilator")
	private staff chiefInvigilator;
	
	@Column (name = "invigilators")
	private List<staff> invigilators;
	
	public int getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(int examinationId) {
		this.examinationId = examinationId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public subject getSubject() {
		return Subject;
	}
	public void setSubject(subject subject) {
		Subject = subject;
	}
	public staff getChiefInvigilator() {
		return chiefInvigilator;
	}
	public void setChiefInvigilator(staff chiefInvigilator) {
		this.chiefInvigilator = chiefInvigilator;
	}
	public List<staff> getInvigilators() {
		return invigilators;
	}
	public void setInvigilators(List<staff> invigilators) {
		this.invigilators = invigilators;
	}
	
	
}
