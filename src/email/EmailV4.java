package email;

import java.io.FileInputStream;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class EmailV4 extends UnicastRemoteObject implements Email {
	Properties config = new Properties();

	public EmailV4() throws Exception {
		config.load(new FileInputStream("config.properties"));
	}

	@Override
	public void sendEmail(String from, String to, String subject, String body) throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.mailtrap.io");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(config.get("username").toString(), config.get("password").toString());
			}
		});

		new ExcelV1();

		String file = "BankStatement.xlsx";

		Message message = Attachment.getMessage(session, from, to, subject, body, file);

		Transport.send(message);

		System.out.println("Email Message Sent Successfully");
	}
}
