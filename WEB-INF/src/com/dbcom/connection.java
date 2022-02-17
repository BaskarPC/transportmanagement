package com.dbcom;

import java.sql.Connection;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class connection 	
{	

Connection con;
Statement st;
static int i;
private static final Logger logger=(Logger)Logger.getLogger(connection.class);
String query;

public connection()	{
		logger.debug("In connection Constructor class <<<<< ");	
		try{
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		logger.debug("after driver specification");
		//con=DriverManager.getConnection("jdbc:odbc:transtest","kectrans1","kectrans1");
		Context ctx = new InitialContext();
			DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
			logger.debug("connection : datasource created "+ds);
		   Connection con = ds.getConnection();
			logger.debug("connection : connection Established ");
		     st=con.createStatement();			
		    logger.debug("statement created");	}
			catch (Exception e) {
	  			logger.error("SQL Exception :" +e);
			}
			logger.debug("In connection Constructor class >>>>>> ");
	}

}
