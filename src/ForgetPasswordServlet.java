
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.DatabaseRelation;
import Manager.ShaOne;

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
		String userId = request.getParameter("User Id");

		if (!userId.isEmpty()) {
			if (-1 != DatabaseRelation.getUserId(userId)) {
				System.out.println("User Exist");
				request.setAttribute("error", "User Exist");
				path += "ForgetPassword.jsp";
			} else {

				request.setAttribute("error", "User Does Not Exist");
				path += "ForgetPassword.jsp";

			}

			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			doGet(request, response);
		}
	}
}
