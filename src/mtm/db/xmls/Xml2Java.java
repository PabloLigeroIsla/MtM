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

	public MtM MtMX2J(File file)
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
