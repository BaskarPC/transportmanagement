package com.dao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.TyreRebuiltRequisitionVO;
import com.dbcom.*;
public class TyreRebuiltRequisitionDAO {
	
private static final Logger logger=(Logger)Logger.getLogger(TyreRebuiltRequisitionDAO.class);
    TyreRebuiltRequisitionVO tyrerebuiltrequisitionvo=new TyreRebuiltRequisitionVO();
    dbcom db=new dbcom();
	public ArrayList fetchTyreSize(String query)throws Exception
	{   
		ArrayList tyreSizeList=new ArrayList();
		tyreSizeList=db.selectQuery("com.vo.TyreRebuiltRequisitionVO", query);
		return tyreSizeList;
	 }
	
	public ArrayList fetchTyreBrand(String query)throws Exception
	{   
		ArrayList tyreBrandList=new ArrayList();		
		tyreBrandList=db.selectQuery("com.vo.TyreRebuiltRequisitionVO", query);
		return tyreBrandList;
	 }
	
	public ArrayList fetchTyrePly(String query)throws Exception
	{   
		ArrayList tyrePlyList=new ArrayList();		
		tyrePlyList=db.selectQuery("com.vo.TyreRebuiltRequisitionVO", query);
		return tyrePlyList;
	 }
	public ArrayList fetchTyreNumber(String query)throws Exception
	{   
		ArrayList tyreNumberList=new ArrayList();
		tyreNumberList=db.selectQuery("com.vo.TyreRebuiltRequisitionVO", query);
		return tyreNumberList;
	 }

	public ArrayList fetchTyreDetails(String query) {
		ArrayList tyreDetailsList=new ArrayList();			
		tyreDetailsList=db.selectQuery("com.vo.TyreRebuiltRequisitionVO", query);
		return tyreDetailsList;
	}
	
	public ArrayList retrievetyredetails(String query) {
		ArrayList tyredetailslist=new ArrayList();
		tyredetailslist=db.selectQuery("com.vo.TyreRebuiltRequisitionVO",query);
		return tyredetailslist;
	}
 
	public ArrayList retrievecommontyredetails(String query) {
		ArrayList commondetailslist=new ArrayList();
		commondetailslist=db.selectQuery("com.vo.TyreRebuiltRequisitionVO",query);
	 	return commondetailslist;
	}
	public void insertValues1(String query)	{   
		db.otherQuery(query);
	}
	public void insertValues2(String query) {
		db.otherQuery(query);
	}
	public ArrayList tyreSizeDesc(String query) {
		ArrayList tyresizelist=new ArrayList();
		tyresizelist=db.selectQuery("com.vo.TyreRebuiltRequisitionVO",query);
		return tyresizelist;
	}

	public ArrayList tyreBrandDesc(String query) {
		ArrayList tyrebrandlist=new ArrayList();
		tyrebrandlist=db.selectQuery("com.vo.TyreRebuiltRequisitionVO",query);
		return tyrebrandlist;
	}
	
}
