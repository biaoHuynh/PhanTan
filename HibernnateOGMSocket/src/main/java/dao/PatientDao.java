package dao;

import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.Patient;
import util.HibernateUtil;

public class PatientDao {

	private OgmSessionFactory sessionFactory;

	public PatientDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addPatient(Patient patient) {

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();

		Date date = new Date();

		if (patient.getDOB().after(date)) {
			System.out.println("DOB >= currentdate is not allow");
			return false;
		}

		try {

			transaction.begin();

			session.save(patient);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		return false;
	}

	public Patient getPatient(String patientId) {

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();

		try {

			Patient patient = null;
			transaction.begin();

			patient = session.find(Patient.class, patientId);

			transaction.commit();
			return patient;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return null;
	}

}
