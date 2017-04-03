package mtm.db.jdbc;

import mtm.db.pojos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsert 
{	
	
	
	//Pablo
	public void insert(Hospital hosp,Connection c) 
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
	public void insert(Order ord,Connection c)
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
	public void insert(Instrument instr,Connection c) 
	{
		try
		{
			c.setAutoCommit(false);
			
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO instrument(model,purpose,amount,number_uses,body_location,price,warehouse_location)"
					+ "VALUES ('" + instr.getModel() +"','" +instr.getPurpose() + "','"+ instr.getAmount() + "','"+ instr.getNumber_uses() + "','"+ instr.getBody_location() + "','"+instr.getPrice()+"','"+instr.getWarehouse_location()+"');";
			stmCh.executeUpdate(sqlCh);
			stmCh.close();			
			
			c.commit();
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Warehouse wareh,Connection c) 
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
	public void insert(Employee emp,Connection c)
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
	public void insert(Machinery mach,Connection c)
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
	//Alex
	
	public void insert(Company com, Connection c){
		try{

						Statement stmt = c.createStatement();
						String sql;
						sql = "INSERT INTO company(resource,location,company_name) VALUES ('"+com.getResource()+"','"+com.getLocation()+",'"+com.getCompany_name()+"')"; 
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
	public void insert(Material mat, Connection c){
		try{

						Statement stmt = c.createStatement();
						String sql;
						sql = "INSERT INTO materials(weight,volume,material_provided,machinery_type) VALUES('"+mat.getWeight()+","+mat.getVolume()+","+mat.getMaterialProvided()+","+mat.getMachineryType()+"')";
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
}
