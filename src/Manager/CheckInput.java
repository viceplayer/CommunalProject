package Manager;

public class CheckInput {
	public static final String CORRECT = "correct";

	public static String checkPassword(String password) {
		if (password.length() == 0 || password.length() < 4 || password.length() > 16) {
			return "password";
		}
		return CORRECT;

	}

	public static String checkName(String name, String errorName) {
		if (name.length() == 0) {
			return errorName;
		}
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return errorName;
			}
		}
		return CORRECT;
	}

	public static  String checkEnteredInteger(String personalId, int size, String errorName) {
		if (personalId.length() != size) {
			return errorName;
		}
		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(personalId.charAt(i))) {
				return errorName;
			}
		}
		return CORRECT;
	}

}
