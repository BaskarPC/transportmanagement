package com.dao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.TyreRemovalVO;
import com.dbcom.*;
public class TyreRemovalDAO {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRemovalDAO.class);
	TyreRemovalVO tyreremovalvo=new TyreRemovalVO();
	dbcom db=new dbcom();
	public ArrayList fetchTyreNumber(String query)throws Exception
	{   
		ArrayList tyreNumberList=new ArrayList();
		tyreNumberList=db.selectQuery("com.vo.TyreRemovalVO", query);
		return tyreNumberList;
	 }
	public ArrayList fetchInstitutionName(String query)throws Exception
	{  
		ArrayList institutionList=new ArrayList();
		institutionList=db.selectQuery("com.vo.TyreRemovalVO", query);
		return institutionList;
	 }
	public ArrayList fetchvehicleType(String query)throws Exception
	{   
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.TyreRemovalVO", query);
		return vehicleTypeList;
	 }
	public ArrayList fetchVehicleNumber(String query)throws Exception
	{   
		ArrayList vehicleNumberList=new ArrayList();
		vehicleNumberList=db.selectQuery("com.vo.TyreRemovalVO", query);
		return vehicleNumberList;
	 }
	public ArrayList fetchTyreDetails(String query)
	{
		ArrayList list=new ArrayList();
		list=db.selectQuery("com.vo.TyreRemovalVO", query);
		return list;
	}
	public ArrayList fetchTyrePosition(String query)
	{
		ArrayList tyrePositionList=new ArrayList();
		tyrePositionList=db.selectQuery("com.vo.TyreRemovalVO", query);
		return tyrePositionList;
	}
	public void changeIndicator(String query){
			db.otherQuery(query);
	}
	public void insertValues(String query){
			db.otherQuery(query);
	}
	public void updateTyreMaster(String query){
			db.otherQuery(query);
	}
}