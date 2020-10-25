package cab_booking.driverservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class yourRideService {

	
	public class Name
	{
		private String bookingid;
		private String u_phonenumber;
	    private String d_phonenumber;
	    private String fromlocation;
	    private String vehicleno;
	    private String tolocation;
	    private String price;
	    
		
		public String getFromlocation() {
			return fromlocation;
		}
		public void setFromlocation(String fromlocation) {
			this.fromlocation = fromlocation;
		}
		public String getTolocation() {
			return tolocation;
		}
		public void setTolocation(String tolocation) {
			this.tolocation = tolocation;
		}
		public String getBookingid() {
			return bookingid;
		}
		public void setBookingid(String bookingid) {
			this.bookingid = bookingid;
		}
		public String getU_phonenumber() {
			return u_phonenumber;
		}
		public void setU_phonenumber(String u_phonenumber) {
			this.u_phonenumber = u_phonenumber;
		}
		public String getD_phonenumber() {
			return d_phonenumber;
		}
		public void setD_phonenumber(String d_phonenumber) {
			this.d_phonenumber = d_phonenumber;
		}
		public String getVehicleno() {
			return vehicleno;
		}
		public void setVehicleno(String vehicleno) {
			this.vehicleno = vehicleno;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
	}
	
	public ArrayList values(String Email){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
			
			Statement s = conn.createStatement();
			ArrayList<Name> list=new ArrayList<Name>();
			Name name= null;
			
			ResultSet rs=s.executeQuery("select phonenumber from driver where email='"+Email+"'");
			String phonenumber=null;
			if(rs.next()) {
			phonenumber=rs.getString(1);
			}
			rs=s.executeQuery("select * from confirmed_cabs where d_phonenumber='"+phonenumber+"'");
			while(rs.next()) {
				name = new Name();
			name.setBookingid(rs.getString(1));	
			name.setU_phonenumber(rs.getString(2));
			name.setD_phonenumber(rs.getString(3));
			name.setVehicleno(rs.getString(4));
			name.setFromlocation(rs.getString(5));
			name.setTolocation(rs.getString(6));
			name.setPrice(rs.getString(7));
			list.add(name);
			
			}
			return list;
		}
			catch(Exception e){
				
			return null;
			}
	}
}
