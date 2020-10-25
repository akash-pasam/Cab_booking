package cab_booking.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginservice {
	public boolean isUservalid(String username,String password) {
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
			
			Statement s = conn.createStatement();
			
			ResultSet rs=s.executeQuery("select * from customer where Email='"+username+"'");
			if(rs.next()) {
				
			if(rs.getString(4).equals(password))
			
			return true;
			}
		}
			catch(Exception e){
			return false;
			}
		return false;
			}
}
