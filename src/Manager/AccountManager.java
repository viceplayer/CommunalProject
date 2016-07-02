package Manager;

import java.util.ArrayList;

public class AccountManager {
	private DatabaseRelation db;

	public AccountManager() {
		db = new DatabaseRelation();

	}

	/**
	 * This method receives all the parameters, which are required to create
	 * account. it at first checks, whether account already exists or not, if it
	 * doesn't it creates account and returns true else false.
	 * @param personalId
	 * @param firstName
	 * @param lastName
	 * @param date
	 * @param mail
	 * @param mobile
	 * @param
	 */
	public boolean createAccount(String personalId, String firstName, String lastName, String date, String mail,
			String mobile, String password) {
		if (DatabaseRelation.getUserId(personalId) == -1) {
			DatabaseRelation.createUser(personalId, firstName, lastName, date, mail, mobile, password);
			return true;
		}
		return false;
	}

	/**
	 * This method receives all the parameters, which are
	 * required to create object. it checks, whether object already
	 * exists or not. if it doesn't method adds it to database.
	 * @param userId
	 * @param type
	 * @param name
	 * @return
	 */
	public boolean addObject(int userId, int type, String name) {
		ArrayList<object> tmp = DatabaseRelation.getObjects(userId);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).getName().equals(name))
				return false;

		}
		DatabaseRelation.createObject(userId, type, name);
		return true;

	}

	/**
	 * This method receives all the parameters, which are required
	 * to create ticket. It checks whether ticket already exists or not, in that exact
	 * object, if it doesn't method adds given information to database.
	 * @param objectId
	 * @param companyId
	 * @param ticket
	 * @return
	 */
	public boolean addTicket(int objectId, int companyId, String ticket) {
		ArrayList<Ticket> tmp = DatabaseRelation.getTickets(objectId);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).getCompanyId() == companyId)
				return false;

		}
		DatabaseRelation.createTicket(objectId, companyId, ticket);
		return true;
	}
	/**
	 * 
	 * @param userId
	 * @param cardNumber
	 * @return
	 */
	public boolean addCard(int userId, String cardNumber, String date, String firstName, String lastName){
		ArrayList<Card> tmp = DatabaseRelation.getCards(userId);
		for(int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getCardNumber().equals(cardNumber)){
				return false;
			}
		}
		DatabaseRelation.createCard(userId, cardNumber, date, firstName, lastName);
		return  true;
		
	}
	/**
	 * This method is used, when user tries to log in.
	 * this method checks given personalId and password in database
	 * and if they both exist, returns true;
	 * @param personalId
	 * @param password
	 * @return
	 */
	public boolean logIn(String personalId, String password) {
		if (DatabaseRelation.userExists(personalId, password)) {
			return true;
		}
		return false;
	}

	
}
