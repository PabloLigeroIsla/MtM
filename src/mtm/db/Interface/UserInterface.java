package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

import java.util.ArrayList;

import java.util.Iterator;

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
					//xmlManager.createXML();
					//createXML();
					waitEnter();
					break;
				case 7:
					//openXML();
					waitEnter();
					break;
				case 8:
					jdbcManager.closeConnection();
					jpaManager.closeJPAConnection();
					waitEnter();
					break;
				}
		}while(option!=8);
	}

	// Menu
	
	public static int openMenu(boolean dbCreated)
	{
		int option;
		int numOptions = 8; //Numero de opciones que podemos seleccionar con esta funci�n
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
					+ "Option 8.- Exit \n");

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
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery\n"
    				+ "6:Material\n");
    		break;
    	case 6:
    		//Menu for the Update
    		System.out.println("\nSelect the table you want to modify:\n"
    				+ "1:Machinery\n"
    				+ "2:WareHouse\n");
    		break;
    	case 7:
    		//Exit
    		System.out.println("Are you Sure?\n");
    		break;
    	}
    	
    }
    
	//Data Base Methods
	
	public static void createTable()
	{
		System.out.println("All tables created\n");
		jdbcManager.createTables();
		//System.out.println(" Tables created succesfully\n");
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
			listInstruments(relationOption);
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
			listInstruments(false);
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
		System.out.println("What table do you want to insert the value to? \n");
		selectionMenu(4);
		int op=writeNumber(7);
		switch(op){
		
		case 1: //Company   
			createCompany();
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
				if(jdbcManager.valExist("SELECT * FROM instrument WHERE instrument_ID = ?",1,null))
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
							System.out.println("Insert the amountOrder");
							int amOrd = writeNumber();
							jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(),op2,amOrd);
						}else
						{
					    	System.out.println("Introduce the values of the New Order:\n");
					    	
							Order ord = createOrder();
							jdbcManager.setOrderID(ord);
							
							System.out.println("Select the Primary Key of the instrument you want to order\n");
					    	listInstruments(false);
					    	int opt = writeNumber();
					    	ord.addInstrument(jdbcManager.selectInstrument(opt));
							System.out.println("Insert the amountOrder\n");
							int tao = writeNumber();
							
							jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(),ord.getOrderID(),tao);
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
				System.out.println("Introduce how much time (minutes) the instrument is in the machinery:\n");
				int time = writeNumber();

				jpaManager.selectMachinery(machID);
				//jdbcManager.selectMachinery(machID);
				jdbcManager.setRelationInstrumentMachinery(inst.getInstrumentID(),machID,time);
			}
			else
			{
		    	System.out.println("Introduce the values of the new machinery:\n");

				Machinery mach=createMachinery();
				jdbcManager.insert(mach);
				jdbcManager.setMachineryID(mach);

				System.out.println("Introduce how much time (minutes) the instrument is in the machinery:\n");
				int time = writeNumber();
				
				
				jdbcManager.setRelationInstrumentMachinery(inst.getInstrumentID(),mach.getMachineryID(),time);
				
				
			}			
		
			
			break;
		case 5: //Machinery
			Machinery mach = createMachinery();
			//jdbcManager.insert(mach);@SIMach
			jpaManager.insert(mach);
			
			break;
		case 6: //Material
			createMaterial(); 
			break;
		case 7: // Warehouse 
			Warehouse wareh = createWarehouse();
			jdbcManager.insert(wareh);
			break;
		}
		
		
	}
	
	public static void delValTable()
	{
		System.out.println("What table do you want to delete a value from? \n");
		selectionMenu(5);
		int op=0;
		
		switch(op){
		
		case 1: //Company 
			listCompanies(false);
			System.out.println("What company do you want to delete from this table? \n");
			int pk1 = writeNumber();
			jdbcManager.deleteCompany(pk1);
			break;
		case 2: //Employee
			listEmployees(false);
			System.out.println("What employee do you want to delete from this table? \n");
			int pk2 = writeNumber();
			jdbcManager.deleteEmployee(pk2);
			break;
		case 3: //Hospital 
			listHospitals(false);
			System.out.println("What hospital do you want to delete from this table? \n");
			int pk3 = writeNumber();
			jdbcManager.deleteHospital(pk3);
			break;
		case 4: //Instrument
			listInstruments(false);
			System.out.println("What instrument do you want to delete from this table? \n");
			int pk4 = writeNumber();
			jdbcManager.deleteInstrument(pk4);
			break;
		case 5: //Machinery
			listMachineries(false);
			System.out.println("What machinery do you want to delete from this table? \n");
			int pk5 = writeNumber();
			jdbcManager.deleteRelationInstrumentMachinery(pk5, "machineryID");
			jdbcManager.deleteRelationMachineryEmployee(pk5);
			jpaManager.deleteMachinery(pk5); 
			//jdbcManager.deleteMachinery(pk5);@JPAChange
			break;
		case 6: //Material
			listMaterials(false);
			System.out.println("What material do you want to delete from this table? \n");
			int pk6 = writeNumber();
			jpaManager.deleteMaterial(pk6);
			break;	
		}
		
	}
    
    public static void updValTable()
{
    selectionMenu(6);
    int op = writeNumber(2);
    switch(op)
    {
    case 1://Machinery
    	System.out.println("Select the primary key of the machinery you want to change:");
    	listMachineries(false);
    	int pk = writeNumber();
    	//machinery
    	System.out.println("You can only change the state of this machine, set the satate:\n"
    			+ "1:Work\n"
    			+ "2:No Work\n");
    	int op2 = writeNumber(2);
    	jpaManager.updateMachinery(pk,op2);
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
        		jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(), ord.getOrderID(), 0);
        	}
    	}
    	else
    	{
    		MtM mtm = xmlManager.unmarshallMtM(path);
    		
    		String queryIns = "SELECT * FROM instrument WHERE instrument_ID = ?";
    		String queryHosp = "SELECT * FROM hospital WHERE hospitalID = ?";
    		String queryOrd = "SELECT * FROM orders WHERE orderID = ?";
    		String queryMach = "SELECT * FROM machinery WHERE machineryID = ?";
    		String queryMat = "SELECT * FROM material WHERE materialID = ?";
    		String queryEmp = "SELECT * FROM employee WHERE employee_ID = ?";
    		String queryComp = "SELECT * FROM company WHERE companyID = ?";
    		String queryWare = "SELECT * FROM warehouse WHERE warehouse_ID = ?";
    		
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
    				}
    				
    				//Relation moment
    				
    				jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(), ord.getOrderID(), 100);
    				
    			}
    		}
    		
    		//INSTRUMENT
    		while(instIter.hasNext())
    		{
    			Instrument ins = instIter.next();
    			
    			if(!jdbcManager.valExist(queryIns, ins.getInstrumentID(), null))
    			{
    				jdbcManager.insert(ins);
    			}
    			
    			ArrayList<Order> ordList = (ArrayList<Order>)ins.getOrderList();
    			Iterator<Order> orderIter = ordList.iterator();
    			
    			while(orderIter.hasNext())
    			{
    				Order ord = orderIter.next();
    				if(!jdbcManager.valExist(queryOrd, ord.getOrderID(), null))
    				{
    					jdbcManager.insert(ord);
    				}
    				
    				jdbcManager.setRelationInstrumentOrder(ins.getInstrumentID(), ord.getOrderID());
    			}
    			//MAQUINARIAS
    			ArrayList<Machinery> machListIns = (ArrayList<Machinery>)ins.getMachineryTypeList();
    			Iterator <Machinery> machInsIter = machListIns.iterator();
    			
    			while(machInsIter.hasNext())
    			{
    				Machinery mach = machInsIter.next();
    				if(!jdbcManager.valExist(queryMach,mach.getMachineryID(),null))
    				{
    					jdbcManager.insert(mach);
    				}
    				
    				jdbcManager.setRelationInstrumentMachinery(ins.getInstrumentID(), mach.getMachineryID(), 100);
    			}
    			//WAREHOUSES
    			Warehouse ware = ins.getWarehouse();
    			if(!jdbcManager.valExist(queryWare,ware.getWarehouseID(), null))
    			{
    				//Introduce is relate
    				jdbcManager.insert(ware);
    			}
    			
    		}
    		
    		//MACHINERY
    		while(machIter.hasNext())
    		{
    			Machinery mach = machIter.next();
    			
    			if(!jdbcManager.valExist(queryMach,mach.getMachineryID(),null))
    			{
    				jdbcManager.insert(mach);
    			}
    			
    			//EMPLEADOS
    			ArrayList<Employee> empArray = (ArrayList<Employee>)mach.getEmployeeList();
    			Iterator<Employee> empIter = empArray.iterator();
    			while(empIter.hasNext())
    			{
    				Employee  emp = empIter.next();
    				if(jdbcManager.valExist(queryEmp,emp.getEmployee_ID(), null))
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
    			}
    			
    			Warehouse war = mat.getWarehouseID();
    			if(!jdbcManager.valExist(queryWare, war.getWarehouseID(),null))
    			{
    				jdbcManager.insert(war);
    			}
    		}
    		
    	}
    	
    	 
    }
    
    //Creation of Objects
    
    public static Hospital createHospital()
    {
    	System.out.println("Name of the hospital:");
		String a = writeString();
		System.out.println("Location of the Hospital: ");
		String b = writeString();
		System.out.println("Medical Specialization of the hospital:");
		String c = writeString();
		
		Hospital hosp = new Hospital(a,b,c);
		
		
		return hosp;
    } 
    
    public static Order createOrder()
    {		
    	
    	Order ord = new Order();
    	System.out.println("Total Amount of Instruments\n");
		int d = writeNumber();
		
		String []d1 = new String[2];
		String []d2 = new String[2];
		
		System.out.println("Order Date\n");
		d1 = createDate();
		System.out.println("Delivery Date");
		d2 = createDate();
		
		ord = jdbcManager.createPojoOrder(d,d1[0],d1[1],d1[2],d2[0],d2[1],d2[2]);
		
		return ord;
    }
    
    public static Warehouse createWarehouse(){
    	
    	System.out.println("Location of the warehouse\n");
		String warehouseLocation=writeString();
		System.out.println("Capacity of the warehouse\n");
		int capacity=writeNumber();
		System.out.println("Filled space in the warehouse\n");
		int filledSpace=writeNumber();
		
		Warehouse warehouse = new Warehouse( warehouseLocation,capacity,filledSpace);	
		
		return warehouse;
    }

    public static Instrument createInstrument(){
    	
    	System.out.println("Name of the instrument\n");
    	String name=writeString();
    	System.out.println("Model of the instrument\n");
		String model=writeString();
		System.out.println("Purpose of the instrument\n");
		String purpose=writeString();
		System.out.println("Amount of instrument\n");
		int amount=writeNumber();
		System.out.println("Number of uses of the instrument\n");
		int numberUses=writeNumber();
		System.out.println("Body location of the instrument\n");
		String bodyLocation=writeString();
		System.out.println("Price of the instrument\n");
		int price=writeNumber();
		
		Instrument inst = new Instrument (name,model,purpose,amount,numberUses,bodyLocation,price);
		
		return inst;
    }
    
    public static Employee createEmployee(){

	System.out.println("Name of the employee:\n");
	String name = writeString();
	System.out.println("Type of contract: \n");
	String typec = writeString();
	System.out.println("Does the machinery exist?\n");
	String d = writeString();
	Machinery mach=new Machinery();
	if(writeOption(d)){
		listMachineries(false);
		System.out.println("Select the ID of the machinery the employee is spezialized in\n");
		int e=writeNumber();
		
		mach=jpaManager.selectMachinery(e);
		//mach=jdbcManager.selectMachinery(e);@JPAChange
		
	}
	else
	{
		mach=createMachinery();
		jdbcManager.insert(mach);
		mach = jdbcManager.setMachineryID(mach);
		
	}
	
	String st = mach.getMachineryType();
	Employee emp = new Employee(name,st,typec,mach);
	
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
    	
    	
    	System.out.println("\nCompany location");
    	String a=writeString();
    	System.out.println("\nCompany name");
    	String b=writeString();
    	
    	Company com = new Company(a,b);
    	jdbcManager.insert(com);
    	com = jdbcManager.setCompanyID(com);

    	
    	return com;
    }
    
    public static Material createMaterial()
    {
    	
    	System.out.println("\nWeight");
    	int a = writeNumber();
    	System.out.println("\nVolume");
    	int b = writeNumber();
    	System.out.println("\nType");
    	String c = writeString();
    	
    	Material mat = new Material(a,b,c);
    	
    	//company
    	boolean aux = true;
    	while(aux)
    	{
    		System.out.println("This material is provided by a company from the database YES or NO: \n");
    		String answ = writeString();
    		if(answ.equals("YES"))
    		{
    			listCompanies(false);
    			System.out.println("Type the PK of the company:\n");
    			int pk = writeNumber();
    			Company com = jdbcManager.selectCompany(pk);
    			mat.setCompanyID(com);
    			System.out.println("The material is attached to the company\n");
    			aux = false;
    		
    		}else if(answ.equals("NO"))
    		{
    			System.out.println("Therefore, you need to create a new company\n");
    			Company com = createCompany();
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
    		if(answ.equals("YES"))
    		{
    			listMachineries(false);
    			System.out.println("Type the PK of the machinery:\n");
    			int pk = writeNumber();
    			Machinery mach = jpaManager.selectMachinery(pk);
    			if(mach != null){
    				mat.setMachineryID(mach);
    				aux2 = false;
    			}
    		
    		}else if(answ.equals("NO"))
    		{
    			System.out.println("\n Therefore, a Machinery must be created\n");
    			Machinery mach = createMachinery();
    			jdbcManager.insert(mach);
    			jdbcManager.setMachineryID(mach);
    			
    			mat.setMachineryID(mach);
    			aux2 = false;
    		}else
    		{
    			System.out.println("Please type YES or NO\n");
    		}
    		
    		
    	}
    	
    	//warehouse
    	boolean aux3 = true;
    	while(aux3)
    	{
    		System.out.println("The material need to be stored in a warehouse\n");
    		System.out.println("Do you wnat to:\n1:Create a New WareHouse\n2:Use a warehouse from the DataBase");
    		int op = writeNumber(2);
    		if(op == 1)
    		{
    			//crear
    			System.out.println("A new WareHouse will be created");
    			Warehouse war = createWarehouse();
    			jdbcManager.insert(war);
    			jdbcManager.setWarehouseID(war);
    			mat.setWarehouseID(war);
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
        			mat.setWarehouseID(ware);
        			aux3 = false;
        		}
    		}
    	
    	}

    	jpaManager.insert(mat);
		//jdbcManager.insert(mat);
		System.out.println("The material is correctly attached to the database\n");
		
    	return mat;
    	
    }

    
    //Show the Objects
    public static void showCompany(int pk){
    	Company com;
		com = jdbcManager.selectCompany(pk);
		com.printCompany();
    }
    
    public static void showMaterial(int pk){
    	Material mat;
    	mat = jpaManager.selectMaterial(pk);
    	mat.printMaterial();
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
    	inst.toString();
    	
    }
    
    public static void showWarehouse(int pk){
    	Warehouse war;
    	war = jdbcManager.selectWarehouse(pk);
    	war.printWarehouse();
    	//war.toString();
    }
    
    public static void showEmployee(int pk)
    {
    	Employee emp;
    	emp = jdbcManager.selectEmployee(pk);
    	emp.toString();
    }
    
    public static void showMachinery(int pk)
    {
    	Machinery mach;
    	mach = jpaManager.selectMachinery(pk);
    	//mach = jdbcManager.selectMachinery(pk);@JPAChange
    	jdbcManager.setMachineryRelations(mach);
    	mach.printMach();
    }
    
    //List the objects
    public static void listCompanies(boolean relation){
    	Company com;
		ArrayList<Company> comList = new ArrayList<Company>();
		comList = jdbcManager.selectAllCompanies();
			
		int count= 0;
			
		while(count < comList.size())
		{
			com = comList.get(count);
			String name = com.getCompanyName();
			int id = com.getCompanyID();
			
				System.out.printf("id: %d,name: %s\n",id,name);
				count++;
			}
	}
  
    public static void listMaterials(boolean relation){
        	Material mat;
        	ArrayList<Material> matList = new ArrayList<Material>();
        	matList = jdbcManager.selectAllMaterials();
        	
        	int count = 0;
        	
        	while(count < matList.size())
        	{
        		mat = matList.get(count);
        		if(relation)
        		{
        			System.out.printf("id: %d, type: %d relations: company id:%d machinery id:%d wharehouse id:%d\n", mat.getMaterialID() , mat.getType(), mat.getCompany(), mat.getMachineryID(), mat.getWarehouseID());
        		}else
        		{
        			System.out.printf("id: %d, type: %d \n", mat.getMaterialID(), mat.getType());
        		}
        		
        	}
        	
        }
     
    public static void listHospitals(boolean relation)
    {
    	Hospital hosp;
		ArrayList<Hospital> hospList = jdbcManager.selectAllHospitals();
		Iterator <Hospital> iter = hospList.iterator();
		
		while(iter.hasNext())
		{
			hosp = iter.next();
			if(relation)
			{
				jdbcManager.setHospitalRelations(hosp);
				System.out.printf("id: %d,name: %s\n",hosp.getHospitalID(),hosp.getName());
				System.out.printf("Orden Relations: ids: ");
				Iterator<Order> iterOrd = hosp.getOrderList().iterator();
				while(iterOrd.hasNext())
				{
					Order ord = iterOrd.next();
					System.out.printf("%d, ",ord.getOrderID());
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
    	
    	while(iter.hasNext())
    	{
    		ord = iter.next();
    		jdbcManager.setOrderRelations(ord);
    		if(relation)
    		{
    			System.out.printf("id: %d,\n",ord.getOrderID());
    			
    			System.out.println("Hospital Relations \nids: ");
    			Iterator<Hospital> hospIter = ord.getHospitalList().iterator();
    			while(hospIter.hasNext())
    			{
    				Hospital hosp = hospIter.next();
    				System.out.printf("%d, ",hosp.getHospitalID());
    			}
    			
    			System.out.println("Instruments Relations: \nids: ");
    			Iterator<Instrument> insIter = ord.getInstrumentList().iterator();
    			while(insIter.hasNext())
    			{
    				Instrument ins = insIter.next();
    				System.out.printf("%d, ",ins.getInstrumentID());
    			}
    		}else
    		{
    			System.out.printf("id: %d\n",ord.getOrderID());
    		}
    	}
    	
    }
        
    public static void listInstruments(boolean relation){
    	Instrument inst = new Instrument();
    	ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
    	
    	instrumentList = jdbcManager.selectAllInstruments();
    	Iterator <Instrument> iter = instrumentList.iterator();
    	
    	while(iter.hasNext()){
    		
    		inst = iter.next();
    
    		if(relation){
    			jdbcManager.setInstrumentRelations(inst);
    			System.out.printf("id of instrument: %d, relation with order: %d\n",inst.getInstrumentID(),inst.getOrderList().toString());
    			System.out.printf("id of instrument: %d, relation with machinery: %d\n",inst.getInstrumentID(),inst.getMachineryTypeList().toString());
    			System.out.printf("id of instrument: %d, relation with warehouse: %d\n",inst.getInstrumentID(),inst.getWarehouse().toString());	
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
    	
    	while(count < warehouseList.size())
		{
			war = warehouseList.get(count);
			String warehouseLocation = war.getWarehouseLocation();
			int id = war.getWarehouseID();
			
				System.out.printf("Id of the warehouse: %d,location of the warehouse: %s\n",id,warehouseLocation);
				count++;
			}
    }
    
    public static void listEmployees(boolean relation)
    {
    	Employee emp;
    	ArrayList<Employee> empList = new ArrayList<Employee>();
    	empList = jdbcManager.selectAllEmployees();
    	
    	int count = 0;
    	while(count < empList.size())
    	{
    		emp = empList.get(count);
    		String name = emp.getName();
			int id = emp.getEmployee_ID();
    		emp = empList.get(count);
    		if(relation){
        		System.out.printf("id: %d, mach: %d\n",emp.getEmployee_ID(),emp.getMachineryType().getMachineryType());
            	
    		}
    		else{
        		System.out.printf("id: %d, name: %d\n",id,name);
    		}
    		count ++;
    	} 	
    }
    
    public static void listMachineries(boolean relation) {
    	
    	Machinery mach;
    	ArrayList<Machinery> machList = jdbcManager.selectAllMachineries();
    	int count = 0;
    	
    	while(count < machList.size()){
    		
    		mach =machList.get(count);
    		
    		int id = mach.getMachineryID();
        	String machineryType = mach.getMachineryType();
    		

    		if(relation)
    		{
    			jdbcManager.setMachineryRelations(mach);
    			System.out.printf("id: %d, relation Instrument: %s, relation employee: %s, relation materials: %s\n"
    					,mach.getMachineryID(),mach.getInstrumentList().toString(),mach.getEmployeeList().toString(),mach.getMaterialList().toString());
       
    		}else
    		{
    			System.out.printf("id: %d, machinery type: %s\n",id,machineryType);
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
}
