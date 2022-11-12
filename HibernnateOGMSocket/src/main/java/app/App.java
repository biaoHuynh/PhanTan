package app;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import dao.DoctorDao;
import dao.PatientDao;
import entity.Doctor;
import entity.Patient;
import entity.Treatment;

public class App {

	public static void main(String[] args) {

		PatientDao patientDao = new PatientDao();
		DoctorDao doctorDao = new DoctorDao();

//		Doctor doctor1 = new Doctor("DT100", "Steven King", new HashSet<>(Arrays.asList("(155) 555-2234")),
//				new HashSet<String>(Arrays.asList("CCS-P", "CPCT", "CNA")), "Dermatologist");
//		doctorDao.addDoctor(doctor1);
//		Patient patient = new Patient("PT-1", "Shenna Espinoza", new HashSet<>(Arrays.asList("(555) 857-118")),
//				new Date(2022 - 1900, 1, 1), "66-4 Parkhurst Rd, Chelmsford MA 1824");
//		Set<Treatment> treatments = new HashSet<Treatment>(Arrays.asList(new Treatment(doctor1,
//				new Date(2019 - 1900, 1, 15), new Date(2019 - 1900, 1, 15), "Circadian rhythm sleep disorder")));
//		patient.setTreatments(treatments);
//		patientDao.addPatient(patient);

		System.out.println(patientDao.getPatient("PT-1"));
		
	}

}
