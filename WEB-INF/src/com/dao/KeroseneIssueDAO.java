package com.dao;
	import java.sql.*;
	import java.util.ArrayList;
	import sun.jdbc.odbc.JdbcOdbcDriver;

	import org.apache.log4j.Logger;

import com.service.KeroseneIssueService;
import com.util.KeroseneIssueUtil;
import com.vo.KeroseneIssueVO;
	import com.vo.KeroseneVO;
import com.dbcom.*;
	public class KeroseneIssueDAO {
		private static final Logger logger=(Logger)Logger.getLogger(KeroseneIssueDAO.class);
		ArrayList instList=new ArrayList();
		dbcom db=new dbcom();
		 String vofile="com.vo.KeroseneIssueVO";
		 KeroseneIssueUtil util=new KeroseneIssueUtil();
		 
		public ArrayList fetchKeroseneReason()
		{   
			String query="select id as GREASEREASONID,codetype as GREASEREASONTYPE,codedesc as GREASEREASONDESC from MAINTENANCE_REASON_LOOKUP where codetype='KEROSENE'";
			instList=db.selectQuery(vofile,query);
			logger.debug("institution list size="+instList.size());
			
			return instList;
		}
		 
		public void insertValues(KeroseneIssueVO kvo,int jobid)
		{   
			
			util.insertValues(kvo,jobid);
			logger.debug("institution list size="+instList.size());
			
		}
		
		public ArrayList fetchValues(int jobid)
		{   
			
			instList=util.fetchValues(jobid);
			logger.debug("institution list size="+instList.size());
			return instList;
		}
		
		public ArrayList fetchRates(String pid)
		{   
			
			String query="select OLD_RATE as tempoldprice,NEW_RATE as tempnewprice,TOLD_QTY as tempoldquantity,TNEW_QTY as tempnewquantity FROM COMMON_TRANSACTION WHERE PARTNUMBER='"+pid+"'";
			instList=db.selectQuery(vofile,query);
			logger.debug("institution list size="+instList.size());
			return instList;
		}
	}


