package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.DieselOrderFromEODAO;
import com.vo.DieselOrderFromEOVO;

public class DieselOrderFromEOService {
			private static final Logger logger=(Logger)Logger.getLogger(DieselOrderFromEOService.class);
		ArrayList list=null;
		DieselOrderFromEODAO dao=new DieselOrderFromEODAO();
		public void insert(DieselOrderFromEOVO vo)
		{
			logger.debug("insert :DieselOrderFromEOService <<<<<<<<<<<<<<< ");
			
			dao.insert(vo);
			logger.debug("insert :DieselOrderFromEOService >>>>>>>>>>>>>>> ");
			
		}
		public ArrayList retrieve(int jobid)
		{
			logger.debug("retrieve :DieselOrderFromEOService <<<<<<<<<<<<<<< ");
		
			list=dao.retrieve(jobid);
			logger.debug("retrieve :DieselOrderFromEOService >>>>>>>>>>>>>>> ");
			return list;
		}
}
