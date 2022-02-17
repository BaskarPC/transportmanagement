package com.dbcom;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;


public class getfield
{
	private static final Logger logger=(Logger)Logger.getLogger(getfield.class);
	public ArrayList fetchField(connection con,String query)
		{
		logger.debug("getfield class <<<<<< ");
		logger.debug("In fetch field method using getfield class......");
		ArrayList fieldlist=new ArrayList();
		result rset=new result();
		try
			{
			 
			 ResultSet rs=rset.getrs(con,query);
			 ResultSetMetaData rsmd = rs.getMetaData();
			
			    int numColumns = rsmd.getColumnCount();
			   
			  

			    // Get the column names; column indices start from 1
			    for (int i=1; i<numColumns+1; i++) 
			    {
			    	XMLElementsVO uservo=new XMLElementsVO();
			    	logger.debug(rsmd.getColumnName(i));
			    	uservo.setFieldname(rsmd.getColumnName(i));
			    	
			    	fieldlist.add(uservo);

			    	// Get the name of the column's table name
			    	//System.out.println( rsmd.getTableName(i));
			    }
			   
			    

			  } 
			catch(SQLException e){logger.error("SQLException :"+e);}
			  
			return fieldlist;
			 
	}
  
}	  