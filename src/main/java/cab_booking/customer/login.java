package cab_booking.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cab_booking.service.loginservice;

@WebServlet(urlPatterns = "/login")
public class login extends HttpServlet{
	private loginservice service = new loginservice();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/views/login.jsp")
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		boolean isUservalid=service.isUservalid(name,password);
		if(isUservalid){
//			request.getSession().setAttribute("name", name);
			 HttpSession session=request.getSession();
		      session.setAttribute("uname",name);
		      response.sendRedirect("/booking");
		}
		else {
			request.setAttribute("error_message", "Inavlid credentials");
			response.sendRedirect("/login");
		}
		
	}
	

}
