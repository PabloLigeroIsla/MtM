package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCreate 
{
	
	public void createTables(Connection c)
	{
		try
		{
			//Pablo
			// fPt -->firstPablotable //sqlp1 --> sqlpablo1
			Statement fPt = c.createStatement();
			String sqlp1 = "CREATE TABLE hospital("
				+ "hospital_ID    INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT NOT NULL,"
				+ "location TEXT NOT NULL,"
				+ "medical_specialization TEXT NOT NULL)";
			fPt.executeUpdate(sqlp1);
			fPt.close();

			Statement sPt = c.createStatement();
			String sqlp2 = "CREATE TABLE orders("
				+ "order_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "total_amount_instruments INTEGER NOT NULL,"
				+ "order_date DATE NOT NULL,"
				+ "delivery_date DATE NOT NULL)";
			sPt.executeUpdate(sqlp2);
			sPt.close();
			
			//Alex
			// fAt -->firstAlextable // sqla1 --> sqlalex1
			Statement fAt = c.createStatement();
			String sqla1 = "CREATE TABLE company ("
					+ "resource TEXT PRIMARY KEY,"
					+ "location TEXT,"
					+"company_name TEXT);";
			fAt.executeUpdate(sqla1);
			fAt.close();
			
			Statement sAt = c.createStatement();
			String sqla2 =  "CREATE TABLE materials ("
							+"material_id INTEGER PRIMARY KEY AUTOINCREMENT,"
							+"weight INTEGER,"
							+"volume INTEGER,"
							+"material_provided  TEXT REFERENCES company(resource),"
							+"machinery_type TEXT REFERENCES machinery(type));";
			sAt.executeUpdate(sqla2);
			sAt.close();
			
			//Alex
			
			//Charo
			// fCht -->firstCharotable //sqlch1 --> sqlcharo1
			Statement fCht = c.createStatement();
			String sqlch1 = "CREATE TABLE instrument("
					+ "instrument_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "model TEXT NOT NULL,"
					+ "purpose TEXT NOT NULL,"
					+ "amount INTEGER NOT NULL,"
					+ "number_Uses INTEGER NOT NULL,"
					+ "body_location TEXT NOT NULL,"
					+ "price INTEGER NOT NULL,"
					+ "warehouse_location TEXT REFERENCES warehouse (warehouse_location))";
			fCht.executeUpdate(sqlch1);
			fCht.close();
			
			Statement sCht = c.createStatement();
			String sqlch2 = "CREATE TABLE warehouse("
					+ "warehouse_location TEXT PRIMARY KEY NOT NULL,"
					+ "capacity INTEGER NOT NULL,"
					+ "filled_space INTEGER NOT NULL)";
			sCht.executeUpdate(sqlch2);
			sCht.close();
			
			
			
			
			//Celia
			Statement fCt = c.createStatement();
			String sqlc1= "CREATE TABLE employee("
					+ "employee_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "typeofContract TEXT NOT NULL,"
					+ "specializationType TEXT NOT NULL,"
					+ "machineryType TEXT,"
					+ "FOREIGN KEY (machineryType) REFERENCES machinery(machineryType) )";
			fCt.executeUpdate(sqlc1);
			fCt.close();
				
			Statement sCt = c.createStatement();
				String sqlc2= "CREATE TABLE machinery("
				+ "machineryType TEXT PRIMARY KEY,"
				+ "stateofMachinery TEXT NOT NULL,"
				+ "dateofInstallation DATE,"
				+ "sizeofMachinery INTEGER)";

				sCt.executeUpdate(sqlc2);
				sCt.close();	

			
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
		
	}
	
	//Pablo
	public void createTableHospital(Connection c)
	{
		try
		{
			Statement fPt = c.createStatement();
			String sqlp1 = "CREATE TABLE hospital("
				+ "hospital_ID    INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT NOT NULL,"
				+ "location TEXT NOT NULL,"
				+ "medical_specialization TEXT NOT NULL)";
			fPt.executeUpdate(sqlp1);
			fPt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void createTableOrder(Connection c)
	{
		try
		{
			Statement sPt = c.createStatement();
			String sqlp2 = "CREATE TABLE orders("
				+ "order_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "total_amount_instruments INTEGER NOT NULL,"
				+ "order_date DATE NOT NULL,"
				+ "delivery_date DATE NOT NULL)";
			sPt.executeUpdate(sqlp2);
			sPt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//Charo
	
	public void createTableInstrument(Connection c)
	{
		try
		{
			Statement fCht = c.createStatement();
			String sqlch1 = "CREATE TABLE instrument("
					+ "instrument_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "model TEXT NOT NULL,"
					+ "purpose TEXT NOT NULL,"
					+ "amount INTEGER NOT NULL,"
					+ "number_Uses INTEGER NOT NULL,"
					+ "body_location TEXT NOT NULL,"
					+ "price INTEGER NOT NULL,"
					+ "warehouse_location TEXT REFERENCES warehouse (warehouse_location))";
			fCht.executeUpdate(sqlch1);
			fCht.close();
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
	}
	
	
	public void createTableWarehouse(Connection c)
	{
		try
		{
			Statement sCht = c.createStatement();
			String sqlch2 = "CREATE TABLE warehouse("
					+ "warehouse_location TEXT PRIMARY KEY NOT NULL,"
					+ "capacity INTEGER NOT NULL,"
					+ "filled_space INTEGER NOT NULL)";
			sCht.executeUpdate(sqlch2);
			sCht.close();
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
	}
	
	//Celia
	public void createTableEmployee(Connection c)
	{
		try
		{
			Statement fCt = c.createStatement();
			String sqlc1 =  "CREATE TABLE employee("
					+ "employee_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "typeofContract TEXT NOT NULL,"
					+ "specializationType TEXT NOT NULL,"
					+ "machineryType TEXT,"
					+ "FOREIGN KEY (machineryType) REFERENCES machinery(machineryType) )";
			fCt.executeUpdate(sqlc1);
			fCt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void createTableMachinery(Connection c)
	{
		try
		{
			Statement sCt = c.createStatement();
			String sqlc2 = "CREATE TABLE machinery("
					+ "machineryType TEXT PRIMARY KEY,"
					+ "stateofMachinery TEXT NOT NULL,"
					+ "dateofInstallation DATE,"
					+ "sizeofMachinery INTEGER)";
			sCt.executeUpdate(sqlc2);
			sCt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
