
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Manager.DatabaseRelation;

/**
 * Servlet implementation class DeleteObjectServlet
 */
@WebServlet("/DeleteObjectServlet")
public class DeleteObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteObjectServlet() {
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
		String path = "";
		int objectId = Integer.parseInt(request.getParameter("objectId"));
		DatabaseRelation.deleteObject(objectId);
		path += "Home.jsp";
		System.out.print("Success! Object Deleted");
		
	}

	/**
	 * This servlet is being used, when user tries to delete specific object on home page.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
