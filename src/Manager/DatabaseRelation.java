package Manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DatabaseRelation {
	private static Connection con;

	public DatabaseRelation() {
		// DBConnection asd = new DBConnection();
		con = DBConnection.getConnection();
	}

	public static int getUserId(int personalId) {
		String query = "SELECT id FROM user WHERE personalId = " + personalId;
		int result = -1;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<object> getTesseracts(int userId) {
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

	public static void createUser(int personalId, String firstName, String lastName, java.sql.Date date, String mail,
			int mobile) {
		String query = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, personalId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setDate(4, date);
			ps.setString(5, mail);
			ps.setInt(6, mobile);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void createCard(int userId, int cardNumber, String date, String firstName, String lastName) {
		String query = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setInt(2, cardNumber);
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
		for(int i=0;i<arr.size();i++){
			query += arr.get(i).getId();
			if(i!=arr.size()-1){
				query += " OR objectId = ";
			}
		}
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction temp = new Transaction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	public static ArrayList<card> getCards(int userId) {
		String query = "SELECT userId, cardNumber, cardDate, firstName, lastName from card where userId = "
				+ userId;
		ArrayList<card> result = new ArrayList<card>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				card temp = new card(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

}