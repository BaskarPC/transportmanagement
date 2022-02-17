package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.util.WasteUtil;
import com.vo.WasteVO;

public class WasteDAO {
	private static final Logger logger=(Logger)Logger.getLogger(WasteDAO.class);
	ArrayList instList=new ArrayList();
	WasteUtil util=new WasteUtil();
	 public ArrayList fetchWasteReason()
		{
		 instList=util.fetchWasteReason();
			return instList;
		}
	 public void insertValues(WasteVO kvo,int jobid)
		{   
			
			util.insertValues(kvo,jobid);
			logger.debug("institution list size="+instList.size());
			
		}
	
	
}
