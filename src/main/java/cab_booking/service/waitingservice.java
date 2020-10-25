package cab_booking.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class waitingservice{
	public class Name
	{
	    private String phonenumber;
	    private String fromlocation;
	    private String tolocation;
	    private String passengers;
	    private String status;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String Phonenumber) {
			this.phonenumber = Phonenumber;
		}
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
		public String getPassengers() {
			return passengers;
		}
		public void setPassengers(String passengers) {
			this.passengers = passengers;
		}
	}
	public String username;
	public String uname(String uname) {
		this.username=uname;
		return null;
	}

	public ArrayList values(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
			Statement s = conn.createStatement();
			ArrayList<Name> list=new ArrayList<Name>();
			Name name= null;
			ResultSet rs = s.executeQuery("select * from customer where Email='"+username+"'");
			String phonenumber=null;
			if(rs.next()) {
			
			phonenumber=rs.getString(3);
			}
			rs=s.executeQuery("select * from confirmation where phonenumber='"+phonenumber+"'");
			while(rs.next()) {
			name = new Name();
			
			name.setPhonenumber(rs.getString(1));
			name.setFromlocation(rs.getString(2));
			name.setTolocation(rs.getString(3));
			name.setStatus(rs.getString(4));
			name.setPassengers(rs.getString(5));
			list.add(name);
			
			}
			return list;
			
		}
			catch(Exception e){
				e.printStackTrace();
			return null;
			}
	}
}
