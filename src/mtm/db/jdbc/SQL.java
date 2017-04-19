package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mtm.db.pojos.Company;
import mtm.db.pojos.Employee;
import mtm.db.pojos.Hospital;
import mtm.db.pojos.Instrument;
import mtm.db.pojos.Machinery;
import mtm.db.pojos.Material;
import mtm.db.pojos.Order;
import mtm.db.pojos.Warehouse;



public class SQL 
{
	Connection c = openConnection();
	
	
	//Create
		public void createTables()
	{
		try
		{
			c.setAutoCommit(false);
			//Pablo
			// fPt -->firstPablotable , sqlp1 --> sqlpablo1
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
			
			Statement tPt = c.createStatement();
			String sqlp3 = "CREATE TABLE hospital_orders("
					+ "hospital_ID INTEGER REFERENCES hospital(hospital_ID),"
					+ "order_ID INTEGER REFERENCES orders(order_ID),"
					+ "PRIMARY KEY(hospital_ID,order_ID))";
			tPt.executeUpdate(sqlp3);
			tPt.close();
			
			Statement fPt2 = c.createStatement();
			String sqlp4 = "CREATE TABLE instrument_orders("
					+ "order_ID INTEGER REFERENCES orders(order_ID),"
					+ "instrument_ID INTEGER REFERENCES instrument(instrument_ID),"
					+ "amount_order INTEGER,"
					+ "PRIMARY KEY(order_ID,instrument_ID))";
			fPt2.executeUpdate(sqlp4);
			fPt2.close();
			
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

			
			
			c.commit();
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
		
	}
	
		//Pablo
		public void createTableHospital()
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
		public void createTableOrder()
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
	
		//Alex
		public void createTableMaterial(){
		try
		{
		Statement sAt = c.createStatement();
		String sqla2 =  "CREATE TABLE material ("
				+"material_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"weight INTEGER NOT NULL,"
				+"volume INTEGER NOT NULL,"
				+"company_ID  TEXT REFERENCES company(company_id),"
				+"machinery_ID TEXT REFERENCES machinery(machinery_id));";

		sAt.executeUpdate(sqla2);
		sAt.close();
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
	}	
		public void createTableCompany(){
			try
			{
				Statement fAt = c.createStatement();
				String sqla1 = "CREATE TABLE company ("
						+ "company_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ "location TEXT,"
						+"company_name TEXT);";

				fAt.executeUpdate(sqla1);
				fAt.close();
				
			}catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("Conection Error, Ask Rodrigo for Help");
			
			}
		}
		
		//Charo
	
		public void createTableInstrument()
	{
		try
		{
			Statement fCht = c.createStatement();
			String sqlch1 = "CREATE TABLE instrument("
					+ "instrument_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "model TEXT NOT NULL,"
					+ "purpose TEXT NOT NULL,"
					+ "amount INTEGER NOT NULL,"
					+ "numberUses INTEGER NOT NULL,"
					+ "bodyLocation TEXT NOT NULL,"
					+ "price INTEGER NOT NULL,"
					+ "warehouseID INTEGER REFERENCES warehouse (warehouseID))";
			fCht.executeUpdate(sqlch1);
			fCht.close();
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
	}	
		public void createTableWarehouse()
	{
		try
		{
			Statement sCht = c.createStatement();
			String sqlch2 = "CREATE TABLE warehouse("
					+ "warehouse_location TEXT PRIMARY KEY NOT NULL,"
					+ "capacity INTEGER NOT NULL,"
					+ "filledSpace INTEGER NOT NULL)";
			sCht.executeUpdate(sqlch2);
			sCht.close();
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
	}
	
		//Celia
		public void createTableEmployee()
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
		public void createTableMachinery()
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
		
		//Relational Tables 
	
		public void createTableHospitalOrders()
	{
		try
		{
			Statement tPt = c.createStatement();
			String sqlp3 = "CREATE TABLE hospital_orders("
					+ "hospital_ID INTEGER REFERENCES hospital(hospital_ID),"
					+ "order_ID INTEGER REFERENCES orders(order_ID),"
					+ "PRIMARY KEY(hospital_ID,order_ID))";
			tPt.executeUpdate(sqlp3);
			tPt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void createTableInstrumentOrders()
	{
		try
		{
			Statement fPt = c.createStatement();
			String sqlp4 = "CREATE TABLE instrument_orders("
					+ "order_ID INTEGER REFERENCES orders(order_ID),"
					+ "instrument_ID INTEGER REFERENCES instrument(instrument_ID),"
					+ "amount_order INTEGER,"
					+ "PRIMARY KEY(order_ID,instrument_ID))";
			fPt.executeUpdate(sqlp4);
			fPt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void createTableMaterial(Connection c){
			try
			{
			Statement sAt = c.createStatement();
			String sqla2 =  "CREATE TABLE materials ("
							+"material_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
							+"weight INTEGER NOT NULL,"
							+"volume INTEGER NOT NULL,"
							+"type TEXT"
							+"material_ID  TEXT REFERENCES company(material_ID),"
							+"machinery_ID TEXT REFERENCES machinery(machinery_ID));";
			sAt.executeUpdate(sqla2);
			sAt.close();
			}catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("Conection Error, Ask Rodrigo for Help");
			
			}
		}

		public void createTableCompany(Connection c){
			try
			{
				Statement fAt = c.createStatement();
				String sqla1 = "CREATE TABLE company ("
						+ "company_ID TEXT PRIMARY KEY,"
						+ "location TEXT,"
						+"company_name TEXT);";
				fAt.executeUpdate(sqla1);
				fAt.close();
				
			}catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("Conection Error, Ask Rodrigo for Help");
			
			}
		}

	//Delete
		public void deleteInstrument( int pkInstrument)
	{
		try
		{
			String sql = "DELETE FROM instrument WHERE instrumentID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkInstrument);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void deleteWarehouse( int pkWarehouse)
	{
		try
		{
			String sql = "DELETE FROM warehouse WHERE warehouseID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkWarehouse);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
		//Celia
		public void deleteEmployee( int pk)
	{
		try
		{
			String sql = "DELETE FROM employee WHERE employee_ID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void deleteMachinery( int pk)
	{
		try
		{
			String sql = "DELETE FROM machinery WHERE machineryType = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}	
		//Alex
		
		public void deleteCompany(int pk)
		{
			try
			{
				String sql = "DELETE FROM company WHERE company_id = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				prep.executeUpdate();
				System.out.println("Deletion finished.");
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		public void deleteMaterial(int pk)
		{
			try
			{
				String sql = "DELETE FROM material WHERE material_id = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				prep.executeUpdate();
				System.out.println("Deletion finished.");
				
				prep.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		
		
		//Pablo
		public void deleteHospital( int pk)
	{
		try
		{
			String sql = "DELETE FROM hospital WHERE hospital_ID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void deleteOrder( int pk)
	{
		try
		{
			String sql = "DELETE FROM orders WHERE order_ID = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pk);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
		//Delete Relations
	
		public void deleteRelationNtoN(String table, String colPk,int pkCol)
	{
		try
		{
			String sql = "DELETE FROM "+table+" WHERE "+colPk+" = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, pkCol);
			prep.executeUpdate();
			System.out.println("Deletion finished.");
			
			prep.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//Drop
	
	//Insert
		public void insert(Hospital hosp) 
	{
		try
		{
			c.setAutoCommit(false);//With false the data base will be updated in the c.commit();
								   // If true, then in line executeUpdate() the data base is updated
			
			String sql = "INSERT INTO hospital(name,location,medical_specialization)"
					+ "VALUES(?,?,?);";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1,hosp.getName());
			prep.setString(2,hosp.getLocation());
			prep.setString(3,hosp.getMedicalSpecialization());
			prep.executeUpdate();
			
			
			prep.close();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
		public void insert(Order ord)
	{
		try
		{
			c.setAutoCommit(false);
			
			String sql = "INSERT INTO orders(total_amount_instruments,order_date,delivery_date)"
					+ "VALUES(?,?,?);";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setDouble(1, ord.getTotalAmountInstruments());
			prep.setDate(2,ord.getDeliveryDate());
			prep.setDate(3, ord.getOrderDate());
			
			prep.executeUpdate();
			
			c.commit();
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		//Charo

		public void insert(Instrument instr) 
	{
		try
		{
			c.setAutoCommit(false);
			
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO instrument(model,purpose,amount,numberUses,bodyLocation,price,warehouseLocation)"
					+ "VALUES ('" + instr.getModel() +"','" +instr.getPurpose() + "','"+ instr.getAmount() + "','"+ instr.getNumberUses() + "','"+ instr.getBodyLocation() + "','"+instr.getPrice()+"','"+instr.getWarehouseID()+"');";
			stmCh.executeUpdate(sqlCh);
			stmCh.close();			
			
			c.commit();
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void insert(Warehouse wareh) 
	{
		try
		{
			c.setAutoCommit(false);
			
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO warehouse (warehouse_location,capacity,filled_space)"
					+ "VALUES ('" + wareh.getWarehouseLocation() +"','" +wareh.getCapacity() + "','"+ wareh.getFilledSpace() +"');";
			stmCh.executeUpdate(sqlCh);
			stmCh.close();
			
			c.commit();
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		//Celia
		public void insert(Employee emp)
	{
		try
		{	
			c.setAutoCommit(false);

			Statement stmt = c.createStatement();
			String sql = "INSERT INTO employee (name, typeofContract,specializationType) "
					+ "VALUES ('" + emp.getName() + "', '" + emp.getTypeofContract()	+ "', '" + emp.getSpecializationType()	+ "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Employee information processed");
			System.out.println("Records inserted.");
			
			c.commit();
			
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
		public void insert(Machinery mach)
	{
		try
		{
			c.setAutoCommit(false);

			Statement stmt = c.createStatement();
			
			String sql = "INSERT INTO machinery (machineryType, stateofMachinery,dateofInstallation,sizeofMachinery) "
					+ "VALUES ('" + mach.getMachineryType() + "', '" + mach.getStateofMachinery()	+ "', '" + mach.getDateofInstallation()	+ "', '" + mach.getSizeofMachinery()	+ "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Machinery information processed");
			System.out.println("Records inserted.");
			c.commit();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
		//Alex
	
		public void insert(Company com){
			try{

							Statement stmt = c.createStatement();
							String sql;
							sql = "INSERT INTO company(location,company_name)  VALUES ('"+com.getLocation()+",'"+com.getCompanyName()+"')"; 
							stmt.executeUpdate(sql);					
							stmt.close();
							// End of transaction
							c.commit();
							System.out.println("Records inserted.");
							// Insert new records: end

							// Close database connection
							c.close();
							System.out.println("Database connection closed.");
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		public void insert(Material mat){
			try{

							Statement stmt = c.createStatement();
							String sql;
							sql = "INSERT INTO material(weight,volume,type,compnay_id,machinery_id) VALUES('"+mat.getWeight()+","+mat.getVolume()+","+mat.getCompanyID()+","+mat.getMachineryID()+"')";
							stmt.executeUpdate(sql);
							stmt.close();
							// End of transaction
							c.commit();
							System.out.println("Records inserted.");
							// Insert new records: end

							// Close database connection
							c.close();
							System.out.println("Database connection closed.");
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		//Relational Tables 
	
		public void insertHospitalOrderRelation( int pkHospital, int pkOrder)
	{
		try
		{
			c.setAutoCommit(false);
			
			String sql = "INSERT INTO hospital_orders(hospital_ID,order_ID)"
					+ "VALUES(?,?)";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkHospital);
			prep.setInt(2,pkOrder);
			
			prep.executeUpdate();
			
			c.commit();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
		public void insertInstrumentOrderRelation(int pkInstrument, int pkOrder)
	{
		try
		{
			c.setAutoCommit(false);
			
			String sql = "INSERT INTO instrument_orders(order_ID,instrument_ID)VALUES(?,?)";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkInstrument);
			prep.setInt(2,pkOrder);
			
			prep.executeUpdate();
			c.commit();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
		public void insertMachineryInstrumentRelation(int pkMachinery,int pkInstrument){
				//////TIME: atributo predeterminado 
			
						try
						{
							c.setAutoCommit(false);

							Statement stmt = c.createStatement();
							String sql ="INSERT INTO machinery_instrument(machinery_ID,instrument_ID)"
									+ "VALUES('" + pkMachinery + "','" + pkInstrument+ "');";
							stmt.executeUpdate(sql);
							stmt.close();
							c.commit();

						}catch(SQLException e)
						{
							e.printStackTrace();
						}
		}
	
		public void insertInstrumentWarehouseRelation(int pkInstrument, int pkWarehouse ){
			try
			{
				c.setAutoCommit(false);
				
				String sql = "INSERT INTO instrument_warehouse(instrument_ID,warehouse_ID)"
						+ "VALUES(?,?)";
				
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1,pkInstrument);
				prep.setInt(2,pkWarehouse);
				
				prep.executeUpdate();
				
				c.commit();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
		
		public void insertMaterialWarehouseRelation(int pkMaterial, int pkWarehouse ){
			try
			{
				c.setAutoCommit(false);
				
				String sql = "INSERT INTO instrument_warehouse(instrument_ID,warehouse_ID)"
						+ "VALUES(?,?)";
				
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1,pkMaterial);
				prep.setInt(2,pkWarehouse);
				
				prep.executeUpdate();
				
				c.commit();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			
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
			prep.setString(1, string);
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
	
	//Select
		
		//Pablo
	
		public ArrayList<Hospital> selectAllHospitals()
		{
			ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM hospital";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next());
				{
					int hospitalID = rs.getInt("hospital_ID");
					String name = rs.getString("name");
					String location = rs.getString("location");
					String medicalSpecialization = rs.getString("medical_Specializaton");
					
					Hospital hosp = new Hospital(hospitalID,name,location,medicalSpecialization);
					hospitals.add(hosp);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return hospitals;
		}
		
		public Hospital selectHospital( String query, int pk)
		{
			Hospital hosp = null;
			int hospitalID;
			String name, location,medicalSpecialization;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					hospitalID = rs.getInt("hospital_ID");
					name = rs.getString("name");
					location = rs.getString("location");
					medicalSpecialization = rs.getString("medical_Specializaton");
					
					hosp = new Hospital(hospitalID,name,location,medicalSpecialization);
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return hosp;
		}
		
		public Hospital selectHospital( String query, String nameHosp)
		{
			Hospital hosp = null;
			int hospitalID;
			String name, location,medicalSpecialization;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, nameHosp);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					hospitalID = rs.getInt("hospital_ID");
					name = rs.getString("name");
					location = rs.getString("location");
					medicalSpecialization = rs.getString("medical_Specializaton");
					
					hosp = new Hospital(hospitalID,name,location,medicalSpecialization);
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return hosp;
		}
		
		public ArrayList<Order> selectAllOrders()
		{
			ArrayList<Order> orderList = new ArrayList<Order>();
			
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM hospital";
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next());
				{
					int orderID = rs.getInt("order_ID");
					int totalAmountInstruments = rs.getInt("total_amount_instrument");
					java.sql.Date orderDate = rs.getDate("order_date");
					java.sql.Date deliveryDate = rs.getDate("delivery_date");
					
					Order order = new Order(orderID,totalAmountInstruments,orderDate,deliveryDate);
					orderList.add(order);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return orderList;
		}
		
		public Order selectOrder(String query, int pk)
		{
			
			Order order = null;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				ResultSet rs = prep.executeQuery();
				
				while(rs.next())
				{
					int orderID = rs.getInt("order_ID");
					int totalAmountInstruments = rs.getInt("total_amount_instrument");
					java.sql.Date orderDate = rs.getDate("order_date");
					java.sql.Date deliveryDate = rs.getDate("delivery_date");
					
					order = new Order(orderID,totalAmountInstruments,orderDate,deliveryDate);
					
				}
				
				prep.close();
				rs.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return order;
		}

		//Charo
		
		//al insertar un instrumento, cuando tengo que rellenar el campo de warehouse meto un nombre, le doy la lista, lo busca con un cearch y lo coje con select
		//cuando tenga que 
		
		
		public Instrument selectInstrument(String query, int pkInstrument)
		{
			Instrument instrument = null;
			int instrumentID;
			
			//atributos de instrument
			String model;
			String purpose;
			Integer amount;
			Integer numberUses;
			String bodyLocation;
			Integer price;
			
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pkInstrument);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					instrumentID = rs.getInt("instrumentID");
					model = rs.getString("model");
					purpose = rs.getString("purpose");
					amount = rs.getInt("amount");
					numberUses = rs.getInt("numberUses");
					bodyLocation = rs.getString("bodyLocation");
					price = rs.getInt("price");
					/*warehouseID = rs.getInt("warehouseID");
					Warehouse ware = new Warehouse();
					ware = selectWarehouse(c,sql,warehouseID);
					//warehouseLocation = rs.getString("warehouseLocation");
					*/
					instrument = new Instrument(instrumentID,model,purpose,amount,numberUses,bodyLocation,price);
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return instrument;
		}
		
		
		
		public ArrayList<Instrument> selectAllInstruments()
		{
			ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM instrument";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next());
				{
					int instrumentID = rs.getInt("instrumentID");
					String model = rs.getString("model");
					String purpose = rs.getString("purpose");
					int amount = rs.getInt("amount");
					int numberUses = rs.getInt("numberUses");
					String bodyLocation = rs.getString("bodyLocation");
					int price = rs.getInt("price");
					
					//debo hacer la relacion para meter el objeto
					//warehouseLocation = rs.getString("warehouseLocation");
					
					Instrument instrument = new Instrument(instrumentID,model,purpose,amount,numberUses,bodyLocation,price);
					instrumentList.add(instrument);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return instrumentList;
		}
		
		public Warehouse selectWarehouse( String query, int pkWarehouse)
		{
			Warehouse warehouse = null;
			
			//atributos de warehouse
			int warehouseID;
			String warehouseLocation;
			Integer capacity;
			Integer filledSpace;
			
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pkWarehouse);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					warehouseID = rs.getInt("warehouseID");
					warehouseLocation = rs.getString("warehouseLocation");
					capacity = rs.getInt("capacity");
					filledSpace = rs.getInt("filledSpace");
				
					warehouse = new Warehouse(warehouseID,warehouseLocation,capacity,filledSpace);
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return warehouse;
		}
		
		//no me hace falta una lista de Warehouse porque solo hay uno en el que está todo, instruments and materials
		
		
		//Celia
		//Employee
		
		public ArrayList<Employee> selectAllEmployee(Connection c)
		{
			ArrayList<Employee> employee = new ArrayList<Employee>();
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM employee";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next());
				{
					int employeeID = rs.getInt("employee_ID");
					String name = rs.getString("name");
					String specializationType = rs.getString("specializationType");
					String typeofContract = rs.getString("typeofContract");
					
					Employee emp = new Employee(employeeID,name,specializationType,typeofContract);
					employee.add(emp);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return employee;
		}
		
		public Employee selectEmployee(Connection c, String query, int pk)
		{
			Employee emp = null;
			int employeeID;
			String name, specializationType,typeofContract;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					employeeID = rs.getInt("employee_ID");
					name = rs.getString("name");
					specializationType = rs.getString("specializationType");
					typeofContract = rs.getString("typeofContract");
					emp = new Employee(employeeID,name,specializationType,typeofContract);
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return emp;
		}
		
		public Employee selectEmployee(Connection c, String query, String nameEmp)
		{
			Employee emp = null;
			int employeeID;
			String name, specializationType,typeofContract;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, nameEmp);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					employeeID = rs.getInt("employee_ID");
					name = rs.getString("name");
					specializationType = rs.getString("specializationType");
					typeofContract = rs.getString("typeofContract");
					emp = new Employee(employeeID,name,specializationType,typeofContract);	
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return emp;
		}
		
		//Machinery
		public ArrayList<Machinery> selectAllMachinery(Connection c)
		{
			ArrayList<Machinery> machineryList = new ArrayList<Machinery>();
			
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM machinery";
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next());
				{
					int machineryID = rs.getInt("machinery_ID");
					String machineryType = rs.getString("machineryType");
					String stateofMachinery = rs.getString("stateofMachinery");				
					java.sql.Date machineryDate = rs.getDate("dateofInstallation");
					int sizeofMachinery = rs.getInt("sizeofMachinery");
					
					Machinery machinery = new Machinery(machineryID,machineryType,stateofMachinery,machineryDate,sizeofMachinery);
					machineryList.add(machinery);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return machineryList;
		}
		
		public Machinery selectMachinery(Connection c, String query, int pk)
		{
			
			Machinery machinery = null;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				ResultSet rs = prep.executeQuery();
				
				while(rs.next())
				{
					
					int machineryID = rs.getInt("machinery_ID");
					String machineryType = rs.getString("machineryType");
					String stateofMachinery = rs.getString("stateofMachinery");				
					java.sql.Date machineryDate = rs.getDate("dateofInstallation");
					int sizeofMachinery = rs.getInt("sizeofMachinery");
					
					machinery = new Machinery(machineryID,machineryType,stateofMachinery,machineryDate,sizeofMachinery);
					
				}
				
				prep.close();
				rs.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return machinery;
		}

		public Machinery selectMachinery(Connection c, String query, String nameMach)
		{
			Machinery mach = null;
			int machineryID, sizeofMachinery;
			String machineryType, stateofMachinery;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, nameMach);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{				
					
					machineryID = rs.getInt("machinery_ID");
					machineryType = rs.getString("machineryType");
					stateofMachinery = rs.getString("stateofMachinery");
					java.sql.Date dateMachinery = rs.getDate("order_date");
					sizeofMachinery = rs.getInt("sizeofMachinery");

					mach = new Machinery(machineryID,machineryType,stateofMachinery,dateMachinery,sizeofMachinery);	
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			
			return mach;
		}

		
		//Alex
		public ArrayList<Company> selectAllCompanies()
		{
			ArrayList<Company> companies = new ArrayList<Company>();
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM company";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next());
				{
					int companyID = rs.getInt("company_ID");
					String location = rs.getString("location");
					String name = rs.getString("company_name");
					
					Company com = new Company(companyID, location, name);
					companies.add(com);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return companies;
		}

		public Company selectCompany(String query, int pk){
				Company comp = null;
				int companyID;
				String name, location;
				
				try
				{
					String sql = query;
					PreparedStatement prep = c.prepareStatement(sql);
					prep.setInt(1, pk);
					ResultSet rs = prep.executeQuery();
					
					while (rs.next()) 
					{
						companyID = rs.getInt("company_ID");
						name = rs.getString("company_name");
						location = rs.getString("location");
						
						comp = new Company(companyID, name, location);
					}
					
					prep.close();
					rs.close();
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}

				return comp;
			
		}

		public  ArrayList<Material> selectAllMaterials()
		{
			ArrayList<Material> materials = new ArrayList<Material>();
			try
			{
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM material";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next());
				{
					int materialID = rs.getInt("material_ID");
					int weight = rs.getInt("weight");
					int volume = rs.getInt("volume");
					String type = rs.getString("type");
					
					Material mat = new Material(materialID, weight, volume, type);
					materials.add(mat);
				}
				
				stmt.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return materials;
		}

		public Material selectMaterial(String query, int pk){
			Material mat = null;
			int materialID, weight, volume;
			String type;
			
			try
			{
				String sql = query;
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, pk);
				ResultSet rs = prep.executeQuery();
				
				while (rs.next()) 
				{
					materialID = rs.getInt("material_ID");
					weight = rs.getInt("weight");
					volume = rs.getInt("volume");
					type = rs.getString("type");
					
					mat = new Material(materialID, weight, volume, type);
				}
				
				prep.close();
				rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			return mat;
		
	}

		
	//Update
		public void update(String table, String colChange, String stringChange, int intChange, String colSearch, int pkSearch)
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


	//Connection
		public Connection openConnection()
	{
		Connection c = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/mtm.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}	
		public void closeConnection(Connection c)
		{
			try
			{
				c.close();
				System.out.println("Database Closed");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
