package cab_booking.driverservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class confirmationservice {
	public class Name
	{
	    private String phonenumber;
	    private String fromlocation;
	    private String tolocation;
	    private String passengers;
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
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
	
	public ArrayList values(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false","root","admin@123");
			
			Statement s = conn.createStatement();
			ArrayList<Name> list=new ArrayList<Name>();
			Name name= null;
			
			ResultSet rs=s.executeQuery("select * from booking");
			while(rs.next()) {
				name = new Name();
			name.setPhonenumber(rs.getString(1));
			name.setFromlocation(rs.getString(2));
			name.setTolocation(rs.getString(3));
			name.setPassengers(rs.getString(4));
			list.add(name);
			
			}
			return list;
		}
			catch(Exception e){
				
			return null;
			}
	}
	public boolean isConfirmed(String number,String dname) {
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false",
					"root","admin@123");
			
			Statement s = conn.createStatement();
			String sql="update confirmation set status='confirmed' where phonenumber='"+number+"'";
			ResultSet rs = s.executeQuery("select * from driver where Email='"+dname+"'");
			String phonenumber=null;
			String vehicleno=null;
			int price=1;
			if(rs.next()) {
			
			phonenumber=rs.getString(2);
			vehicleno=rs.getString(5);
			}
			rs=s.executeQuery("select * from confirmation where phonenumber='"+number+"'");
			String fromlocation=null;
			String tolocation=null;
			if(rs.next()) {
			
				fromlocation=rs.getString(2);
				tolocation=rs.getString(3);
			}
			
			s.executeUpdate(sql);
			String sql1="insert into confirmed_cabs(u_phonenumber,d_phonenumber,vehiclenumber,fromlocation,tolocation,price) "
					+ "values('"+number+"','"+phonenumber+"','"+vehicleno+"','"+fromlocation+"','"+tolocation+"','"+price+"')";
			s.executeUpdate(sql1);
			return true;
		}
			catch(Exception e){
			return false;
			}
			}
	}

