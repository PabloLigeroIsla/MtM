package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import mtm.db.pojos.Company;
import mtm.db.pojos.Employee;
import mtm.db.pojos.Hospital;
import mtm.db.pojos.Instrument;
import mtm.db.pojos.Machinery;
import mtm.db.pojos.Material;
import mtm.db.pojos.Order;
import mtm.db.pojos.Warehouse;

public class JDBCInsert 
{
	
	private Connection c;
	
	public JDBCInsert(Connection c)
	{
		this.c = c;
	}
	
	//Insert
	public void insert(Hospital obj) 
	{
		try
		{
			c.setAutoCommit(false);//With false the data base will be updated in the c.commit();
								   // If true, then in line executeUpdate() the data base is updated
			
			String sql = "INSERT INTO hospital(name,location,medical_specialization)"
					+ "VALUES(?,?,?);";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1,obj.getName());
			prep.setString(2,obj.getLocation());
			prep.setString(3,obj.getMedicalSpecialization());
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
			
			java.sql.Date delDate = LocaltoSqlDate(ord.getDeliveryDate());
			java.sql.Date ordDate = LocaltoSqlDate(ord.getOrderDate());
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setDouble(1, ord.getTotalAmountInstruments());
			prep.setDate(2,ordDate);
			prep.setDate(3, delDate);
			
			prep.executeUpdate();
		
			c.commit();
			prep.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Instrument instr) 
	{
		try
		{
			c.setAutoCommit(false);
			
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO instrument(model,purpose,amount,number_uses,body_location,price)"
					+ "VALUES ('" + instr.getModel() +"','" +instr.getPurpose() + "','"+ instr.getAmount() + "','"+ instr.getNumberUses() + "','"+ instr.getBodyLocation() + "','"+instr.getPrice()+"');";
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
	
	public void insert(Employee emp)
	{
		try
		{	
			c.setAutoCommit(false);
			Statement stmt = c.createStatement();
			String sql = "INSERT INTO employee(name,typeofContract,specializationType,machinery_ID) "
			+ "VALUES ('" + emp.getName() + "', '" + emp.getTypeofContract()	+ "', '" 
					+ emp.getSpecializationType()	+ "', '" + emp.getMachineryType().getMachineryID()	+ "');";
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
			
			String sql = "INSERT INTO machinery(machineryType,stateofMachinery,dateofInstallation,sizeofMachinery) "
				+ "VALUES (?,?,?,?);";
			
			java.sql.Date InstallationDate = LocaltoSqlDate(mach.getDateofInstallation());
			PreparedStatement prep = c.prepareStatement(sql);
			
			prep.setString(1, mach.getMachineryType());
			prep.setString(2, mach.getStateofMachinery());
			prep.setDate(3, InstallationDate);
			prep.setInt(4, mach.getSizeofMachinery());
			
			prep.executeUpdate();
			prep.close();
			
			c.commit();
			
			
			
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Company com){
		try{
			c.setAutoCommit(false);
			
				String sql;
				sql = "INSERT INTO company(location,company_name)" + "VALUES(?,?);"; 
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1,com.getLocation());
				prep.setString(2,com.getCompanyName());
								
				prep.executeUpdate();
									
				prep.close();
								
				System.out.println("Records inserted.");
				
				c.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void insert(Material mat){
		try{

						c.setAutoCommit(false);
								String sql;
								sql = "INSERT INTO material(weight,volume,type,company_ID,machinery_ID,warehouse_ID) VALUES(?,?,?,?,?,?);";
								PreparedStatement prep = c.prepareStatement(sql);
								prep.setInt(1,mat.getWeight());
								prep.setInt(2,mat.getVolume());
								prep.setString(3,mat.getType());
								prep.setInt(4,mat.getCompanyID());
								prep.setInt(5,mat.getMachineryID());
								prep.setInt(6,mat.getWarehouseID());
								
								prep.executeUpdate();
								
								
								prep.close();
								
								System.out.println("Records inserted.");

								c.commit();
				}
				catch (Exception e) {
					e.printStackTrace();
					
				}
			}
	
	//Relational Tables 
		
	public void insertHospitalOrderRelation( int pkHospital, int pkOrder, int tao)
	{
		try
		{
			c.setAutoCommit(false);
			
			String sql = "INSERT INTO hospital_orders(hospital_ID,order_ID,amountOrder)"
					+ "VALUES(?,?,?)";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkHospital);
			prep.setInt(2,pkOrder);
			prep.setInt(3,tao);
			
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

	public void insertMaterialCompanyRelation(int pkMaterial, int pkCompany){
		try
		{
			c.setAutoCommit(false);
				
			String sql = "INSERT INTO material(company_ID)"
					+ "VALUES(?,?)";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkMaterial);
			prep.setInt(2,pkCompany);
			
			prep.executeUpdate();
			
			c.commit();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
			
	//Help Methods
	
	private java.sql.Date LocaltoSqlDate(LocalDate locDate) 
	{
		java.sql.Date sqlDate;
		sqlDate = java.sql.Date.valueOf(locDate);
		return sqlDate;
		    
	}
}
