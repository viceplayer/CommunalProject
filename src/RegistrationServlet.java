
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.AccountManager;
import Manager.DatabaseRelation;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager.AccountManager am = (Manager.AccountManager) request.getServletContext()
				.getAttribute("Account Manager");
		String path = "";
		errors = new Vector<>();
		String personalId = request.getParameter("personalId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String mail = request.getParameter("mail");
		String date = request.getParameter("date");
		checkEnteredInteger(personalId, 11, "personalId");
		checkEnteredInteger(mobile, 9, "mobile");
		checkName(firstName, "firstName");
		checkName(lastName, "lastName");
		checkPassword(password);
		checkMail(mail);
		checkDate(date);
		if (DatabaseRelation.getUserId(personalId) != -1) {
			path += "AccountAlreadyExists.jsp";
		} else {
			am.createAccount(personalId, firstName, lastName, date, mail, mobile, password);
			path += "Welcome.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}

	private void checkDate(String date) {

	}

	private void checkMail(String mail) {

	}

	private void checkPassword(String password) {
		if (password.length() == 0 || password.length() < 4 || password.length() > 16) {
			errors.add("password");
			return;
		}

	}

	private void checkName(String name, String errorName) {
		if (name.length() == 0) {
			errors.add(errorName);
			return;
		}
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				errors.add(errorName);
				return;
			}
		}
	}

	private void checkEnteredInteger(String personalId, int size, String errorName) {
		if (personalId.length() != size) {
			errors.add(errorName);
			return;
		}
		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(personalId.charAt(i))) {
				errors.add(errorName);
				return;
			}
		}
	}

	private Vector<String> errors;
}
