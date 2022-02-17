package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.DriverLicenceForm;
import com.formbean.DriverOfficialForm;
import com.formbean.RoadTaxForm;
import com.service.DriverLicenceService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.vo.DriverLicenceVO;
import com.vo.DriverPolicyVO;
import com.vo.RoadTaxVO;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * @author 
 *
 */
public class DriverLicenceAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DriverLicenceAction.class);
	/**
	 * load combo box values
	 */
	DriverLicenceService service=new DriverLicenceService();
	DriverLicenceVO vo=new DriverLicenceVO();
	
	DriverLicenceVO vo2=new DriverLicenceVO();
	DriverLicenceVO retrievevo=new DriverLicenceVO();
	DriverLicenceVO idvo=new DriverLicenceVO();
	ArrayList list =new ArrayList();
	ArrayList idlist =new ArrayList();
	ArrayList retrievelist =new ArrayList();
	ArrayList categorylist =new ArrayList();
	ArrayList endorsementlist =new ArrayList();
	String categoryvalue="";
	String endorsementvalue="";
	String cat="";
	String endorse="";
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverLicenceAction: defaultMethod<-------------");
		DriverLicenceForm form=(DriverLicenceForm)aForm;
		list=service.driveridcombo(vo);
		form.setDriveridList(list);
		categorylist=service.categorycombo(vo);
		form.setCategoryList(categorylist);
		endorsementlist=service.endorsementcombo(vo);
		form.setEndorsementList(endorsementlist);
		
		logger.debug("DriverLicenceAction: defaultMethod------------->");
		
		return aMapping.findForward("load");
	}

	/**
	 * switch on to office form
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward backMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverLicenceAction: backMethod<-------------");
		
		DriverLicenceForm form=(DriverLicenceForm)aForm;
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		logger.debug("licence number"+form.getLicenceNo());
		session.setAttribute("driverLicenceNo", form.getLicenceNo());
		String licenceno=(String)session.getAttribute("driverLicenceNo");
		logger.debug("licence in session"+licenceno);
		logger.debug("DriverLicenceAction: backMethod------------->");
		return aMapping.findForward("back");
	}
	/**
	 * save values into database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
		
	public ActionForward saveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("DriverLicenceAction: saveMethod<-------------");
			DriverLicenceForm form=(DriverLicenceForm)aForm;
			HttpSession session =((HttpServletRequest)aRequest).getSession();
			vo.setDriverId(form.getDriverId());
			vo.setDriverName(form.getDriverName());
			vo.setLicenceNo(form.getLicenceNo());
			vo.setBatchNo(form.getBatchNo());
			vo.setDateOfLicence(form.getDateOfLicence());
			vo.setValidPeriod(form.getValidPeriod());
		
	     	String categorystr = ",";
	     	     for(int i=0;i<form.getCategoryarray().length;i++)
	     	     {
	     	    	 String str1=form.getCategoryarray()[i];
	     	    	 categorystr=categorystr+str1+",";
	     	     }
	     	String catstr=categorystr.substring(1, categorystr.length()-1);
	     	vo.setCategory(catstr);
	     	vo.setLicenceExpiryDate(form.getLicenceExpiryDate());
	   	    String endorsementstr = ",";
	   	    	for(int i=0;i<form.getEndorsementarray().length;i++)
	   	    	{
	   	    		String str1=form.getEndorsementarray()[i];
	   	    		endorsementstr=endorsementstr+str1+",";
	   	    	}
	   	    String endstr=endorsementstr.substring(1, endorsementstr.length()-1);
	   	    vo.setEndorsement(endstr);
	   	    vo.setPunishment(form.getPunishment());
	   	    logger.debug("licence number"+form.getLicenceNo());
	   	    session.setAttribute("driverLicenceNo", form.getLicenceNo());
	   	    String licenceno=(String)session.getAttribute("driverLicenceNo");
	   	    logger.debug("licence in session"+licenceno);
	   	    service.insert(vo);
	   	    String a[]; 
			a=catstr.split(",");
			
			for(int k=0;k<a.length;k++)
			{
				logger.debug("cat list values:"+a[k]);
				list=service.retrievecategoryvalues(a[k]);
				logger.debug("list size "+list.size());
				vo2=(DriverLicenceVO)list.get(0);
				logger.debug("value of cat:"+vo2.getCategory());
				categoryvalue=categoryvalue+vo2.getCategory()+" ";
			}
			form.setCategory(categoryvalue);
			String endarray[];
			endarray=endstr.split(",");
			for(int k=0;k<endarray.length ;k++)
			{
				logger.debug("endorse value in for loop:"+endarray[k]);
				list=service.retrieveendorsementvalues(endarray[k]);
				logger.debug("endorse list size "+list.size());
				vo2=(DriverLicenceVO)list.get(0);
				endorsementvalue=endorsementvalue+vo2.getEndorsement()+" ";
				logger.debug("endorse value:"+vo2.getEndorsement());
			}
			form.setEndorsement(endorsementvalue);
			logger.debug("DriverLicenceAction: saveMethod------------->");
		return aMapping.findForward("load");
	}
	
	/**
	 * 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("DriverLicenceAction: updateMethod<-------------");
			DriverLicenceForm form=(DriverLicenceForm)aForm;
			HttpSession session =((HttpServletRequest)aRequest).getSession();
			vo.setDriverName(form.getDriverName());
			logger.debug("after driver name");
			vo.setLicenceNo(form.getLicenceNo());
			vo.setBatchNo(form.getBatchNo());
			vo.setDateOfLicence(form.getDateOfLicence());
			vo.setValidPeriod(form.getValidPeriod());
			vo.setCategory(form.getCategory());//desc from lookup
			String cats=form.getCategory();
			logger.debug("summa:");
			String catstr="";
			logger.debug("cccc");
			String aaa[]=form.getCategoryarray();
			logger.debug("CCCCC:"+aaa.length);
			boolean bool=form.getCategoryarray().length==0;
			logger.debug("cateeee array:"+bool);
			if(!(form.getCategoryarray().length==0))
			{
				logger.debug("arrayy len:"+form.getCategoryarray().length);
				String categorystr = ",";
	     	     for(int i=0;i<form.getCategoryarray().length;i++)//select another category
	     	     {
	     	    	 logger.debug("cate array:"+form.getCategoryarray());
	     	    	 String str1=form.getCategoryarray()[i];
	     	    	 logger.debug("str1:"+str1);
	     	    	 categorystr=categorystr+str1+",";
	     	     }
	     	catstr=categorystr.substring(1, categorystr.length()-1);// contains comma separated values(1,2,3)
	     	logger.debug("catstr:"+catstr);
	     	String aa=cat+","+catstr;//cat-->old values from database //catstr-->currently selected value
	     	vo.setCategory(aa);//set the old+new values in database
	     	logger.debug("vo+catstr:"+aa);
				 String a[]; 
				a=catstr.split(",");
				for(int k=0;k<a.length;k++)
				{
					logger.debug("cat list values:"+a[k]);
					list=service.retrievecategoryvalues(a[k]);
					logger.debug("list size "+list.size());
					vo2=(DriverLicenceVO)list.get(0);
					logger.debug("value of cat:"+vo2.getCategory());
					categoryvalue=categoryvalue+vo2.getCategory()+" ";
				}
			}
				form.setCategory(null);
				form.setCategory(cats+categoryvalue);
	     	vo.setLicenceExpiryDate(form.getLicenceExpiryDate());
	     	vo.setEndorsement(form.getEndorsement());
			String endorsements=form.getEndorsement();
		   	String endorsementstr = ",";
			if(StringUtils.isNotEmpty(form.getEndorsementarray().toString()))
			{
	   	    	for(int i=0;i<form.getEndorsementarray().length;i++)
	   	    	{
	   	    		String str1=form.getEndorsementarray()[i];
	   	    		endorsementstr=endorsementstr+str1+",";
	   	    	}
	   	    String endstr=endorsementstr.substring(1, endorsementstr.length()-1);
	   	    vo.setEndorsement(endorse+","+endstr);
	   	    String endarray[];
			endarray=endstr.split(",");
			String endorsementvalue="";
				for(int k=0;k<endarray.length ;k++)
				{
				logger.debug("endorse value in for loop:"+endarray[k]);
				list=service.retrieveendorsementvalues(endarray[k]);
				logger.debug("endorse list size "+list.size());
				vo2=(DriverLicenceVO)list.get(0);
				endorsementvalue=endorsementvalue+vo2.getEndorsement()+" ";
				logger.debug("endorse value:"+vo2.getEndorsement());
				}
			}
			form.setEndorsement(null);
			form.setEndorsement(endorsements+endorsementvalue);
	   	    vo.setPunishment(form.getPunishment());
	   	    logger.debug("licence number"+form.getLicenceNo());
	   	    session.setAttribute("driverLicenceNo", form.getLicenceNo());
	   	    String licenceno=(String)session.getAttribute("driverLicenceNo");
	   	    logger.debug("licence in session"+licenceno);
	   	    service.update(vo,form.getDriverId());
	  		
			logger.debug("DriverLicenceAction: updateMethod------------->");
		return aMapping.findForward("load");
	}
	
	/**
	 * insert new category values
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertothersMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		DriverLicenceForm form=(DriverLicenceForm)aForm;
		logger.debug("DriverLicenceAction:insertothersMethod<----------");
		vo.setOthers(form.getOthers());
		service.insertothers(vo);
		categorylist=service.categorycombo(vo);
		form.setCategoryList(categorylist);
		logger.debug("DriverLicenceAction: insertothersMethod---------->");
		return aMapping.findForward("load");
	}
	/**
	 * retrieve values from database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */	
	public ActionForward retrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		
		DriverLicenceForm form=(DriverLicenceForm)aForm;
		logger.debug("DriverLicenceAction:retrieveMethod<----------");
		idlist=service.idretrieve(form.getDriverId());
		for(int i=0;i<idlist.size();i++)
		{
			idvo=(DriverLicenceVO)idlist.get(i);
		}
		
		retrievelist=service.retrieveall();
		for(int i=0;i<retrievelist.size();i++)
		{
		retrievevo=(DriverLicenceVO)retrievelist.get(i);
		logger.debug("driverid in action(vo:"+retrievevo.getDriverdesc());
		logger.debug("driverid in idform(vo:"+idvo.getDriverdesc());
		if(retrievevo.getDriverdesc().equals(idvo.getDriverdesc()))
		{
		logger.debug("equal inside if");
		int id=Integer.parseInt(form.getDriverId());
		list=service.retrievedrivername(id);
		vo2=(DriverLicenceVO)list.get(0);
		form.setDriverName(vo2.getDriverName());
	    list=service.retrieve(id);
		vo=(DriverLicenceVO)list.get(0);
		form.setLicenceNo(vo.getLicenceNo());
		form.setBatchNo(vo.getBatchNo());
		form.setDateOfLicence(vo.getDateOfLicence());
		form.setValidPeriod(vo.getValidPeriod());
		logger.debug("valid period in action;"+vo.getValidPeriod());
		//form.setCategoryList(null);
		cat=vo.getCategory();
		form.setCategory(cat);
		logger.debug("cat from vo:"+cat);
		String a[]; 
		a=cat.split(",");
		String categoryvalue="";
		for(int k=0;k<a.length;k++)
		{
			logger.debug("cat list values:"+a[k]);
			list=service.retrievecategoryvalues(a[k]);
			logger.debug("list size "+list.size());
			vo2=(DriverLicenceVO)list.get(0);
			logger.debug("value of cat:"+vo2.getCategory());
			categoryvalue=categoryvalue+vo2.getCategory()+" ";
		}
		form.setCategory(categoryvalue);
		logger.debug("categoryvalue:"+categoryvalue);
		form.setLicenceExpiryDate(vo.getLicenceExpiryDate());
		endorse=vo.getEndorsement();
		logger.debug("endorse from vo:"+endorse);
		String endarray[];
		endarray=endorse.split(",");
		String endorsementvalue="";
		for(int k=0;k<endarray.length ;k++)
		{
			logger.debug("endorse value in for loop:"+endarray[k]);
			list=service.retrieveendorsementvalues(endarray[k]);
			logger.debug("endorse list size "+list.size());
			vo2=(DriverLicenceVO)list.get(0);
			endorsementvalue=endorsementvalue+vo2.getEndorsement()+" ";
			logger.debug("endorse value:"+vo2.getEndorsement());
		}
		form.setEndorsement(endorsementvalue);
		form.setPunishment(vo.getPunishment());
		i=retrievelist.size()+1;
		}
		else
		{
			logger.debug("not equal");
			int id=Integer.parseInt(form.getDriverId());
			list=service.retrievedrivername(id);
			vo2=(DriverLicenceVO)list.get(0);
			form.setDriverName(vo2.getDriverName());
			form.setLicenceNo(null);
		    form.setBatchNo(null);
		    form.setDateOfLicence(null);
		    form.setValidPeriod(null);
		    form.setCategoryarray(null);
		    form.setLicenceExpiryDate(null);
		    form.setEndorsement(null);
		    form.setPunishment(null);
		}
		}
		logger.debug("DriverLicenceAction: retrieveMethod---------->");
		return aMapping.findForward("load");
	}
	/**
	 * clear the form values
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward clearformMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		DriverLicenceForm form=(DriverLicenceForm)aForm;
		logger.debug("RoadTaxAction:clearformMethod<----------");
	     form.setDriverId(null);
	     form.setDriverName(null);
	     form.setLicenceNo(null);
	     form.setBatchNo(null);
	     form.setDateOfLicence(null);
	     form.setValidPeriod(null);
	     form.setCategoryarray(null);
	     form.setLicenceExpiryDate(null);
	     form.setEndorsement(null);
	     form.setPunishment(null);
	     logger.debug("DriverLicenceAction: clearformMethod---------->");
	     return aMapping.findForward("load");
	}
}
