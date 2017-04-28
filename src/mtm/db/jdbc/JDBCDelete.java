package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDelete 
{
	private Connection c;
	
	public JDBCDelete(Connection c)
	{
		this.c = c;
	}
	//Delete
			public void deleteInstrument( int pkInstrument)
		{
			try
			{
				String sql = "DELETE FROM instrument WHERE instrument_ID = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pkInstrument);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
			public void deleteWarehouse( int pkWarehouse)
		{
			try
			{
				String sql = "DELETE FROM warehouse WHERE warehouse_ID = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pkWarehouse);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
			//Celia
			public void deleteEmployee( int pk)
		{
			try
			{
				String sql = "DELETE FROM employee WHERE employee_ID = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
			public void deleteMachinery( int pk)
		{
			try
			{
				String sql = "DELETE FROM machinery WHERE machineryType = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
			//Alex
			
			public void deleteCompany(int pk)
			{
				try
				{
					String sql = "DELETE FROM company WHERE company_id = ?";
					PreparedStatement prep = c.prepareStatement(sql);
					prep.setInt(1, pk);
					prep.executeUpdate();
					System.out.println("Deletion finished\n");
					
					prep.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			public void deleteMaterial(int pk)
			{
				try
				{
					String sql = "DELETE FROM material WHERE material_id = ?";
					PreparedStatement prep = c.prepareStatement(sql);
					prep.setInt(1, pk);
					prep.executeUpdate();
					System.out.println("Deletion finished\n");
					
					prep.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}

			
			
			//Pablo
			public void deleteHospital( int pk)
		{
			try
			{
				String sql = "DELETE FROM hospital WHERE hospital_ID = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
			public void deleteOrder( int pk)
		{
			try
			{
				String sql = "DELETE FROM orders WHERE order_ID = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
			//Delete Relations
		
			public void deleteRelationNtoN(String table, String colPk,int pkCol)
		{
			try
			{
				String sql = "DELETE FROM "+table+" WHERE "+colPk+" = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pkCol);
				prep.executeUpdate();
				System.out.println("Deletion finished\n");
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		
}
