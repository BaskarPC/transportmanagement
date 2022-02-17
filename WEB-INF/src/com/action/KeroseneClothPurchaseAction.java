package com.action;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseDispatchAction;
import com.formbean.DieselRequisitionForm;
import com.formbean.KeroseneClothPurchaseForm;
import com.formbean.KeroseneClothRequisitionForm;
import com.formbean.OilGreasePurchaseForm;
import com.service.KeroseneClothPurchaseService;
import com.vo.KeroseneClothPurchaseVO;
import com.vo.KeroseneClothRequisitionVO;
import com.wf.job;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class KeroseneClothPurchaseAction extends BaseDispatchAction{
private static final Logger logger=(Logger)Logger.getLogger(KeroseneClothPurchaseAction.class);
KeroseneClothPurchaseService ks=new KeroseneClothPurchaseService();
ArrayList list=new ArrayList();
job jb=new job();
	KeroseneClothPurchaseVO vo=new KeroseneClothPurchaseVO();
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse response)throws Exception{
		logger.debug("KeroseneClothPurchaseAction: defaultMethod<-------------");	
		KeroseneClothPurchaseForm f=(KeroseneClothPurchaseForm)form;
		HttpSession session = ((HttpServletRequest) request).getSession();
		list=ks.fetchItemDes();
		f.setItemList(list);
		list=ks.fetchCompanyName();
		f.setCompanyList(list);
		
		return aMapping.findForward("load");
	}
	public ActionForward fetchplacelist(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		KeroseneClothPurchaseForm f=(KeroseneClothPurchaseForm)form;
		String cname=f.getCompanyName();
		
			list=ks.fetchplacelist(cname);
			logger.debug("list sizeee :"+list.size());
			f.setPlaceList(list);
			return mapping.findForward("load");		
	}
	public ActionForward amtMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		KeroseneClothPurchaseForm f=(KeroseneClothPurchaseForm)form;
		
		f.setAmount(Integer.toString(Integer.parseInt(f.getQtyPurchased())*Integer.parseInt(f.getUnitPrice())));
			return mapping.findForward("load");		
	}
	
	public ActionForward jobPurchaseMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		KeroseneClothPurchaseForm f=(KeroseneClothPurchaseForm)form;
		String name=f.getItemDes();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		logger.debug("inside job method");
		String ss1=mapping.getName();
		int jobid=0;
		int taskid=0;
		try{
			
			logger.debug("jobid...");
			
			jobid=(Integer)session.getAttribute("jobseq");
			String reqName=ks.getPurchaseItem(jobid)+"Purchase";
			logger.debug("item name"+reqName);
			taskid=(Integer)session.getAttribute("taskseqseq");
			logger.debug("taskid..."+taskid);
		jb.approveStatus(jobid,taskid);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		insertvalues(jobid,form);
		
		logger.debug("insert executed");
		
		return mapping.findForward("success");

	}
	public ActionForward saveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		HttpSession session = ((HttpServletRequest) request).getSession();
		int jobid=0;
		int taskid=0;
		try{
			
			logger.debug("jobid...");
			
			jobid=(Integer)session.getAttribute("jobseq");
			taskid=(Integer)session.getAttribute("taskseqseq");
			logger.debug("taskid..."+taskid);
			insertvalues(jobid,form);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		
		
		
		logger.debug("insert executed");
		
		return mapping.findForward("load");
	}
	public void insertvalues(int jobid,ActionForm form)
	{
		logger.debug("insertvalues <<<<<<<<<<<<");
		KeroseneClothPurchaseForm f=(KeroseneClothPurchaseForm)form;
		String date=f.getBillDate();
		String billno=f.getBillNo();
		String delivereddate=f.getDeliveredDate();
		String reqitem=f.getItemDes();
		String cname=f.getCompanyName();
		String place=f.getPlace();
		int qtypurchased=Integer.parseInt(f.getQtyPurchased());
		float rate=Float.parseFloat(f.getUnitPrice());
		float amt=Float.parseFloat(f.getAmount());
		int sid=ks.getSid();
		logger.debug("KeroseneClothPurchaseAction: insertvalues for supplier table->record passed to service");
		ks.insertSupplier(sid,jobid,date,billno,delivereddate,cname,place,reqitem);
		logger.debug("KeroseneClothPurchaseAction: values are inserted to the supplier table");   
		logger.debug("KeroseneClothPurchaseAction: insertvalues for product table->record passed to service");
		ks.insertProduct(sid,jobid,qtypurchased,rate,amt);
		logger.debug("KeroseneClothPurchaseAction: values are inserted to the product table"); 
		logger.debug("KeroseneClothPurchaseAction: common_transaction for product table->record passed to service");
		ks.insertcommontrans(reqitem, rate, qtypurchased);
		logger.debug("KeroseneClothPurchaseAction: values are inserted to the common_transaction table");  

}
}
