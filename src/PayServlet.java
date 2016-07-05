
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.ChackParametrs;
import Manager.DatabaseRelation;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayServlet() {
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
		String amount = request.getParameter("amount");
		String cardNumber = request.getParameter("cardId");
		System.out.println(cardNumber);
		int cardId = DatabaseRelation.getCardId(cardNumber);
		String cvc = request.getParameter("CVC");
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		// String path = request.getRequestURI();
		// path += "?companyId=" + companyId;
		String path = "";
		ChackParametrs chackParametrs = new ChackParametrs();
		String errors = "?companyId=" + companyId + "&";
		errors = errors + "cvc=" + chackParametrs.checkEnteredInteger(cvc, 3) + "&";
		errors = errors + "amount=" + chackParametrs.checkEnteredInteger(amount, -1) + "&";
		if (cardNumber == null)errors = errors + "cardNum=You do not have the card!&";
		if (chackParametrs.error == false  && cardNumber != null) {
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String date = dateFormat.format(cal.getTime());
			DatabaseRelation.createTransaction(userId, Integer.parseInt(amount), companyId, date);
			errors += "success=Success Pay !";
			path += "Pay.jsp" + errors;
		} else {
			path += "Pay.jsp" + errors;
		}
		response.sendRedirect(path);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
