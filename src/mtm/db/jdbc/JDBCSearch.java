package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCSearch 
{
	private Connection c;
	
	public JDBCSearch(Connection c)
	{
		this.c = c;
	}
	
	//Search
	public boolean valPKInt(String query, int numb)
	{
		boolean a = false;
		
		try 
		{
			int count = 0;
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, numb);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
			{
				count = count +1;
			}
		
			if(count == 0){
				//We dont find the 
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

	public boolean valPKString(String query, String string)
	{
		boolean a = false;
	
		try 
		{
			int count = 0;
			
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, "%"+string+"%");
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
		
	public boolean valPK2(String query)
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

	public boolean valGen(String query)
	{
		boolean resp = false;
		try
		{
			int count = 0;
			String sql = query;
			PreparedStatement prep = c.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
			{
				count = count +1;
			}
		
			if(count == 0){
				//We dont find the 
				resp = false;
			}else
			{
				resp = true;
			}
			
			prep.close();
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public ArrayList<Integer> searchPkRelation(String query,int pk,String colAtSearch)
	{
		ArrayList<Integer> pkArray = new ArrayList<Integer>();
		try
		{
			
			PreparedStatement prep = c.prepareStatement(query);
			prep.setInt(1, pk);
			ResultSet rs = prep.executeQuery();
		
			while(rs.next())
			{
				int pkFound = rs.getInt(colAtSearch);
				pkArray.add(pkFound);
			}
			rs.close();
			prep.close();
				
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return pkArray;
			
	}
		
}
