package com.dbcom;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import org.xml.sax.SAXException;

import org.xml.sax.XMLReader;




import java.io.IOException;
import java.util.ArrayList;

public class fetchXMLProperty 
{
	String query;
	String filename = null;
	fetchXMLProperty (String query)	
	{	
		this.query=query; 
	}
    
    private static final Logger logger=(Logger)Logger.getLogger(fetchXMLProperty.class);
    public ArrayList fetchProperty()
    {  
    	logger.debug("In fetchProperty <<<<<< ");
    	filename = "E:\\Tomcat 5.5\\webapps\\transportCombine\\WEB-INF\\src\\com\\dbcom\\KecTransFile.xml"; 
    	logger.debug("fetchProperty : the givent XML File path:"+ filename);   	  	        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        XMLReader reader = null;
        try {
          SAXParser parser = spf.newSAXParser();
          reader = parser.getXMLReader();
        } catch (Exception e1) {
          System.err.println(e1);
          System.exit(1);
        }
        dbproperty ch=new dbproperty(query);
        reader.setErrorHandler(new dbErrorHandler());
        reader.setContentHandler(ch);      
        try {
          InputSource is = new InputSource(filename);
          reader.parse(is);          
          logger.debug("fetchProperty : Return list size from dbproperty");
          logger.debug("fetchProperty :Array list size ="+ ch.propertylist.size());
          
        } catch (SAXException e3) {
          System.exit(1);
        } catch (IOException e) {
          System.err.println(e);
          System.exit(1);
        } 
           
        logger.debug("In fetchProperty >>>>>>> ");
        return ch.propertylist;
    	    
    }
  

}

		

