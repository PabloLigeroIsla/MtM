package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

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
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return hospitals;
	}
	
	public Hospital selectHospital(Connection c, int primaryKey)
	{
		ArrayList<Hospital> hosp = new ArrayList<Hospital>();
		ListIterator <Hospital> iterator = hosp.listIterator(hosp.size());
		Hospital hospital = new Hospital();
		Hospital hospObject = null;
		hosp = selectAllHospitals(c);

		while(iterator.hasPrevious())
			hospital = iterator.previous();
		{
			if(hospital.getHospital_ID()== primaryKey)
			{
				hospObject = hospital;
			}
		}
		return hospObject;
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
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderList;
	}
	
	public Order selectOrder(Connection c, int primaryKey)
	{
		ArrayList<Order> orderList = new ArrayList<Order>();
		ListIterator <Order> iterator = orderList.listIterator(orderList.size());
		Order orderStudy = new Order();
		Order order = null;
		orderList = selectAllOrders(c);

		while(iterator.hasPrevious())
			orderStudy = iterator.previous();
		{
			if(orderStudy.getOrderID() == primaryKey)
			{
				order = orderStudy;
			}
		}
		return order;
	}

}
