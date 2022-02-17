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
import com.wf.*;
import com.service.TyreRebuiltService;
import com.vo.TyreRebuiltVO;

public class TyreRebuiltAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(TyreRebuiltAction.class);
	job jb=new job();
	int jobid;
	String tyreNumber=null;
	TyreRebuiltService tyrerebuiltservice =new TyreRebuiltService();
	TyreRebuiltVO tyrerebuiltvo=new TyreRebuiltVO();
	ArrayList list=new ArrayList();
	String rebuilt=null;
	ArrayList list1=new ArrayList();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		   	TyreRebuiltAction tyrerebuiltaction=new TyreRebuiltAction();
			tyrerebuiltaction.tyreNumberMethod(mapping, form, request, response);
			return mapping.findForward("load");
	  }
	
	/**
	 * To fetch the tyrenumber in the multiple selection box
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tyreNumberMethod(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
			ArrayList tyreNumberList=new ArrayList();
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;
			TyreRebuiltService tyrerebuiltservice =new TyreRebuiltService();
			tyreNumberList=tyrerebuiltservice.tyreNumberCombo();
			tyrerebuiltform.setTyreNumberList(tyreNumberList);
			return mapping.findForward("load");
		}
	
	/**
	 * Action method to set the tyredetails in the form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward setTyreNumberMethod1(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
			
			if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber1()))
		    {
		    	tyrerebuiltform.setTyreNumber1(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber1(rebuilt);
		       	tyrerebuiltform.setRebuiltReason1(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize1(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand1(tyrerebuiltvo.getTyreBrand());
		      }
		    return mapping.findForward("load");	
	}
		
	public ActionForward setTyreNumberMethod2(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber2()))
		    {
		    	tyrerebuiltform.setTyreNumber2(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber2(rebuilt);
		       	tyrerebuiltform.setRebuiltReason2(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize2(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand2(tyrerebuiltvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
	}
		
	public ActionForward setTyreNumberMethod3(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {		
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber3()))
		    {
		    	tyrerebuiltform.setTyreNumber3(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber3(rebuilt);
		       	tyrerebuiltform.setRebuiltReason3(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize3(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand3(tyrerebuiltvo.getTyreBrand());
	        }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod4(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {		
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber4()))
		    {
		    	tyrerebuiltform.setTyreNumber4(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber4(rebuilt);
		       	tyrerebuiltform.setRebuiltReason4(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize4(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand4(tyrerebuiltvo.getTyreBrand());
		    }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod5(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {					
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber5()))
		    {
		    	tyrerebuiltform.setTyreNumber5(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber5(rebuilt);
		       	tyrerebuiltform.setRebuiltReason5(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize5(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand5(tyrerebuiltvo.getTyreBrand());
		    }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod6(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {					
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber6()))
		    {
		    	tyrerebuiltform.setTyreNumber6(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber6(rebuilt);
		       	tyrerebuiltform.setRebuiltReason6(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize6(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand6(tyrerebuiltvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod7(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {					
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber7()))
		    {
		    	tyrerebuiltform.setTyreNumber7(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber7(rebuilt);
		       	tyrerebuiltform.setRebuiltReason7(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize7(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand7(tyrerebuiltvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod8(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {					
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber8()))
		    {
		    	tyrerebuiltform.setTyreNumber8(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber8(rebuilt);
		       	tyrerebuiltform.setRebuiltReason8(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize8(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand8(tyrerebuiltvo.getTyreBrand());
		       	
	        }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod9(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {					
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber9()))
		    {
		    	tyrerebuiltform.setTyreNumber9(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber9(rebuilt);
		       	tyrerebuiltform.setRebuiltReason9(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize9(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand9(tyrerebuiltvo.getTyreBrand());
		     }
		    return mapping.findForward("load");	
	}
	public ActionForward setTyreNumberMethod10(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {					
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;			
			tyreNumber=tyrerebuiltform.getTyreNumbers()[0];
		    if(StringUtils.isEmpty(tyrerebuiltform.getTyreNumber10()))
		    {
		    	tyrerebuiltform.setTyreNumber10(tyreNumber);
       	        list=tyrerebuiltservice.retrieveTyreDetails(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list.get(0);
		       	rebuilt=tyrerebuiltvo.getRebuiltNumber1();
		       	tyrerebuiltform.setRebuiltNumber10(rebuilt);
		       	tyrerebuiltform.setRebuiltReason10(tyrerebuiltvo.getRebuiltReason1());
		       	list1=tyrerebuiltservice.tyredetailscode(tyreNumber);
		       	tyrerebuiltvo=(TyreRebuiltVO)list1.get(0);
		       	int tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
		       	int tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
		       	ArrayList sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
			    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
			    tyrerebuiltform.setTyreSize10(tyrerebuiltvo.getTyreSize());
			    ArrayList brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
			    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
			    tyrerebuiltform.setTyreBrand10(tyrerebuiltvo.getTyreBrand());
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
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;
			TyreRebuiltService tyrerebuiltservice =new TyreRebuiltService();
			TyreRebuiltVO tyrerebuiltvo=new TyreRebuiltVO();
			String tyreNumber=null;
			String rebuilt_repair=null;
			String reason=null;
			PropertyUtils.copyProperties(tyrerebuiltvo,tyrerebuiltform);
		    tyrerebuiltservice.insertCommontyretransaction(job_id,tyrerebuiltvo);	
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber1()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber1();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber1();
		 		reason=tyrerebuiltform.getRebuiltReason1();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber2()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber2();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber2();
		 		reason=tyrerebuiltform.getRebuiltReason2();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber3()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber3();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber3();
		 		reason=tyrerebuiltform.getRebuiltReason3();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber4()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber4();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber4();
		 		reason=tyrerebuiltform.getRebuiltReason4();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber5()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber5();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber5();
		 		reason=tyrerebuiltform.getRebuiltReason5();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber6()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber6();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber6();
		 		reason=tyrerebuiltform.getRebuiltReason6();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber7()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber7();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber7();
		 		reason=tyrerebuiltform.getRebuiltReason7();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber, rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber8()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber8();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber8();
		 		reason=tyrerebuiltform.getRebuiltReason8();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber,rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber9()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber9();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber9();
		 		reason=tyrerebuiltform.getRebuiltReason9();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber,rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}
		 	if(!StringUtils.isEmpty(tyrerebuiltform.getTyreNumber10()))
		 	{
		 		tyreNumber=tyrerebuiltform.getTyreNumber10();
		 		rebuilt_repair=tyrerebuiltform.getRebuiltNumber10();
		 		reason=tyrerebuiltform.getRebuiltReason10();
		 		tyrerebuiltservice.insertTyretransaction(job_id, tyreNumber,rebuilt_repair, reason);
		 		tyrerebuiltservice.updateIndicator(tyreNumber);
		 		tyrerebuiltservice.updateTyreMaster(tyreNumber,rebuilt_repair);
		 	}	 			
	}
		
	public ActionForward jobMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			String reqName="TyreRebuilt";
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("userId");
			String ss1=mapping.getName();
			try{
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
		 * To retrieve the values from database for inbox view 
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
			
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			ArrayList tyrelist=new ArrayList();
			ArrayList commonlist=new ArrayList();
			commonlist=tyrerebuiltservice.retrievecommondetails(job);
			/**
			 * To set common details in TyreRebuiltForm
			 */
			tyrerebuiltvo=(TyreRebuiltVO)commonlist.get(0);
			tyrerebuiltform.setBillDate(tyrerebuiltvo.getBillDate());
			tyrerebuiltform.setBillNumber(tyrerebuiltvo.getBillNumber());
			tyrerebuiltform.setCompanyName(tyrerebuiltvo.getCompanyName());
			tyrerebuiltform.setBillAmount(tyrerebuiltvo.getBillAmount());
			/**
			 * To set Tyre details in TyreRebuiltForm
			 */
			int tyreSizeCode;
			int tyreBrandCode;
			ArrayList sizeList=new ArrayList();
			ArrayList brandList=new ArrayList();
			tyrelist=tyrerebuiltservice.retrievetyredetails(job);
			for(int i=0;i<tyrelist.size();i++)
			{
				tyrerebuiltvo=(TyreRebuiltVO)tyrelist.get(i);
				switch(i)
				{
				case 0:
					tyrerebuiltform.setTyreNumber1(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber1(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason1(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand1(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize1(tyrerebuiltvo.getTyreSize());
				    break;
					
				case 1:
					tyrerebuiltform.setTyreNumber2(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber2(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason2(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand2(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize2(tyrerebuiltvo.getTyreSize());
					break;
				case 2:
					tyrerebuiltform.setTyreNumber3(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber3(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason3(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand3(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize3(tyrerebuiltvo.getTyreSize());
					break;
				case 3:
					tyrerebuiltform.setTyreNumber4(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber4(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason4(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand4(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize4(tyrerebuiltvo.getTyreSize());
					break;
				case 4:
					tyrerebuiltform.setTyreNumber5(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber5(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason5(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand5(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize5(tyrerebuiltvo.getTyreSize());
					break;
				case 5:
					tyrerebuiltform.setTyreNumber6(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber6(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason6(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand6(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize6(tyrerebuiltvo.getTyreSize());
					break;
				case 6:
					tyrerebuiltform.setTyreNumber7(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber7(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason7(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand7(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize7(tyrerebuiltvo.getTyreSize());
					break;
				case 7:
					tyrerebuiltform.setTyreNumber8(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber8(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason8(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand8(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize8(tyrerebuiltvo.getTyreSize());
					break;
				case 8:
					tyrerebuiltform.setTyreNumber9(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber9(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason9(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand9(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize9(tyrerebuiltvo.getTyreSize());
					break;
				case 9:
					tyrerebuiltform.setTyreNumber10(tyrerebuiltvo.getTyreNumber());
					tyreSizeCode=Integer.parseInt(tyrerebuiltvo.getTyreSize());
					tyreBrandCode=Integer.parseInt(tyrerebuiltvo.getTyreBrand());
					tyrerebuiltform.setRebuiltNumber10(tyrerebuiltvo.getRebuiltNumber1());
					tyrerebuiltform.setRebuiltReason10(tyrerebuiltvo.getRebuiltReason1());
					brandList=tyrerebuiltservice.tyreBrandDesc(tyreBrandCode);
				    tyrerebuiltvo=(TyreRebuiltVO)brandList.get(0);
				    tyrerebuiltform.setTyreBrand10(tyrerebuiltvo.getTyreBrand());
				    sizeList=tyrerebuiltservice.tyreSizeDesc(tyreSizeCode);
				    tyrerebuiltvo=(TyreRebuiltVO)sizeList.get(0);
				    tyrerebuiltform.setTyreSize10(tyrerebuiltvo.getTyreSize());
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
		/**
		 * To clear the values in the form
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
	public ActionForward clearMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRebuiltForm tyrerebuiltform=(TyreRebuiltForm)form;
			tyrerebuiltform.setRebuiltNumber1(null);
			tyrerebuiltform.setRebuiltNumber2(null);
			tyrerebuiltform.setRebuiltNumber3(null);
			tyrerebuiltform.setRebuiltNumber4(null);
			tyrerebuiltform.setRebuiltNumber5(null);
			tyrerebuiltform.setRebuiltNumber6(null);
			tyrerebuiltform.setRebuiltNumber7(null);
			tyrerebuiltform.setRebuiltNumber8(null);
			tyrerebuiltform.setRebuiltNumber9(null);
			tyrerebuiltform.setRebuiltNumber10(null);
			
			tyrerebuiltform.setRebuiltReason1(null);
			tyrerebuiltform.setRebuiltReason2(null);
			tyrerebuiltform.setRebuiltReason3(null);
			tyrerebuiltform.setRebuiltReason4(null);
			tyrerebuiltform.setRebuiltReason5(null);
			tyrerebuiltform.setRebuiltReason6(null);
			tyrerebuiltform.setRebuiltReason7(null);
			tyrerebuiltform.setRebuiltReason8(null);
			tyrerebuiltform.setRebuiltReason9(null);
			tyrerebuiltform.setRebuiltReason10(null);
			
			tyrerebuiltform.setTyreBrand1(null);
			tyrerebuiltform.setTyreBrand2(null);
			tyrerebuiltform.setTyreBrand3(null);
			tyrerebuiltform.setTyreBrand4(null);
			tyrerebuiltform.setTyreBrand5(null);
			tyrerebuiltform.setTyreBrand6(null);
			tyrerebuiltform.setTyreBrand7(null);
			tyrerebuiltform.setTyreBrand8(null);
			tyrerebuiltform.setTyreBrand9(null);
			tyrerebuiltform.setTyreBrand10(null);
			
			tyrerebuiltform.setTyreSize1(null);
			tyrerebuiltform.setTyreSize2(null);
			tyrerebuiltform.setTyreSize3(null);
			tyrerebuiltform.setTyreSize4(null);
			tyrerebuiltform.setTyreSize5(null);
			tyrerebuiltform.setTyreSize6(null);
			tyrerebuiltform.setTyreSize7(null);
			tyrerebuiltform.setTyreSize8(null);
			tyrerebuiltform.setTyreSize9(null);
			tyrerebuiltform.setTyreSize10(null);
			
			tyrerebuiltform.setTyreNumber1(null);
			tyrerebuiltform.setTyreNumber2(null);
			tyrerebuiltform.setTyreNumber3(null);
			tyrerebuiltform.setTyreNumber4(null);
			tyrerebuiltform.setTyreNumber5(null);
			tyrerebuiltform.setTyreNumber6(null);
			tyrerebuiltform.setTyreNumber7(null);
			tyrerebuiltform.setTyreNumber8(null);
			tyrerebuiltform.setTyreNumber9(null);
			tyrerebuiltform.setTyreNumber10(null);
			
			tyrerebuiltform.setTyreBrand(null);
			tyrerebuiltform.setTyreSize(null);
			tyrerebuiltform.setTyreNumber(null);
			tyrerebuiltform.setTyrePly(null);
			tyrerebuiltform.setBillAmount(null);
			tyrerebuiltform.setBillDate(null);
			tyrerebuiltform.setCompanyName(null);
			tyrerebuiltform.setBillNumber(null);
		    return mapping.findForward("load");
	}

}
