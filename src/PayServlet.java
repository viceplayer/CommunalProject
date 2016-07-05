

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//shemowmemeba informaciis, 
		int amount = Integer.parseInt(request.getParameter("amount"));
		String cardNumber = request.getParameter("cardId");
		int  cardId = DatabaseRelation.getCardId(cardNumber);
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		String path = request.getRequestURI();
		path += "?companyId=";
		path+=companyId;
		//Tu error moxda am paths damatebuli erroris parametrebi
		// response.sendRedirect(path);
		
		
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		
		
		String date = "asd";   //// gasaketebelia
		DatabaseRelation.createTransaction(userId, amount, companyId, date);
		response.sendRedirect("Confirm.jsp");
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
