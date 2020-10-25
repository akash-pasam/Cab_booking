package cab_booking.customer;

import java.io.IOException;
import java.net.URLEncoder;

import cab_booking.service.Cancelservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cab_booking.service.bookingservice;

@WebServlet(urlPatterns = "/cancelled")

public class Cancellation extends HttpServlet{
	private Cancelservice service=new Cancelservice();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		String phonenumber=request.getParameter("number"); 
		boolean cancelled=service.cancel(phonenumber);
		if(cancelled) {
			String message = "Booking Cancelled";
			
			response.sendRedirect("index?message=" + URLEncoder.encode(message, "UTF-8"));
//		request.getRequestDispatcher("/WEB-INF/views/index.jsp")
//		.forward(request, response);
		}
		else {
			response.sendRedirect("/booking");
		}
		
	}

}
