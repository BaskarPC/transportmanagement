package com.dbcom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class result
{   ResultSet rs=null;
	private static final Logger logger=(Logger)Logger.getLogger(connection.class);
public ResultSet getrs(connection con,String query)
	{
	
		logger.debug("In getrs method() <<<<<<");
		logger.debug("The given Query is :"+query);
	try{		
	if(query.startsWith("select"))
		{
			logger.debug("before the select query execution");
			rs=con.st.executeQuery(query);			
			logger.debug("This is select query");
		}
		else
		{
			logger.debug("before the other query execution");
			con.st.executeUpdate(query);
			logger.debug("Other than Select Query");
			rs=null;
	     }	   
	}   	
		catch (SQLException e) {	logger.error("SQL Exception :" +e);  		}
  		catch (Exception e) {  		logger.error("Exception :" +e);  		} 			
  			
  		logger.debug("In getrs method() >>>>>>");
return rs;
	}
}