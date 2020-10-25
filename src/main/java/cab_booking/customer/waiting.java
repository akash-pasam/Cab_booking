package cab_booking.customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.service.waitingservice;
import cab_booking.service.waitingservice.Name;


@WebServlet(urlPatterns = "/waiting")

public class waiting extends HttpServlet{
	private waitingservice service = new waitingservice();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		HttpSession session=request.getSession();
	      String Email=(String)session.getAttribute("uname");
	     String uname= service.uname(Email);
		ArrayList<Name> list =service.values();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/waiting.jsp")
		.forward(request, response);

}
}