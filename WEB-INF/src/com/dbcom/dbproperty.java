package com.dbcom;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

class dbproperty implements ContentHandler {	
	String query;
	ArrayList userList=new ArrayList();
	private static final Logger logger=(Logger)Logger.getLogger(dbproperty.class);
	public dbproperty(String query){
		logger.debug("In dbProperty Class ...........");
		this.query=query;		
	}
	private Locator locator;	
	public ArrayList propertylist=new ArrayList(); 
	public void setDocumentLocator(Locator locator) {this.locator = locator;}
	public void startDocument() {  }
	public void endDocument() {  }
	public void startPrefixMapping(String prefix, String uri) {}
	public void endPrefixMapping(String prefix) {}
	public void startElement(String namespaceURI, String localName,String qName, Attributes atts) 
  	{ 
		  store(qName,atts);
	}
	public void endElement(String namespaceURI, String localName, String qName) {}
	public void characters(char[] ch, int start, int length) { }
	public void ignorableWhitespace(char[] ch, int start, int length) {}
	public void processingInstruction(String target, String data) {}
	public void skippedEntity(String name) {  }  
	public void store(String qName,Attributes atts)
  	{
		logger.debug(" store method <<<<<<");
		ArrayList field_list=new ArrayList();
		connection con=new connection();
		getfield gf=new getfield();
		field_list=gf.fetchField(con,query);
		logger.debug("store : Query field size :"+field_list.size());
		if(qName.equals("column"))
		  {	
			logger.debug("store : with in if condition ");
			 	  for (int i = 0; i < atts.getLength(); i=i+2)
					  {
			 		 logger.debug("store :with in first for loop");  
			 		for(int j=0;j<field_list.size();j++)
			        	{ 
			 			 logger.debug("store :with in second for loop"); 		
			        		XMLElementsVO fieldvo=new XMLElementsVO();
			        		fieldvo=(XMLElementsVO)field_list.get(j);			        		
			        		logger.debug("store :Attribute name ="+atts.getValue(i));
			        		logger.debug("store :Query field name ="+fieldvo.getFieldname());
			        		if(atts.getValue(i).equals(fieldvo.getFieldname()))
			   		     	{
			        			logger.debug("store : both values are equal");
			        			XMLElementsVO vo=new XMLElementsVO();
			        			logger.debug("store : for the field in query "+ fieldvo.getFieldname()+", Equalent Property value in xml document is "+ atts.getValue(i+1));
			        			vo.setProperty(atts.getValue(i+1));
			        			logger.debug("store : before property list size ="+propertylist.size());
			        			logger.debug("store : added value : "+vo.getProperty());
			   		    	 	propertylist.add(vo);   
			   		    	 	logger.debug("store : after property list size ="+propertylist.size());
			   		    	 	
			   		     	}
			        	}			 	
				  }	  
			  }
			
		logger.debug(" store method >>>>>>"); 
	}

}