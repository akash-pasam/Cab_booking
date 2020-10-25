package cab_booking.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class registerservice {
	public boolean register(String name,String email,String phonenumber,String password,String repass) {
		if (password.equals(repass))
		{
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
		
		Statement s = conn.createStatement();
		
		ResultSet rs=s.executeQuery("select * from customer");
		
		s.executeUpdate("insert into customer(name,email,phonenumber,password)values('"+name+"','"+email+"','"+phonenumber+"','"+password+"')");
		return true;
		}
		catch(Exception e){
		return false;
		}
		}
		else{
			return false;
		}

		
	}
		
		
		
		
}
