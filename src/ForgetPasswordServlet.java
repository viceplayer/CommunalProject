
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.DatabaseRelation;
import Manager.SendGMail;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This servlet is being used, when user tries to recover password. He/she types
	 * personalId and then using sendGMail class, method sends him/her reseted password.
	 * If the input is wrong, or user doesn't exist or  user hasn't got mail, method
	 * shows proper result "no mail or user doesn't exist"
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String personalId = request.getParameter("userId");
		if (DatabaseRelation.PersonalIdExsist(personalId)) {
			if (DatabaseRelation.getUserMail(personalId).equals("")) {
				request.setAttribute("error", "This User Have Not Mail You Can Not Recovery Password");
				path += "ForgetPassword.jsp";
			} else {
				request.setAttribute("mail", DatabaseRelation.getUserMail(personalId));
				
				SendGMail.send(DatabaseRelation.getUserMail(personalId), personalId);
				path += "RecoveryPassword.jsp";
			}

		} else {

			request.setAttribute("error", "User Does Not Exist");
			path += "ForgetPassword.jsp";

		}
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}
}
