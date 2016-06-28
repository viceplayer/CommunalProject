package Manager;

import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGMail {
	// https://www.google.com/settings/security/lesssecureapps
	final static String SENDERS_EMAIL = "lukamatcharadze13@gmail.com";
	final static String SENDERS_PWD = "19960504";
	final static String subject = "Communal Recovery Password";
	final static String startText = "Your new password is  ";
	final static String endTeext = " Now you can use your new password!";

	private static String randomPassword(String personalId) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int size = 7 + random.nextInt(10);
		for (int i = 0; i < size; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		try {
			DatabaseRelation.makeUpdateToUsersInfo(DatabaseRelation.getUserId(personalId), "password",
					ShaOne.sha1(sb.toString()));
		} catch (NoSuchAlgorithmException e) {
			System.err.println("gmail password update");
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void send(String userAddres, String personalId) {
		// https://www.google.com/settings/security/lesssecureapps
		Properties mailProps = new Properties();

		// Set properties required to connect to Gmail's SMTP server
		mailProps.put("mail.smtp.host", "smtp.gmail.com");
		mailProps.put("mail.smtp.port", "587");
		mailProps.put("mail.smtp.auth", "true");
		mailProps.put("mail.smtp.starttls.enable", "true");

		// Create a username-password authenticator to authenticate SMTP session
		Authenticator authenticator = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SENDERS_EMAIL, SENDERS_PWD);
			}
		};

		// Create the mail session
		Session session = Session.getDefaultInstance(mailProps, authenticator);
		try {
			// Create a default MimeMessage object.
			final MimeMessage message = new MimeMessage(session);

			// Set the sender's email address
			message.setFrom(new InternetAddress(SENDERS_EMAIL));

			// Set recipient's email address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userAddres));

			// Set the subject of the email
			message.setSubject(subject);

			// Now set the actual message body of the email
			message.setText(startText + randomPassword(personalId) + endTeext);

			// Send message
			Transport.send(message);

		} catch (Exception e) {
			System.err.println("Problem sending email. Exception : " + e.getMessage());
		}

	}
}