package com.wf;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.formbean.GeneralForm;

import com.service.SparepartsService;
import com.vo.SparePartsFormVO;


public class arrayList {
	private static final Logger logger=(Logger)Logger.getLogger(arrayList.class);
public void dropdownList(ActionForm form) throws Exception
{
	GeneralForm generalForm=(GeneralForm)form;
	ArrayList instList;
	ArrayList vehicleTypeList;
	ArrayList vehicleNumberList;
	SparepartsService sparepartsservice=new SparepartsService();
	instList=sparepartsservice.fetchInst();
	logger.debug("array size in form"+instList.size());
	generalForm.setInstList(instList);
	vehicleTypeList=sparepartsservice.fetchVehicleType();
	generalForm.setVehicleTypeList(vehicleTypeList);
	vehicleNumberList=sparepartsservice.fetchVehicleNumber();
	generalForm.setVehicleNumberList(vehicleNumberList);
	logger.debug("array size in form"+vehicleNumberList.size());
	SparePartsFormVO vo=new SparePartsFormVO();
	for(int i=0;i<vehicleNumberList.size();i++)
	{
	vo=(SparePartsFormVO)vehicleNumberList.get(i);
	}
}
}
