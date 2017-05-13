package mtm.db.xmls;

import java.io.File;

import mtm.db.pojos.*;

public class XMLManager 
{
	
	public void marshallHospital(String route,Hospital hosp)
	{
		File file = new File(route);
		Java2Xml j2x = new Java2Xml();
		j2x.createXML(file,hosp);
		
		
	}
	
	public Hospital unmarshallHospital(String route)
	{
		Hospital hosp;
		File file = new File(route);
		Xml2Java x2j = new Xml2Java();
		
		hosp = x2j.hospitalX2J(file);
		
		return hosp;
	}

}
