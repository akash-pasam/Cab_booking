package cab_booking;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class logout extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		HttpSession session=request.getSession();
	      session.invalidate();
	      String message = "Logout successful";
			response.sendRedirect("index?message="+ URLEncoder.encode(message, "UTF-8"));
		
	}
}
