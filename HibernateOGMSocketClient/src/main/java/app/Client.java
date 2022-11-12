package app;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entity.Doctor;
import entity.Patient;
import entity.Treatment;

public class Client {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("192.168.1.139", 1451);

		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		while (true) {

			Doctor doctor2 = new Doctor("DT102", "Neena Kochhar", new HashSet<>(Arrays.asList("(355) 444-1234")),
					new HashSet<String>(Arrays.asList("CPT", "CNA", "RBT", "CPC")), "Gastroenterologist");
			Patient patient = new Patient("PT-2", "Shenna Espinoza", new HashSet<>(Arrays.asList("(555) 857-118")),
					new Date(2022 - 1900, 1, 1), "12 Nguyn van bao");
			Set<Treatment> treatments = new HashSet<Treatment>(Arrays.asList(
					new Treatment(doctor2, new Date(2019 - 1900, 1, 15), new Date(2019 - 1900, 1, 15), "Ngheof ")));
			patient.setTreatments(treatments);

			out.writeObject(doctor2);
			out.writeObject(patient);
			boolean rs = in.readBoolean();
			if (rs) {
				System.out.println("thanh cong");
			} else {
				System.out.println("that bai");
			}
		}
	}
}
