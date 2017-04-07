package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUpdate 
{

	public void update(Connection c, String table, String colChange, String stringChange, int intChange, String colSearch, int pkSearch)
	{
		
		if(stringChange == null)
		{
			try
			{
				String sql = "UPDATE "+table+" SET "+colChange+"=? WHERE "+colSearch+"=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1,intChange);
				prep.setInt(2, pkSearch);
				prep.executeUpdate();
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}else
		{
			try
			{
				String sql = "UPDATE "+table+" SET "+colChange+" LIKE ? WHERE "+colSearch+"=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1,stringChange);
				prep.setInt(2, pkSearch);
				prep.executeUpdate();
				
				prep.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}


}

