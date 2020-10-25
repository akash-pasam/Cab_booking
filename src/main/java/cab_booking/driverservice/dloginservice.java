package cab_booking.driverservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dloginservice {
public boolean isUservalid(String username,String password) {
		
		
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
		
		Statement s = conn.createStatement();
		
		ResultSet rs=s.executeQuery("select * from driver where Email='"+username+"'");
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
public boolean location(String latitude,String longitude,String name) {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
		
		Statement s = conn.createStatement();
		ResultSet rs=s.executeQuery("select phonenumber from driver where Email='"+name+"'");
		String phonenumber=null;
		if(rs.next()) {
			phonenumber=rs.getString(1);
		}
		String sql="update driver_location set d_latitude='"+latitude+"',d_longitude='"+longitude+"' where d_phonenumber='"+phonenumber+"'";
		s.executeUpdate(sql);
	}
		catch(Exception e){
		return false;
		}
	return true;
		}
}
