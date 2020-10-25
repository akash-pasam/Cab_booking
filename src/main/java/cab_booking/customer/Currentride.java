package cab_booking.customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.driverservice.confirmationservice.Name;
import cab_booking.service.CurrentRideService;
@WebServlet(urlPatterns = "/currentride")
public class Currentride extends HttpServlet{
	
		private CurrentRideService service = new CurrentRideService();
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException,IOException{
			HttpSession session=request.getSession();
			String flat=(String)session.getAttribute("fromlat");
			String flng=(String)session.getAttribute("fromlng");
			String tlat=(String)session.getAttribute("tolat");
			String tlng=(String)session.getAttribute("tolng");
			String name=(String)session.getAttribute("uname");
		boolean value=service.price(flat,flng,tlat,tlng,name);
		request.getRequestDispatcher("/WEB-INF/views/Currentride.jsp")
		.forward(request, response);
		}
}
