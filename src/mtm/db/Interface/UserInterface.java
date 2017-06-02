package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

import java.io.File;
import java.util.ArrayList;

import java.util.Iterator;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import mtm.db.jdbc.JDBCManager;
import mtm.db.jpa.JPAManager;
import mtm.db.xmls.XMLManager;
import mtm.db.pojos.*;

public class UserInterface 
{
	static JDBCManager jdbcManager = new JDBCManager();
	static JPAManager jpaManager = new JPAManager();
	static XMLManager xmlManager = new XMLManager();
	 
	static boolean openDbBefore = false;
	
	//Main
	public static void main(String args[]) 
	{
		
		int option;
		jdbcManager.openConnection();
		
		boolean dbCreated;
		
		dbCreated = allreadyExistDb();
		jpaManager.openJPAConnection();
		
		do{
			//Start of the db
			option = openMenu(dbCreated);
		
			switch(option)
				{
				case 1:
					//List Entities
					listEntity();
					waitEnter();
					break;
				case 2:
					//show table
					showTable();
					waitEnter();
					break;
				case 3:
					//Introduce Value
					intValTable();
					waitEnter();
					break;
				case 4:
					//DeleteOption//
					delValTable();
					waitEnter();
					break;

				case 5:
					//Modify
					updValTable();
					waitEnter();
					break;
				case 6:
					createXML();
					waitEnter();
					break;
				case 7:
					openXML();
					waitEnter();
					break;
				case 8:
					createHTML();
					waitEnter();
					break;
				case 9:
					
					jdbcManager.closeConnection();
					jpaManager.closeJPAConnection();
					waitEnter();
					break;
				}
		}while(option!=9);
	}

	// Menu
	
	public static int openMenu(boolean dbCreated)
	{
		int option;
		int numOptions = 9; //Numero de opciones que podemos seleccionar con esta funci�n
		printMenu(dbCreated);
		option = writeNumber(numOptions);
		
		return option;
	}
    
    public static void printMenu(boolean dbCreated)
	{
    	if(!openDbBefore)
    	{
    		if(dbCreated)
    		{
    			System.out.println("\nTables created before\n");
    			openDbBefore = true;
    		}else
    		{
    			System.out.println("\n New Data Base");
    			openDbBefore = true;
    		}
    	}
    	
		
		
			//Si a�ades opciones, recuerda mirar el metodo abrirMenu
			System.out.println(""
					
					+ "Option 1.- List entities\n"
						//Option: Do you want to see all the relations? (Condition)					
							//Option 2.1: What table do you want to see? //y se las ense�as
								//Listas el objeto 
								//Seleccioname 1 
								//muestras
					+ "Option 2.- Show table\n"
						//Seleccioname la tabla que quieres ver
						//Muestramela con todo (relaciones incluidas)
					
					+ "Option 3.- Introduce value to a table\n"
						//Option 3.1: What table do you want to insert the value to? //y se las ense�as
							//Listas tablas
							//Select the table
							//Introduces
							
					//aqui ademas se debe llamar a UPDATE la tabla, y la relacion con otra tabla si la tiene
					
					+ "Option 4.- Delete value of a Table\n"
						///Option 4.1: What table do you want to delete a value from? //y se las ense�as
							//Select the table
					
					+ "Option 5.- Modify value\n"
						//mostrar entidades
						//Option 6.1: Select a table to madify a value
						// mostrar valores d la tabla
						// seleccionar la fila 
						// seleccionas la columna
						// Das el valor
						// update
					+ "Option 6.- Create XML of the Pojos \n"
					+ "Option 7.- Open the XML of the pojos\n"
					+ "Option 8.- html creation\n"
					+ "Option 9.- Exit \n");

	}
	
    public static void selectionMenu(int option)
    {
    	//The option of this menu select the type of menu we want to print
    	switch(option)
    	{
    	case 1:
    		//This case is used to the method CreateTables
    		System.out.println("\n\nThis are the tables in the data base:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery\n"
    				+ "6:Material\n"
    				+ "7:Order\n"
    				+ "8:Warehouse\n");
    		
    		break;
    	case 2:
    		//This case is used when you want to list an Entity
    		System.out.println("\n\nSelect the table you want to List:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery\n"
    				+ "6:Material\n"
    				+ "7:Order\n"
    				+ "8:Warehouse\n");
    		break;
    	case 3:
    		System.out.println("\n\nSelect the table you want to show:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery\n"
    				+ "6:Material\n"
    				+ "7:Order\n"
    				+ "8:Warehouse\n");
    		break;
    	case 4:
    		//This case is used when you want to introduce a value in the dataBase
    		System.out.println("\n\nSelect the table where you want to insert the value:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery\n"
    				+ "6:Material\n"
    				+ "7:Warehouse\n");
    		break;
    	case 5:
    		//Menu for the delete option
    		System.out.println("\n\nSelect the table where you want to delete a value:\n"
    				+ "1:Employee\n"
    				+ "2:Material\n");
    		break;
    	case 6:
    		//Menu for the Update
    		System.out.println("\nSelect the table you want to modify:\n"
    				+ "1:Machinery\n"
    				+ "2:WareHouse\n");
    		break;
    	case 7:
    		System.out.println("\nThe \n");
    		break;
    	}
    	
    }
    
