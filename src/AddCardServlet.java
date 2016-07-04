
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.ChackParametrs;

/**
 * Servlet implementation class AddCardServlet
 */
@WebServlet("/AddCardServlet")
public class AddCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCardServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cardNumber = request.getParameter("cardNumber");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String date = month + "/" + year;
		String errors = "?";
		ChackParametrs chackParametrs = new ChackParametrs();
		if (!firstName.isEmpty())errors = errors + "cardFirstName=" + chackParametrs.checkName(firstName) + "&";
		if (!lastName.isEmpty())errors = errors + "cardLastName=" + chackParametrs.checkName(lastName) + "&";
		if (!cardNumber.isEmpty())errors = errors + "cardName=" + chackParametrs.checkEnteredInteger(cardNumber, 16) + "&";
		if (chackParametrs.error == false) {
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			if (!am.addCard(userId, cardNumber, date, firstName, lastName)) {
				errors = errors + "cardError=Card already exists&";
				
			} else {
				errors = errors + "cardAdd=Success! Card Added&";
			}
		}
		path = path +  "AccountPanel.jsp" + errors;
		response.sendRedirect(path);
	}

}
