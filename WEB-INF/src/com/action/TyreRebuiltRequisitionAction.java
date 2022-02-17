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
import com.formbean.TyreRebuiltRequisitionForm;
import com.service.TyreRebuiltRequisitionService;
import com.vo.TyreRebuiltRequisitionVO;
import com.wf.job;

public class TyreRebuiltRequisitionAction extends BaseDispatchAction{
	
	private static final Logger logger=(Logger)Logger.getLogger(TyreRebuiltRequisitionAction.class);
	job jb=new job();
	int jobid;
	ArrayList list=new ArrayList();
	String rebuilt=null;
	TyreRebuiltRequisitionVO tyrerebuiltrequisitionvo=new TyreRebuiltRequisitionVO();
	TyreRebuiltRequisitionService tyrerebuiltrequisitionservice =new TyreRebuiltRequisitionService();
	String tyreNumber=null;
	
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		    
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;	
			TyreRebuiltRequisitionService tyrerebuiltrequisitionservice =new TyreRebuiltRequisitionService();
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("userId");
			
			/**
			 * Setting  Tyre Size to Combo Box
			 */	
		    ArrayList tyreSizeList=new ArrayList();
		    tyreSizeList=tyrerebuiltrequisitionservice.tyreSizeCombo();
			tyrerebuiltrequisitionform.setTyreSizeList(tyreSizeList);
		    
			/**
			 * Setting  Tyre Brand to Combo Box
			 */	
		    ArrayList tyreBrandList=new ArrayList();
		    tyreBrandList=tyrerebuiltrequisitionservice.tyreBrandCombo();
			tyrerebuiltrequisitionform.setTyreBrandList(tyreBrandList);
		    
			/**
			 * Setting  Tyre Ply to Combo Box
			 */	
		    ArrayList tyrePlyList=new ArrayList();
		    tyrePlyList=tyrerebuiltrequisitionservice.tyrePlyCombo();
			tyrerebuiltrequisitionform.setTyrePlyList(tyrePlyList);
		    
