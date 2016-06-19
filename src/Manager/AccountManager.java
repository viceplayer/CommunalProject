package Manager;

import java.util.ArrayList;

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

	public boolean addObject(int userId, int type, String name){
		ArrayList<object> tmp =  DatabaseRelation.getObjects(userId);
		for(int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getName() == name) return false;
		}
		DatabaseRelation.createObject(userId, type, name);
		return true;
		
		
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
