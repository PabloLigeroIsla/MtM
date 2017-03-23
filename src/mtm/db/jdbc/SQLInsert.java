package mtm.db.jdbc;

import mtm.db.pojos.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	//Celia
	public void insert(Employee emp,Connection c) throws IOException 
	{
		try
		{			
			Statement stmt = c.createStatement();
			String sql = "INSERT INTO employee (name, typeofContract,specializationType) "
					+ "VALUES ('" + emp.getName() + "', '" + emp.getTypeofContract()	+ "', '" + emp.getSpecializationType()	+ "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Employee information processed");
			System.out.println("Records inserted.");
			
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public void insert(Machinery mach,Connection c) throws IOException
	{
		try
		{
			Statement stmt = c.createStatement();
			
			String sql = "INSERT INTO machinery (machineryType, stateofMachinery,dateofInstallation,sizeofMachinery) "
					+ "VALUES ('" + mach.getMachineryType() + "', '" + mach.getStateofMachinery()	+ "', '" + mach.getDateofInstallation()	+ "', '" + mach.getSizeofMachinery()	+ "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Machinery information processed");
			System.out.println("Records inserted.");			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
