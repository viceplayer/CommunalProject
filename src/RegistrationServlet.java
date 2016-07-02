
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.ChackParametrs;
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
		String errors = "?";
		String personalId = request.getParameter("personalId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String mail = request.getParameter("mail");
		String date = request.getParameter("date");
		ChackParametrs chackParametrs = new ChackParametrs();
		errors = errors + "personalId=" + chackParametrs.checkEnteredInteger(personalId, 11) + "&";
		errors = errors + "firstName=" + chackParametrs.checkName(firstName) + "&";
		errors = errors + "lastName=" + chackParametrs.checkName(lastName) + "&";
		errors = errors + "password=" + chackParametrs.checkPassword(password) + "&";
		errors = errors + "mail=" + chackParametrs.checkMail(mail) + "&";
		errors = errors + "mobile=" + chackParametrs.checkEnteredInteger(mobile, 9) + "&";
		errors = errors + "birthDate=" + chackParametrs.checkDate(date);

		if (chackParametrs.error == false) {
			if (DatabaseRelation.getUserId(personalId) != -1) {
				path += "Registration.jsp" + "?AccountAlreadyExists=AccountAlreadyExists";
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
		}else{
			path += "Registration.jsp" + errors;
		}
		response.sendRedirect(path);
	}

}
