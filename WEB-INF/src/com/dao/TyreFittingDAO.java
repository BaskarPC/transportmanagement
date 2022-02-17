package com.dao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.TyreFittingVO;
import com.dbcom.*;
public class TyreFittingDAO {
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingDAO.class);
	
	TyreFittingVO tyrefittingvo=new TyreFittingVO();
	
	/**
	 * To fetch the TyreSize to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchTyreSize(String query)throws Exception
	{   
		ArrayList tyreSizeList=new ArrayList();
		dbcom ob=new dbcom();
		tyreSizeList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return tyreSizeList;
	 }
	
	/**
	 * To fetch the TyreBrand to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchTyreBrand(String query)throws Exception
	{   
		ArrayList tyreBrandList=new ArrayList();
		dbcom ob=new dbcom();
		tyreBrandList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return tyreBrandList;
	 }
	
	/**
	 * To fetch the TyrePly to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchTyrePly(String query)throws Exception
	{   
		ArrayList tyrePlyList=new ArrayList();
		dbcom ob=new dbcom();
		
		tyrePlyList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return tyrePlyList;
	 }
	
	/**
	 * To fetch the TyreNumber to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchTyreNumber(String query)throws Exception
	{   
		ArrayList tyreNumberList=new ArrayList();
		dbcom ob=new dbcom();
		tyreNumberList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return tyreNumberList;
	 }
	
	/**
	 * To fetch the InstitutionName to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchInstitutionName(String query)throws Exception
	{   
		ArrayList institutionList=new ArrayList();
		dbcom ob=new dbcom();
		institutionList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return institutionList;
	 }
	/**
	 * To fetch the InstitutionName to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchvehicleType(String query)throws Exception
	{   
		ArrayList vehicleTypeList=new ArrayList();
		dbcom ob=new dbcom();
		vehicleTypeList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return vehicleTypeList;
	 }
	
	/**
	 * To fetch the VehicleNumber to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchVehicleNumber(String query)throws Exception
	{   
		ArrayList vehicleNumberList=new ArrayList();
		dbcom ob=new dbcom();
		vehicleNumberList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return vehicleNumberList;
	 }
	
	/**
	 * To fetch the TyrePosition to Combo box
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList fetchTyrePosition(String query)throws Exception
	{   
		ArrayList tyrePositionList=new ArrayList();
		dbcom ob=new dbcom();
		tyrePositionList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return tyrePositionList;
	 }
	
	/**
	 * To fetch the tyre status to Combo box
	 * @param query
	 * @return
	 */
	public ArrayList fetchTyreStatus(String query) {
		ArrayList tyreStatusList=new ArrayList();
		dbcom ob=new dbcom();
		tyreStatusList=ob.selectQuery("com.vo.TyreFittingVO", query);
		return tyreStatusList;
	}
	
	/**
	 * To Insert the values from formbean to database
	 * @param query
	 * @return
	 * @throws Exception
	 */
	
	public void insertValues(String query)throws Exception{   
		dbcom ob=new dbcom();
		ob.otherQuery(query);
	}
	
	/**
	 * To update the tyre master table
	 * @param query
	 */
	public void updateTyreMaster(String query) {
		dbcom db=new dbcom();
		db.otherQuery(query);
	}
}