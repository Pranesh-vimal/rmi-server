package email;

import java.rmi.Naming;
import java.util.Scanner;

public class RmiClient {
	public static void main(String[] args) throws Exception {
		Email email = (Email) Naming.lookup("rmi://localhost:1099/email");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter From ID : ");
		String from = s.nextLine();
		System.out.print("Enter To ID : ");
		String to = s.nextLine();
		System.out.print("Enter Subject : ");
		String subject = s.nextLine();
		System.out.print("Enter Body : ");
		String body = s.nextLine();
		email.sendEmail(from, to, subject, body);
	}
}
