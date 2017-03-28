package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSearch 
{
	
	public boolean valPK1(String query,Connection c)
	{
		boolean a = false;
		
		try 
		{
			Statement stm = c.createStatement();
			String sql = query;
			ResultSet rs = stm.executeQuery(sql);
			if(rs.getFetchSize() == 0){
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
	
	public boolean valPK2(String query,Connection c)
	{
		boolean a = false;
		
		try 
		{
			
			Statement stm = c.createStatement();
			String sql = query;
			ResultSet rs = stm.executeQuery(sql);
			int count = 0;
			//count = rs.getRow()
			while(rs.next())
			{
				count++;
			}
			
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
	
	public boolean valPK3(String query,Connection c)
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
