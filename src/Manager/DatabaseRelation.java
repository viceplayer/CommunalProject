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
}