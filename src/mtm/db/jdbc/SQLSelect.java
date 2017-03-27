package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSelect 
{

	public boolean valIPK(String query,Connection c)
	{
		boolean a = false;
		
		try 
		{
			Statement stm = c.createStatement();
			String sql = query;
			ResultSet rs = stm.executeQuery(sql);
			if(rs.getFetchSize() == 0)//if the table is empty.....................................
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
