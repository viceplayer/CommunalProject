package Manager;

public class AccountManager {
	private DatabaseRelation db;

	public AccountManager() {
		db = new DatabaseRelation();

	}

	public boolean createAccount(String personalId, String firstName, String lastName, String date, String mail,
			String mobile, String password) {
		if (accountExists(personalId) == false) {
			DatabaseRelation.createUser(personalId, firstName, lastName, date, mail, mobile, password);
			return true;
		}
		return false;
	}

	public boolean accountExists(String personalId) {

		if (DatabaseRelation.getUserId(personalId) == -1) {
			return false;
		}
		return true;
	}

	public boolean logIn(String personalId, String password) {
		if (DatabaseRelation.userExists(personalId, password)) {
			return true;
		}
		return false;
	}

}
