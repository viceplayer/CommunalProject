package Manager;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGMail {

	final static String username = "lukamatcharadze13@gmail.com";
	final static String password = "19960504";
	final static String subject = "Communal Recovery Password";
	final static String startText = "Your new password is  ";
	final static String endTeext = "! Now you can use your new password!";

	public static void send(String userAddres, int recoveryPassword) {

		String addres = userAddres;

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(username, password);

					}

				});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));

			message.setRecipients(Message.RecipientType.TO,

					InternetAddress.parse(addres));
			message.setSubject(subject);

			message.setText(startText + recoveryPassword + endTeext);

			Transport.send(message);

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}
