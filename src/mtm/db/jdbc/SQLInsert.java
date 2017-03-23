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
			stm.executeUpdate(sql);
			stm.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
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
						sql = "INSERT INTO materials(weight,volume,material_provided,machinery_type) VALUES('"+mat.getWeight()+","+mat.getVolume()+","+mat.getMaterial_provided()+","+mat.getMachinery_type()+"')";
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
