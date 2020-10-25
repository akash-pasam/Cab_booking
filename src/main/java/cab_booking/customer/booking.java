package cab_booking.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.service.bookingservice;
@WebServlet(urlPatterns = "/booking")
public class booking extends HttpServlet{
		private bookingservice service=new bookingservice();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException,IOException{
			request.getRequestDispatcher("/WEB-INF/views/booking.jsp")
			.forward(request, response);
			
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException,IOException{
			HttpSession session=request.getSession();
			String latitude1 = request.getParameter("latitude1");
			String latitude2 = request.getParameter("latitude2");
			String longitude1 = request.getParameter("longitude1");
			String longitude2 = request.getParameter("longitude2");
		      String Email=(String)session.getAttribute("uname");
		      session.setAttribute("fromlat",latitude1);
		      session.setAttribute("fromlng",longitude1);
		      session.setAttribute("tolat",latitude2);
		      session.setAttribute("tolng",longitude2);
			String from_location = request.getParameter("from_location");
			String to_location = request.getParameter("to_location");
			String number = request.getParameter("number");		     
			boolean bookings=service.booking(from_location,to_location,number,Email);
			if(bookings){
				response.sendRedirect("/waiting");
			
			}
			else {
				
				response.sendRedirect("/booking");
			}
			
		}
		


}
