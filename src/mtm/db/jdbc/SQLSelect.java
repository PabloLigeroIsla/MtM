package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mtm.db.pojos.*;


public class SQLSelect 
{
	//Pablo
	
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

	//Charo
	
	//al insertar un instrumento, cuando tengo que rellenar el campo de warehouse meto un nombre, le doy la lista, lo busca con un cearch y lo coje con select
	//cuando tenga que 
	
	
	public Instrument selectInstrument(Connection c, String query, int pkInstrument)
	{
		Instrument instrument = null;
		int instrumentID;
		
		//atributos de instrument
		String model;
		String purpose;
		Integer amount;
		Integer numberUses;
		String bodyLocation;
		Integer price;
		Integer warehouseID;
		
		
		try
		{
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkInstrument);
			ResultSet rs = prep.executeQuery();
			
			while (rs.next()) 
			{
				instrumentID = rs.getInt("instrumentID");
				model = rs.getString("model");
				purpose = rs.getString("purpose");
				amount = rs.getInt("amount");
				numberUses = rs.getInt("numberUses");
				bodyLocation = rs.getString("bodyLocation");
				price = rs.getInt("price");
				/*warehouseID = rs.getInt("warehouseID");
				Warehouse ware = new Warehouse();
				ware = selectWarehouse(c,sql,warehouseID);
				//warehouseLocation = rs.getString("warehouseLocation");
				*/
				instrument = new Instrument(instrumentID,model,purpose,amount,numberUses,bodyLocation,price);
			}
			
			prep.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		
		return instrument;
	}
	
	
	
	public ArrayList<Instrument> selectAllInstruments(Connection c)
	{
		ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
		try
		{
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM instrument";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next());
			{
				int instrumentID = rs.getInt("instrumentID");
				String model = rs.getString("model");
				String purpose = rs.getString("purpose");
				int amount = rs.getInt("amount");
				int numberUses = rs.getInt("numberUses");
				String bodyLocation = rs.getString("bodyLocation");
				int price = rs.getInt("price");
				
				//debo hacer la relacion para meter el objeto
				//warehouseLocation = rs.getString("warehouseLocation");
				
				Instrument instrument = new Instrument(instrumentID,model,purpose,amount,numberUses,bodyLocation,price);
				instrumentList.add(instrument);
			}
			
			stmt.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return instrumentList;
	}
	
	public Warehouse selectWarehouse(Connection c, String query, int pkWarehouse)
	{
		Warehouse warehouse = null;
		
		//atributos de warehouse
		int warehouseID;
		String warehouseLocation;
		Integer capacity;
		Integer filledSpace;
		
		
		try
		{
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkWarehouse);
			ResultSet rs = prep.executeQuery();
			
			while (rs.next()) 
			{
				warehouseID = rs.getInt("warehouseID");
				warehouseLocation = rs.getString("warehouseLocation");
				capacity = rs.getInt("capacity");
				filledSpace = rs.getInt("filledSpace");
			
				warehouse = new Warehouse(warehouseID,warehouseLocation,capacity,filledSpace);
			}
			
			prep.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		
		return warehouse;
	}
	
	//no me hace falta una lista de Warehouse porque solo hay uno en el que está todo, instruments and materials
	
	
	//Celia
	
	//Alex
}
