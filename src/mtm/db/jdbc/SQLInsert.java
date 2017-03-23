package mtm.db.jdbc;

import mtm.db.pojos.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsert 
{	
	public void insert(Hospital hosp,Connection c) 
	{
		try
		{
			Statement stm = c.createStatement();
			
			//////////////////////////////////////////////////////////////////////
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public void insert(Order ord,Connection c)
	{
		try
		{
			Statement stm = c.createStatement();
			
			//////////////////////////////////////////////////////////////////////
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
