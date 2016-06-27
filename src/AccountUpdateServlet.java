
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.DatabaseRelation;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager.AccountManager am = (Manager.AccountManager) request.getServletContext()
				.getAttribute("Account Manager");
		String path = "";
		String newName = request.getParameter("newName");
		String newLastName = request.getParameter("newLastName");
		String newPersonalId = request.getParameter("newPersonalId");
		String newMail = request.getParameter("newMail");
		String newMobile = request.getParameter("newMobile");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		if(!newName.isEmpty()){
			System.out.println("shesrulda name");
			DatabaseRelation.makeUpdateToUsersInfo(userId, "firstName", newName);
		}
		if(!newLastName.isEmpty()){
			DatabaseRelation.makeUpdateToUsersInfo(userId, "lastName", newLastName);
		}
		if(!newMail.isEmpty()){
			DatabaseRelation.makeUpdateToUsersInfo(userId, "mail", newMail);
		}
		if(!newMobile.isEmpty()){
			DatabaseRelation.makeUpdateToUsersInfo(userId, "mobile", newMobile);
		}
		if(!oldPassword.isEmpty() && !newPassword.isEmpty()){
			//aq jer unda shevadarot dzveli pw sworia tu ara
			DatabaseRelation.makeUpdateToUsersInfo(userId, "password", newPassword);
		}
		path += "AccountPanel.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}

}
