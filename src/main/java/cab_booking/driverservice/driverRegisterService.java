package cab_booking.driverservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class driverRegisterService {
	public boolean dregister(String name,String email,String phonenumber,String password,
			String repass,String vehicleno,String model,String number) {
		if (password.equals(repass))
		{
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
		
		Statement s = conn.createStatement();
		
		ResultSet rs=s.executeQuery("select * from customer");
		String sql="insert into driver_location(d_phonenumber) values('"+phonenumber+"') ";
		s.executeUpdate("insert into driver(name,phonenumber,email,password,vehicleno,modelname,seater)values('"+name+"','"+phonenumber+"','"+email+"','"+password+"','"+vehicleno+"','"+model+"','"+number+"')");
		s.executeUpdate(sql);
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

