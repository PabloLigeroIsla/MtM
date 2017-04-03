package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mtm.db.pojos.*;


public class SQLSelect 
{
	
	public ArrayList<Hospital> selectAllHospitals(Connection c)
	{
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
		try
		{
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM hospital";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next());
			{
				int hospitalID = rs.getInt("hospital_ID");
				String name = rs.getString("name");
				String location = rs.getString("location");
				String medicalSpecialization = rs.getString("medical_Specializaton");
				
				Hospital hosp = new Hospital(hospitalID,name,location,medicalSpecialization);
				hospitals.add(hosp);
			}
			
			stmt.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return hospitals;
	}
	
	public Hospital selectHospital(Connection c, String query, int pk)
	{
		Hospital hosp = null;
		int hospitalID;
		String name, location,medicalSpecialization;
		
		try
		{
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			ResultSet rs = prep.executeQuery();
			
			while (rs.next()) 
			{
				hospitalID = rs.getInt("hospital_ID");
				name = rs.getString("name");
				location = rs.getString("location");
				medicalSpecialization = rs.getString("medical_Specializaton");
				
				hosp = new Hospital(hospitalID,name,location,medicalSpecialization);
			}
			
			prep.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		
		return hosp;
	}
	
	public Hospital selectHospital(Connection c, String query, String nameHosp)
	{
		Hospital hosp = null;
		int hospitalID;
		String name, location,medicalSpecialization;
		
		try
		{
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, nameHosp);
			ResultSet rs = prep.executeQuery();
			
			while (rs.next()) 
			{
				hospitalID = rs.getInt("hospital_ID");
				name = rs.getString("name");
				location = rs.getString("location");
				medicalSpecialization = rs.getString("medical_Specializaton");
				
				hosp = new Hospital(hospitalID,name,location,medicalSpecialization);
			}
			
			prep.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		
		return hosp;
	}
	
	public ArrayList<Order> selectAllOrders(Connection c)
	{
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		try
		{
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM hospital";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next());
			{
				int orderID = rs.getInt("order_ID");
				int totalAmountInstruments = rs.getInt("total_amount_instrument");
				java.sql.Date orderDate = rs.getDate("order_date");
				java.sql.Date deliveryDate = rs.getDate("delivery_date");
				
				Order order = new Order(orderID,totalAmountInstruments,orderDate,deliveryDate);
				orderList.add(order);
			}
			
			stmt.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderList;
	}
	
	public Order selectOrder(Connection c, String query, int pk)
	{
		
		Order order = null;
		
		try
		{
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
			{
				int orderID = rs.getInt("order_ID");
				int totalAmountInstruments = rs.getInt("total_amount_instrument");
				java.sql.Date orderDate = rs.getDate("order_date");
				java.sql.Date deliveryDate = rs.getDate("delivery_date");
				
				order = new Order(orderID,totalAmountInstruments,orderDate,deliveryDate);
				
			}
			
			prep.close();
			rs.close();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
	}

}
