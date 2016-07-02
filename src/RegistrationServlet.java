
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.DatabaseRelation;
import Manager.ShaOne;

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
	 * This servlet is being used while registering user. it checks each field
	 * in a specific way, and if everything is okay, it tries to add user into
	 * database, if it doesn't already exists there.
	 * 
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
			try {
				am.createAccount(personalId, firstName, lastName, date, mail, mobile, ShaOne.sha1(password));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				System.err.println("RegstrationServlet Sha1");
				e.printStackTrace();
			}
			path += "Home.jsp";
		}
		response.sendRedirect(path);
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