		    /**
		     * To set InchargeName
		     */
		    tyrerebuiltrequisitionform.setInchargeName(userName);
		    return mapping.findForward("load");
	  }
		
		
		public ActionForward tyreNumberMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			ArrayList tyreNumberList=new ArrayList();
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;
			TyreRebuiltRequisitionService tyrerebuiltrequisitionservice =new TyreRebuiltRequisitionService();
			int tyreSize=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
			int tyrePly=Integer.parseInt(tyrerebuiltrequisitionform.getTyrePly());
			int tyreBrand=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			tyreNumberList=tyrerebuiltrequisitionservice.tyreNumberCombo(tyreSize,tyreBrand,tyrePly);
			tyrerebuiltrequisitionform.setTyreNumberList(tyreNumberList);
			return mapping.findForward("load");
		}
		
		public void saveMethod(int job_id,ActionForm form)throws Exception 
		{
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;
			TyreRebuiltRequisitionService tyrerebuiltrequisitionservice =new TyreRebuiltRequisitionService();
			TyreRebuiltRequisitionVO tyrerebuiltrequisitionvo=new TyreRebuiltRequisitionVO();
			String tyreNumber=null;
			String rebuilt_repair=null;
			String reason=null;	
		    PropertyUtils.copyProperties(tyrerebuiltrequisitionvo,tyrerebuiltrequisitionform);
		   	tyrerebuiltrequisitionservice.insertCommontyretransaction(job_id,tyrerebuiltrequisitionvo);	
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber1()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber1();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber1();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason1();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber2()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber2();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber2();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason2();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber3()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber3();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber3();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason3();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber4()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber4();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber4();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason4();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber5()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber5();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber5();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason5();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber6()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber6();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber6();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason6();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber7()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber7();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber7();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason7();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber8()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber8();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber8();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason8();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber9()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber9();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber9();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason9();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber10()))
		 	{
		 		tyreNumber=tyrerebuiltrequisitionform.getTyreNumber10();
		 		rebuilt_repair=tyrerebuiltrequisitionform.getRebuiltNumber10();
		 		reason=tyrerebuiltrequisitionform.getRebuiltReason10();
		 		tyrerebuiltrequisitionservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 	}	 			
		}
		
		public ActionForward setTyreNumberMethod1(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber1()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber1(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		       	rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber1(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize1(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand1(tyrerebuiltrequisitionvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod2(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber2()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber2(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
                rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		        if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber2(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize2(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand2(tyrerebuiltrequisitionvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		
		public ActionForward setTyreNumberMethod3(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber3()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber3(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		       	rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber3(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize3(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand3(tyrerebuiltrequisitionvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod4(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {		
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber4()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber4(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		        rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber4(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize4(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand4(tyrerebuiltrequisitionvo.getTyreBrand());
		       	
		    }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod5(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber5()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber5(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		      	rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber5(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize5(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand5(tyrerebuiltrequisitionvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod6(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber6()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber6(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		       	rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber6(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize6(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand6(tyrerebuiltrequisitionvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod7(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber7()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber7(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		       	rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber7(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize7(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand7(tyrerebuiltrequisitionvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod8(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber8()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber8(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		        rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber8(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize8(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand8(tyrerebuiltrequisitionvo.getTyreBrand());
		    }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod9(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber9()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber9(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		        rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	tyrerebuiltrequisitionform.setRebuiltNumber9(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize9(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand9(tyrerebuiltrequisitionvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
		}
		public ActionForward setTyreNumberMethod10(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {					
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;			
			tyreNumber=tyrerebuiltrequisitionform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltrequisitionform.getTyreNumber10()))
		    {
		    	tyrerebuiltrequisitionform.setTyreNumber10(tyreNumber);
       	        list=tyrerebuiltrequisitionservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)list.get(0);
		       	rebuilt=tyrerebuiltrequisitionvo.getRebuiltNumber1();
		       	
		       	if(rebuilt.equals("Original"))
		       		rebuilt="Rebuilt-1";
		       	else if(rebuilt.equals("Rebuilt-1"))
		       		rebuilt="Rebuilt-2";
		       	else if(rebuilt.equals("Rebuilt-2"))
		       		rebuilt="Rebuilt-3";
		       	else if(rebuilt.equals("Rebuilt-3"))
		       		rebuilt="Rebuilt-4";
		       	else if(rebuilt.equals("Rebuilt-4"))
		       		rebuilt="Rebuilt-5";
		       	else if(rebuilt.equals("Rebuilt-5"))
		       		rebuilt="Rebuilt-6";
		       	
		       	tyrerebuiltrequisitionform.setRebuiltNumber10(rebuilt);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreSize());
				int tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionform.getTyreBrand());
			    ArrayList sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
			    tyrerebuiltrequisitionform.setTyreSize10(tyrerebuiltrequisitionvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
			    tyrerebuiltrequisitionform.setTyreBrand10(tyrerebuiltrequisitionvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
		}
		
		
		public ActionForward jobMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			String reqName="TyreRebuiltRequisition";
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
			logger.debug("job id in job method: "+jobid);
			return mapping.findForward("load");
		}
		
		/**
		 * To set tyredetails in the TyreRebuiltRequisition Form
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
			
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;
			
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			ArrayList tyrelist=new ArrayList();
			ArrayList commonlist=new ArrayList();
			
			commonlist=tyrerebuiltrequisitionservice.retrievecommondetails(job);
			/**
			 * To set common details in TyreRebuiltRequisitionForm
			 */
			tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)commonlist.get(0);
			tyrerebuiltrequisitionform.setInchargeName(tyrerebuiltrequisitionvo.getInchargeName());
			tyrerebuiltrequisitionform.setRequestedDate(tyrerebuiltrequisitionvo.getRequestedDate());
		    
			/**
			 * To set Tyre details in TyreRebuiltRequisitionForm
			 */
			tyrelist=tyrerebuiltrequisitionservice.retrievetyredetails(job);
			int tyreSizeCode;
			int tyreBrandCode;
			ArrayList sizeList=new ArrayList();
			ArrayList brandList=new ArrayList();
			for(int i=0;i<tyrelist.size();i++)
			{
				tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)tyrelist.get(i);
				switch(i)
				{
				case 0:
					tyrerebuiltrequisitionform.setTyreNumber1(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber1(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason1(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand1(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize1(tyrerebuiltrequisitionvo.getTyreSize());
				    break;
					
				case 1:
					tyrerebuiltrequisitionform.setTyreNumber2(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber2(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason2(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand2(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize2(tyrerebuiltrequisitionvo.getTyreSize());
				    break;
				case 2:
					tyrerebuiltrequisitionform.setTyreNumber3(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber3(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason3(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand3(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize3(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 3:
					tyrerebuiltrequisitionform.setTyreNumber4(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber4(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason4(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand4(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize4(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 4:
					tyrerebuiltrequisitionform.setTyreNumber5(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber5(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason5(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand5(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize5(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 5:
					tyrerebuiltrequisitionform.setTyreNumber6(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber6(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason6(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand6(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize6(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 6:
					tyrerebuiltrequisitionform.setTyreNumber7(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber7(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason7(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand7(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize7(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 7:
					tyrerebuiltrequisitionform.setTyreNumber8(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber8(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason8(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand8(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize8(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 8:
					tyrerebuiltrequisitionform.setTyreNumber9(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber9(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason9(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand9(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize9(tyrerebuiltrequisitionvo.getTyreSize());
					break;
				case 9:
					tyrerebuiltrequisitionform.setTyreNumber10(tyrerebuiltrequisitionvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltrequisitionvo.getTyreBrand());
					tyrerebuiltrequisitionform.setRebuiltNumber10(tyrerebuiltrequisitionvo.getRebuiltNumber1());
					tyrerebuiltrequisitionform.setRebuiltReason10(tyrerebuiltrequisitionvo.getRebuiltReason1());
					brandList=tyrerebuiltrequisitionservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)brandList.get(0);
				    tyrerebuiltrequisitionform.setTyreBrand10(tyrerebuiltrequisitionvo.getTyreBrand());
				    sizeList=tyrerebuiltrequisitionservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltrequisitionvo=(TyreRebuiltRequisitionVO)sizeList.get(0);
				    tyrerebuiltrequisitionform.setTyreSize10(tyrerebuiltrequisitionvo.getTyreSize());
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
			TyreRebuiltRequisitionForm tyrerebuiltrequisitionform=(TyreRebuiltRequisitionForm)form;
			tyrerebuiltrequisitionform.setInchargeName(null);
			tyrerebuiltrequisitionform.setRebuiltNumber1(null);
			tyrerebuiltrequisitionform.setRebuiltNumber2(null);
			tyrerebuiltrequisitionform.setRebuiltNumber3(null);
			tyrerebuiltrequisitionform.setRebuiltNumber4(null);
			tyrerebuiltrequisitionform.setRebuiltNumber5(null);
			tyrerebuiltrequisitionform.setRebuiltNumber6(null);
			tyrerebuiltrequisitionform.setRebuiltNumber7(null);
			tyrerebuiltrequisitionform.setRebuiltNumber8(null);
			tyrerebuiltrequisitionform.setRebuiltNumber9(null);
			tyrerebuiltrequisitionform.setRebuiltNumber10(null);
			
			tyrerebuiltrequisitionform.setRebuiltReason1(null);
			tyrerebuiltrequisitionform.setRebuiltReason2(null);
			tyrerebuiltrequisitionform.setRebuiltReason3(null);
			tyrerebuiltrequisitionform.setRebuiltReason4(null);
			tyrerebuiltrequisitionform.setRebuiltReason5(null);
			tyrerebuiltrequisitionform.setRebuiltReason6(null);
			tyrerebuiltrequisitionform.setRebuiltReason7(null);
			tyrerebuiltrequisitionform.setRebuiltReason8(null);
			tyrerebuiltrequisitionform.setRebuiltReason9(null);
			tyrerebuiltrequisitionform.setRebuiltReason10(null);
			
			tyrerebuiltrequisitionform.setTyreBrand1(null);
			tyrerebuiltrequisitionform.setTyreBrand2(null);
			tyrerebuiltrequisitionform.setTyreBrand3(null);
			tyrerebuiltrequisitionform.setTyreBrand4(null);
			tyrerebuiltrequisitionform.setTyreBrand5(null);
			tyrerebuiltrequisitionform.setTyreBrand6(null);
			tyrerebuiltrequisitionform.setTyreBrand7(null);
			tyrerebuiltrequisitionform.setTyreBrand8(null);
			tyrerebuiltrequisitionform.setTyreBrand9(null);
			tyrerebuiltrequisitionform.setTyreBrand10(null);
			
			tyrerebuiltrequisitionform.setTyreSize1(null);
			tyrerebuiltrequisitionform.setTyreSize2(null);
			tyrerebuiltrequisitionform.setTyreSize3(null);
			tyrerebuiltrequisitionform.setTyreSize4(null);
			tyrerebuiltrequisitionform.setTyreSize5(null);
			tyrerebuiltrequisitionform.setTyreSize6(null);
			tyrerebuiltrequisitionform.setTyreSize7(null);
			tyrerebuiltrequisitionform.setTyreSize8(null);
			tyrerebuiltrequisitionform.setTyreSize9(null);
			tyrerebuiltrequisitionform.setTyreSize10(null);
			
			tyrerebuiltrequisitionform.setTyreNumber1(null);
			tyrerebuiltrequisitionform.setTyreNumber2(null);
			tyrerebuiltrequisitionform.setTyreNumber3(null);
			tyrerebuiltrequisitionform.setTyreNumber4(null);
			tyrerebuiltrequisitionform.setTyreNumber5(null);
			tyrerebuiltrequisitionform.setTyreNumber6(null);
			tyrerebuiltrequisitionform.setTyreNumber7(null);
			tyrerebuiltrequisitionform.setTyreNumber8(null);
			tyrerebuiltrequisitionform.setTyreNumber9(null);
			tyrerebuiltrequisitionform.setTyreNumber10(null);
			
			tyrerebuiltrequisitionform.setTyreBrand(null);
			tyrerebuiltrequisitionform.setTyreSize(null);
			tyrerebuiltrequisitionform.setTyreNumber(null);
			tyrerebuiltrequisitionform.setTyrePly(null);
						
		  return mapping.findForward("load");
		}
}
