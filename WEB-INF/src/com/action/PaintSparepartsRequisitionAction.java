package com.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.action.BaseDispatchAction;
import com.formbean.PaintSparepartsRequisitionForm;
import com.formbean.SparePartsForm;
import com.service.PaintSparepartsRequisitionService;
import com.service.SparepartsService;
import com.vo.PaintSparepartsRequisitionVO;
import com.vo.SparePartsFormVO;
import com.wf.arrayList;
import com.wf.job;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PaintSparepartsRequisitionAction extends BaseDispatchAction{
private static final Logger logger=(Logger)Logger.getLogger(PaintSparepartsRequisitionAction.class);
job jb=new job();
ArrayList res_list=new ArrayList();
ArrayList res_list1=new ArrayList();
ArrayList res_list2=new ArrayList();
ArrayList res_list3=new ArrayList();	
int jobid,spareid,total;
String reqName,brname,brtype,id;
int newqty,brandname,brandtype,wantedquantity,available;

SparepartsService ss=new SparepartsService();
PaintSparepartsRequisitionService spareservice=new PaintSparepartsRequisitionService();

public ActionForward defaultMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		res_list=spareservice.fetchTypeValues();
		sform.setTypeList(res_list);
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

/**
 *  to create the job and task
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
	
	PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
	int type=Integer.parseInt(sform.getItemDes());
	if(type==2)
	reqName="spare";
	else if(type==1)
		reqName="paint requisition";
	HttpSession session = ((HttpServletRequest) request).getSession();
	String userName=(String) session.getAttribute("username");
	logger.debug("inside job method");
	String ss1=mapping.getName();
	try{
	jobid=jb.creatJob(ss1,userName,reqName);
	}
	catch(Exception e)
	{
		logger.debug("error in job"+e);
	}
	logger.debug("job executed");
	insertvalues(jobid,form);
	
	logger.debug("insert executed");
	return mapping.findForward("load");

}

/**
 * passes the jobid,taskid to change the status to 2 for the approve task of that form 
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
		return mapping.findForward("load");
}
public ActionForward partNumberMethod1(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		spareid=Integer.parseInt(sform.getBrandName1());
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList1(res_list1);
		}
		return mapping.findForward("load");
}
public ActionForward partNumberMethod2(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		spareid=Integer.parseInt(sform.getBrandName2());
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList2(res_list1);
		}
		return mapping.findForward("load");
}
public ActionForward partNumberMethod3(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		spareid=Integer.parseInt(sform.getBrandName3());
		//res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList3(res_list1);
		}
		return mapping.findForward("load");
}
public ActionForward partNumberMethod4(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		spareid=Integer.parseInt(sform.getBrandName4());
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList4(res_list1);
		}
		return mapping.findForward("load");
}
public ActionForward partNumberMethod5(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		spareid=Integer.parseInt(sform.getBrandName5());
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList5(res_list1);
		}
		return mapping.findForward("load");
}
public ActionForward quantityMethod1(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		total=0;
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		res_list=spareservice.fetchTypeValues();
		sform.setTypeList(res_list);
		//res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList1(res_list1);
		id=sform.getBrandType1();
		res_list1=ss.fetchRateValue(id);
		SparePartsFormVO vo=new SparePartsFormVO();
		
		for(int i=0;i<res_list1.size();i++)
		{
			vo=(SparePartsFormVO)res_list1.get(i);
			total=Integer.parseInt(vo.getOldAvailable1());
			total=total+Integer.parseInt(vo.getNewAvailable1());
			logger.debug("total available quantity"+total);
		}
		sform.setAvailableQty1(Integer.toString(total));
		}
		return mapping.findForward("load");
}		

public ActionForward quantityMethod2(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		total=0;
		if(typeid==2)
		{
		res_list=spareservice.fetchTypeValues();
		sform.setTypeList(res_list);
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList2(res_list1);
		id=sform.getBrandType2();
		res_list1=ss.fetchRateValue(id);
		SparePartsFormVO vo=new SparePartsFormVO();
		
		for(int i=0;i<res_list1.size();i++)
		{
			vo=(SparePartsFormVO)res_list1.get(i);
			total=Integer.parseInt(vo.getOldAvailable1());
			total=total+Integer.parseInt(vo.getNewAvailable1());
			logger.debug("total available quantity"+total);
		}
		sform.setAvailableQty2(Integer.toString(total));
		}
		return mapping.findForward("load");
}		

public ActionForward quantityMethod3(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		total=0;
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		res_list=spareservice.fetchTypeValues();
		sform.setTypeList(res_list);
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList3(res_list1);
		id=sform.getBrandType3();
		res_list1=ss.fetchRateValue(id);
		SparePartsFormVO vo=new SparePartsFormVO();
		
		for(int i=0;i<res_list1.size();i++)
		{
			vo=(SparePartsFormVO)res_list1.get(i);
			total=Integer.parseInt(vo.getOldAvailable1());
			total=total+Integer.parseInt(vo.getNewAvailable1());
			logger.debug("total available quantity"+total);
		}
		sform.setAvailableQty3(Integer.toString(total));
		}
		return mapping.findForward("load");
}		

public ActionForward quantityMethod4(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		total=0;
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		res_list=spareservice.fetchTypeValues();
		sform.setTypeList(res_list);
	//	res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList4(res_list1);
		id=sform.getBrandType4();
		res_list1=ss.fetchRateValue(id);
		SparePartsFormVO vo=new SparePartsFormVO();
		
		for(int i=0;i<res_list1.size();i++)
		{
			vo=(SparePartsFormVO)res_list1.get(i);
			total=Integer.parseInt(vo.getOldAvailable1());
			total=total+Integer.parseInt(vo.getNewAvailable1());
			logger.debug("total available quantity"+total);
		}
		sform.setAvailableQty4(Integer.toString(total));
		}
		return mapping.findForward("load");
}		

public ActionForward quantityMethod5(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		total=0;
		PaintSparepartsRequisitionForm sform=(PaintSparepartsRequisitionForm)form;
		int typeid=Integer.parseInt(sform.getItemDes());
		if(typeid==2)
		{
		res_list=spareservice.fetchTypeValues();
		sform.setTypeList(res_list);
		//res_list1=spareservice.fetchNameValues(spareid);
		sform.setPartList5(res_list1);
		id=sform.getBrandType5();
		res_list1=ss.fetchRateValue(id);
		SparePartsFormVO vo=new SparePartsFormVO();
		
		for(int i=0;i<res_list1.size();i++)
		{
			vo=(SparePartsFormVO)res_list1.get(i);
			total=Integer.parseInt(vo.getOldAvailable1());
			total=total+Integer.parseInt(vo.getNewAvailable1());
			logger.debug("total available quantity"+total);
		}
		sform.setAvailableQty5(Integer.toString(total));
		}
		return mapping.findForward("load");
}		

/**
 * to insert the values in table
 * @param jobid
 * @param form
 */
public void insertvalues(int jobid,ActionForm form)
{
	
	
	PaintSparepartsRequisitionForm sf=(PaintSparepartsRequisitionForm)form;
	int reqItem=Integer.parseInt(sf.getItemDes());
	String reason=sf.getReason();
	PaintSparepartsRequisitionService ss=new PaintSparepartsRequisitionService();
	
	try
    {
		
		ss.insertCommon(jobid,reqItem,reason);
   		logger.debug("main");
    }
    catch(Exception e)
    {
    	logger.debug("error"+e);
    }
    if(!StringUtils.isEmpty(sf.getQtyNeeded1()))
    {
    	brandname=Integer.parseInt(sf.getBrandName1());
		brandtype=Integer.parseInt(sf.getBrandType1());
    	wantedquantity=Integer.parseInt(sf.getQtyNeeded1());
    	available=Integer.parseInt(sf.getAvailableQty1());
    	try
	    {
    		ss.insertCommonValues(jobid,brandname,brandtype,wantedquantity,available);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getQtyNeeded2()))
    {
    	brandname=Integer.parseInt(sf.getBrandName2());
		brandtype=Integer.parseInt(sf.getBrandType2());
    	wantedquantity=Integer.parseInt(sf.getQtyNeeded2());
    	available=Integer.parseInt(sf.getAvailableQty2());
    	try
	    {
    		ss.insertCommonValues(jobid,brandname,brandtype,wantedquantity,available);
	   		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getQtyNeeded3()))
    {
    	brandname=Integer.parseInt(sf.getBrandName3());
		brandtype=Integer.parseInt(sf.getBrandType3());
    	wantedquantity=Integer.parseInt(sf.getQtyNeeded3());
    	available=Integer.parseInt(sf.getAvailableQty3());
    	try
	    {
    		ss.insertCommonValues(jobid,brandname,brandtype,wantedquantity,available);
	   		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getQtyNeeded4()))
    {
    	brandname=Integer.parseInt(sf.getBrandName4());
		brandtype=Integer.parseInt(sf.getBrandType4());
    	wantedquantity=Integer.parseInt(sf.getQtyNeeded4());
    	available=Integer.parseInt(sf.getAvailableQty4());
    	try
	    {
    		ss.insertCommonValues(jobid,brandname,brandtype,wantedquantity,available);  
	   		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getQtyNeeded5()))
    {
    	brandname=Integer.parseInt(sf.getBrandName5());
		brandtype=Integer.parseInt(sf.getBrandType5());
    	wantedquantity=Integer.parseInt(sf.getQtyNeeded5());
    	available=Integer.parseInt(sf.getAvailableQty5());
    	try
	    {
    		ss.insertCommonValues(jobid,brandname,brandtype,wantedquantity,available);  
	   		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getNewBrandName1()))
    		{
    		res_list1=ss.fetchSpareLookupId();
    		PaintSparepartsRequisitionVO vo=new PaintSparepartsRequisitionVO();
    		vo=(PaintSparepartsRequisitionVO)res_list1.get(0);
    		spareid=Integer.parseInt(vo.getSpareSequence());
    			brname=sf.getNewBrandName1();
    			brtype=sf.getNewBrandType1();
    			newqty=Integer.parseInt(sf.getNewQtyNeeded1());
    			available=0;
    			try
    		    {
    	    		ss.insertLookupValues(brname,brtype,spareid);  
    	    		ss.insertCommonValues(jobid,spareid,spareid,newqty,available);  
    		   		logger.debug("fuel");
    		    }
    		    catch(Exception e)
    		    {
    		    	logger.debug("error"+e);
    		    }
    		}
    if(!StringUtils.isEmpty(sf.getNewBrandName2()))
	{
    	res_list1=ss.fetchSpareLookupId();
		PaintSparepartsRequisitionVO vo=new PaintSparepartsRequisitionVO();
		vo=(PaintSparepartsRequisitionVO)res_list1.get(0);
		spareid=Integer.parseInt(vo.getSpareSequence());
		brname=sf.getNewBrandName2();
		brtype=sf.getNewBrandType2();
		newqty=Integer.parseInt(sf.getNewQtyNeeded2());
		available=0;
		try
	    {
    		ss.insertLookupValues(brname,brtype,spareid); 
    		ss.insertCommonValues(jobid,spareid,spareid,newqty,available);  
	   		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
	}
    if(!StringUtils.isEmpty(sf.getNewBrandName3()))
	{
    	res_list1=ss.fetchSpareLookupId();
		PaintSparepartsRequisitionVO vo=new PaintSparepartsRequisitionVO();
		vo=(PaintSparepartsRequisitionVO)res_list1.get(0);
		spareid=Integer.parseInt(vo.getSpareSequence());
		brname=sf.getNewBrandName3();
		brtype=sf.getNewBrandType3();
		newqty=Integer.parseInt(sf.getNewQtyNeeded3());
		available=0;
		try
	    {
    		ss.insertLookupValues(brname,brtype,spareid); 
    		ss.insertCommonValues(jobid,spareid,spareid,newqty,available);  
	   		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
	}
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
	PaintSparepartsRequisitionForm sf=(PaintSparepartsRequisitionForm)form;
	//clear(form);
	HttpSession session = ((HttpServletRequest) request).getSession();
	int job=(Integer)session.getAttribute("jobseq");
	res_list=spareservice.fetchTypeValues();
	sf.setTypeList(res_list);
    res_list=spareservice.fetchCommonValues(job);
    logger.debug("select command executed"+res_list.size());
    
    PaintSparepartsRequisitionVO vo=new PaintSparepartsRequisitionVO();	
   for(int i=0;i<res_list.size();i++)
    {
    	vo=(PaintSparepartsRequisitionVO)res_list.get(i);
    	logger.debug(vo);
    	sf.setReason(vo.getReason());
    	sf.setItemDes(vo.getItemDes());
       }
   
   res_list=spareservice.fetchValues(job);
   logger.debug("select command executed"+res_list.size());
   PaintSparepartsRequisitionVO vo1=new PaintSparepartsRequisitionVO();	
  for(int i=0;i<res_list.size();i++)
  {
	  vo1=(PaintSparepartsRequisitionVO)res_list.get(i);
	  switch(i)
	  {
	  case 0:
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getBrandType1()));
		  sf.setPartList1(res_list1);
		  sf.setBrandName1(vo1.getBrandName1());
		  sf.setBrandType1(vo1.getBrandType1());
		  sf.setAvailableQty1(vo1.getAvailableQty1());
		  sf.setQtyNeeded1(vo1.getQtyNeeded1());
		  break;
	  case 1:
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getBrandType1()));
		  sf.setPartList1(res_list1);
		  sf.setBrandName2(vo1.getBrandName1());
		  sf.setBrandType2(vo1.getBrandType1());
		  sf.setAvailableQty2(vo1.getAvailableQty1());
		  sf.setQtyNeeded2(vo1.getQtyNeeded1());
		  break;
	  case 2:
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getBrandType1()));
		  sf.setPartList1(res_list1);
		  sf.setBrandName3(vo1.getBrandName1());
		  sf.setBrandType3(vo1.getBrandType1());
		  sf.setAvailableQty3(vo1.getAvailableQty1());
		  sf.setQtyNeeded3(vo1.getQtyNeeded1());
		  break;
	  case 3:
		 // res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getBrandType1()));
		  sf.setPartList1(res_list1);
		  sf.setBrandName4(vo1.getBrandName1());
		  sf.setBrandType4(vo1.getBrandType1());
		  sf.setAvailableQty4(vo1.getAvailableQty1());
		  sf.setQtyNeeded4(vo1.getQtyNeeded1());
		  break;
	  case 4:
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getBrandType1()));
		  sf.setPartList1(res_list1);
		  sf.setBrandName5(vo1.getBrandName1());
		  sf.setBrandType5(vo1.getBrandType1());
		  sf.setAvailableQty5(vo1.getAvailableQty1());
		  sf.setQtyNeeded5(vo1.getQtyNeeded1());
		  break;
	  case 5:
		  sf.setNewBrandName1(vo1.getBrandName1());
		  sf.setNewBrandType1(vo1.getBrandType1());
		  sf.setNewQtyNeeded1(vo1.getQtyNeeded1());
		  break;
	  case 6:
		  
		  sf.setNewBrandName2(vo1.getBrandName1());
		  sf.setNewBrandType2(vo1.getBrandType1());
		  sf.setNewQtyNeeded2(vo1.getQtyNeeded1());
		  break;
	  case 7:
		  sf.setNewBrandName3(vo1.getBrandName1());
		  sf.setNewBrandType3(vo1.getBrandType1());
		  sf.setNewQtyNeeded3(vo1.getQtyNeeded1());
		  break;
		  
	  }
  }
	return mapping.findForward("load");
}
}
