package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

 class EclipseInterface 
{
	public static void main()
	{
		
	}



	public int abrirMenu()
	{
		int opcion;
		int numOpciones = 3; //Numero de opciones que podemos seleccionar con esta funci�n
		imprimirMenu();
		opcion = selectNumber(numOpciones);
		System.out.println("Selecciona la Opci�n que tu Quieras Wapi");
		return opcion;
	}

	public void imprimirMenu()
	{
		//Si a�ades opciones, recuerda mirar elm�todo abrirMenu
		System.out.println("Opcion 1.- Introduce Valores de Tabla\n"
				+ "Opci�n 2.- Borrar Valores de la Tabla");
	}
	
	public int selectNumber(int numOp)
	{
		int option = 0;
		try
		{
			int numIntro = writeNumber();
			if((numIntro > numOp) || (numIntro < 0))
			{	
				option = -1;
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error Introducing the values");
			
		}
		return option;
	}
}