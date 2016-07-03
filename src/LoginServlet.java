
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.DatabaseRelation;
import Manager.ShaOne;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		

	}

	/**
	 * this method is being used, when user tries to login.
	 * if the inpuit is wrong, page is being refreshed and result is shown, that
	 * "wrong input was typed", if everything is ok, it dispatchs link to home page.
	 * Also shaOne algorithm is being used to hash the entered password, so we can 
	 * check the password in the database.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Manager.AccountManager am = (Manager.AccountManager) request.getServletContext()
				.getAttribute("Account Manager");
		String personalId = request.getParameter("personalId");
		String password = "";
		try {
			password = ShaOne.sha1(request.getParameter("password"));
		} catch (NoSuchAlgorithmException e) {
			System.err.println("LoginServlet Sha1");
			e.printStackTrace();
		}
		String path = "";
		if (am.logIn(personalId, password)) {
			path += "Home.jsp";
		} else {
			path += "Login.jsp?error=Invalid Username or Password!";
		}
		int userId = DatabaseRelation.getUserId(personalId);
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		response.sendRedirect(path);
		
	}

}
