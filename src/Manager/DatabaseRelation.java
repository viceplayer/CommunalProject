package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseRelation {
	private static Connection con;

	public DatabaseRelation() {
		con = DBConnection.getConnection();

	}

	/**
	 * This method updates specified column in the database using given values,
	 * to the given user
	 * 
	 * @param userId
	 * @param columnToUpdate
	 * @param valueToUpdate
	 */
	public static void makeUpdateToUsersInfo(int userId, String columnToUpdate, String valueToUpdate) {
		String query = "Update user SET ";
		query += columnToUpdate + " = " + "'" + valueToUpdate + "'" + " WHERE id = " + userId;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method returns userData. While using this method, you must say,
	 * which info you want to retreive from database and also specify the user.
	 * 
	 * @param userId
	 * @param infoType
	 * @return
	 */
	public static String getUserData(int userId, String infoType) {
		String queryStart = "SELECT ";
		String queryMiddle = infoType;
		String queryEnd = " FROM user WHERE id = ?";
		String query = queryStart + queryMiddle + queryEnd;
		String result = "";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method returns password of the user
	 * 
	 * @param userId
	 */
	public static String getUserPassword(int userId) {
		String query = "SELECT password FROM user where id = ?";
		String result = "";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result += rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method returns true if given personalId exists in database. if it
	 * doesn't exists, it returns false.
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean PersonalIdExsist(String personalId) {
		String query = "SELECT personalId FROM user where personalId = ?";
		boolean result = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, personalId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method returns the mail of the specified user from the database.
	 * 
	 * @param personalId
	 * @return
	 */
	public static String getUserMail(String personalId) {
		String query = "SELECT mail FROM user where personalId = ?";
		String result = "";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, personalId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result += rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method returns id of the user using personalId
	 */
	public static int getUserId(String personalId) {
		String query = "SELECT id FROM user WHERE personalId = ?";
		int result = -1;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, personalId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method is being used, while registering. It receives all the
	 * information that are needed to create user in database.
	 * 
	 * @param personalId
	 * @param firstName
	 * @param lastName
	 * @param date
	 * @param mail
	 * @param mobile
	 * @param password
	 */
	public static void createUser(String personalId, String firstName, String lastName, String date, String mail,
			String mobile, String password) {
		String query = "INSERT INTO user(personalId, firstName, lastName, birthDate, mail, mobile, password) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, personalId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, date);
			ps.setString(5, mail);
			ps.setString(6, mobile);
			ps.setString(7, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createCard(int userId, String cardNumber, String date, String firstName, String lastName) {
		String query = "INSERT INTO card(userId, cardNumber, cardDate, firstName, lastName) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setString(2, cardNumber);
			ps.setString(3, date);
			ps.setString(4, firstName);
			ps.setString(5, lastName);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is being used to add company
	 * 
	 * @param name
	 */
	public static void createCompany(String name) {
		String query = "INSERT INTO company(companyName) VALUES(?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to create object to the specific user in database
	 * 
	 * @param userId
	 * @param type
	 * @param name
	 */
	public static void createObject(int userId, int type, String name) {
		String query = "INSERT INTO object(userId, objectType, objectName) VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setInt(2, type);
			ps.setString(3, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method returns list of the objects of the given user
	 * 
	 * @param userId
	 * @return
	 */
	public static ArrayList<object> getObjects(int userId) {
		String query = "SELECT * FROM object WHERE userId = ?";
		ArrayList<object> result = new ArrayList<object>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "" + userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				object temp = new object(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * This method is used, while adding transaction into database to the
	 * specific user
	 * 
	 * @param cardId
	 * @param amount
	 * @param companyId
	 * @param date
	 * @param objectId
	 */
	public static void createTransaction(int cardId, double amount, int companyId, String date, int objectId) {
		String query = "INSERT INTO transaction(cardId, amount, companyId, transactionDate, objectId) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cardId);
			ps.setDouble(2, amount);
			ps.setInt(3, companyId);
			ps.setString(4, date);
			ps.setInt(5, objectId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is used, while adding ticket into database to the specific
	 * user
	 * 
	 * @param objectId
	 * @param companyId
	 * @param ticket
	 */
	public static void createTicket(int objectId, int companyId, String ticket) {
		String query = "INSERT INTO ticket(objectId, companyId, ticket) VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, objectId);
			ps.setInt(2, companyId);
			ps.setString(3, ticket);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method returns all the ticket of the given object
	 * 
	 * @param objectId
	 * @return
	 */
	public static ArrayList<Ticket> getTickets(int objectId) {
		String query = "SELECT objectId,ticket,companyName,b.id FROM ticket a join company b on a.companyId = b.id WHERE objectId = ?";
		ArrayList<Ticket> result = new ArrayList<Ticket>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "" + objectId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket temp = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(2), rs.getInt(4));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * This method returns list of transactions of the given objects
	 * 
	 * @param arr
	 * @return
	 */
	public static ArrayList<Transaction> getTransactions(ArrayList<object> arr) {
		String query = "SELECT cardNumber,companyName,amount, transactionDate FROM transaction a join company b join card c join object d on a.companyId = b.id AND a.cardId = c.id AND a.objectId = d.id WHERE objectId = ";
		for (int i = 0; i < arr.size(); i++) {
			query += arr.get(i).getId();
			if (i != arr.size() - 1) {
				query += " OR objectId = ";
			}
		}
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction temp = new Transaction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * This method returns list of cards of the given user
	 * 
	 * @param userId
	 * @return
	 */
	public static ArrayList<Card> getCards(int userId) {
		String query = "SELECT userId, cardNumber, cardDate, firstName, lastName from card where userId = ?";
		ArrayList<Card> result = new ArrayList<Card>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "" + userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Card temp = new Card(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * This method checks, whether user exists or not in the database.
	 * 
	 * @param personalId
	 * @param password
	 * @return
	 */
	public static boolean userExists(String personalId, String password) {
		String query = "SELECT password FROM user WHERE personalId = ? and password = ?";
		boolean result = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, personalId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method checks, whether object exists or not in the database of the
	 * given user
	 * 
	 * @param userId
	 * @param objectName
	 * @return
	 */
	public static boolean objectExist(int userId, String objectName) {
		String query = "SELECT password FROM user WHERE userId = ? and objectName = ?";
		boolean result = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "" + userId);
			ps.setString(2, objectName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method is used to delete ticket for the specific user's object from
	 * the database
	 * 
	 * @param objectId
	 * @param companyId
	 */
	public static void deleteTicket(int objectId, int companyId) {
		String query = "DELETE FROM ticket WHERE objectId = ? and companyId = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, objectId);
			ps.setInt(2, companyId);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method at first deletes all the tickets in the given object, and
	 * then deletes object itself
	 * 
	 * @param objectId
	 */
	public static void deleteObject(int objectId) {
		String query = "DELETE FROM ticket WHERE objectId = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, objectId);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		query = "DELETE FROM object WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, objectId);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * This method at first deletes all the tickets in the given object, and
	 * then deletes object itself
	 * 
	 * @param objectId
	 */
	public static void deleteCard(int userId,String card) {
		String query = "DELETE FROM card WHERE userId = ? AND cardNumber = ?";

		try {
			System.out.println(userId);
			System.out.println(card);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setString(2,card);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
