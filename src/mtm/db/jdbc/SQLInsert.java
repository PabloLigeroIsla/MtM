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
			
			String sql = "INSERT INTO hospital(name,location,medical_specialization)"
					+ "VALUES('"+ hosp.getName() + "','"+ hosp.getLocation() +"','"+ hosp.getMedical_specialization() +"');";
			stm.executeUpdate(sql);
			stm.close();
			
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
			
			String sql = "INSERT INTO orders(total_amount_instruments,order_date,delivery_date)"
					+ "VALUES("+ ord.getTotal_amount_instruments() +",'"+ ord.getOrder_Date() +"','"+ ord.getDelivery_Date() +"');";
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
