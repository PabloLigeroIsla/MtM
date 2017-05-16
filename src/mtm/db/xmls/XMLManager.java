package mtm.db.xmls;

import java.io.File;

import mtm.db.pojos.*;

public class XMLManager 
{
	//Marshall
	public void marshallHospital(String route,Hospital hosp)
	{
		File file = new File(route);
		Java2Xml j2x = new Java2Xml();
		j2x.createXML(file,hosp);
		
		
	}
	
	public void marshalMtM(String route,MtM mtm)
	{
		File file = new File(route);
		Java2Xml j2x = new Java2Xml();
		j2x.createXML(file,mtm);
	}
	
	//Unmarshall
	public Hospital unmarshallHospital(String route)
	{
		Hospital hosp;
		File file = new File(route);
		Xml2Java x2j = new Xml2Java();
		
		hosp = x2j.hospitalX2J(file);
		
		return hosp;
	}

	public MtM unmarshallMtM(String route)
	{
		MtM mtm;
		File file = new File(route);
		Xml2Java x2j = new Xml2Java();
		
		mtm = x2j.mtmX2J(file);
		
		return mtm;
	}
	
}