package cab_booking.driver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.driverservice.dloginservice;

	@WebServlet(urlPatterns = "/driverlogin")
	public class driverlogin extends HttpServlet{
		private dloginservice service = new dloginservice();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException,IOException{
			request.getRequestDispatcher("/WEB-INF/views/driverlogin.jsp")
			.forward(request, response);
			
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException,IOException{
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			
			boolean isUservalid=service.isUservalid(name,password);
			if(isUservalid){
				 HttpSession session=request.getSession();
			      session.setAttribute("dname",name);
			      boolean location=service.location(latitude,longitude,name);
			      response.sendRedirect("/confirmation");
			}
			else {
				request.setAttribute("error_message", "Inavlid credentials");
				response.sendRedirect("/driverlogin");
			}
			
		}
		

	}

