package Manager;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ChackParametrs {
	
	public  boolean error = false;
	

	public  String checkMail(String mail) {
		 String result = "";
		   try {
		      InternetAddress emailAddr = new InternetAddress(mail);
		      emailAddr.validate();
		   } catch (AddressException ex) {
			   error = true;
		      result = "Invalid email address!";
		   }
		   return result;
	}

	public  String checkPassword(String password) {
		if (password.length() == 0 || password.length() < 6 || password.length() > 16) {
			error = true;
			return "Password is too long or short!";
		}
		return "";
	}

	public  String checkName(String name) {
		if (name.length() == 0) {
			error = true;
			return "Name is empty";
		}
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				error = true;
				return"Name conteins invalid characters!";
			}
		}
		return "";
	}

	public  String checkEnteredInteger(String integer, int size) {
		if (integer.length() != size) {
			error = true;
			return "size is not " + size + "!";
		}
		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(integer.charAt(i))) {
				error = true;
				return "Field must contain only numbers!";
			}
		}
		return "";
	}

	
}
