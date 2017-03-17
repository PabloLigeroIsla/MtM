package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

import java.io.IOException;

import mtm.db.jdbc.*;

 class EclipseInterface 
{
	public static void main()
	{
		//Start of the db
		int option = openMenu();
		
		switch(option)
		{
			
		case 1:
		
		case 2:
		
		case 3:
			
		case 4:
		
		}
	}


	//User Methods
	public static int openMenu()
	{
		int option;
		int numOptions = 4; //Numero de opciones que podemos seleccionar con esta función
		printMenu();
		option = writeNumber(numOptions);
		
		return option;
	}

	public static void printMenu()
	{
		//Si añades opciones, recuerda mirar el metodo abrirMenu
		System.out.println("Opcion 1.- Create Table\n"
				+ "Opcion 2.- Drop Table\n"
				+ "Opcion 3.- Introduce values to a Table\n"
				+ "Opción 4.- Delete value of a Table\n");
	}
	
	//Data Base Methods
	
	
	
	//Extra Methods
	
    public static void waitEnter()
    {	
        System.out.println("Press enter to continue: \n");
        try{
            String a = c.readLine();
        }catch(IOException ex){
        	ex.printStackTrace();
        }
    
    }
    
    
}