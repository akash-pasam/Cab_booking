package cab_booking.driver;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.driverservice.yourRideService;
import cab_booking.driverservice.yourRideService.Name;

@WebServlet(urlPatterns = "/yourRide")

public class YourRide extends HttpServlet{
	private yourRideService service = new yourRideService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		HttpSession session=request.getSession();
		String Email=(String)session.getAttribute("dname");
		ArrayList<Name> list =service.values(Email);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/yourRide.jsp")
		.forward(request, response);
	
	}

}
