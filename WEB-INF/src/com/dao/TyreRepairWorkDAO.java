package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.TyreRepairWorkVO;
import com.dbcom.*;

public class TyreRepairWorkDAO {
	
private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkDAO.class);

    TyreRepairWorkVO tyrerepairworkvo=new TyreRepairWorkVO();
    dbcom db=new dbcom();
	public ArrayList fetchTyreSize(String query)throws Exception
	{   
		ArrayList tyreSizeList=new ArrayList();
		tyreSizeList=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return tyreSizeList;
	 }
	
	public ArrayList fetchTyreBrand(String query)throws Exception
	{   
		ArrayList tyreBrandList=new ArrayList();
		tyreBrandList=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return tyreBrandList;
	 }
	
	public ArrayList fetchTyrePly(String query)throws Exception
	{   
		ArrayList tyrePlyList=new ArrayList();
		tyrePlyList=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return tyrePlyList;
	 }
	
    public ArrayList fetchTyreNumber(String query)throws Exception
	{   
		ArrayList tyreNumberList=new ArrayList();
		tyreNumberList=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return tyreNumberList;
	 }

	public ArrayList fetchTyreDetails(String query) {
		
		ArrayList tyreDetailsList=new ArrayList();
		tyreDetailsList=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return tyreDetailsList;
		
	}

	public ArrayList fetchMinJobid(String query) {
		ArrayList jobidList=new ArrayList();
		jobidList=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return jobidList;
	}
	
	public ArrayList retrievetyredetails(String query) {
		
		ArrayList tyredetailslist=new ArrayList();
		tyredetailslist=db.selectQuery("com.vo.TyreRepairWorkVO",query);
		return tyredetailslist;
	}
 
	public ArrayList retrievecommontyredetails(String query) {
		logger.debug("Inside DAO..");
	 ArrayList commondetailslist=new ArrayList();
	 commondetailslist=db.selectQuery("com.vo.TyreRepairWorkVO",query);
	 logger.debug("List in dao : "+commondetailslist.size());
	 logger.debug("Outside DAO..");
	 return commondetailslist;
	}

	public void insertValues1(String query)	{   
		db.otherQuery(query);
	}

	public void insertValues2(String query){
		db.otherQuery(query);
	}

	public void updateIndicator(String query){
		db.otherQuery(query);
	}

	public void updateTyreMaster(String query){
		db.otherQuery(query);
	}
	public ArrayList tyreSizeDesc(String query){
		ArrayList tyresizelist=new ArrayList();
		tyresizelist=db.selectQuery("com.vo.TyreRepairWorkVO",query);
		return tyresizelist;
	}

	public ArrayList tyreBrandDesc(String query) {
		ArrayList tyrebrandlist=new ArrayList();
		tyrebrandlist=db.selectQuery("com.vo.TyreRepairWorkVO",query);
		return tyrebrandlist;
	}

	public ArrayList tyredetailscode(String query) {
		ArrayList tyredetailslist=new ArrayList();
		tyredetailslist=db.selectQuery("com.vo.TyreRepairWorkVO", query);
		return tyredetailslist;
	}
}
