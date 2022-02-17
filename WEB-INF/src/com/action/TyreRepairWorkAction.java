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
import com.formbean.TyreRepairWorkForm;
import com.formbean.TyreRepairWorkRequisitionForm;

import com.wf.*;
import com.service.TyreRepairWorkService;
import com.vo.TyreRepairWorkVO;


public class TyreRepairWorkAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkAction.class);
	job jb=new job();
	int jobid;
	String repairwork=null;
	ArrayList list1=new ArrayList();
	String tyreNumber=null;
	TyreRepairWorkService tyrerepairworkservice =new TyreRepairWorkService();
	TyreRepairWorkVO tyrerepairworkvo=new TyreRepairWorkVO();
	ArrayList list=new ArrayList();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		    TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;	
			TyreRepairWorkAction tyrerepairworkaction=new TyreRepairWorkAction();
			tyrerepairworkaction.tyreNumberMethod(mapping, form, request, response);
			return mapping.findForward("load");
	  }
		
		public ActionForward tyreNumberMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			ArrayList tyreNumberList=new ArrayList();
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;
			TyreRepairWorkService tyrerepairworkservice =new TyreRepairWorkService();
			tyreNumberList=tyrerepairworkservice.tyreNumberCombo();
			tyrerepairworkform.setTyreNumberList(tyreNumberList);
			return mapping.findForward("load");
		}
		
		public ActionForward setTyreNumberMethod1(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
			
		   if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber1()))
		    {
		    	tyrerepairworkform.setTyreNumber1(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork1(repairwork);
		       	tyrerepairworkform.setRepairReason1(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize1(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand1(tyrerepairworkvo.getTyreBrand());
		      }
		    return mapping.findForward("load");	
		}
		
		public ActionForward setTyreNumberMethod2(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber2()))
		    {
		    	tyrerepairworkform.setTyreNumber2(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork2(repairwork);
		       	tyrerepairworkform.setRepairReason2(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize2(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand2(tyrerepairworkvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		
		public ActionForward setTyreNumberMethod3(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			int len=tyrerepairworkform.getTyreNumbers().length;
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber3()))
		    {
		    	tyrerepairworkform.setTyreNumber3(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork3(repairwork);
		       	tyrerepairworkform.setRepairReason3(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize3(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand3(tyrerepairworkvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod4(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			int len=tyrerepairworkform.getTyreNumbers().length;
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber4()))
		    {
		    	tyrerepairworkform.setTyreNumber4(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork4(repairwork);
		       	tyrerepairworkform.setRepairReason4(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize4(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand4(tyrerepairworkvo.getTyreBrand());
		    }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod5(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			int len=tyrerepairworkform.getTyreNumbers().length;
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber5()))
		    {
		    	tyrerepairworkform.setTyreNumber5(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork5(repairwork);
		       	tyrerepairworkform.setRepairReason5(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize5(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand5(tyrerepairworkvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod6(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			int len=tyrerepairworkform.getTyreNumbers().length;
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber6()))
		    {
		    	tyrerepairworkform.setTyreNumber6(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork6(repairwork);
		       	tyrerepairworkform.setRepairReason6(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize6(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand6(tyrerepairworkvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod7(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			int len=tyrerepairworkform.getTyreNumbers().length;
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber7()))
		    {
		    	tyrerepairworkform.setTyreNumber7(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork7(repairwork);
		       	tyrerepairworkform.setRepairReason7(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize7(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand7(tyrerepairworkvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod8(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber8()))
		    {
		    	tyrerepairworkform.setTyreNumber8(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork8(repairwork);
		       	tyrerepairworkform.setRepairReason8(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize8(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand8(tyrerepairworkvo.getTyreBrand());
		      }
		    	return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod9(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber9()))
		    {
		    	tyrerepairworkform.setTyreNumber9(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork9(repairwork);
		       	tyrerepairworkform.setRepairReason9(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize9(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand9(tyrerepairworkvo.getTyreBrand());
		     }
		    	return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod10(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;			
			tyreNumber=tyrerepairworkform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkform.getTyreNumber10()))
		    {
		    	
		    	tyrerepairworkform.setTyreNumber1(tyreNumber);
       	        list=tyrerepairworkservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list.get(0);
		       	repairwork=tyrerepairworkvo.getRepairWork1();
		       	tyrerepairworkform.setRepairWork1(repairwork);
		       	tyrerepairworkform.setRepairReason1(tyrerepairworkvo.getRepairReason1());
		       	list1=tyrerepairworkservice.tyredetailscode(tyreNumber);
		       	tyrerepairworkvo=(TyreRepairWorkVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
		       	ArrayList sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
			    tyrerepairworkform.setTyreSize1(tyrerepairworkvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
			    tyrerepairworkform.setTyreBrand1(tyrerepairworkvo.getTyreBrand());
		   }
		    	return mapping.findForward("load");	
		}
		
		/**
		 * To insert the values into the database
		 * @param job_id
		 * @param form
		 * @throws Exception
		 */
		public void saveMethod(int job_id,ActionForm form)throws Exception 
		{
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;
			TyreRepairWorkService tyrerepairworkservice =new TyreRepairWorkService();
			TyreRepairWorkVO tyrerepairworkvo=new TyreRepairWorkVO();
			String tyreNumber=null;
			String repairwork_repair=null;
			String reason=null;
			//ActionErrors actionErrors = new ActionErrors();
			//TyreRepairWorkAction action=new TyreRebuiltAction();
			//actionErrors=action.validate(mapping, request);
		    //logger.debug("Action Errors:"+actionErrors);
			
		    PropertyUtils.copyProperties(tyrerepairworkvo,tyrerepairworkform);
		   	tyrerepairworkservice.insertCommontyretransaction(job_id,tyrerepairworkvo);	
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber1()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber1();
		 		repairwork_repair=tyrerepairworkform.getRepairWork1();
		 		reason=tyrerepairworkform.getRepairReason1();
		 		tyrerepairworkservice.insertTyretransaction(job_id,tyreNumber,repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		  	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber2()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber2();
		 		repairwork_repair=tyrerepairworkform.getRepairWork2();
		 		reason=tyrerepairworkform.getRepairReason2();
		 		tyrerepairworkservice.insertTyretransaction(job_id,tyreNumber,repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber3()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber3();
		 		repairwork_repair=tyrerepairworkform.getRepairWork3();
		 		reason=tyrerepairworkform.getRepairReason3();
		 		tyrerepairworkservice.insertTyretransaction(job_id,tyreNumber,repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber4()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber4();
		 		repairwork_repair=tyrerepairworkform.getRepairWork4();
		 		reason=tyrerepairworkform.getRepairReason4();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber, repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber5()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber5();
		 		repairwork_repair=tyrerepairworkform.getRepairWork5();
		 		reason=tyrerepairworkform.getRepairReason5();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber, repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber6()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber6();
		 		repairwork_repair=tyrerepairworkform.getRepairWork6();
		 		reason=tyrerepairworkform.getRepairReason6();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber, repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber7()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber7();
		 		repairwork_repair=tyrerepairworkform.getRepairWork7();
		 		reason=tyrerepairworkform.getRepairReason7();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber, repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber8()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber8();
		 		repairwork_repair=tyrerepairworkform.getRepairWork8();
		 		reason=tyrerepairworkform.getRepairReason8();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber,repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber9()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber9();
		 		repairwork_repair=tyrerepairworkform.getRepairWork9();
		 		reason=tyrerepairworkform.getRepairReason9();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber,repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkform.getTyreNumber10()))
		 	{
		 		tyreNumber=tyrerepairworkform.getTyreNumber10();
		 		repairwork_repair=tyrerepairworkform.getRepairWork10();
		 		reason=tyrerepairworkform.getRepairReason10();
		 		tyrerepairworkservice.insertTyretransaction(job_id, tyreNumber,repairwork_repair, reason);
		 		tyrerepairworkservice.updateIndicator(tyreNumber);
		 	}	 			
		}
		
		public ActionForward jobMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			String reqName="TyreRepairWork";
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("userId");
			String ss1=mapping.getName();
			try{
			jobid=jb.creatJob(ss1,userName,reqName);
			}
			catch(Exception e)
			{
				logger.debug("error in job :"+e);
			}
			saveMethod(jobid,form);
			return mapping.findForward("load");
		}
		
		public ActionForward inboxMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			ArrayList tyrelist=new ArrayList();
			ArrayList commonlist=new ArrayList();
			commonlist=tyrerepairworkservice.retrievecommondetails(job);
			/**
			 * To set common details in TyreRepairWorkForm
			 */
			
			tyrerepairworkvo=(TyreRepairWorkVO)commonlist.get(0);
			tyrerepairworkform.setBillDate(tyrerepairworkvo.getBillDate());
			tyrerepairworkform.setBillNumber(tyrerepairworkvo.getBillNumber());
			tyrerepairworkform.setCompanyName(tyrerepairworkvo.getCompanyName());
			tyrerepairworkform.setBillAmount(tyrerepairworkvo.getBillAmount());
			
			
			/**
			 * To set Tyre details in TyreRebuiltForm
			 */
			int tyreSizeCode;
			int tyreBrandCode;
			ArrayList sizeList=new ArrayList();
			ArrayList brandList=new ArrayList();
			tyrelist=tyrerepairworkservice.retrievetyredetails(job);
			for(int i=0;i<tyrelist.size();i++)
			{
				tyrerepairworkvo=(TyreRepairWorkVO)tyrelist.get(i);
				switch(i)
				{
				case 0:
					tyrerepairworkform.setTyreNumber1(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork1(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason1(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand1(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize1(tyrerepairworkvo.getTyreSize());
				    break;
					
				case 1:
					tyrerepairworkform.setTyreNumber2(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork2(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason2(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand2(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize2(tyrerepairworkvo.getTyreSize());
					break;
				case 2:
					tyrerepairworkform.setTyreNumber3(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork3(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason3(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand3(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize3(tyrerepairworkvo.getTyreSize());
					break;
				case 3:
					tyrerepairworkform.setTyreNumber4(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork4(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason4(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand4(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize4(tyrerepairworkvo.getTyreSize());
					break;
				case 4:
					tyrerepairworkform.setTyreNumber5(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork5(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason5(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand5(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize5(tyrerepairworkvo.getTyreSize());
					break;
				case 5:
					tyrerepairworkform.setTyreNumber6(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork6(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason6(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand6(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize6(tyrerepairworkvo.getTyreSize());
					break;
				case 6:
					tyrerepairworkform.setTyreNumber7(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork7(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason7(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand7(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize7(tyrerepairworkvo.getTyreSize());
					break;
				case 7:
					tyrerepairworkform.setTyreNumber8(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork8(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason8(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand8(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize8(tyrerepairworkvo.getTyreSize());
					break;
				case 8:
					tyrerepairworkform.setTyreNumber9(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork9(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason9(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand9(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize9(tyrerepairworkvo.getTyreSize());
					break;
				case 9:
					tyrerepairworkform.setTyreNumber10(tyrerepairworkvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkvo.getTyreBrand());
					tyrerepairworkform.setRepairWork10(tyrerepairworkvo.getRepairWork1());
					tyrerepairworkform.setRepairReason10(tyrerepairworkvo.getRepairReason1());
					brandList=tyrerepairworkservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)brandList.get(0);
				    tyrerepairworkform.setTyreBrand10(tyrerepairworkvo.getTyreBrand());
				    sizeList=tyrerepairworkservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkvo=(TyreRepairWorkVO)sizeList.get(0);
				    tyrerepairworkform.setTyreSize10(tyrerepairworkvo.getTyreSize());
					break;
				}
			}
		    return mapping.findForward("load");
		}

	/**
	 * To create job and task
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
				int job=(Integer)session.getAttribute("jobseq");
				int task=(Integer)session.getAttribute("taskseqseq");
				jb.approveStatus(job,task);
				return mapping.findForward("inb");
		}
		
		public ActionForward okMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			 	HttpSession session = ((HttpServletRequest) request).getSession();
				int job=(Integer)session.getAttribute("jobseq");
				int task=(Integer)session.getAttribute("taskseqseq");
				jb.okStatus(job,task);
				return mapping.findForward("load");
		}
		
		public ActionForward clearMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRepairWorkForm tyrerepairworkform=(TyreRepairWorkForm)form;
			tyrerepairworkform.setRepairWork1(null);
			tyrerepairworkform.setRepairWork2(null);
			tyrerepairworkform.setRepairWork3(null);
			tyrerepairworkform.setRepairWork4(null);
			tyrerepairworkform.setRepairWork5(null);
			tyrerepairworkform.setRepairWork6(null);
			tyrerepairworkform.setRepairWork7(null);
			tyrerepairworkform.setRepairWork8(null);
			tyrerepairworkform.setRepairWork9(null);
			tyrerepairworkform.setRepairWork10(null);
			
			tyrerepairworkform.setRepairReason1(null);
			tyrerepairworkform.setRepairReason2(null);
			tyrerepairworkform.setRepairReason3(null);
			tyrerepairworkform.setRepairReason4(null);
			tyrerepairworkform.setRepairReason5(null);
			tyrerepairworkform.setRepairReason6(null);
			tyrerepairworkform.setRepairReason7(null);
			tyrerepairworkform.setRepairReason8(null);
			tyrerepairworkform.setRepairReason9(null);
			tyrerepairworkform.setRepairReason10(null);
			
			tyrerepairworkform.setTyreBrand1(null);
			tyrerepairworkform.setTyreBrand2(null);
			tyrerepairworkform.setTyreBrand3(null);
			tyrerepairworkform.setTyreBrand4(null);
			tyrerepairworkform.setTyreBrand5(null);
			tyrerepairworkform.setTyreBrand6(null);
			tyrerepairworkform.setTyreBrand7(null);
			tyrerepairworkform.setTyreBrand8(null);
			tyrerepairworkform.setTyreBrand9(null);
			tyrerepairworkform.setTyreBrand10(null);
			
			tyrerepairworkform.setTyreSize1(null);
			tyrerepairworkform.setTyreSize2(null);
			tyrerepairworkform.setTyreSize3(null);
			tyrerepairworkform.setTyreSize4(null);
			tyrerepairworkform.setTyreSize5(null);
			tyrerepairworkform.setTyreSize6(null);
			tyrerepairworkform.setTyreSize7(null);
			tyrerepairworkform.setTyreSize8(null);
			tyrerepairworkform.setTyreSize9(null);
			tyrerepairworkform.setTyreSize10(null);
			
			tyrerepairworkform.setTyreNumber1(null);
			tyrerepairworkform.setTyreNumber2(null);
			tyrerepairworkform.setTyreNumber3(null);
			tyrerepairworkform.setTyreNumber4(null);
			tyrerepairworkform.setTyreNumber5(null);
			tyrerepairworkform.setTyreNumber6(null);
			tyrerepairworkform.setTyreNumber7(null);
			tyrerepairworkform.setTyreNumber8(null);
			tyrerepairworkform.setTyreNumber9(null);
			tyrerepairworkform.setTyreNumber10(null);
			
			tyrerepairworkform.setTyreBrand(null);
			tyrerepairworkform.setTyreSize(null);
			tyrerepairworkform.setTyreNumber(null);
			tyrerepairworkform.setTyrePly(null);
			tyrerepairworkform.setBillAmount(null);
			tyrerepairworkform.setBillDate(null);
			tyrerepairworkform.setBillNumber(null);
			tyrerepairworkform.setCompanyName(null);
	
			return mapping.findForward("load");
		}

}
