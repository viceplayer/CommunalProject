

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
	 * This servlet is being used when user tries to add ticket in specific object.
	 * At first method checks, whether ticket exists or not in that object. If it does, 
	 * path is dispatched to an error page, where it says "ticket exists" if it doesn't, page is
	 * dispatched to home page and ticket is being added.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager.AccountManager am = (Manager.AccountManager) request.getServletContext()
				.getAttribute("Account Manager");
		String path = "";
		String ticketNumber = request.getParameter("ticketNumber");
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		int objectId = Integer.parseInt(request.getParameter("objectId"));
		System.out.println(objectId);

		if (!am.addTicket(objectId, companyId, ticketNumber)){
			path += "TicketAlreadyExists.jsp";
			System.out.print("Ticket already exists");
		} else {
			path += "Home.jsp";
			System.out.print("Success! Ticket Added");

		}
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		doGet(request, response);
	}

}
