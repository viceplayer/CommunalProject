
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Manager.DatabaseRelation;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		// HttpSession session = request.getSession();
		// int userId = (int) session.getAttribute("userId");
		String userId = request.getParameter("userId");
//		if (DatabaseRelation.PersonalIdExsist(userId)) {
//			if (DatabaseRelation.getUserMail(userId).equals("")) {
//				request.setAttribute("error", "This User Have Not Mail You Can Not Recovery Password");
//				path += "ForgetPassword.jsp";
//			} else {
//				// request.setAttribute("error",
//				// DatabaseRelation.getUserMail(userId));
//				// path += "RecoveryPassword.jsp";
//				path += "ForgetPassword.jsp";
//			}
//
//		} else {

			request.setAttribute("error", "User Does Not Exist");
			path += "ForgetPassword.jsp";

//		}

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}
}
