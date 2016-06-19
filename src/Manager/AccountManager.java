package Manager;

import java.util.ArrayList;

public class AccountManager {
	private DatabaseRelation db;

	public AccountManager() {
		db = new DatabaseRelation();

	}

	public boolean createAccount(String personalId, String firstName, String lastName, String date, String mail,
			String mobile, String password) {
		if (DatabaseRelation.getUserId(personalId) == -1) {
			DatabaseRelation.createUser(personalId, firstName, lastName, date, mail, mobile, password);
			return true;
		}
		return false;
	}

	public boolean addObject(int userId, int type, String name){
		ArrayList<object> tmp =  DatabaseRelation.getObjects(userId);
		for(int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getName().equals(name)) return false;
			
		}
		DatabaseRelation.createObject(userId, type, name);
		return true;
		
		
	}

	public boolean logIn(String personalId, String password) {
		if (DatabaseRelation.userExists(personalId, password)) {
			return true;
		}
		return false;
	}

}
