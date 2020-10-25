package cab_booking.driver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cab_booking.driverservice.driverRegisterService;

@WebServlet(urlPatterns = "/driver")
public class driver extends HttpServlet{
	private driverRegisterService service = new driverRegisterService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/views/driver.jsp")
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phonenumber=request.getParameter("phonenumber");
		String password=request.getParameter("password");
		String repass=request.getParameter("repass");
		String vehicleno=request.getParameter("vehicleno");
		String model=request.getParameter("model");
		String number=request.getParameter("number");
		boolean isvalid=service.dregister(name,email,phonenumber,password,repass,vehicleno,model,number);
		if(isvalid)
		response.sendRedirect("/driverlogin");
		else
			response.sendRedirect("/driver");

	}
	

}
