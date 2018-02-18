package org.com.sessionbean;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class MailSenderBean
 */
@Stateless

public class MailSenderBean {

	public void sendEmail(String fromEmail, String username, String password, String toemail, String subject,
			String message) {
		
		System.out.println("in mail sender" +fromEmail);

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.auth", "true");

		prop.put("mail.smtp.port", "465");

		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.failback", "false");

		Session mailsession = Session.getDefaultInstance(prop, null);
		mailsession.setDebug(true);

		Message mailMessage = new MimeMessage(mailsession);

		try {
			mailMessage.setFrom(new InternetAddress(fromEmail));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
			mailMessage.setContent(message, "text/html");
			mailMessage.setSubject(subject);

			Transport transport = mailsession.getTransport("smtp");
			transport.connect("smtp.gmail.com", username, password);

			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MailSenderBean() {
		// TODO Auto-generated constructor stub
	}

}
