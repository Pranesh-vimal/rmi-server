package email;

import java.rmi.Remote;

public interface Email extends Remote {
	public void sendEmail(String from, String to, String subject, String body) throws Exception;
}
