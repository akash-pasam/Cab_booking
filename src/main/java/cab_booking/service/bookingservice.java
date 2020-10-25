	package cab_booking.service;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

	public class bookingservice {
		public boolean booking(String from_location,String to_location,String number,String Email) {
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from customer where Email='"+Email+"'");
			String phonenumber=null;
			if(rs.next()) {
			
			phonenumber=rs.getString(3);
			}
			s.executeUpdate("insert into booking values('"+phonenumber+"','"+from_location+"','"+to_location+"','"+number+"')");
			s.executeUpdate("insert into confirmation(phonenumber,fromlocation,tolocation,passengers)values('"+phonenumber+"','"+from_location+"','"+to_location+"','"+number+"')");
			return true;
			}
			catch(Exception e){
				
			return false;
			}
			}

			
		}
