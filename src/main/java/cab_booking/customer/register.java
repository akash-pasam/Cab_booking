package cab_booking.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cab_booking.service.registerservice;

@WebServlet(urlPatterns = "/register")
public class register extends HttpServlet{
	private registerservice service = new registerservice();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/views/register.jsp")
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phonenumber=request.getParameter("phonenumber");
		String password=request.getParameter("password");
		String repass=request.getParameter("repass");
		boolean isvalid=service.register(name,email,phonenumber,password,repass);
		if(isvalid)
		response.sendRedirect("/login");
		else
			response.sendRedirect("/register");

	}
	

}