	//Data Base Methods
	
	public static void createTable()
	{
		
		jdbcManager.createTables();
		System.out.println("All tables created\n");
		
	}

	public static void listEntity()
	{
		System.out.println("Do you want to see the relations? Write YES or NO");
		boolean relationOption = writeOption(writeString());
		
		System.out.println("What table do you want to list?");
		selectionMenu(2);
		int option = writeNumber(8);
		
		switch(option)
		{
		case 1:
			listCompanies(relationOption);
			break;
		case 2:
			listEmployees(relationOption);
			break;
		case 3:
			listHospitals(relationOption);
			break;
		case 4:
			ArrayList<Instrument> instList = jdbcManager.selectAllInstruments();
			listInstruments(instList,relationOption);
			break;
		case 5:
			listMachineries(relationOption);
			break;
		case 6:
			listMaterials(relationOption);
			break;
		case 7:
			listOrders(relationOption);
			break;
		case 8:
			listWarehouses(relationOption);
			break;
		}
		
	}
	
	public static void showTable()
	{
		selectionMenu(3);
		int option = writeNumber(8);
		switch(option)
		{
		case 1:
			listCompanies(false);
			System.out.printf("Select the ID of the company you want to see\n");
			showCompany(writeNumber());
			break;
		case 2:
			listEmployees(false);
			System.out.printf("Select the ID of the employee you want to see\n");
			showEmployee(writeNumber());
			break;
		case 3:
			System.out.println("Search by:\n1:Id\n2:Name\n");
			int opt = writeNumber(2);
			System.out.println("Hospitals");
			listHospitals(false);
			if(opt==1)
			{
				System.out.printf("Select the ID of the hospital you want to see\n");
				showHospital(writeNumber());
			}else
			{
				System.out.println("Introduce the name of the hospital:");
				String hospName = writeString();
				Hospital hosp = jdbcManager.selectHospital(hospName);
				showHospital(hosp.getHospitalID());
			}
			
			break;
		case 4:
			ArrayList<Instrument> instList = jdbcManager.selectAllInstruments();
			listInstruments(instList,false);
			System.out.printf("Select the ID of the instrument you want to see\n");
			showInstrument(writeNumber());
			break;
		case 5:
			listMachineries(false);
			System.out.printf("Select the ID of the machinery you want to see\n");
			showMachinery(writeNumber());
			break;
		case 6:
			listMaterials(false);
			System.out.printf("Select the ID of the material you want to see\n");
			showMaterial(writeNumber());
			break;
		case 7:
			listOrders(false);
			System.out.printf("Select the ID of the order you want to see\n");
			showOrder(writeNumber());
			break;
		case 8:
			listWarehouses(false);
			System.out.printf("Select the ID of the warehouse you want to see\n");
			showWarehouse(writeNumber());
			break;
			
		}
	}
	
	public static void intValTable()
	{
		selectionMenu(4);
		int op=writeNumber(7);
		switch(op){
		
		case 1: //Company   
			Company comp = createCompany();
			jdbcManager.insert(comp);
			break;
		case 2: //Employee
			Employee emp = createEmployee();
			
			jdbcManager.insert(emp);
			break;
		case 3: //Hospital 
			Hospital hosp = createHospital();
			jdbcManager.insert(hosp);
			jdbcManager.setHospitalID(hosp);
			
			System.out.println("Do you want to relate an order with this hospital? YES or NO:\n");
			String option = writeString();
			if(writeOption(option))
			{
				ArrayList<Instrument> instList = jdbcManager.selectAllInstruments();
				if(instList.size()>0)
				{
					boolean keepRelating = true;
					listOrders(false);
					while(keepRelating)
					{
						System.out.println("The Order allready exixt?. YES or NO");
						option = writeString();
						if(writeOption(option))
						{
							System.out.println("Select one of the following Orders\n");
							listOrders(false);
							int op2 = writeNumber();
							hosp.addOrder(jdbcManager.selectOrder(op2));
							jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(),op2);
						}else
						{
					    	System.out.println("Introduce the values of the New Order:\n");
					    	
							Order ord = createOrder();
							jdbcManager.insert(ord);
							jdbcManager.setOrderID(ord);
							
							System.out.println("Select the Primary Key of the instrument you want to order\n");
					    	listInstruments(instList,false);
					    	int opt = writeNumber();
					    	ord.addInstrument(jdbcManager.selectInstrument(opt));
							
							jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(),ord.getOrderID());
							jdbcManager.setRelationInstrumentOrder(opt,ord.getOrderID());
						}
						System.out.println("Do you want to keep relating? YES,NO\n");
						option = writeString();
						if(!writeOption(option))
						{
							keepRelating = false;
						}
						
					}
				}else
				{
					System.out.println("No intruments exist, therefore, you cant perform an order");
				}
				
			}else
			{
				System.out.println("No Order will be related");
			}
			
