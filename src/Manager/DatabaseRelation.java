package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DatabaseRelation {
	private static Connection con;

	public DatabaseRelation() {
		con = DBConnection.getConnection();

	}

	public static int getUserId(String personalId) {
		String query = "SELECT id FROM user WHERE personalId = " + personalId;
		int result = -1;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<object> getObjects(int userId) {
		String query = "SELECT * FROM object WHERE userId = " + userId;
		ArrayList<object> result = new ArrayList<object>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
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

	public static void createUser(String personalId, String firstName, String lastName, String date, String mail,
			String mobile, String password) {
		String query = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, personalId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, date);
			ps.setString(5, mail);
			ps.setString(6, mobile);
			ps.setString(7, password);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createCard(int userId, String cardNumber, String date, String firstName, String lastName) {
		String query = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setString(2, cardNumber);
			ps.setString(3, date);
			ps.setString(4, firstName);
			ps.setString(5, lastName);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createCompany(String name) {
		String query = "INSERT INTO company VALUES(?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createFolder(int userId, int type, String name) {
		String query = "INSERT INTO object VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setInt(2, type);
			ps.setString(3, name);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//-----------------
	
	public static void createTransaction(int cardId, double amount, int companyId, java.sql.Date date, int objectId) {
		String query = "INSERT INTO transaction VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cardId);
			ps.setDouble(2, amount);
			ps.setInt(3, companyId);
			ps.setDate(4, date);
			ps.setInt(5, objectId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createTicket(int objectId, int companyId, String ticket) {
		String query = "INSERT INTO transaction VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, objectId);
			ps.setInt(2, companyId);
			ps.setString(3, ticket);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static ArrayList<Ticket> getTickets(int objectId) {
		String query = "SELECT objectId,ticket,companyName FROM ticket a join company b on a.companyId = b.id WHERE objectId = "
				+ objectId;
		ArrayList<Ticket> result = new ArrayList<Ticket>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket temp = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(2));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static void createTransaction(int cardId, double amount, int companyId, String date, int objectId) {
		String query = "INSERT INTO transaction VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cardId);
			ps.setDouble(2, amount);
			ps.setInt(3, companyId);
			ps.setString(4, date);
			ps.setInt(5, objectId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createTicket(int objectId, int companyId, String ticket) {
		String query = "INSERT INTO transaction VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, objectId);
			ps.setInt(2, companyId);
			ps.setString(3, ticket);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<Ticket> getTickets(int objectId) {
		String query = "SELECT objectId,ticket,companyName FROM ticket a join company b on a.companyId = b.id WHERE objectId = "
				+ objectId;
		ArrayList<Ticket> result = new ArrayList<Ticket>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket temp = new Ticket(rs.getInt(1), rs.getString(3), rs.getString(2));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

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

	public static ArrayList<card> getCards(int userId) {
		String query = "SELECT userId, cardNumber, cardDate, firstName, lastName from card where userId = " + userId;
		ArrayList<card> result = new ArrayList<card>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				card temp = new card(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static boolean userExists(String personalId, String password) {
		String query = "SELECT password FROM user WHERE personalId = " + personalId + "and password = " + password;
		boolean result = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
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
}