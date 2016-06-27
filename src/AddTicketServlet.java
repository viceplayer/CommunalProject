

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.DatabaseRelation;

/**
 * Servlet implementation class AddTicketServlet
 */
@WebServlet("/AddTicketServlet")
public class AddTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTicketServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager.AccountManager am = (Manager.AccountManager) request.getServletContext()
				.getAttribute("Account Manager");
		String path = "";
		String ticketNumber = request.getParameter("ticketNumber");
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		// aq unda shevamowmot ticketi ari tu ara objectshi
		DatabaseRelation.createTicket(objectId, companyId, ticketNumber);

		//		if (!am.addObject(userId, type, name)){
//			path += "ObjectAlreadyExists.jsp";
//			System.out.print("Object already exists");
//		} else {
//			path += "Home.jsp";
//			System.out.print("Success! Object Added");
//
//		}
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}

}
