package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import mtm.db.pojos.Company;
import mtm.db.pojos.Employee;
import mtm.db.pojos.Hospital;
import mtm.db.pojos.Instrument;
import mtm.db.pojos.Machinery;
import mtm.db.pojos.Material;
import mtm.db.pojos.Order;
import mtm.db.pojos.Warehouse;

public class JDBCSelect 
{
	private Connection c;
	
	public JDBCSelect(Connection c)
	{
		this.c = c;
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
			
			while(rs.next())
			{
				int hospitalID = rs.getInt("hospital_ID");
				String name = rs.getString("name");
				String location = rs.getString("location");
				String medicalSpecialization = rs.getString("medical_specialization");
				
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
				medicalSpecialization = rs.getString("medical_specialization");
				
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
				medicalSpecialization = rs.getString("medical_specialization");
				
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
			String sql = "SELECT * FROM orders";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int orderID = rs.getInt("order_ID");
				int totalAmountInstruments = rs.getInt("total_amount_instruments");
				java.sql.Date orderDate = rs.getDate("order_date");
				java.sql.Date deliveryDate = rs.getDate("delivery_date");
				
				Order order = new Order(orderID,totalAmountInstruments,SqltoLocalDate(orderDate),SqltoLocalDate(deliveryDate));
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
				int totalAmountInstruments = rs.getInt("total_amount_instruments");
				java.sql.Date orderDate = rs.getDate("order_date");
				java.sql.Date deliveryDate = rs.getDate("delivery_date");
				
				order = new Order(orderID,totalAmountInstruments,SqltoLocalDate(orderDate),SqltoLocalDate(deliveryDate));
				
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
	

	
	public Instrument selectInstrument(String query, int pkInstrument)
	{
		Instrument instrument = null;
		int instrumentID;
		
		//attributes of instrument
		String name;
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
				instrumentID = rs.getInt("instrument_ID");
				name = rs.getString("name");
				model = rs.getString("model");
				purpose = rs.getString("purpose");
				amount = rs.getInt("amount");
				numberUses = rs.getInt("number_uses");
				bodyLocation = rs.getString("body_location");
				price = rs.getInt("price");
				
				instrument = new Instrument(instrumentID,name,model,purpose,amount,numberUses,bodyLocation,price);
			}
			
			prep.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		
		return instrument;
	}
	
	//
	
	public ArrayList<Instrument> selectAllInstruments()
	{
		ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
		try
		{
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM instrument";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				int instrumentID = rs.getInt("instrument_ID");
				String name = rs.getString("name");
				String model = rs.getString("model");
				String purpose = rs.getString("purpose");
				int amount = rs.getInt("amount");
				int numberUses = rs.getInt("number_uses");
				String bodyLocation = rs.getString("body_location");
				int price = rs.getInt("price");
				
				//debo hacer la relacion para meter el objeto
				//warehouseLocation = rs.getString("warehouseLocation");
				
				Instrument instrument = new Instrument(instrumentID,name,model,purpose,amount,numberUses,bodyLocation,price);
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
		//attributes of warehouse
		
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
				warehouseID = rs.getInt("warehouse_ID");
				warehouseLocation = rs.getString("warehouse_location");
				capacity = rs.getInt("capacity");
				filledSpace = rs.getInt("filled_space");
			
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
	
	public ArrayList<Employee> selectAllEmployee(){
		
		ArrayList<Employee> employee = new ArrayList<Employee>();
		try
		{
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM employee";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
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
	
	public Employee selectEmployee( String query, int pk)
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
	
	public Employee selectEmployee(String query, String nameEmp)
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
	public ArrayList<Machinery> selectAllMachinery()
	{
		ArrayList<Machinery> machineryList = new ArrayList<Machinery>();
		
		try
		{
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM machinery";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int machineryID = rs.getInt("machinery_ID");
				String machineryType = rs.getString("machineryType");
				String stateofMachinery = rs.getString("stateofMachinery");				
				java.sql.Date machiDate = rs.getDate("dateofInstallation");
				int sizeofMachinery = rs.getInt("sizeofMachinery");
				
				LocalDate machineryDate = SqltoLocalDate(machiDate);
				
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
	
	public Machinery selectMachinery(String query, int pk)
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
				java.sql.Date machiDate = rs.getDate("dateofInstallation");
				int sizeofMachinery = rs.getInt("sizeofMachinery");
				
				LocalDate machineryDate = SqltoLocalDate(machiDate);
				
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

	public Machinery selectMachinery(String query, String nameMach)
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
				java.sql.Date dateMach = rs.getDate("order_date");
				sizeofMachinery = rs.getInt("sizeofMachinery");

				LocalDate dateMachinery = SqltoLocalDate(dateMach);
				
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
			while(rs.next())
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
			while(rs.next())
			{
				int materialID = rs.getInt("material_ID");
				int weight = rs.getInt("weight");
				int volume = rs.getInt("volume");
				String type = rs.getString("type");
				int companyID = rs.getInt("company_ID");
				int machineryID = rs.getInt("machinery_ID");
				
				Material mat = new Material(materialID, weight, volume, type, companyID, machineryID);
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
				int companyID = rs.getInt("company_ID");
				int machineryID = rs.getInt("machinery_ID");
				
				mat = new Material(materialID, weight, volume, type, companyID, machineryID);
			}
			
			prep.close();
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		return mat;
	
}

	//Help Methods
	private LocalDate SqltoLocalDate(java.sql.Date sqlDate)
	{

		LocalDate locDate = sqlDate.toLocalDate();
		return locDate;
		
	}
	
}
