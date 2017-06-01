package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			String sql = "INSERT INTO orders(total_amount_instruments,order_date,delivery_date)"
					+ "VALUES(?,?,?);";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setDouble(1, ord.getTotalAmountInstruments());
			prep.setDate(2,ord.getOrderDate());
			prep.setDate(3, ord.getDeliveryDate());
			
			prep.executeUpdate();
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
			

			String sql = "INSERT INTO instrument(name,model,purpose,amount,number_uses,body_location,price,warehouseID)"
					+ "VALUES(?,?,?,?,?,?,?,?);";

			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1,instr.getName());
			prep.setString(2,instr.getModel());
			prep.setString(3,instr.getPurpose());
			prep.setInt(4,instr.getAmount());
			prep.setInt(5,instr.getNumberUses());
			prep.setString(6,instr.getBodyLocation());
			prep.setInt(7,instr.getPrice());
			prep.setInt(8, instr.getWarehouse().getWarehouseID());
			
			prep.executeUpdate();
		
			prep.close();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Warehouse wareh) 
	{
		try
		{
			
			Statement stmCh = c.createStatement();
			String sqlCh;
			sqlCh = "INSERT INTO warehouse (warehouseLocation,capacity,filledSpace)"
					+ "VALUES ('" + wareh.getWarehouseLocation() +"','" +wareh.getCapacity() + "','"+ wareh.getFilledSpace() +"');";
			stmCh.executeUpdate(sqlCh);
			stmCh.close();
			
					
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(Employee emp)
	{
		try
		{	
			
			
			String sql = "INSERT INTO employee(name,typeofContract,specializationType,machineryID) VALUES (?,?,?,?)";
			PreparedStatement prep = c.prepareStatement(sql);
			
			prep.setString(1,emp.getName());
			prep.setString(2,emp.getTypeofContract());
			prep.setString(3,emp.getSpecializationType());
			prep.setInt(4,emp.getMachineryType().getMachineryID());
			
			prep.executeUpdate();
			prep.close();
			
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	public void insert(Machinery mach)
	{
		
		try
		{
						
			
			String sql = "INSERT INTO machinery(machineryType,stateofMachinery,dateofInstallation,sizeofMachinery)"
				+ "VALUES (?,?,?,?);";
			
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, mach.getMachineryType());
			prep.setString(2, mach.getStateofMachinery());
			prep.setDate(3, mach.getDateofInstallation());
			prep.setInt(4, mach.getSizeofMachinery());
			
			prep.executeUpdate();
			prep.close();
			
			
			
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
		
	public void insert(Company com){
		try{
			
				String sql = "INSERT INTO company(location,companyName)" + "VALUES(?,?);"; 
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1,com.getLocation());
				prep.setString(2,com.getCompanyName());
								
				prep.executeUpdate();	
				prep.close();
								
				
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void insert(Material mat){
		try{

				String sql;
				sql = "INSERT INTO material(weight,volume,type,companyID,machineryID,warehouseID) VALUES(?,?,?,?,?,?);";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1,mat.getWeight());
				prep.setInt(2,mat.getVolume());
				prep.setString(3,mat.getType());
				prep.setInt(4,mat.getCompany().getCompanyID());
				prep.setInt(5,mat.getMachineryID().getMachineryID());
				prep.setInt(6,mat.getWarehouse().getWarehouseID());
								
				prep.executeUpdate();
				prep.close();
								
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
			
			String sql = "INSERT INTO hospital_orders(hospitalID,orderID)"
					+ "VALUES(?,?)";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkHospital);
			prep.setInt(2,pkOrder);
			
			prep.executeUpdate();
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		}
		
	public void insertInstrumentOrderRelation(int pkInstrument, int pkOrder)
	{
		try
		{
			
			String sql = "INSERT INTO instrument_orders(instrument_ID,orderID)"
					+"VALUES(?,?)";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkInstrument);
			prep.setInt(2,pkOrder);
			
			prep.executeUpdate();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void insertMachineryInstrumentRelation(int pkInstrument ,int pkMachinery){
	
	try
	{
		
		String sql = "INSERT INTO instrument_machinery(instrument_ID, machineryID)"
				+ "VALUES(?,?)";
		
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, pkInstrument );
		prep.setInt(2, pkMachinery);
		
		prep.executeUpdate();
			

	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
	
	
	
	public void insertMaterialWarehouseRelation(int pkMaterial, int pkWarehouse ){
		try
		{
			
			String sql = "INSERT INTO material_warehouse(materialID,warehouseID)"
					+ "VALUES(?,?)";
				
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1,pkMaterial);
			prep.setInt(2,pkWarehouse);
			
			prep.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}	
	
}
