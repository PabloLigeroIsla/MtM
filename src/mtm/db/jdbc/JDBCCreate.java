package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCreate 
{
	
	private Connection c;
	
	public JDBCCreate(Connection c)
	{
		this.c = c;
	}
	//Create
	public boolean createTables()
	{
		boolean act=true;
		try
		{
			c.setAutoCommit(false);
			
			Statement fPt = c.createStatement();
			String sqlp1 = "CREATE TABLE hospital("
				+ "hospitalID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT NOT NULL,"
				+ "location TEXT NOT NULL,"
				+ "medical_specialization TEXT NOT NULL)";
			fPt.executeUpdate(sqlp1);
			fPt.close();
			
			Statement sPt = c.createStatement();
			String sqlp2 = "CREATE TABLE orders("
				+ "orderID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "total_amount_instruments INTEGER NOT NULL,"
				+ "order_date DATE NOT NULL,"
				+ "delivery_date DATE NOT NULL)";
			sPt.executeUpdate(sqlp2);
			sPt.close();
			
			Statement fAt = c.createStatement();
			String sqla1 = "CREATE TABLE company ("
					+ "companyID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "location TEXT,"
					+"companyName TEXT);";
			fAt.executeUpdate(sqla1);
			fAt.close();
			
			Statement fCht = c.createStatement();
			String sqlch1 = "CREATE TABLE instrument("
					+ "instrument_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "model TEXT NOT NULL,"
					+ "purpose TEXT NOT NULL,"
					+ "amount INTEGER NOT NULL,"
					+ "number_uses INTEGER NOT NULL,"
					+ "body_location TEXT NOT NULL,"
					+ "price INTEGER NOT NULL,"
					+ "warehouseID INTEGER REFERENCES warehouse(warehouseID))";
			fCht.executeUpdate(sqlch1);
			fCht.close();
			
			Statement sCht = c.createStatement();
			String sqlch2 = "CREATE TABLE warehouse("
					+ "warehouseID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "warehouseLocation TEXT NOT NULL,"
					+ "capacity INTEGER NOT NULL,"
					+ "filledSpace INTEGER NOT NULL)";
			sCht.executeUpdate(sqlch2);
			sCht.close();
			
			//Celia
			Statement fCt = c.createStatement();
			String sqlc1= "CREATE TABLE employee("
					+ "employee_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "typeofContract TEXT NOT NULL,"
					+ "specializationType TEXT NOT NULL,"
					+ "machineryID INTEGER,"
					+ "FOREIGN KEY (machineryID) REFERENCES machinery(machineryID) )";
			fCt.executeUpdate(sqlc1);
			fCt.close();
				
			Statement sCt = c.createStatement();
			String sqlc2= "CREATE TABLE machinery("
					+ "machineryID INTEGER PRIMARY KEY AUTOINCREMENT,"							
					+ "machineryType TEXT NOT NULL,"
					+ "stateofMachinery TEXT NOT NULL,"
					+ "dateofInstallation DATE NOT NULL,"
					+ "sizeofMachinery INTEGER NOT NULL)";
				
			sCt.executeUpdate(sqlc2);
			sCt.close();	
				
			Statement sAt = c.createStatement();
			String sqla2 =  "CREATE TABLE material ("
					+"materialID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+"weight INTEGER,"
					+"volume INTEGER,"
					+"type TEXT,"
					+"companyID  INTEGER REFERENCES company(companyID),"
					+"machineryID INTEGER REFERENCES machinery(machineryID),"
					+"warehouseID INTEGER REFERENCES warehouse(warehouseID))";
			
			sAt.executeUpdate(sqla2);
			sAt.close();
				//
			//RELATIONAL TABLES
				
			Statement rCht = c.createStatement();
			String sqlch3 = "CREATE TABLE instrument_machinery("
					+ "instrument_ID INTEGER REFERENCES instrument(instrument_ID),"
					+ "machineryID INTEGER REFERENCES machinery(machineryID),"
					+ "PRIMARY KEY (instrument_ID,machineryID))";
			rCht.executeUpdate(sqlch3);
			rCht.close();
			
			Statement fPt2 = c.createStatement();
			String sqlp4 = "CREATE TABLE instrument_orders("
					+ "orderID INTEGER REFERENCES orders(orderID),"
					+ "instrument_ID INTEGER REFERENCES instrument(instrument_ID),"
					+ "PRIMARY KEY(orderID,instrument_ID))";
			fPt2.executeUpdate(sqlp4);
			fPt2.close();
			
			Statement tPt = c.createStatement();
			String sqlp3 = "CREATE TABLE hospital_orders("
					+ "hospitalID INTEGER REFERENCES hospital(hospitalID),"
					+ "orderID INTEGER REFERENCES orders(orderID),"
					+ "PRIMARY KEY(hospitalID,orderID))";
			tPt.executeUpdate(sqlp3);
			tPt.close();
			
			Statement stmtSeq = c.createStatement();
			String sqlSeq;
			
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('hospital', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('orders', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('company', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('instrument', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('warehouse', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('employee', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('machinery', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('material', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			
			c.commit();
			c.setAutoCommit(true);
			
			act = false;
		}catch (Exception e)
		{
			act = true;
		}
		return act;
	}

}
