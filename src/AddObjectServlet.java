

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class AddObjectServlet
 */
@WebServlet("/AddObjectServlet")
public class AddObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddObjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Using this servlet, user can add object in his/her account. Method 
	 * first checks, whether object exists or not, if it does, path is dispatched to
	 * Error, which says: object exists. If it doesn't, Object is being added and page is
	 * being refreshed.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager.AccountManager am = (Manager.AccountManager) request.getServletContext()
				.getAttribute("Account Manager");
		String path = "";
		String name = request.getParameter("objectName");
		int type = Integer.parseInt(request.getParameter("type"));
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		if (!am.addObject(userId, type, name)){
			path += "ObjectAlreadyExists.jsp";
			System.out.print("Object already exists");
		} else {
			path += "Home.jsp";
			System.out.print("Success! Object Added");

		}
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}
	
}
