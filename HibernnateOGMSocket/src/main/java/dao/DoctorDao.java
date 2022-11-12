package dao;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.Doctor;
import util.HibernateUtil;

public class DoctorDao {

	private OgmSessionFactory sessionFactory;

	public DoctorDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addDoctor(Doctor doctor) {

		OgmSession session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.save(doctor);

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}

		return false;
	}

}
