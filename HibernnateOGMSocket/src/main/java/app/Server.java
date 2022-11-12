package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.DoctorDao;
import dao.PatientDao;
import entity.Doctor;
import entity.Patient;

public class Server {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(1451);
		System.out.println("Ready...");

		while (true) {

			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress().getHostAddress());
			System.out.println(socket.getPort());

			new Thread(new Handler(socket)).start();

		}
	}
}

class Handler implements Runnable {

	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private DoctorDao doctorDao;
	private PatientDao patientDao;

	public Handler(Socket socket) {
		super();
		this.socket = socket;
		doctorDao = new DoctorDao();
		patientDao = new PatientDao();
	}

	@Override
	public void run() {

		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());

			while (true) {
				Doctor doctor = (Doctor) in.readObject();
				boolean result = doctorDao.addDoctor(doctor);
				out.writeBoolean(result);

				Patient patient = (Patient) in.readObject();
				boolean resultPatient = patientDao.addPatient(patient);
				out.writeBoolean(resultPatient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
