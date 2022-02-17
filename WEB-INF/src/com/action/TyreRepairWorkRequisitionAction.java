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

import com.formbean.TyreRebuiltForm;
import com.formbean.TyreRepairWorkRequisitionForm;
import com.service.TyreRepairWorkRequisitionService;
import com.vo.TyreRepairWorkRequisitionVO;
import com.wf.job;

public class TyreRepairWorkRequisitionAction extends BaseDispatchAction{
	
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkRequisitionAction.class);
	job jb=new job();
	int jobid;
	ArrayList list=new ArrayList();
	String rebuilt=null;
	TyreRepairWorkRequisitionVO tyrerepairworkrequisitionvo=new TyreRepairWorkRequisitionVO();
	TyreRepairWorkRequisitionService tyrerepairworkrequisitionservice =new TyreRepairWorkRequisitionService();
	String tyreNumber=null;
		
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		    
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;	
			TyreRepairWorkRequisitionService tyrerepairworkrequisitionservice =new TyreRepairWorkRequisitionService();
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("userId");
			
			/**
			 * Setting  Tyre Size to Combo Box
			 */	
		    ArrayList tyreSizeList=new ArrayList();
		    tyreSizeList=tyrerepairworkrequisitionservice.tyreSizeCombo();
			tyrerepairworkrequisitionform.setTyreSizeList(tyreSizeList);
		    
			/**
			 * Setting  Tyre Brand to Combo Box
			 */	
		    ArrayList tyreBrandList=new ArrayList();
		    tyreBrandList=tyrerepairworkrequisitionservice.tyreBrandCombo();
			tyrerepairworkrequisitionform.setTyreBrandList(tyreBrandList);
		    
			/**
			 * Setting  Tyre Ply to Combo Box
			 */	
		    ArrayList tyrePlyList=new ArrayList();
		    tyrePlyList=tyrerepairworkrequisitionservice.tyrePlyCombo();
			tyrerepairworkrequisitionform.setTyrePlyList(tyrePlyList);
		    
		    /**
		     * To set InchargeName
		     */
		    tyrerepairworkrequisitionform.setInchargeName(userName);
		    return mapping.findForward("load");
	  }
		
		
		public ActionForward tyreNumberMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			ArrayList tyreNumberList=new ArrayList();
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;
			TyreRepairWorkRequisitionService tyrerepairworkrequisitionservice =new TyreRepairWorkRequisitionService();
			int tyreSize=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
			int tyrePly=Integer.parseInt(tyrerepairworkrequisitionform.getTyrePly());
			int tyreBrand=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			tyreNumberList=tyrerepairworkrequisitionservice.tyreNumberCombo(tyreSize,tyreBrand,tyrePly);
			tyrerepairworkrequisitionform.setTyreNumberList(tyreNumberList);
			return mapping.findForward("load");
		}
		
		public void saveMethod(int job_id,ActionForm form)throws Exception 
		{
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;
			TyreRepairWorkRequisitionService tyrerepairworkrequisitionservice =new TyreRepairWorkRequisitionService();
			TyreRepairWorkRequisitionVO tyrerepairworkrequisitionvo=new TyreRepairWorkRequisitionVO();
			String tyreNumber=null;
			String rebuilt_repair=null;
			String reason=null;	
		    PropertyUtils.copyProperties(tyrerepairworkrequisitionvo,tyrerepairworkrequisitionform);
		    logger.debug("inside actionnnnnnnnnnnn:");
		 	tyrerepairworkrequisitionservice.insertCommontyretransaction(job_id,tyrerepairworkrequisitionvo);	
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber1()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber1();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork1();
		 		reason=tyrerepairworkrequisitionform.getRepairReason1();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber2()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber2();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork2();
		 		reason=tyrerepairworkrequisitionform.getRepairReason2();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber3()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber3();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork3();
		 		reason=tyrerepairworkrequisitionform.getRepairReason3();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber4()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber4();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork4();
		 		reason=tyrerepairworkrequisitionform.getRepairReason4();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber5()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber5();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork5();
		 		reason=tyrerepairworkrequisitionform.getRepairReason5();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber6()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber6();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork6();
		 		reason=tyrerepairworkrequisitionform.getRepairReason6();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber7()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber7();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork7();
		 		reason=tyrerepairworkrequisitionform.getRepairReason7();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber8()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber8();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork8();
		 		reason=tyrerepairworkrequisitionform.getRepairReason8();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber9()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber9();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork9();
		 		reason=tyrerepairworkrequisitionform.getRepairReason9();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber10()))
		 	{
		 		tyreNumber=tyrerepairworkrequisitionform.getTyreNumber10();
		 		rebuilt_repair=tyrerepairworkrequisitionform.getRepairWork10();
		 		reason=tyrerepairworkrequisitionform.getRepairReason10();
		 		tyrerepairworkrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}	 			
		}
		
		public ActionForward setTyreNumberMethod1(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;	
	
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber1()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber1(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		       	rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		        tyrerepairworkrequisitionform.setRepairWork1(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize1(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand1(tyrerepairworkrequisitionvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod2(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber2()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber2(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
                rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       	tyrerepairworkrequisitionform.setRepairWork2(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize2(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand2(tyrerepairworkrequisitionvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		
		public ActionForward setTyreNumberMethod3(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber3()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber3(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		       	rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       	tyrerepairworkrequisitionform.setRepairWork3(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize3(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand3(tyrerepairworkrequisitionvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod4(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber4()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber4(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		        rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       	tyrerepairworkrequisitionform.setRepairWork4(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize4(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand4(tyrerepairworkrequisitionvo.getTyreBrand());
		       	
		    }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod5(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber5()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber5(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		      	rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       	tyrerepairworkrequisitionform.setRepairWork5(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize5(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand5(tyrerepairworkrequisitionvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod6(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber6()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber6(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		       	rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
	       	tyrerepairworkrequisitionform.setRepairWork6(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize6(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand6(tyrerepairworkrequisitionvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod7(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber7()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber7(tyreNumber);
       	        /*list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		       	rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       	tyrerepairworkrequisitionform.setRepairWork7(rebuilt);*/
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize7(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand7(tyrerepairworkrequisitionvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod8(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber8()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber8(tyreNumber);
       	        //list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       //	tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		       // rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       //	tyrerepairworkrequisitionform.setRepairWork8(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize8(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand8(tyrerepairworkrequisitionvo.getTyreBrand());
		    }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod9(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber9()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber9(tyreNumber);
       	        //list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       //tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		        //rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       
		       //	tyrerepairworkrequisitionform.setRepairWork9(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize9(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand9(tyrerepairworkrequisitionvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod10(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;			
			tyreNumber=tyrerepairworkrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerepairworkrequisitionform.getTyreNumber10()))
		    {
		    	tyrerepairworkrequisitionform.setTyreNumber10(tyreNumber);
       	        //list=tyrerepairworkrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	//tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)list.get(0);
		       	//rebuilt=tyrerepairworkrequisitionvo.getRepairWork1();
		       //tyrerepairworkrequisitionform.setRepairWork10(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
			    tyrerepairworkrequisitionform.setTyreSize10(tyrerepairworkrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
			    tyrerepairworkrequisitionform.setTyreBrand10(tyrerepairworkrequisitionvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
		}
		
		
		public ActionForward jobMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			String reqName="TyreRepairWorkRequisition";
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("userId");
			String ss1=mapping.getName();
			try
			{
			jobid=jb.creatJob(ss1,userName,reqName);
			}
			catch(Exception e)
			{
				logger.debug("error in job"+e);
			}
			saveMethod(jobid,form);
			return mapping.findForward("load");
		}
		
		/**
		 * To set tyredetails in the TyreRepairWorkRequisition Form
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
			
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;
			
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			ArrayList tyrelist=new ArrayList();
			ArrayList commonlist=new ArrayList();
			
			commonlist=tyrerepairworkrequisitionservice.retrievecommondetails(job);
			/**
			 * To set common details in TyreRepairWorkRequisitionForm
			 */
			tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)commonlist.get(0);
			tyrerepairworkrequisitionform.setInchargeName(tyrerepairworkrequisitionvo.getInchargeName());
			tyrerepairworkrequisitionform.setRequestedDate(tyrerepairworkrequisitionvo.getRequestedDate());
		    
			/**
			 * To set Tyre details in TyreRepairWorkRequisitionForm
			 */
			tyrelist=tyrerepairworkrequisitionservice.retrievetyredetails(job);
			int tyreSizeCode;
			int tyreBrandCode;
			ArrayList sizeList=new ArrayList();
			ArrayList brandList=new ArrayList();
			for(int i=0;i<tyrelist.size();i++)
			{
				tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)tyrelist.get(i);
				switch(i)
				{
				case 0:
					tyrerepairworkrequisitionform.setTyreNumber1(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork1(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason1(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand1(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize1(tyrerepairworkrequisitionvo.getTyreSize());
				    break;
					
				case 1:
					tyrerepairworkrequisitionform.setTyreNumber2(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork2(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason2(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand2(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize2(tyrerepairworkrequisitionvo.getTyreSize());
				    break;
				case 2:
					tyrerepairworkrequisitionform.setTyreNumber3(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork3(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason3(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand3(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize3(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 3:
					tyrerepairworkrequisitionform.setTyreNumber4(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork4(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason4(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand4(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize4(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 4:
					tyrerepairworkrequisitionform.setTyreNumber5(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork5(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason5(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand5(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize5(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 5:
					tyrerepairworkrequisitionform.setTyreNumber6(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork6(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason6(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand6(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize6(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 6:
					tyrerepairworkrequisitionform.setTyreNumber7(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork7(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason7(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand7(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize7(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 7:
					tyrerepairworkrequisitionform.setTyreNumber8(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork8(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason8(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand8(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize8(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 8:
					tyrerepairworkrequisitionform.setTyreNumber9(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork9(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason9(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand9(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize9(tyrerepairworkrequisitionvo.getTyreSize());
					break;
				case 9:
					tyrerepairworkrequisitionform.setTyreNumber10(tyrerepairworkrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerepairworkrequisitionvo.getTyreBrand());
					tyrerepairworkrequisitionform.setRepairWork10(tyrerepairworkrequisitionvo.getRepairWork1());
					tyrerepairworkrequisitionform.setRepairReason10(tyrerepairworkrequisitionvo.getRepairReason1());
					brandList=tyrerepairworkrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)brandList.get(0);
				    tyrerepairworkrequisitionform.setTyreBrand10(tyrerepairworkrequisitionvo.getTyreBrand());
				    sizeList=tyrerepairworkrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerepairworkrequisitionvo=(TyreRepairWorkRequisitionVO)sizeList.get(0);
				    tyrerepairworkrequisitionform.setTyreSize10(tyrerepairworkrequisitionvo.getTyreSize());
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
			String empty=null;
			TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform=(TyreRepairWorkRequisitionForm)form;
			tyrerepairworkrequisitionform.setRepairWork1(empty);
			tyrerepairworkrequisitionform.setRepairWork2(empty);
			tyrerepairworkrequisitionform.setRepairWork3(empty);
			tyrerepairworkrequisitionform.setRepairWork4(empty);
			tyrerepairworkrequisitionform.setRepairWork5(empty);
			tyrerepairworkrequisitionform.setRepairWork6(empty);
			tyrerepairworkrequisitionform.setRepairWork7(empty);
			tyrerepairworkrequisitionform.setRepairWork8(empty);
			tyrerepairworkrequisitionform.setRepairWork9(empty);
			tyrerepairworkrequisitionform.setRepairWork10(empty);
			
			tyrerepairworkrequisitionform.setRepairReason1(empty);
			tyrerepairworkrequisitionform.setRepairReason2(empty);
			tyrerepairworkrequisitionform.setRepairReason3(empty);
			tyrerepairworkrequisitionform.setRepairReason4(empty);
			tyrerepairworkrequisitionform.setRepairReason5(empty);
			tyrerepairworkrequisitionform.setRepairReason6(empty);
			tyrerepairworkrequisitionform.setRepairReason7(empty);
			tyrerepairworkrequisitionform.setRepairReason8(empty);
			tyrerepairworkrequisitionform.setRepairReason9(empty);
			tyrerepairworkrequisitionform.setRepairReason10(empty);
			
			tyrerepairworkrequisitionform.setTyreBrand1(empty);
			tyrerepairworkrequisitionform.setTyreBrand2(empty);
			tyrerepairworkrequisitionform.setTyreBrand3(empty);
			tyrerepairworkrequisitionform.setTyreBrand4(empty);
			tyrerepairworkrequisitionform.setTyreBrand5(empty);
			tyrerepairworkrequisitionform.setTyreBrand6(empty);
			tyrerepairworkrequisitionform.setTyreBrand7(empty);
			tyrerepairworkrequisitionform.setTyreBrand8(empty);
			tyrerepairworkrequisitionform.setTyreBrand9(empty);
			tyrerepairworkrequisitionform.setTyreBrand10(empty);
			
			tyrerepairworkrequisitionform.setTyreSize1(empty);
			tyrerepairworkrequisitionform.setTyreSize2(empty);
			tyrerepairworkrequisitionform.setTyreSize3(empty);
			tyrerepairworkrequisitionform.setTyreSize4(empty);
			tyrerepairworkrequisitionform.setTyreSize5(empty);
			tyrerepairworkrequisitionform.setTyreSize6(empty);
			tyrerepairworkrequisitionform.setTyreSize7(empty);
			tyrerepairworkrequisitionform.setTyreSize8(empty);
			tyrerepairworkrequisitionform.setTyreSize9(empty);
			tyrerepairworkrequisitionform.setTyreSize10(empty);
			
			tyrerepairworkrequisitionform.setTyreNumber1(empty);
			tyrerepairworkrequisitionform.setTyreNumber2(empty);
			tyrerepairworkrequisitionform.setTyreNumber3(empty);
			tyrerepairworkrequisitionform.setTyreNumber4(empty);
			tyrerepairworkrequisitionform.setTyreNumber5(empty);
			tyrerepairworkrequisitionform.setTyreNumber6(empty);
			tyrerepairworkrequisitionform.setTyreNumber7(empty);
			tyrerepairworkrequisitionform.setTyreNumber8(empty);
			tyrerepairworkrequisitionform.setTyreNumber9(empty);
			tyrerepairworkrequisitionform.setTyreNumber10(empty);
			
			tyrerepairworkrequisitionform.setTyreBrand(empty);
			tyrerepairworkrequisitionform.setTyreSize(empty);
			tyrerepairworkrequisitionform.setTyreNumber(empty);
			tyrerepairworkrequisitionform.setTyrePly(empty);
			tyrerepairworkrequisitionform.setRequestedDate(empty);
			
		  return mapping.findForward("load");
		}

}
