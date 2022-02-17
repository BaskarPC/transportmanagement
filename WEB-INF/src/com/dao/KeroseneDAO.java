package com.dao;
	import java.sql.*;
	import java.util.ArrayList;
	import sun.jdbc.odbc.JdbcOdbcDriver;

	import org.apache.log4j.Logger;

	import com.vo.KeroseneVO;
	import com.dbcom.*;
	public class KeroseneDAO {
		private static final Logger logger=(Logger)Logger.getLogger(KeroseneDAO.class);
		public ArrayList fetchUser(KeroseneVO aVO)throws Exception
		{
			ArrayList userArrayList=new ArrayList();
			dbcom ob=new dbcom();
			String query="select cdesc from lookup where ctype='kerosenereason'";
			userArrayList=ob.selectQuery("com.vo.KeroseneVO", query);
			for(int i=0 ;i<userArrayList.size();i++)
			{
				KeroseneVO vo=new KeroseneVO();
			vo=(KeroseneVO)userArrayList.get(i);
		    logger.debug("value :"+vo.getKeroseneReason());
		    
			}
			
			return userArrayList;
		 }

	}


