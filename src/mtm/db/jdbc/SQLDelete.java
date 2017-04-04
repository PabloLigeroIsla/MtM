package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDelete 
{
	// One method of delete for each POJO.
	// The method must delete the row with the "primaryKey", with the Quarry that select this
	// 		value
	
	//Charo
	
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
}
