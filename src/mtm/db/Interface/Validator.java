package mtm.db.Interface;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validator
{
	//This class contains some functions that we should use in order to know if the user is
	//introducing the type of value we are storing in the variable.
	
	static BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
	
	//Writing Methods
	
	public static int writeNumber() 
	{
		//Methos used to write an integer value without conditions (Just to be an Integer)
        boolean out = false;
        int answer = 0;
        String stringNumber = "";
        try
        {
        	 do {
        		    
                 System.out.println("Introduce a number, anything else Wapi\n");
   
                     stringNumber = c.readLine();
                     if (valNumString(stringNumber)) 
                     {
                         answer = Integer.parseInt(stringNumber);
                         out = true;
                     }
                
          } while (!out);//Mientras que no me introduzca un numero, no le dejo salir
        }catch(IOException ex)
        {
        	 ex.printStackTrace();
        }

        return answer;
    }
	
	public static int writeNumber(int upperlimit)
	{
		// Method used to 
		int numIntro = -1;
		try
		{
			while((numIntro > upperlimit) || (numIntro < 0))
			{
			numIntro = writeNumber();
			if((numIntro > upperlimit) || (numIntro < 0))//si hay 5 opciones no puedes poner 6
			{	
				System.out.println("Out of established limits\n");
			}
			
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error Introducing the values");
			
		}
		return numIntro;
	}
	
	//Validating Methods
	
	public static boolean valNumString(String validar) 
	{
        try {
            Integer.parseInt(validar);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }
	
	
}
