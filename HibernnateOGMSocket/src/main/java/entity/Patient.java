package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "patients")
@AttributeOverride(name = "name", column = @Column(name = "patient_name"))
public class Patient extends Person implements Serializable {

	private String address;
	@Column(name = "date_of_birth")
	private Date DOB;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Treatment> treatments;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String id, String name, Set<String> phones, Date dOB, String address) {
		super(id, name, phones);
		// TODO Auto-generated constructor stub
		this.address = address;
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Set<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(Set<Treatment> treatments) {
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return "Patient [address=" + address + ", DOB=" + DOB + ", treatments=" + treatments + "]";
	}

}