			break;
		case 4: //Instrument
			Instrument inst = createInstrument();
			
			System.out.println("Now lets see in which warehouse is the instrument stored:\n");
			
			System.out.println("Does the warehouse exist, Introduce YES or NO?\n");
			String st = writeString();
			
			int warID;
			Warehouse war = new Warehouse();
			
			if(writeOption(st)){
				listWarehouses(false);
				System.out.println("Select the ID of the warehouse you want to insert the instrument into:\n");
				warID=writeNumber();
				jdbcManager.updateWarehouse(warID, inst.getAmount());
				
				inst.setWarehouseID(jdbcManager.selectWarehouse(warID));
				jdbcManager.insert(inst);
				jdbcManager.setInstrumentID(inst); // to obtain the ID of the instrument
				
			}
			else
			{
				System.out.println("Intruduce the values of the new warehouse:\n");

				war=createWarehouse();
				jdbcManager.insert(war);
				jdbcManager.setWarehouseID(war);
				jdbcManager.updateWarehouse(war.getWarehouseID(), inst.getAmount());
				
				inst.setWarehouseID(jdbcManager.selectWarehouse(war.getWarehouseID()));
				
				jdbcManager.insert(inst);
				jdbcManager.setInstrumentID(inst); // to obtain the ID of the instrument
				

			}
			
			
			System.out.println("Now lets see which machinery has created the instrument:\n");			
			System.out.println("Does the machinery exist, Introduce YES or NO?\n");
			String s = writeString();
			
			if(writeOption(s)){
				listMachineries(false);
				System.out.println("Select the ID of the machinery the instrument has been through:\n");
				int machID=writeNumber();

				jpaManager.selectMachinery(machID);
				//jdbcManager.selectMachinery(machID);
				jdbcManager.setRelationInstrumentMachinery(inst.getInstrumentID(),machID);
			}
			else
			{
		    	System.out.println("Introduce the values of the new machinery:\n");

				Machinery mach=createMachinery();
				jpaManager.insert(mach);


				
				jdbcManager.setRelationInstrumentMachinery(inst.getInstrumentID(),mach.getMachineryID());
				
				
			}			
		
			
			break;
		case 5: //Machinery
			Machinery mach = createMachinery();
			//jdbcManager.insert(mach);@SIMach
			jpaManager.insert(mach);
			
			break;
		case 6: //Material
			Material mat = createMaterial(); 
			jpaManager.insert(mat);
			
