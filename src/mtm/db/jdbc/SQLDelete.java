package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLDelete 
{
	// One method of delete for each POJO.
	// The method must delete the row with the "primaryKey", with the Quarry that select this
	// 		value
	
	//Charo
	public void deleteInstrument(Connection c, int pkInstrument)
	{
		try
		{
			String sql = "DELETE FROM instrument WHERE instrumentID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkInstrument);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteWarehouse(Connection c, int pkWarehouse)
	{
		try
		{
			String sql = "DELETE FROM warehouse WHERE warehouseID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkWarehouse);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//Celia
	public void deleteEmployee(Connection c, int pk)
	{
		try
		{
			String sql = "DELETE FROM employee WHERE employee_ID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteMachinery(Connection c, int pk)
	{
		try
		{
			String sql = "DELETE FROM machinery WHERE machineryType = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}	
	//Alex
	
	//Pablo
	public void deleteHospital(Connection c, int pk)
	{
		try
		{
			String sql = "DELETE FROM hospital WHERE hospital_ID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteOrder(Connection c, int pk)
	{
		try
		{
			String sql = "DELETE FROM orders WHERE order_ID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//Delete Relations
	
	public void deleteRelationNtoN(Connection c,String table, String colPk,int pkCol)
	{
		try
		{
			String sql = "DELETE FROM "+table+" WHERE "+colPk+" = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkCol);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
