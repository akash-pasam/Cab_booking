package cab_booking.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cancelservice {
	public boolean cancel(String number) {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
		String sql="delete from confirmation where phonenumber='"+number+"'";
		Statement s = conn.createStatement();
		s.executeUpdate(sql);

		s.executeUpdate("delete from booking where phonenumber='"+number+"'");
		
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
		return false;
		}
		}

}
