package com.dbcom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class dbcom 
{
	private static final Logger logger=(Logger)Logger.getLogger(connection.class);
	public static int record_count;
	public static int field_count;
	connection con=new connection();
	result rset=new result();	
	
	 public Integer mtdindex(String fld,String vofilename)
	 	   {
		 logger.debug("In mtdIndex() method <<<<<<< ");
		 String token = fld.substring(0,1);
		 String token2= fld.substring(1);
		 int  i=0;
		 String name="set"+token.toUpperCase() + token2;
		 logger.debug("mtdindex :Method to be called ="+name);
		 try{
		 Class cls = Class.forName(vofilename);
		 Method m[]=cls.getMethods();
		 
		 for(int j=0;j<15;j++)
		 { 	logger.debug("i :"+j);
		    logger.debug("mtdindex : VO file methods name ="+m[j].getName());
		 }
			 		
    	 while(!(m[i].getName().equals(name)))
    	 {  
    		 logger.debug("mtdindex : with in while loop ,i ="+i);
    		 i++;
    	   		
    	 }    	
		  }catch(Exception e){System.out.println(e);}
		  logger.debug("mtdindex : return index value to the called method i ="+i);
		  logger.debug("In mtdIndex() method >>>>>> ");
		  return i;
	 	  }
    
	public ArrayList selectQuery(String vofile, String query)		
	{	
		logger.debug("In selectQuery <<<<<<< ");
		//creating arraylists
		ArrayList ref_list=new ArrayList();
		ArrayList prop_list=new ArrayList();
		ArrayList fld_list=new ArrayList();
		ArrayList res=new ArrayList();		
		//declare variables
		String[] fld1=new String[500];
		Integer[] index=new Integer[500];
		int k=0;		
		// creating objects for classes
		getfield gf=new getfield();
		reflection ref=new reflection();
		fetchXMLProperty fp=new fetchXMLProperty(query);
		
		fld_list=gf.fetchField(con,query);	
		logger.debug("selectQuery : Received field list size ="+fld_list.size());
		ref_list=ref.getVOMethod(vofile);
		logger.debug("selectQuery : Received Reflection ArrayList size ="+ref_list.size());
		prop_list=fp.fetchProperty();	
		logger.debug("selectQuery : Received property list size ="+prop_list.size());

		for(int i=0;i<ref_list.size();i++)
		{
		for(int j=0;j<prop_list.size();j++)
		{
		XMLElementsVO propvo=new XMLElementsVO();
		propvo=(XMLElementsVO)prop_list.get(j);
		XMLElementsVO fieldvo=new XMLElementsVO();
		fieldvo=(XMLElementsVO)ref_list.get(i);
		logger.debug("selectQuery : VO file method name ="+fieldvo.getFieldname());
		logger.debug("selectQuery : XML property value ="+propvo.getProperty());
		if(fieldvo.getFieldname().equals(propvo.getProperty()))
		{
		logger.debug("selectQuery : with in if condition ");	
		index[k]=mtdindex( fieldvo.getFieldname(),vofile);
		logger.debug("selectQuery : Received Index value ="+index[k]);
		XMLElementsVO vo=new XMLElementsVO();
		vo=(XMLElementsVO)fld_list.get(j);
	    String fldname=vo.getFieldname();
	    logger.debug("selectQuery : Field name ="+fldname);
	    fld1[k]=fldname;
	    logger.debug("selectQuery :fld1[k]= "+  fld1[k]);	     
	    k++;
	  	    field_count=k;
		}
		}	
		}	
	try{
		 Class cls = Class.forName(vofile);	
		 Method m[]=cls.getMethods();	
		 int i=0;
		 ResultSet rs=rset.getrs(con,query);
	if(!rs.equals(null))
		{
    while(rs.next())
    		{
    	        logger.debug("selectQuery : with in resultset while loop");
    			Object o=cls.newInstance();
    	    	record_count++;
    	    	logger.debug("selectQuery : field_count ="+field_count);
    	    	for( i=0;i<field_count;i++)
    	    	{    			 
    	    		logger.debug("selectQuery : index value ="+index[i]);
    	    		logger.debug("selectQuery : Required setter method name ="+  m[index[i]].getName());
    	    		m[index[i]].invoke(cls.cast(o), rs.getString(fld1[i]));
    	    		logger.debug("selectQuery : count before result list size  :"+res.size());
    	    	}
    	    	 logger.debug("selectQuery : ths added values is "+cls.cast(o));
    			 res.add(cls.cast(o));
    			 logger.debug("selectQuery : count after result list size  :"+res.size());   		 			
    		} 
		}
		else
		{
			logger.debug("list sizeeee :"+res.size());
		}
    
    }catch(ClassNotFoundException e){logger.error("ClassNotFoundException :"+e);}   
    catch(IllegalAccessException e){logger.error("IllegalAccessException :"+e);}
    catch(SQLException e){logger.error("SQLException :"+e);}
    catch(InvocationTargetException e){logger.error("InvocationTargetException :"+e);}
    catch(InstantiationException e){logger.error("InstantiationException :"+e);
    }       
    logger.debug("In selectQuery  >>>>>>> ");
	return res;	  
	}
	public void otherQuery(String query)
	{
		logger.debug("In otherQuery <<<<<<"); 
		rset.getrs(con,query);
		logger.debug("In otherQuery >>>>>>"); 
		
	}
	}
	
		










