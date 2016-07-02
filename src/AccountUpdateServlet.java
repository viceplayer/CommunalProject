
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.ChackParametrs;
import Manager.DatabaseRelation;
import Manager.ShaOne;

/**
 * Servlet implementation class AccountUpdateServlet
 */
@WebServlet("/AccountUpdateServlet")
public class AccountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * This doPost method receives values of all of the fields. It has got
	 * specific TO-DO for each field, if one of the fields isn't empty it does
	 * the thing. This server is being used when user goes to his/her account
	 * panel and wants to change personal information.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String newFirstName = request.getParameter("newName");
		String newLastName = request.getParameter("newLastName");
		String newMail = request.getParameter("newMail");
		String newMobile = request.getParameter("newMobile");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String errors = "?";
		ChackParametrs chackParametrs = new ChackParametrs();
		if (!newFirstName.isEmpty())errors = errors + "firstName=" + chackParametrs.checkName(newFirstName) + "&";
		if (!newLastName.isEmpty())errors = errors + "lastName=" + chackParametrs.checkName(newLastName) + "&";
		if (!newMail.isEmpty())errors = errors + "mail=" + chackParametrs.checkMail(newMail) + "&";
		if (!newMobile.isEmpty())errors = errors + "mobile=" + chackParametrs.checkEnteredInteger(newMobile, 9) + "&";
		if (!oldPassword.isEmpty())errors = errors + "oldPassword=" + chackParametrs.checkPassword(oldPassword) + "&";
		if (!newPassword.isEmpty())errors = errors + "newPassword=" + chackParametrs.checkPassword(newPassword);
		if (chackParametrs.error == false) {
			try {
				oldPassword = ShaOne.sha1(oldPassword);
				newPassword = ShaOne.sha1(newPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			if (!newFirstName.isEmpty()) {
				System.out.println("shesrulda name");
				DatabaseRelation.makeUpdateToUsersInfo(userId, "firstName", newFirstName);
			}
			if (!newLastName.isEmpty()) {
				DatabaseRelation.makeUpdateToUsersInfo(userId, "lastName", newLastName);
			}
			if (!newMail.isEmpty()) {
				DatabaseRelation.makeUpdateToUsersInfo(userId, "mail", newMail);
			}
			if (!newMobile.isEmpty()) {
				DatabaseRelation.makeUpdateToUsersInfo(userId, "mobile", newMobile);
			}
			if (!oldPassword.isEmpty() && !newPassword.isEmpty()) {
				if (oldPassword.equals(DatabaseRelation.getUserPassword(userId))) {
					DatabaseRelation.makeUpdateToUsersInfo(userId, "password", newPassword);
				} else {
					System.out.println("Password doesn't match an old password");
				}

			}
		}
		path += "AccountPanel.jsp" + errors;
		response.sendRedirect(path);
	}

}
