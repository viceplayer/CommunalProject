package Manager;

import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGMail {
//https://www.google.com/settings/security/lesssecureapps
	final static String username = "lukamatcharadze13@gmail.com";
	final static String password = "19960504";
	final static String subject = "Communal Recovery Password";
	final static String startText = "Your new password is  ";
	final static String endTeext = " Now you can use your new password!";
	
	private static String randomPassword(String personalId){
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int size = 7 + random.nextInt(10);
		for (int i = 0; i < size; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
//		try {
//			DatabaseRelation.makeUpdateToUsersInfo(DatabaseRelation.getUserId(personalId), "password", ShaOne.sha1(sb.toString()));
//		} catch (NoSuchAlgorithmException e) {
//			System.err.println("gmail password update");
//			e.printStackTrace();
//		}
		return sb.toString();
	}

	public static void send(String userAddres, String personalId) {
//https://www.google.com/settings/security/lesssecureapps
		String addres = "lmach14@freeuni.edu.ge";//userAddres;

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

			message.setText(startText + randomPassword(personalId) + endTeext);

			Transport.send(message);

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}
