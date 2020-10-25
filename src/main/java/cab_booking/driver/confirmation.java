package cab_booking.driver;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.driverservice.confirmationservice;
import cab_booking.driverservice.confirmationservice.Name;
import cab_booking.service.loginservice;

@WebServlet(urlPatterns = "/confirmation")
public class confirmation extends HttpServlet{
	private confirmationservice service = new confirmationservice();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		
		ArrayList<Name> list =service.values();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp")
		.forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		String number=request.getParameter("number");
		String latitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		HttpSession session=request.getSession();
	      String dname=(String)session.getAttribute("dname");
		boolean isConfirmed=service.isConfirmed(number,dname);
		if(isConfirmed) {
		response.sendRedirect("/yourRide");
		}
		else {
			response.sendRedirect("/index");
		}
		}
}