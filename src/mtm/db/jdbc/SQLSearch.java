package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSearch 
{
	
	public boolean valPKInt(String query,Connection c, int numb)
	{
		boolean a = false;
		
		try 
		{
			int count = 0;
			Statement stm = c.createStatement();
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, numb);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
			{
				count = count +1;
			}
			
			if(count == 0){
				a = false;
			}else
			{
				a = true;
			}
			
			stm.close();
			prep.close();
			rs.close();
		} catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		return a;
	}

	public boolean valPKString(String query,Connection c, String string)
	{
boolean a = false;
		
		try 
		{
			int count = 0;
			
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, string);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
			{
				count = count +1;
			}
			
			if(count == 0){
				a = false;
			}else
			{
				a = true;
			}
			prep.close();
			rs.close();
		} catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		return a;
	}
	
	public boolean valPK2(String query,Connection c)
	{
		boolean a = false;
		
		try 
		{
			
			Statement stm = c.createStatement();
			String sql = query;
			ResultSet rs = stm.executeQuery(sql);
			int count = 0;
			count = rs.getRow();
			
			if(count == 0)
			{
				stm.close();
				a = false;
			}else
			{
				stm.close();
				a = true;
			}
			
		} catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		return a;
	}

	
	
}
