package com.dbcom;


import java.lang.reflect.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;


public class reflection 
{    
	ArrayList ref_fldlist=new ArrayList();        	        	   
	private static final Logger logger=(Logger)Logger.getLogger(reflection.class);
   	public ArrayList getVOMethod(String vofilename)
	{    	   
   			logger.debug("In getVOMethod <<<<<<<");
            try
            {
            	Class cls = Class.forName(vofilename);            	             	 
            	Field fieldlist[]=cls.getDeclaredFields();
            	for(int i=0;i<fieldlist.length;i++)
            	{    
            		XMLElementsVO vo=new XMLElementsVO();
            		Field fld=fieldlist[i];
                    logger.debug("getVOMethod : VOfile Method name :"+i+" "+fld.getName());
                    vo.setFieldname(fld.getName());
                    vo.setClassname(cls);
                    logger.debug("getVOMethod : before array list count :"+ref_fldlist.size());
                    logger.debug("getVOMethod : Added value is :"+vo.getFieldname());
                    ref_fldlist.add(vo);    
                    logger.debug("getVOMethod : after array list count :"+ref_fldlist.size());
                 }
                
             }
             catch (ClassNotFoundException e) {logger.error("ClassNotFoundException :"+e); }
             logger.debug("In getVOMethod >>>>>>");
             return ref_fldlist;
       }
	
}
