package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class Treatment implements Serializable {

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	private String decription;
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	public Treatment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Treatment(Doctor doctor, Date startDate, Date endDate, String description) {
		super();
		this.doctor = doctor;
		this.decription = decription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Treatment [doctor=" + doctor + ", decription=" + decription + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
