package mtm.db.xmls;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import mtm.db.pojos.*;


public class Xml2Java 
{
	public Hospital hospitalX2J(File file)
	{
		
		Hospital hosp = null;
		
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		hosp = (Hospital) unmarshaller.unmarshal(file);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return hosp;
	}
	
	public Employee employeeX2J(File file)
	{
		
		Employee emp = null;
		
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		emp = (Employee) unmarshaller.unmarshal(file);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public Machinery machineryX2J(File file)
	{
		
		Machinery mach = null;
		
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Machinery.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		mach = (Machinery) unmarshaller.unmarshal(file);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return mach;
	}
	
	public MtM mtmX2J(File file)
	{
		MtM mtm = null;
		
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(MtM.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			mtm = (MtM) unmarshaller.unmarshal(file);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return mtm;
	}
}
