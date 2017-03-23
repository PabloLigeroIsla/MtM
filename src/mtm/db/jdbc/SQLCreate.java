package mtm.db.jdbc;

import java.sql.Connection;
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
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
		
	}
	

}