			break;
		case 7: // Warehouse 
			Warehouse wareh = createWarehouse();
			jdbcManager.insert(wareh);
			break;
		}
		
		
	}
	
	public static void delValTable()
	{
		selectionMenu(5);
		int op=writeNumber(2);
		
		switch(op){
		
		case 1: //Employee
			listEmployees(false);
			System.out.println("What employee do you want to delete from this table? \n");
			int pk2 = writeNumber();
			jdbcManager.deleteEmployee(pk2);
			System.out.println("Employee deleted correctly\n");
			break;
		case 2: //Material
			listMaterials(false);
			System.out.println("What material do you want to delete from this table? \n");
			int pk6 = writeNumber();
			jpaManager.deleteMaterial(pk6);
			System.out.println("Material deleted correctly\n");
			break;	
		}
		
	}
    
    public static void updValTable()
{
    selectionMenu(6);
    int op = writeNumber(2);
    switch(op)
    {
    case 1://Machinery//
    	System.out.println("Select the primary key of the machinery you want to change:");
    	listMachineries(false);
    	int pk = writeNumber();
    	//machinery
    	System.out.println("You can only change the state of this machine, set the satate:\n"
    			+ "1:Work\n"
    			+ "2:No Work\n");
    	int op2 = writeNumber(2);
    	Machinery mach = jpaManager.selectMachinery(pk);
    	jpaManager.updateMachinery(mach,op2);
    	//jdbcManager.updateMachinery(pk,op2);
    	break;
    case 2://warehouse
    	System.out.println("Select the primary key of the warehouse you want to modify:");
    	listWarehouses(false);
    	int pkWar = writeNumber();
    	System.out.println("Write the new location of the warehouse you want to change:");
    	String loc = writeString();
    	jdbcManager.updateWarehouseL(pkWar,loc);
    	break;
    	
    }
    
}
    
    public static void createXML()
    {
    	System.out.println("Do you want to:\n1:Create XML of the DataBase\n2:Create Xml of a Hospital");
    	int opt = writeNumber(2);
    	System.out.println("Introduce the path to the file that will store the DB");
    	String path = writeString();
    	if(opt == 1)
    	{
    		
    		ArrayList<Material> matList = jdbcManager.selectAllMaterials();

    		
    		ArrayList<Hospital> hospList = jdbcManager.selectAllHospitals();
    		Iterator<Hospital> hospIter = hospList.iterator();
    		while(hospIter.hasNext())
    		{
    			jdbcManager.setHospitalRelations(hospIter.next());
    		}
    		
    		ArrayList<Machinery> machList = jdbcManager.selectAllMachineries();
    		Iterator<Machinery> machIter = machList.iterator();
    		while(machIter.hasNext())
    		{
    			jdbcManager.setMachineryRelations(machIter.next());
    		}
    		
    		ArrayList<Instrument> instList = jdbcManager.selectAllInstruments();
    		Iterator<Instrument> wareIter = instList.iterator();
    		while(wareIter.hasNext())
    		{
    			jdbcManager.setInstrumentRelations(wareIter.next());
    		}
    		
    		MtM mtmObj = new MtM(matList,hospList,machList,instList);
    		
    		xmlManager.marshalMtM(path,mtmObj);
    		
    	}else
    	{
    		System.out.println("Select the hospital you want to convert into XML");
    		listHospitals(false);
    		int op = writeNumber();
    		Hospital hosp = jdbcManager.selectHospital(op);
    		hosp = jdbcManager.setHospitalRelations(hosp);
    	
    		xmlManager.marshallHospital(path, hosp);
    	}
    	
    }
    
    public static void openXML()
    {
    	
    	System.out.println("Introduce the path to the file that contains the DB");
    	String path = writeString();
    	//String optionalPath = "./db/xml";
    	//String path = optionalPath;
    	
    	System.out.printf("Do you want to open:\n1:Hospital\n2:MtM");
    	int opt = writeNumber(2);
    	if(opt == 1)
    	{
    		Hospital hosp = xmlManager.unmarshallHospital(path);
        	Iterator <Order> iter = hosp.getOrderList().iterator();
        	
        	jdbcManager.insert(hosp);
        	jdbcManager.setHospitalID(hosp);
        	
        	while(iter.hasNext())
        	{
        		Order ord = iter.next();
        		jdbcManager.insert(ord);
        		jdbcManager.setOrderID(ord);
        		jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(), ord.getOrderID());
        	}
    	}
    	else
    	{
    		MtM mtm = xmlManager.unmarshallMtM(path);
    		
    		String queryIns = "SELECT * FROM instrument WHERE instrumentID = ?";
    		String queryHosp = "SELECT * FROM hospital WHERE hospitalID = ?";
    		String queryOrd = "SELECT * FROM orders WHERE orderID = ?";
    		String queryMach = "SELECT * FROM machinery WHERE machineryID = ?";
    		String queryMat = "SELECT * FROM material WHERE materialID = ?";
    		String queryEmp = "SELECT * FROM employee WHERE employeeID = ?";
    		String queryComp = "SELECT * FROM company WHERE companyID = ?";
    		String queryWare = "SELECT * FROM warehouse WHERE warehouseID = ?";
    		
    		ArrayList<Hospital> hospList = (ArrayList<Hospital>) mtm.getHospList();
    		Iterator<Hospital> hospIter = hospList.iterator();
    		
    		ArrayList<Instrument> instList= (ArrayList<Instrument>) mtm.getInstList();
    		Iterator<Instrument> instIter = instList.iterator();
    		
    		ArrayList<Machinery>  machList = (ArrayList<Machinery>) mtm.getMachList();
    		Iterator<Machinery> machIter = machList.iterator();
    		
    		ArrayList<Material> matList = (ArrayList<Material>)mtm.getmatList();
    		Iterator<Material> matIter = matList.iterator();
    		
    		//Set the relations and store in the DB
    		//HOSPITAL
    		while(hospIter.hasNext())
    		{
    			Hospital hosp = hospIter.next();
    			
    			//Inserto Objeto
    			if(!jdbcManager.valExist(queryHosp,hosp.getHospitalID(),null))//Si el objeto no existe en la base de datos
    			{
    				jdbcManager.insert(hosp);
    				hosp = jdbcManager.setHospitalID(hosp);
    			}
    			//ORDER
    			ArrayList<Order> ordList = (ArrayList<Order>)hosp.getOrderList();
    			Iterator<Order> orderIter = ordList.iterator();
    			while(orderIter.hasNext())
    			{
    				Order ord = orderIter.next();
    				
    				if(!jdbcManager.valExist(queryOrd, ord.getOrderID(), null))
    				{
    					jdbcManager.insert(ord);
    					ord = jdbcManager.setOrderID(ord);
    					jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(), ord.getOrderID());
    				}
    				
    				
    			}
    		}
    		
    		//INSTRUMENT
    		while(instIter.hasNext())
    		{
    			Instrument ins = instIter.next();
    			
    			if(!jdbcManager.valExist(queryIns, ins.getInstrumentID(), null))
    			{
    				jdbcManager.insert(ins);
    				ins = jdbcManager.setInstrumentID(ins);
    			}
    			
    			ArrayList<Order> ordList = (ArrayList<Order>)ins.getOrderList();
    			Iterator<Order> orderIter = ordList.iterator();
    			
    			while(orderIter.hasNext())
    			{
    				Order ord = orderIter.next();
    				if(!jdbcManager.valExist(queryOrd, ord.getOrderID(), null))
    				{
    					jdbcManager.insert(ord);
    					ord = jdbcManager.setOrderID(ord);
    					jdbcManager.setRelationInstrumentOrder(ins.getInstrumentID(), ord.getOrderID());
    				}
    				
    				
    			}
    			//MAQUINARIAS
    			ArrayList<Machinery> machListIns = (ArrayList<Machinery>)ins.getMachineryList();
    			Iterator <Machinery> machInsIter = machListIns.iterator();
    			
    			while(machInsIter.hasNext())
    			{
    				Machinery mach = machInsIter.next();
    				if(!jdbcManager.valExist(queryMach,mach.getMachineryID(),null))
    				{
    					jdbcManager.insert(mach);
    					mach = jdbcManager.setMachineryID(mach);
    					jdbcManager.setRelationInstrumentMachinery(ins.getInstrumentID(), mach.getMachineryID());
    				}
    				
    				
    			}
    			//WAREHOUSES
    			Warehouse ware = ins.getWarehouse();
    			if(!jdbcManager.valExist(queryWare,ware.getWarehouseID(), null))
    			{
    				//Introduce is relate
    				jdbcManager.insert(ware);
    				ware = jdbcManager.setWarehouseID(ware);
    			}
    			
    		}
    		
    		//MACHINERY
    		while(machIter.hasNext())
    		{
    			Machinery mach = machIter.next();
    			
    			if(!jdbcManager.valExist(queryMach,mach.getMachineryID(),null))
    			{
    				jdbcManager.insert(mach);
    				mach = jdbcManager.setMachineryID(mach);
    			}
    			
    			//EMPLEADOS
    			ArrayList<Employee> empArray = (ArrayList<Employee>) mach.getEmployeeList();
    			Iterator<Employee> empIter = empArray.iterator();
    			while(empIter.hasNext())
    			{
    				Employee  emp = empIter.next();
    				if(jdbcManager.valExist(queryEmp,emp.getEmployeeID(), null))
    				{
    					jdbcManager.insert(emp);
    					
    				}
    				
    			}
    			
    			//Cargar desde maquinaria los materiales
        		ArrayList<Material> matArray = (ArrayList<Material>)mach.getMaterialList();
        		Iterator<Material> matItera = matArray.iterator();
        		
        		while(matItera.hasNext())
        		{
        			Material mat = matItera.next();
        			
        			if(!jdbcManager.valExist(queryMat, mat.getMaterialID(), null))
        			{
        				jdbcManager.insert(mat);
        				
        			}
        		}
    			
    		}
    		
    		
    		//MATERIAL
    		while(matIter.hasNext())
    		{
    			Material mat = matIter.next();
    			if(!jdbcManager.valExist(queryMat, mat.getMaterialID(), null))
    			{
    				jdbcManager.insert(mat);
    			}
    			
    			Company comp = mat.getCompany();
    			
    			if(!jdbcManager.valExist(queryComp, mat.getMaterialID(), null))
    			{
    				jdbcManager.insert(comp);
    				comp = jdbcManager.setCompanyID(comp);
    			}
    			
    			Warehouse war = mat.getWarehouse();
    			if(!jdbcManager.valExist(queryWare, war.getWarehouseID(),null))
    			{
    				jdbcManager.insert(war);
    				war = jdbcManager.setWarehouseID(war);
    			}
    		}
    		
    	}
    	
    	 
    }
    
    //Creation of Objects
    
    public static Hospital createHospital()
    {
    	System.out.println("Name of the hospital:\n");
		String a = writeString();
		System.out.println("Location of the Hospital:\n");
		String b = writeString();
		System.out.println("Medical Specialization of the hospital:\n");
		String c = writeString();
		
		Hospital hosp = new Hospital(a,b,c);
		
		
		return hosp;
    } 
    
    public static Order createOrder()
    {		
    	
    	Order ord = new Order();
    	System.out.println("Total Amount of Instruments:\n");
		int d = writeNumber();
		
		String []d1 = new String[2];
		String []d2 = new String[2];
		
		System.out.println("Order Date:");
		d1 = createDate();
		System.out.println("Delivery Date:\n");
		d2 = createDate();
		
		ord = jdbcManager.createPojoOrder(d,d1[0],d1[1],d1[2],d2[0],d2[1],d2[2]);
		
		return ord;
    }
    
    public static Warehouse createWarehouse(){
    	
    	System.out.println("Location of the warehouse:\n");
		String warehouseLocation=writeString();
		System.out.println("Capacity of the warehouse:\n");
		int capacity=writeNumber();
		System.out.println("Filled space in the warehouse:\n");
		int filledSpace=writeNumber();
		
		Warehouse warehouse = new Warehouse( warehouseLocation,capacity,filledSpace);	
		
		return warehouse;
    }

    public static Instrument createInstrument(){
    	
    	System.out.println("Name of the instrument:\n");
    	String name=writeString();
    	System.out.println("Model of the instrument:\n");
		String model=writeString();
		System.out.println("Purpose of the instrument:\n");
		String purpose=writeString();
		System.out.println("Amount of instrument:\n");
		int amount=writeNumber();
		System.out.println("Number of uses of the instrument:\n");
		int numberUses=writeNumber();
		System.out.println("Body location of the instrument:\n");
		String bodyLocation=writeString();
		System.out.println("Price of the instrument:\n");
		int price=writeNumber();
		
		Instrument inst = new Instrument (name,model,purpose,amount,numberUses,bodyLocation,price);
		
		return inst;
    }
    
    public static Employee createEmployee(){

	System.out.println("Name of the employee:\n");
	String name = writeString();
	System.out.println("Type of contract: \n");
	String typec = writeString();
	System.out.println("Does the machinery exist? Introduce YES or NO\n");
	String d = writeString();
	Machinery mach=new Machinery();
	if(writeOption(d))
	{
		listMachineries(false);
		System.out.println("Select the ID of the machinery the employee is spezialized in:\n");
		int e=writeNumber();
		
		mach = jdbcManager.selectMachinery(e);
		
	}
	else
	{
		mach = createMachinery();
		jdbcManager.insert(mach);
		mach = jdbcManager.setMachineryID(mach);
		
	}
	
	Employee emp = new Employee(name,typec,mach.getMachineryType(),mach);
	
	return emp;
    
    }
   
    public static Machinery createMachinery(){
    	
	Machinery mach;
	
    	System.out.println("Type of Machinery (Laser,Milling...)");
		String a=writeString();
		System.out.println("State of machinery:\n1.-Working\n2.-No Working\n");
		int op = writeNumber(2);
		String b;
		if(op == 1)
		{
			b= "Working";
			System.out.println("The machinery State will be set as Working\n");
		}else
		{
			b= "No Working";
			System.out.println("The machinery State will be set as NO working\n");
		}
		
		System.out.println("Date of installation:");		
		String []c1 = new String[2];	
		c1 = createDate();

		System.out.println("Size of machinery(m^2):\n");
		int d=writeNumber();

		mach = jdbcManager.createPojoMachinery(a,b,c1[0],c1[1],c1[2],d);
		
		return mach;
}
    
    public static Company createCompany(){
    	
    	
    	System.out.println("Company location:\n");
    	String a=writeString();
    	System.out.println("Company name:\n");
    	String b=writeString();
    	
    	Company com = new Company(a,b);
    	
    	return com;
    }
    
    public static Material createMaterial()
    {
    	
    	System.out.println("Weight:\n");
    	int a = writeNumber();
    	System.out.println("Volume:\n");
    	int b = writeNumber();
    	System.out.println("Type:\n");
    	String c = writeString();
    	
    	Material mat = new Material(a,b,c);
    	
    	//company//
    	boolean aux = true;
    	while(aux)
    	{
    		System.out.println("This material is provided by a company from the database YES or NO: \n");
    		String answ = writeString();
    		if(writeOption(answ))
    		{
    			listCompanies(false);
    			System.out.println("Type the PK of the company:\n");
    			int pk = writeNumber();
    			Company com = jpaManager.selectCompany(pk);
    			mat.setCompanyID(com);
    			System.out.println("The material is attached to the company\n");
    			aux = false;
    		
    		}else if(writeOption(answ))
    		{
    			System.out.println("Therefore, you need to create a new company\n");
    			Company com = createCompany();
    			jpaManager.insert(com);
    			mat.setCompanyID(com);
    			System.out.println("The material is attached to the company\n");
    			aux = false;
    		
    		}else
    		{
    		System.out.println("Please type YES or NO\n");
    		}
    	}
    	
    	//machinery
    	boolean aux2 = true;
    	while(aux2)
    	{
    		
    		System.out.println("\n\n Machinery\n");
    		
    		System.out.println("Does the machinery exists in the data base? YES or NO: \n");
    		String answ = writeString();
    		if(writeOption(answ))
    		{
    			listMachineries(false);
    			System.out.println("Type the PK of the machinery:\n");
    			int pk = writeNumber();
    			Machinery mach = jpaManager.selectMachinery(pk);
    			if(mach != null)
    			{
    				mat.setMachineryID(mach);
    				aux2 = false;
    			}
    		
    		}else
    		{
    			System.out.println("Therefore, a Machinery must be created\n");
    			Machinery mach = createMachinery();
    			jpaManager.insert(mach);
    			
    			mat.setMachineryID(mach);
    			aux2 = false;
    		}
    		
    		
    	}
    	
    	//warehouse
    	boolean aux3 = true;
    	while(aux3)
    	{
    		System.out.println("The material need to be stored in a warehouse\n");
    		System.out.println("Do you want to:\n1:Create a new wareHouse\n2:Use a warehouse from the DataBase");
    		int op = writeNumber(2);
    		if(op == 1)
    		{
    			//crear
    			System.out.println("A new WareHouse will be created\n");
    			Warehouse war = createWarehouse();
    			jpaManager.insert(war);

    			mat.setWarehouse(war);
    			aux3 = false;
    		}else
    		{
    			//Seleccionar
    			listWarehouses(true);
        		System.out.println("Type the PK of the Warehouse:\n");
        		int pk = writeNumber();
        		//Warehouse ware = jdbcManager.selectWarehouse(pk);
        		Warehouse ware = jpaManager.selectWarehouse(pk);
        	
        		if(ware != null)
        		{
        			mat.setWarehouse(ware);
        			aux3 = false;
        		}
    		}
    	
    	}
		
    	return mat;
    }

    
    //Show the Objects
    public static void showCompany(int pk){
    	Company com;
		com = jdbcManager.selectCompany(pk);
		jdbcManager.setCompanyRelations(com);
		com.printCompany(true);
    }
    
    public static void showMaterial(int pk){
    	Material mat;
    	mat = jpaManager.selectMaterial(pk);
    	//jdbcManager.setMaterialRelations(mat);
    	mat.printMaterial(true);
    }
    
    public static void showHospital(int pk)
    {
    	Hospital hosp;
		hosp = jdbcManager.selectHospital(pk);
		jdbcManager.setHospitalRelations(hosp);
		hosp.printHospital(true);
    }
    
    public static void showOrder(int pk)
    {
    	Order ord;
    	ord = jdbcManager.selectOrder(pk);
    	jdbcManager.setOrderRelations(ord);
    	ord.printOrder(true);
    }
    
    public static void showInstrument(int pk){
    	Instrument inst;
    	inst = jdbcManager.selectInstrument(pk);
    	jdbcManager.setInstrumentRelations(inst);
    	inst.printInstrument();
    	
    }
    
    public static void showWarehouse(int pk){
    	Warehouse war;
    	war = jdbcManager.selectWarehouse(pk);
    	jdbcManager.setWarehouseRelations(war);    	
    	war.printWarehouse(true);
    
    }
    
    public static void showEmployee(int pk)
    {
    	Employee emp;
    	emp = jdbcManager.selectEmployee(pk);
    	emp.printEmployee(true);
    	
    	//emp.toString();
    }
    
    public static void showMachinery(int pk)
    {
    	Machinery mach;
    	mach = jpaManager.selectMachinery(pk);
    	//mach = jdbcManager.selectMachinery(pk);@JPAChange
    	jdbcManager.setMachineryRelations(mach);
    	mach.printMach(true);
    }
    
    //List the objects
    public static void listCompanies(boolean relation){
    	Company com;
		ArrayList<Company> comList = new ArrayList<Company>();
		comList = jdbcManager.selectAllCompanies();
			
		Iterator<Company> compIter = comList.iterator(); 
			
		
		while(compIter.hasNext())
		{
			com = compIter.next();
			String name = com.getCompanyName();
			int id = com.getCompanyID();

			System.out.printf("Company\n");
			System.out.printf("id: %d,name: %s\n",id,name);
			
			if(relation)
			{
				ArrayList<Material> matList = (ArrayList<Material>)com.getMaterialList();
				Iterator<Material> iter = matList.iterator();
				while(iter.hasNext())
				{
					Material mat = iter.next();
					System.out.printf("\nMaterial id:%d\n",mat.getMaterialID());
				}
			}			
		}
	}
  
    public static void listMaterials(boolean relation){
        	Material mat;
        	ArrayList<Material> matList = new ArrayList<Material>();
        	matList = jdbcManager.selectAllMaterials();
        	
        	int count = 0;
			System.out.printf("Material\n");

        	while(count < matList.size())
        	{
        		mat = matList.get(count);
        		if(relation)
        		{
        			System.out.printf("id: %d, type: %s \nCompany id: %d \nMachinery id:%d \nWharehouse id:%d\n", mat.getMaterialID() , mat.getType(), mat.getCompany().getCompanyID(), mat.getMachineryID().getMachineryID(), mat.getWarehouse().getWarehouseID());
        		}else
        		{
        			System.out.printf("id: %d, type: %s \n", mat.getMaterialID(), mat.getType());
        		}
        		
        		count++;
        	}
        	
        }
     
    public static void listHospitals(boolean relation)
    {
    	Hospital hosp;
		ArrayList<Hospital> hospList = jdbcManager.selectAllHospitals();
		Iterator <Hospital> iter = hospList.iterator();
		System.out.printf("Hospital\n");

		while(iter.hasNext())
		{
			hosp = iter.next();
			if(relation)
			{
				jdbcManager.setHospitalRelations(hosp);
				System.out.printf("id: %d,name: %s\n",hosp.getHospitalID(),hosp.getName());
				Iterator<Order> iterOrd = hosp.getOrderList().iterator();
				while(iterOrd.hasNext())
				{
					Order ord = iterOrd.next();
					System.out.printf("\nOrder id:%d\n ",ord.getOrderID());
				}
			}else
			{
				System.out.printf("id: %d,name: %s\n",hosp.getHospitalID(),hosp.getName());				
			}
		}
    }
  
    public static void listOrders(boolean relation)
    {
    	Order ord;;
    	ArrayList<Order> ordList = new ArrayList<Order>();
    	ordList = jdbcManager.selectAllOrders();
    	Iterator <Order> iter = ordList.iterator();
		System.out.printf("Order\n");

    	while(iter.hasNext())
    	{
    		ord = iter.next();
    		jdbcManager.setOrderRelations(ord);
    		if(relation)
    		{
    			System.out.printf("id: %d,\n",ord.getOrderID());
    			
    			Iterator<Hospital> hospIter = ord.getHospitalList().iterator();
    			while(hospIter.hasNext())
    			{
    				Hospital hosp = hospIter.next();
    				System.out.printf("\nHospital id:%d\n",hosp.getHospitalID());
    			}
    			
    			Iterator<Instrument> insIter = ord.getInstrumentList().iterator();
    			while(insIter.hasNext())
    			{
    				Instrument ins = insIter.next();
    				System.out.printf("\nInstrument id:%d\n",ins.getInstrumentID());
    			}
    		}else
    		{
    			System.out.printf("id: %d\n",ord.getOrderID());
    		}
    	}
    	
    }
        
    public static void listInstruments(ArrayList<Instrument>instrumentList ,boolean relation){
    	
    	Instrument inst = new Instrument();
    	
    	Iterator <Instrument> iter = instrumentList.iterator();
		System.out.printf("Instrument\n");

    	while(iter.hasNext()){
    		
    		inst = iter.next();
    
    		if(relation){
    			jdbcManager.setInstrumentRelations(inst);
    			System.out.printf("id: %d\n",inst.getInstrumentID());
    			System.out.printf("\nOrder id: %d\n",inst.getOrderList());
    			System.out.printf("\nMachinery id: %d\n",inst.getMachineryList());
    			System.out.printf("\nWarehouse id: %d\n",inst.getWarehouse());	
    		}else{
    			System.out.printf("id: %d\n",inst.getInstrumentID());
    		}
    	}	
    }
    
    public static void listWarehouses(boolean relation){
    	Warehouse war = new Warehouse();
    	ArrayList<Warehouse> warehouseList = new ArrayList<Warehouse>();
    	warehouseList = jdbcManager.selectAllWarehouses();
    	int count = 0;
		System.out.printf("Warehouse\n");

    	while(count < warehouseList.size())
		{
			war = warehouseList.get(count);
			String warehouseLocation = war.getWarehouseLocation();
			int id = war.getWarehouseID();
			
				System.out.printf("id: %d,location: %s\n",id,warehouseLocation);
				count++;
				if(relation){
					System.out.printf("id: %d,location: %s\n",id,warehouseLocation);
	    			System.out.printf("\nInstrument id: %d\n",war.getInstrumentList());
	    			System.out.printf("\nWarehouse id: %d\n",war.getWarehouseID());
				}
			}
    }
    
    public static void listEmployees(boolean relation)
    {
    	Employee emp;
    	ArrayList<Employee> empList = new ArrayList<Employee>();
    	empList = jdbcManager.selectAllEmployees();
		System.out.printf("Employee\n");

    	int count = 0;
    	while(count < empList.size())
    	{
    		emp = empList.get(count);
			int id = emp.getEmployeeID();
    		emp = empList.get(count);
    		if(relation){
        		System.out.printf("id: %d, \nMachinery id: %d\n",id,emp.getMachineryID());
            	
    		}
    		else{
        		System.out.printf("id: %d\n",id);
    		}
    		count ++;
    	} 	
    }
    
    public static void listMachineries(boolean relation) {
    	
    	Machinery mach;
    	ArrayList<Machinery> machList = jdbcManager.selectAllMachineries();
    	int count = 0;
		System.out.printf("Machinery\n");

    	while(count < machList.size()){
    		
    		mach =machList.get(count);
    		
    		int id = mach.getMachineryID();    		
        	
    		if(relation)
    		{
    			jdbcManager.setMachineryRelations(mach);
    			System.out.printf("id: %d \nInstrument id: %d \nEmployee id: %d Material id: %ds\n"
    					,mach.getMachineryID(),mach.getInstrumentList(),mach.getEmployeeList(),mach.getMaterialList());
       
    		}else
    		{
    			System.out.printf("id: %d\n",id);
    		}    		
        	count ++;
    	}
    
    }
    
    //Management Methods

    public static boolean allreadyExistDb()
    {
    	boolean op;
    	op = jdbcManager.createTables();
    	return op;
    }
    
    public static void createHTML()
    {
    	System.out.println("\nIntroduce the xml Path with her name:\n");
    	String sourcePath = writeString();

    	String xsltPath = "C:/Users/Pablo/git/MtM/db/HospitalStyle.xslt";
    	
    	System.out.println("\nInsert the path where the link will be saved:\n");
    	String resultDir = writeString();
    	
    	simpleTransform(sourcePath,xsltPath,resultDir);
    	
    	System.out.println("\nDone\n");
    }
    
	public static void simpleTransform(String sourcePath, String xsltPath,String resultDir) 
	{
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
			transformer.transform(new StreamSource(new File(sourcePath)),new StreamResult(new File(resultDir)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
