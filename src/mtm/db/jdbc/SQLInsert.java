package mtm.db.jdbc;

import mtm.db.pojos.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsert 
{	
	
	//Pablo
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
	
	//Charo
	public void insert(Instrument instr,Connection c) 
	{
		try
		{
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO instrument(model,purpose,amount,number_uses,body_location,price,warehouse_location)"
					+ "VALUES ('" + instr.getModel() +"','" +instr.getPurpose() + "','"+ instr.getAmount() + "','"+ instr.getNumber_uses() + "','"+ instr.getBody_location() + "','"+instr.getPrice()+"','"+instr.getWarehouse_location()+"');";
			stmCh.executeUpdate(sqlCh);
			stmCh.close();							
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Warehouse wareh,Connection c) 
	{
		try
		{
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO warehouse (warehouse_location,capacity,filled_space)"
					+ "VALUES ('" + wareh.getWarehouse_location() +"','" +wareh.getCapacity() + "','"+ wareh.getFilled_space() +"');";
			stmCh.executeUpdate(sqlCh);
			stmCh.close();							
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//Celia
	
	
	
	
	
	
	//Alex
	
	
	
	
	


}
