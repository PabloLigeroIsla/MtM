package mtm.db.xmls;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import mtm.db.pojos.*;


public class Java2Xml 
{
	//Marshall
	public void createXML(File marshallFile, Hospital hosp)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			
			marshaller.marshal(hosp,marshallFile);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
