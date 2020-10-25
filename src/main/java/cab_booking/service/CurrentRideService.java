package cab_booking.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import cab_booking.driverservice.confirmationservice.Name;

public class CurrentRideService {
	public boolean price(String flat,String flng,String tlat,String tlng,String name) {
		String key="xRY0IAhuypFLZAIjm59RoNwpR3omCb6P";
		String targetURL="https://api.tomtom.com/routing/1/calculateRoute/"+flat+"%2C"+flng+"%3A"+tlat+"%2C"+tlng+
				"/json?traffic=true&avoid=unpavedRoads&key="+key;
		
		HttpURLConnection connection = null;
		 try {
			    //Create connection
			    URL url = new URL(targetURL);
			    connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestProperty("Content-Type", 
			        "application/x-www-form-urlencoded");
			    connection.setRequestProperty("Content-Language", "en-US");  
			    connection.setUseCaches(false);
			    connection.setDoOutput(true);
			    InputStream is = connection.getInputStream();
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			    String line;
			    while ((line = rd.readLine()) != null) {
			      response.append(line);
			      response.append('\r');
			    }
			    rd.close();
			    JSONObject myresponse=new JSONObject (response.toString());
			    JSONArray matches = myresponse.optJSONArray("routes");
			    JSONObject object = matches.getJSONObject(0);
			    JSONObject summary=new JSONObject (object.getJSONObject("summary").toString());
			    Integer Distance=summary.getInt("lengthInMeters");
			    Integer time=summary.getInt("travelTimeInSeconds");
			    boolean data=data(flat,flng,tlat,tlng,name,Distance,time);
			  } catch (Exception e) {
			    e.printStackTrace();
			  } finally {
			    if (connection != null) {
			      connection.disconnect();
			    }
			  }
		 return true;
	}
	public boolean data(String flat,String flng,String tlat,String tlng,String name,Integer Distance,Integer time) {
		 try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?"
						+ "autoReconnect=true&useSSL=false","root","admin@123");
				
				Statement s = conn.createStatement();
				
				String sql="select phonenumber from customer where email='"+name+"'";
				ResultSet rs=s.executeQuery(sql);
				String phonenumber=null;
				if(rs.next()) {
					phonenumber=rs.getString(1);
				}
				String sql1="select bookingid from confirmed_cabs where u_phonenumber='"+phonenumber+"'";
				rs=s.executeQuery(sql1);
				Integer bookingid=0;
				if(rs.next()) {
					bookingid=rs.getInt(1);
				}
				rs=s.executeQuery("select d_latitude,d_longitude from driver_location where d_phonenumber='"+phonenumber+"'");
				String dlatitude="";
				String dlongitude="";
				if(rs.next()) {
					dlatitude=rs.getString(1);
					dlongitude=rs.getString(2);
				}
				String sql2="insert into location(bookingid,fLatitude,fLongitude,tLatitude,tLongitude,dlatitude,dlongitude,Distance,time) "
						+ "values('"+bookingid+"','"+flat+"','"+flng+"','"+tlat+"','"+tlng+"','"+dlatitude+"','"+dlongitude+"','"+Distance+"','"+time+"') ";
				s.executeUpdate(sql2);
			}
				catch(Exception e){
				return false;
				}
		 return true;
	}
	
}