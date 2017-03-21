package mtm.db.Interface;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validator
{
	//This class contains some functions that we should use in order to know if the user is
	//introducing the type of value we are storing in the variable.
	
	static BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
	
	// Writing Methods
	
	int variable;
	
	public static int writeNumber() 
	{
		//P Methods used to write an integer value without conditions (Just to be an Integer)
        boolean out = false;
        int answer = -1;
        String stringNumber = "";
        try
        {
        	 do 
        	 {
        		    
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
	
	public static int writeNumber(int upperLim)
	{
		//P Method used to set one limit, the upper limit
		int numIntro = -1;
		boolean out = false;
		String stringNumber = "";
		try
		{
			while((numIntro > upperLim) || (numIntro < 0))
			{
				 do 
	        	 {
	                 System.out.println("Introduce a number, anything else Wapi\n");
	   
	                     stringNumber = c.readLine();
	                     if (valNumString(stringNumber)) 
	                     {
	                         numIntro = Integer.parseInt(stringNumber);
	                         out = true;
	                     }
	                
	        	 } while (!out);//Mientras que no me introduzca un numero, no le dejo salir
				
				if((numIntro > upperLim) || (numIntro < 0))//si hay 5 opciones no puedes poner 6
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
	
	
	// Validating Methods
	
	public static boolean valNumString(String val) 
	//Method used to validate if the value val is realy an integer or not
	{
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }
	
	// More Functions


}
