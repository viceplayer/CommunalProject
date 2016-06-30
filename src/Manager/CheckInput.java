package Manager;

public class CheckInput {
	public static final String CORRECT = "correct";

	/**
	 * This method checks, whether length of the given password is more than 4
	 * and less than 16. If so, it returns string "correct" if not it returns
	 * string "password" so we know, what error occured.
	 * 
	 * @param password
	 */
	public static String checkPassword(String password) {
		if (password.length() == 0 || password.length() < 4 || password.length() > 16) {
			return "password";
		}
		return CORRECT;

	}

	/**
	 * This method checks, name consists of all the letters. If so, it returns
	 * string "correct" if not it returns string errorName, which is given as a
	 * variable so we know, what error occured.
	 * 
	 * @param password
	 */
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

	/**
	 * This method checks, whether entered Integer is equal to the given size
	 * and all the symbols are digit. If so, it returns string "correct" if not
	 * it returns string "password" so we know, what error occured.
	 * 
	 * @param password
	 */
	public static String checkEnteredInteger(String personalId, int size, String errorName) {
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
