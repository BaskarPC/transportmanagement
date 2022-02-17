package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.OilForm;
import com.service.OilService;
import com.util.OilUtil;
import com.vo.OilVO;
import com.wf.job;

public class OilAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(OilAction.class);
	
	job jb=new job();
	int jobid,rlvl;
	String itemname="Oil";
	String place="Perundurai";
	String servicestation="KVITT Workshop";
	OilService oilservice=new OilService();
	OilUtil oilutil=new OilUtil();
	OilVO generalvo=new OilVO();
	OilVO currentkmvo=new OilVO();
	OilVO drivernamevo=new OilVO();
	OilVO drivervo=new OilVO();
	OilVO oilidvo=new OilVO();
	OilVO oildescvo=new OilVO();
	
	float qty=0,totalqty=0;
	float amt=0,extra=0;
	float newrate,oldrate=0,xrate=0;
	float newqty,oldqty=0,tnewqty,toldqty=0,xqty=0,qtyissue=0;
	String partnumber=null;
	String itemtype1=null,itemtype2=null,itemtype3=null,itemtype4=null,itemtype5=null;
	
	ArrayList oildescList=new ArrayList();
	ArrayList totalqtyList=new ArrayList();
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:defaultMethod<----------");
		OilForm oilform=(OilForm)form;
		
		ArrayList instList=new ArrayList();
		ArrayList oilList=new ArrayList();
		ArrayList oilReasonList=new ArrayList();
		
		instList=oilservice.fetchInst();
		oilform.setInstList(instList);
		oilList=oilservice.fetchOil();
		oilform.setOilList(oilList);
		oilReasonList=oilservice.fetchOilReason();
		oilform.setOilReasonList(oilReasonList);
		logger.debug("OilAction:defaultMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass institution name
	 * To retrieve vehicle type for combo
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward instMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:instMethod<----------");
		ArrayList instList=new ArrayList();
		OilForm oilform=(OilForm)form;
		int instname=Integer.parseInt(oilform.getInstitutionName());
		instList=oilservice.instMethod(instname);
		oilform.setTypeList(instList);
		logger.debug("OilAction:instMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass vehicle type
	 * to retrieve vehicle number and set values in combo
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicleMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		OilForm oilform=(OilForm)form;
		int vehtype=Integer.parseInt(oilform.getVehicleType());
		vehicleList=oilservice.vehicleMethod(vehtype);
		oilform.setVehicleList(vehicleList);
		logger.debug("OilAction:vehicleMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass vehicle number
	 * To retrieve preiously serviced km,drivername 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward driverMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:driverMethod<----------");
		ArrayList drivernameList=new ArrayList();
		ArrayList driverList=new ArrayList();
		OilForm oilform=(OilForm)form;
		int currentKM;
		int vehnum=Integer.parseInt(oilform.getVehicleNumber());
		drivernameList=oilservice.driverMethod(vehnum);
		currentKM=oilservice.previouslyServicedKmMethod(vehnum);
		drivernamevo=(OilVO)drivernameList.get(0);
		String driver_name=drivernamevo.getDriverName();
		driverList=oilservice.convertToDesc(driver_name);
		drivervo=(OilVO)driverList.get(0);
		oilform.setDriverName(drivervo.getDriverName());
		oilform.setPreviousServicedKM(Integer.toString(currentKM));
		logger.debug("OilAction:driverMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves previouskm and current km
	 * calculates difference km and sets in form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward differenceKmMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:differenceKmMethod---------->");
		OilForm oilform=(OilForm)form;
		
		int previousKm=Integer.parseInt(oilform.getPreviousServicedKM());
		int currentKm=Integer.parseInt(oilform.getCurrentKM());
		int differenceKm=currentKm-previousKm;
		oilform.setDifferenceKM(Integer.toString(differenceKm));
		logger.debug("OilAction:differenceKmMethod---------->");
		return mapping.findForward("load");
	}
	
	/**
	 * retrieves available quantity while choosing oiltype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod1(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:typeMethod1---------->");
		OilForm oilform=(OilForm)form;
		itemtype1=oilform.getOilType1();
		oildescList=oilservice.convertToDesc(itemtype1);
		oildescvo=(OilVO)oildescList.get(0);
		totalqtyList=oilservice.quantityMethod(oildescvo.getDriverName());
		oildescvo=(OilVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(oildescvo.getNewAvailable1())+Float.parseFloat(oildescvo.getOldAvailable1());
		oilform.setTotalAvailableQuantity1(Float.toString(totalqty));
		logger.debug("OilAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing oiltype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod2(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:typeMethod1---------->");
		OilForm oilform=(OilForm)form;
		itemtype1=oilform.getOilType2();
		oildescList=oilservice.convertToDesc(itemtype1);
		oildescvo=(OilVO)oildescList.get(0);
		totalqtyList=oilservice.quantityMethod(oildescvo.getDriverName());
		oildescvo=(OilVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(oildescvo.getNewAvailable1())+Float.parseFloat(oildescvo.getOldAvailable1());
		oilform.setTotalAvailableQuantity2(Float.toString(totalqty));
		logger.debug("OilAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing oiltype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod3(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:typeMethod1---------->");
		OilForm oilform=(OilForm)form;
		itemtype1=oilform.getOilType3();
		oildescList=oilservice.convertToDesc(itemtype1);
		oildescvo=(OilVO)oildescList.get(0);
		totalqtyList=oilservice.quantityMethod(oildescvo.getDriverName());
		oildescvo=(OilVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(oildescvo.getNewAvailable1())+Float.parseFloat(oildescvo.getOldAvailable1());
		oilform.setTotalAvailableQuantity3(Float.toString(totalqty));
		logger.debug("OilAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing oiltype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod4(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:typeMethod1---------->");
		OilForm oilform=(OilForm)form;
		itemtype1=oilform.getOilType4();
		oildescList=oilservice.convertToDesc(itemtype1);
		oildescvo=(OilVO)oildescList.get(0);
		totalqtyList=oilservice.quantityMethod(oildescvo.getDriverName());
		oildescvo=(OilVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(oildescvo.getNewAvailable1())+Float.parseFloat(oildescvo.getOldAvailable1());
		oilform.setTotalAvailableQuantity4(Float.toString(totalqty));
		logger.debug("OilAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing oiltype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod5(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:typeMethod1---------->");
		OilForm oilform=(OilForm)form;
		itemtype1=oilform.getOilType5();
		oildescList=oilservice.convertToDesc(itemtype1);
		oildescvo=(OilVO)oildescList.get(0);
		totalqtyList=oilservice.quantityMethod(oildescvo.getDriverName());
		oildescvo=(OilVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(oildescvo.getNewAvailable1())+Float.parseFloat(oildescvo.getOldAvailable1());
		oilform.setTotalAvailableQuantity5(Float.toString(totalqty));
		logger.debug("OilAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass required quantity
	 * retrieves oldqty,newqty,oldrate,newrate
	 * calculates totalamount
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward quantityMethod1(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:quantityMethod1<----------");
		OilForm oilform=(OilForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList oildescList=new ArrayList();
	    String oiltype;
	    float qtyissue=0;
	if(StringUtils.isNotEmpty(oilform.getWantedQuantity1()))
		{
			qty=Float.parseFloat(oilform.getWantedQuantity1());
			oiltype=oilform.getOilType1();
			oildescList=oilservice.convertToDesc(oiltype);
			oildescvo=(OilVO)oildescList.get(0);
			logger.debug(oildescvo.getDriverName());
			partnumberList=oilservice.quantityMethod(oildescvo.getDriverName());
			generalvo=(OilVO)partnumberList.get(0);	
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			rlvl=Integer.parseInt(generalvo.getReorderLevel());
			totalqty=oldqty+newqty;
			logger.debug("Quantity"+oldqty+newqty+totalqty);
			if(qty>(totalqty))
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				oilform.setOldAvailable1(Float.toString(qty));
				oilform.setOldRate1(Float.toString(oldrate));
				oilform.setNewAvailable1(null);
				oilform.setNewRate1(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
						
				oilform.setOldAvailable1(Float.toString(oldqty));
				oilform.setOldRate1(Float.toString(oldrate));
				oilform.setNewRate1(Float.toString(newrate));
				qtyissue=newqty-rlvl;
				logger.debug("Issue"+qtyissue);
				if(extra<qtyissue)
				{
					oilform.setNewAvailable1(Float.toString(extra));
					amt=(extra*newrate)+(oldqty*oldrate);
				}
				else
				{
					oilform.setNewAvailable1(Float.toString(qtyissue));
					amt=(qtyissue*newrate)+(oldqty*oldrate);
				}
			}
			
			oilform.setTotalAvailableQuantity1(Float.toString(totalqty));
			oilform.setTotalAmount1(Float.toString(amt));
			oilform.setWantedQuantity1(Float.toString(Float.parseFloat(oilform.getOldAvailable1())+Float.parseFloat(oilform.getNewAvailable1())));
		}
	logger.debug("OilAction:quantityMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass required quantity
	 * retrieves oldqty,newqty,oldrate,newrate
	 * calculates totalamount
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward quantityMethod2(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:quantityMethod2<----------");
		OilForm oilform=(OilForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList oildescList=new ArrayList();
	    String oiltype;
	if(StringUtils.isNotEmpty(oilform.getWantedQuantity2()))
		{
			qty=Float.parseFloat(oilform.getWantedQuantity2());					
			oiltype=oilform.getOilType2();
			oildescList=oilservice.convertToDesc(oiltype);
			oildescvo=(OilVO)oildescList.get(0);
			partnumberList=oilservice.quantityMethod(oildescvo.getDriverName());
			generalvo=(OilVO)partnumberList.get(0);		
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			rlvl=Integer.parseInt(generalvo.getReorderLevel());
			totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				oilform.setOldAvailable2(Float.toString(qty));
				oilform.setOldRate2(Float.toString(oldrate));				
				oilform.setNewAvailable2(null);
				oilform.setNewRate2(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
				
				oilform.setOldAvailable2(Float.toString(oldqty));
				oilform.setOldRate2(Float.toString(oldrate));
				oilform.setNewRate2(Float.toString(newrate));
				qtyissue=newqty-rlvl;
				if(extra>qtyissue)
				{
					oilform.setNewAvailable2(Float.toString(qtyissue));
					amt=(qtyissue*newrate)+(oldqty*oldrate);
				}
				else
				{
					oilform.setNewAvailable2(Float.toString(extra));
					amt=(extra*newrate)+(oldqty*oldrate);
				}
			}
			oilform.setTotalAvailableQuantity2(Float.toString(totalqty));
			oilform.setTotalAmount2(Float.toString(amt));
			oilform.setWantedQuantity2(Float.toString(Float.parseFloat(oilform.getOldAvailable2())+Float.parseFloat(oilform.getNewAvailable2())));
		}
	logger.debug("OilAction:quantityMethod2---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass required quantity
	 * retrieves oldqty,newqty,oldrate,newrate
	 * calculates totalamount
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward quantityMethod3(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:quantityMethod3<----------");
		OilForm oilform=(OilForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList oildescList=new ArrayList();
	    String oiltype;
	if(StringUtils.isNotEmpty(oilform.getWantedQuantity3()))
		{
			qty=Float.parseFloat(oilform.getWantedQuantity3());					
			oiltype=oilform.getOilType3();
			oildescList=oilservice.convertToDesc(oiltype);
			oildescvo=(OilVO)oildescList.get(0);
			partnumberList=oilservice.quantityMethod(oildescvo.getDriverName());
			generalvo=(OilVO)partnumberList.get(0);		
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				oilform.setOldAvailable3(Float.toString(qty));
				oilform.setOldRate3(Float.toString(oldrate));				
				oilform.setNewAvailable3(null);
				oilform.setNewRate3(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
							
				oilform.setOldAvailable3(Float.toString(oldqty));
				oilform.setOldRate3(Float.toString(oldrate));
				oilform.setNewRate3(Float.toString(newrate));
				qtyissue=newqty-rlvl;
				if(extra>qtyissue)
				{
					oilform.setNewAvailable3(Float.toString(qtyissue));
					amt=(qtyissue*newrate)+(oldqty*oldrate);
				}
				else
				{
					oilform.setNewAvailable3(Float.toString(extra));
					amt=(extra*newrate)+(oldqty*oldrate);
				}
			}
			oilform.setTotalAvailableQuantity3(Float.toString(totalqty));
			oilform.setTotalAmount3(Float.toString(amt));
			oilform.setWantedQuantity3(Float.toString(Float.parseFloat(oilform.getOldAvailable3())+Float.parseFloat(oilform.getNewAvailable3())));
		}
	logger.debug("OilAction:quantityMethod3---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass required quantity
	 * retrieves oldqty,newqty,oldrate,newrate
	 * calculates totalamount
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward quantityMethod4(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:quantityMethod4<----------");
		OilForm oilform=(OilForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList oildescList=new ArrayList();
	    String oiltype;
	if(StringUtils.isNotEmpty(oilform.getWantedQuantity4()))
		{
		qty=Float.parseFloat(oilform.getWantedQuantity4());					
		oiltype=oilform.getOilType4();
		oildescList=oilservice.convertToDesc(oiltype);
		oildescvo=(OilVO)oildescList.get(0);
		partnumberList=oilservice.quantityMethod(oildescvo.getDriverName());
		generalvo=(OilVO)partnumberList.get(0);		
		oldqty=Float.parseFloat(generalvo.getOldAvailable1());
		newqty=Float.parseFloat(generalvo.getNewAvailable1());
		oldrate=Float.parseFloat(generalvo.getOldRate1());
		newrate=Float.parseFloat(generalvo.getNewRate1());
		totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				oilform.setOldAvailable4(Float.toString(qty));
				oilform.setOldRate4(Float.toString(oldrate));
				oilform.setNewAvailable4(null);
				oilform.setNewRate4(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
							
				oilform.setOldAvailable4(Float.toString(oldqty));
				oilform.setOldRate4(Float.toString(oldrate));
				oilform.setNewRate4(Float.toString(newrate));
				qtyissue=newqty-rlvl;
				if(extra>qtyissue)
				{
					oilform.setNewAvailable4(Float.toString(qtyissue));
					amt=(qtyissue*newrate)+(oldqty*oldrate);
				}
				else
				{
					oilform.setNewAvailable4(Float.toString(extra));
					amt=(extra*newrate)+(oldqty*oldrate);
				}
			}
			oilform.setTotalAvailableQuantity4(Float.toString(totalqty));
			oilform.setTotalAmount4(Float.toString(amt));
			oilform.setWantedQuantity4(Float.toString(Float.parseFloat(oilform.getOldAvailable4())+Float.parseFloat(oilform.getNewAvailable4())));
		}
	logger.debug("OilAction:quantityMethod4---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass required quantity
	 * retrieves oldqty,newqty,oldrate,newrate
	 * calculates totalamount
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward quantityMethod5(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:quantityMethod5<----------");
		OilForm oilform=(OilForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList oildescList=new ArrayList();
	    String oiltype;
	if(StringUtils.isNotEmpty(oilform.getWantedQuantity5()))
		{
		qty=Float.parseFloat(oilform.getWantedQuantity5());					
		oiltype=oilform.getOilType5();
		oildescList=oilservice.convertToDesc(oiltype);
		oildescvo=(OilVO)oildescList.get(0);
		partnumberList=oilservice.quantityMethod(oildescvo.getDriverName());
		generalvo=(OilVO)partnumberList.get(0);		
		oldqty=Float.parseFloat(generalvo.getOldAvailable1());
		newqty=Float.parseFloat(generalvo.getNewAvailable1());
		oldrate=Float.parseFloat(generalvo.getOldRate1());
		newrate=Float.parseFloat(generalvo.getNewRate1());
		totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				oilform.setOldAvailable5(Float.toString(qty));
				oilform.setOldRate5(Float.toString(oldrate));				
				oilform.setNewAvailable5(null);
				oilform.setNewRate5(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
							
				oilform.setOldAvailable5(Float.toString(oldqty));
				oilform.setOldRate5(Float.toString(oldrate));
				oilform.setNewRate5(Float.toString(newrate));
				qtyissue=newqty-rlvl;
				if(extra>qtyissue)
				{
					oilform.setNewAvailable5(Float.toString(qtyissue));
					amt=(qtyissue*newrate)+(oldqty*oldrate);
				}
				else
				{
					oilform.setNewAvailable5(Float.toString(extra));
					amt=(extra*newrate)+(oldqty*oldrate);
				}
			}
			oilform.setTotalAvailableQuantity5(Float.toString(totalqty));
			oilform.setTotalAmount5(Float.toString(amt));
			oilform.setWantedQuantity5(Float.toString(Float.parseFloat(oilform.getOldAvailable5())+Float.parseFloat(oilform.getNewAvailable5())));
		}
	logger.debug("OilAction:quantityMethod5---------->");
		return mapping.findForward("load");
	}
	/**
	 * to create the job and task
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:jobMethod---------->");
		String reqName="OilIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		String ss1=mapping.getName();
		jobid=jb.creatJob(ss1,userName,reqName);
		saveMethod(jobid,form);
		logger.debug("OilAction:jobMethod<----------");
		return mapping.findForward("load");
	}
	/**
	 * to insert the values in table
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
			throws Exception {
		logger.debug("OilAction:saveMethod<----------");
		OilForm oilform=(OilForm)form;
		ArrayList descList=new ArrayList();
		PropertyUtils.copyProperties(generalvo,oilform);
		int ITEM_TYPE=0;
		float AVAILABLE_QTY=0,QTY_WANTED=0,IQTY_OLD=0;
		float IQTY_NEW=0,URATE_OLD=0,URATE_NEW=0,AMOUNT=0;
		int REASON_REQ=0,CURRENT_KM=0,PREV_SERVICED_KM=0,DIFFERNCE_KM=0;
		int driverName,REQ_DRIVERNAME,GOODS_TYPE,PLACE,SERVICE_STATION;
		int INSTITUTION_NAME=Integer.parseInt(generalvo.getInstitutionName());
		int VEHICLE_TYPE=Integer.parseInt(generalvo.getVehicleType());
		int VEHICLE_NUMBER=Integer.parseInt(generalvo.getVehicleNumber());
		int BILL_NUMBER=Integer.parseInt(generalvo.getBillNumber());
		String REQ_DATE =generalvo.getRequestedDate();
		
		String DRIVERNAME=generalvo.getDriverName();
		driverName=oilservice.convertToCode(DRIVERNAME);
				
		String REQDRIVERNAME=oilform.getRequestedDriverName();
		REQ_DRIVERNAME=oilservice.convertToCode(REQDRIVERNAME);
			
		String OTHER_PURPOSE=generalvo.getOtherPurpose();
		GOODS_TYPE=oilservice.convertToCode(itemname);
		PLACE=oilservice.convertToCode(place);
		SERVICE_STATION=oilservice.convertToCode(servicestation);
		float TotalAmount=Float.parseFloat(oilform.getTotalAmount());
		if(VEHICLE_TYPE==102 && OTHER_PURPOSE!="")
		{
			logger.debug("Other Purpose Entered");
		}
		else if(VEHICLE_TYPE==102 && OTHER_PURPOSE=="")
		{
			logger.debug("Other Purpose Should be Entered");
		}
		else
		{
			OTHER_PURPOSE="null";
		}
		try
	    {
			oilservice.insertmaster(jobid,INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,driverName,OTHER_PURPOSE,REQ_DRIVERNAME,GOODS_TYPE,TotalAmount,PLACE,SERVICE_STATION);
	   		logger.debug("OIL MASTER");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
		if(!StringUtils.isEmpty(oilform.getWantedQuantity1()))
		{
			ITEM_TYPE=Integer.parseInt(oilform.getOilType1());
			descList=oilservice.convertToDesc(oilform.getOilType1());
			drivernamevo=(OilVO)descList.get(0);
			itemtype1=drivernamevo.getDriverName();
			logger.debug("Item Type"+ITEM_TYPE);
			AVAILABLE_QTY=Float.parseFloat(oilform.getTotalAvailableQuantity1());
			logger.debug("AVAILABLE_QTY"+AVAILABLE_QTY);
			QTY_WANTED=Float.parseFloat(oilform.getWantedQuantity1()) ;
			logger.debug("QTY_WANTED"+QTY_WANTED);
			IQTY_OLD=Float.parseFloat(oilform.getOldAvailable1());
			IQTY_NEW=Float.parseFloat(oilform.getNewAvailable1());
			URATE_OLD=Float.parseFloat(oilform.getOldRate1());
			URATE_NEW=Float.parseFloat(oilform.getNewRate1());
			AMOUNT=Float.parseFloat(oilform.getTotalAmount1());
			logger.debug("AMOUNT"+AMOUNT);
			REASON_REQ=Integer.parseInt(oilform.getOilReason1());
			CURRENT_KM=Integer.parseInt(oilform.getCurrentKM());
			PREV_SERVICED_KM=Integer.parseInt(oilform.getPreviousServicedKM());
			DIFFERNCE_KM=Integer.parseInt(oilform.getDifferenceKM());	
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
				oilservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ,CURRENT_KM,PREV_SERVICED_KM,DIFFERNCE_KM);
				oilservice.updateValues(toldqty,tnewqty,itemname,itemtype1);
		    	logger.debug("OIL1 INSERT");
			    if(toldqty==0 && tnewqty!=0)
				{
					toldqty=tnewqty;
					oldrate=newrate;
					if(xqty!=0)
					{
						tnewqty=xqty;
					    newrate=xrate;
					}
					else
					{
						tnewqty=0;
						newrate=0;
					}			    
				}
				else if(toldqty==0 && tnewqty==0 && xqty!=0)
				{
					    toldqty=xqty;
					    oldrate=xrate;
						tnewqty=0;
						newrate=0;
				}
				logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
				oilservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype1);
			}
		if(!StringUtils.isEmpty(oilform.getWantedQuantity2()))
		{
			ITEM_TYPE=Integer.parseInt(oilform.getOilType2());
			descList=oilservice.convertToDesc(oilform.getOilType2());
			drivernamevo=(OilVO)descList.get(0);
			itemtype2=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(oilform.getTotalAvailableQuantity2());
			QTY_WANTED=Float.parseFloat(oilform.getWantedQuantity2()) ;
			IQTY_OLD=Float.parseFloat(oilform.getOldAvailable2());
			IQTY_NEW=Float.parseFloat(oilform.getNewAvailable2());
			URATE_OLD=Float.parseFloat(oilform.getOldRate2());
			URATE_NEW=Float.parseFloat(oilform.getNewRate2());
			AMOUNT=Float.parseFloat(oilform.getTotalAmount2());
			REASON_REQ=Integer.parseInt(oilform.getOilReason2());
			CURRENT_KM=Integer.parseInt(oilform.getCurrentKM());
			PREV_SERVICED_KM=Integer.parseInt(oilform.getPreviousServicedKM());
			DIFFERNCE_KM=Integer.parseInt(oilform.getDifferenceKM());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
		
				oilservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ,CURRENT_KM,PREV_SERVICED_KM,DIFFERNCE_KM);
				oilservice.updateValues(toldqty,tnewqty,itemname,itemtype2);
		    	logger.debug("OIL2 INSERT");
			    if(toldqty==0 && tnewqty!=0)
				{
					toldqty=tnewqty;
					oldrate=newrate;
					if(xqty!=0)
					{
						tnewqty=xqty;
					    newrate=xrate;
					}
					else
					{
						tnewqty=0;
						newrate=0;
					}			    
				}
				else if(toldqty==0 && tnewqty==0 && xqty!=0)
				{
					    toldqty=xqty;
					    oldrate=xrate;
						tnewqty=0;
						newrate=0;
				}
				logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
				oilservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype2);
			}
		
		if(!StringUtils.isEmpty(oilform.getWantedQuantity3()))
		{
			ITEM_TYPE=Integer.parseInt(oilform.getOilType3());
			descList=oilservice.convertToDesc(oilform.getOilType3());
			drivernamevo=(OilVO)descList.get(0);
			itemtype3=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(oilform.getTotalAvailableQuantity3());
			QTY_WANTED=Float.parseFloat(oilform.getWantedQuantity3()) ;
			IQTY_OLD=Float.parseFloat(oilform.getOldAvailable3());
			IQTY_NEW=Float.parseFloat(oilform.getNewAvailable3());
			URATE_OLD=Float.parseFloat(oilform.getOldRate3());
			URATE_NEW=Float.parseFloat(oilform.getNewRate3());
			AMOUNT=Float.parseFloat(oilform.getTotalAmount3());
			REASON_REQ=Integer.parseInt(oilform.getOilReason3());
			CURRENT_KM=Integer.parseInt(oilform.getCurrentKM());
			PREV_SERVICED_KM=Integer.parseInt(oilform.getPreviousServicedKM());
			DIFFERNCE_KM=Integer.parseInt(oilform.getDifferenceKM());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
		
				oilservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ,CURRENT_KM,PREV_SERVICED_KM,DIFFERNCE_KM);
				oilservice.updateValues(toldqty,tnewqty,itemname,itemtype3);
		    	logger.debug("OIL3 INSERT");
			    if(toldqty==0 && tnewqty!=0)
				{
					toldqty=tnewqty;
					oldrate=newrate;
					if(xqty!=0)
					{
						tnewqty=xqty;
					    newrate=xrate;
					}
					else
					{
						tnewqty=0;
						newrate=0;
					}			    
				}
				else if(toldqty==0 && tnewqty==0 && xqty!=0)
				{
					    toldqty=xqty;
					    oldrate=xrate;
						tnewqty=0;
						newrate=0;
				}
				logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
				oilservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype3);
			}
			
		if(!StringUtils.isEmpty(oilform.getWantedQuantity4()))
		{
			ITEM_TYPE=Integer.parseInt(oilform.getOilType4());
			descList=oilservice.convertToDesc(oilform.getOilType4());
			drivernamevo=(OilVO)descList.get(0);
			itemtype4=drivernamevo.getDriverName();
			AVAILABLE_QTY=Integer.parseInt(oilform.getTotalAvailableQuantity4());
			QTY_WANTED=Float.parseFloat(oilform.getWantedQuantity4()) ;
			IQTY_OLD=Float.parseFloat(oilform.getOldAvailable4());
			IQTY_NEW=Float.parseFloat(oilform.getNewAvailable4());
			URATE_OLD=Float.parseFloat(oilform.getOldRate4());
			URATE_NEW=Float.parseFloat(oilform.getNewRate4());
			AMOUNT=Float.parseFloat(oilform.getTotalAmount4());
			REASON_REQ=Integer.parseInt(oilform.getOilReason4());
			CURRENT_KM=Integer.parseInt(oilform.getCurrentKM());
			PREV_SERVICED_KM=Integer.parseInt(oilform.getPreviousServicedKM());
			DIFFERNCE_KM=Integer.parseInt(oilform.getDifferenceKM());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
			oilservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ,CURRENT_KM,PREV_SERVICED_KM,DIFFERNCE_KM);
			oilservice.updateValues(toldqty,tnewqty,itemname,itemtype4);
		    logger.debug("OIL4 INSERT");
			    if(toldqty==0 && tnewqty!=0)
				{
					toldqty=tnewqty;
					oldrate=newrate;
					if(xqty!=0)
					{
						tnewqty=xqty;
					    newrate=xrate;
					}
					else
					{
						tnewqty=0;
						newrate=0;
					}			    
				}
				else if(toldqty==0 && tnewqty==0 && xqty!=0)
				{
					    toldqty=xqty;
					    oldrate=xrate;
						tnewqty=0;
						newrate=0;
				}
				logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
				oilservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype4);
			}
	
		if(!StringUtils.isEmpty(oilform.getWantedQuantity5()))
		{
			ITEM_TYPE=Integer.parseInt(oilform.getOilType5());
			descList=oilservice.convertToDesc(oilform.getOilType5());
			drivernamevo=(OilVO)descList.get(0);
			itemtype5=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(oilform.getTotalAvailableQuantity5());
			QTY_WANTED=Float.parseFloat(oilform.getWantedQuantity5()) ;
			IQTY_OLD=Float.parseFloat(oilform.getOldAvailable5());
			IQTY_NEW=Float.parseFloat(oilform.getNewAvailable5());
			URATE_OLD=Float.parseFloat(oilform.getOldRate5());
			URATE_NEW=Float.parseFloat(oilform.getNewRate5());
			AMOUNT=Float.parseFloat(oilform.getTotalAmount5());
			REASON_REQ=Integer.parseInt(oilform.getOilReason5());
			CURRENT_KM=Integer.parseInt(oilform.getCurrentKM());
			PREV_SERVICED_KM=Integer.parseInt(oilform.getPreviousServicedKM());
			DIFFERNCE_KM=Integer.parseInt(oilform.getDifferenceKM());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
			oilservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ,CURRENT_KM,PREV_SERVICED_KM,DIFFERNCE_KM);
			oilservice.updateValues(toldqty,tnewqty,itemname,itemtype5);
		    logger.debug("OIL5 INSERT");
		    if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			oilservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype5);
		}	
		
		logger.debug("OilAction:saveMethod---------->");
	}
	
	/**
	 * to display the values in form 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward inboxMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilAction:inboxMethod---------->");
		OilForm oilform=(OilForm)form;
		clear(form);
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		ArrayList instList=new ArrayList();
		ArrayList typeList=new ArrayList();
		ArrayList vehicleList=new ArrayList();
		ArrayList retrieveList=new ArrayList();
		ArrayList retrivemasterList=new ArrayList();
		ArrayList oilList=new ArrayList();
		ArrayList oilReasonList=new ArrayList();
		ArrayList descList=new ArrayList();
		
		retrivemasterList=oilservice.retrieveMaster(job);
	    retrieveList=oilservice.retrieve(job);
	    
	    instList=oilservice.fetchInst();
		typeList=oilservice.fetchType();
		vehicleList=oilservice.fetchVehicle();
		
		oilform.setInstList(instList);
		oilform.setTypeList(typeList);
		oilform.setVehicleList(vehicleList);
		
		oilList=oilservice.fetchOil();
		oilReasonList=oilservice.fetchOilReason();
		
		oilform.setOilList(oilList);
		oilform.setOilReasonList(oilReasonList);
		
	    OilVO vo1=new OilVO();	
	    OilVO vo=new OilVO();
	    vo1=(OilVO)retrivemasterList.get(0);
	    vo=(OilVO)retrieveList.get(0);
	  
	    oilform.setInstitutionName(vo1.getInstitutionName());
	    oilform.setVehicleType(vo1.getVehicleType());
	    oilform.setVehicleNumber(vo1.getVehicleNumber());
	 
	    oilform.setBillNumber(vo1.getBillNumber());
	    oilform.setRequestedDate(vo1.getRequestedDate());
	    oilform.setOtherPurpose(vo1.getOtherPurpose());
	    
	    String drivercode=vo1.getDriverName();
	    descList=oilservice.convertToDesc(drivercode);
	    drivernamevo=(OilVO)descList.get(0);
	    oilform.setDriverName(drivernamevo.getDriverName());
	    
	    String reqdrivercode=vo1.getRequestedDriverName();
	    descList=oilservice.convertToDesc(reqdrivercode);
	    oilidvo=(OilVO)descList.get(0);
	    oilform.setRequestedDriverName(oilidvo.getDriverName());
	    
	    for(int i=0;i<retrieveList.size();i++)
	    {
	    	vo=(OilVO)retrieveList.get(i);
	    	logger.debug("List Size"+retrieveList.size());
		  	  switch(i)
		  	  {
		  	  	case 0:
		  	  	{
		  	  		oilform.setOilType1(vo.getOilType1());
		  	  		oilform.setOilReason1(vo.getOilReason1());
		  	  		oilform.setWantedQuantity1(vo.getWantedQuantity1());
		  	  		oilform.setTotalAvailableQuantity1(vo.getTotalAvailableQuantity1());
		  	  		oilform.setOldAvailable1(vo.getOldAvailable1());
		  	  		oilform.setNewAvailable1(vo.getNewAvailable1());
		  	  		oilform.setOldRate1(vo.getOldRate1());
		  	  		oilform.setNewRate1(vo.getNewRate1());
		  	  		oilform.setTotalAmount1(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 1:
		  	  	{
		  	  		oilform.setOilType2(vo.getOilType1());
		  	  		oilform.setOilReason2(vo.getOilReason1());
		  	  		oilform.setWantedQuantity2(vo.getWantedQuantity1());
		  	  		oilform.setTotalAvailableQuantity2(vo.getTotalAvailableQuantity1());
		  	  		oilform.setOldAvailable2(vo.getOldAvailable1());
		  	  		oilform.setNewAvailable2(vo.getNewAvailable1());
		  	  		oilform.setOldRate2(vo.getOldRate1());
		  	  		oilform.setNewRate2(vo.getNewRate1());
		  	  		oilform.setTotalAmount2(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 2:
		  	  	{
		  	  		oilform.setOilType3(vo.getOilType1());
		  	  		oilform.setOilReason3(vo.getOilReason1());
		  	  		oilform.setWantedQuantity3(vo.getWantedQuantity1());
		  	  		oilform.setTotalAvailableQuantity3(vo.getTotalAvailableQuantity1());
		  	  		oilform.setOldAvailable3(vo.getOldAvailable1());
		  	  		oilform.setNewAvailable3(vo.getNewAvailable1());
		  	  		oilform.setOldRate3(vo.getOldRate1());
		  	  		oilform.setNewRate3(vo.getNewRate1());
		  	  		oilform.setTotalAmount3(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 3:
		  	  	{
		  	  		oilform.setOilType4(vo.getOilType1());
		  	  		oilform.setOilReason4(vo.getOilReason1());
		  	  		oilform.setWantedQuantity4(vo.getWantedQuantity1());
		  	  		oilform.setTotalAvailableQuantity4(vo.getTotalAvailableQuantity1());
		  	  		oilform.setOldAvailable4(vo.getOldAvailable1());
		  	  		oilform.setNewAvailable4(vo.getNewAvailable1());
		  	  		oilform.setOldRate4(vo.getOldRate1());
		  	  		oilform.setNewRate4(vo.getNewRate1());
		  	  		oilform.setTotalAmount4(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 4:
		  	  	{
		  	  		oilform.setOilType5(vo.getOilType1());
		  	  		oilform.setOilReason5(vo.getOilReason1());
		  	  		oilform.setWantedQuantity5(vo.getWantedQuantity1());
		  	  		oilform.setTotalAvailableQuantity5(vo.getTotalAvailableQuantity1());
		  	  		oilform.setOldAvailable5(vo.getOldAvailable1());
		  	  		oilform.setNewAvailable5(vo.getNewAvailable1());
		  	  		oilform.setOldRate5(vo.getOldRate1());
		  	  		oilform.setNewRate5(vo.getNewRate1());
		  	  		oilform.setTotalAmount5(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  	  }
	    }
	  	oilform.setCurrentKM(vo.getCurrentKM());
	  	oilform.setPreviousServicedKM(vo.getPreviousServicedKM());
	  	oilform.setDifferenceKM(vo.getDifferenceKM());
	  	logger.debug("OilAction:inboxMethod<----------"); 
	    return mapping.findForward("load");
	}
	/**
	 * to clear the values
	 * @param form
	 */
	public void clear(ActionForm form)
	{
		logger.debug("OilAction:clear<----------");
		OilForm oilform=(OilForm)form;
		oilform.setBillNumber(null);
		oilform.setCurrentKM(null);
		oilform.setDifferenceKM(null);
		oilform.setDriverName(null);
		oilform.setInstitutionName(null);
		oilform.setNewAvailable1(null);
		oilform.setNewAvailable2(null);
		oilform.setNewAvailable3(null);
		oilform.setNewAvailable4(null);
		oilform.setNewAvailable5(null);
		oilform.setNewRate1(null);
		oilform.setNewRate2(null);
		oilform.setNewRate3(null);
		oilform.setNewRate4(null);
		oilform.setNewRate5(null);
		oilform.setOilReason1(null);
		oilform.setOilReason2(null);
		oilform.setOilReason3(null);
		oilform.setOilReason4(null);
		oilform.setOilReason5(null);
		oilform.setOldAvailable1(null);
		oilform.setOldAvailable2(null);
		oilform.setOldAvailable3(null);
		oilform.setOldAvailable4(null);
		oilform.setOldAvailable5(null);
		oilform.setOldRate1(null);
		oilform.setOldRate2(null);
		oilform.setOldRate3(null);
		oilform.setOldRate4(null);
		oilform.setOldRate5(null);
		oilform.setOilType1(null);
		oilform.setOilType2(null);
		oilform.setOilType3(null);
		oilform.setOilType4(null);
		oilform.setOilType5(null);
		oilform.setOtherPurpose(null);
		oilform.setPreviousServicedKM(null);
		oilform.setRequestedDate(null);
		oilform.setRequestedDriverName(null);
		oilform.setTotalAmount1(null);
		oilform.setTotalAmount2(null);
		oilform.setTotalAmount3(null);
		oilform.setTotalAmount4(null);
		oilform.setTotalAmount5(null);
		oilform.setTotalAvailableQuantity1(null);
		oilform.setTotalAvailableQuantity2(null);
		oilform.setTotalAvailableQuantity3(null);
		oilform.setTotalAvailableQuantity4(null);
		oilform.setTotalAvailableQuantity5(null);
		oilform.setVehicleNumber(null);
		oilform.setVehicleType(null);
		oilform.setWantedQuantity1(null);
		oilform.setWantedQuantity2(null);
		oilform.setWantedQuantity3(null);
		oilform.setWantedQuantity4(null);
		oilform.setWantedQuantity5(null);
		logger.debug("OilAction:clear---------->");
	}
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the approve task oilform that form 
	 * and 0 for issue task  for the corresponding form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward approveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.approveStatus(job,task);
			return mapping.findForward("load");
	}
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the issue task of that form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.okStatus(job,task);
			updateValues(job,form);
			return mapping.findForward("load");
	}
	public void updateValues(int jobid,ActionForm form) throws Exception
	{
		ArrayList quantityList=new ArrayList();
		if(!StringUtils.isEmpty(itemtype1))
		{
			quantityList=oilservice.quantityMethod(itemtype1);
			generalvo=(OilVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			oilservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype1,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype2))
		{
			quantityList=oilservice.quantityMethod(itemtype2);
			generalvo=(OilVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			oilservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype2,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype3))
		{
			quantityList=oilservice.quantityMethod(itemtype3);
			generalvo=(OilVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			oilservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype3,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype4))
		{
			quantityList=oilservice.quantityMethod(itemtype4);
			generalvo=(OilVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			oilservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype4,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype5))
		{
			quantityList=oilservice.quantityMethod(itemtype5);
			generalvo=(OilVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			oilservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype5,jobid);
		}
		logger.debug("DieselAction:updateValues<---------->");
	}
	
	public ActionForward totalAmountMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		OilForm oilform=(OilForm)form;
		float amt1=0,amt2=0,amt3=0,amt4=0,amt5=0;
		if(!StringUtils.isEmpty(oilform.getTotalAmount1()))
			amt1=Float.parseFloat(oilform.getTotalAmount1());
		else
			amt1=0;
		if(!StringUtils.isEmpty(oilform.getTotalAmount2()))
			amt2=Float.parseFloat(oilform.getTotalAmount2());
		else
			amt2=0;
		if(!StringUtils.isEmpty(oilform.getTotalAmount3()))
				amt3=Float.parseFloat(oilform.getTotalAmount3());
		else
			amt3=0;
		if(!StringUtils.isEmpty(oilform.getTotalAmount4()))
			amt4=Float.parseFloat(oilform.getTotalAmount4());
		else
			amt4=0;
		if(!StringUtils.isEmpty(oilform.getTotalAmount5()))
			amt5=Float.parseFloat(oilform.getTotalAmount5());
		else
			amt5=0;
		float amount=amt1+amt2+amt3+amt4+amt5;
		oilform.setTotalAmount(Float.toString(amount));
		return mapping.findForward("load");
	
	}
}
