package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.action.BaseDispatchAction;
import com.formbean.DieselPurchaseForm;
import com.service.DieselPurchaseService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class DieselPurchaseAction extends BaseDispatchAction{
private static final Logger logger=(Logger)Logger.getLogger(DieselPurchaseAction.class);
DieselPurchaseService ds=new DieselPurchaseService();
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DieselPurchaseAction: defaultMethod<-------------");		
		DieselPurchaseForm df=(DieselPurchaseForm)form;
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		logger.debug("job in acquire"+job);
		String name=ds.fetchCompany(job);
		df.setGoodsType("Diesel");
		df.setCompanyName(name);
		df.setAdditionalAmount(null);
		df.setDeliveryAmount(null);
		df.setAmount(null);
		logger.debug("DieselPurchaseAction: defaultMethod------------->");		
		return aMapping.findForward("load");
	}
	public ActionForward amtMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DieselPurchaseAction: amountMethod<-------------");		
		DieselPurchaseForm df=(DieselPurchaseForm)form;
		Float tot1=Float.parseFloat(df.getQtyPurchased())* Float.parseFloat(df.getUnitPrice());
		df.setAmount(Float.toString(tot1));
		logger.debug("DieselPurchaseAction: amountMethod------------->");		
		return aMapping.findForward("load");
	}
	public ActionForward vatMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DieselPurchaseAction: vatMethod<-------------");		
		DieselPurchaseForm df=(DieselPurchaseForm)form;
		
		Float vatamt=(Float.parseFloat(df.getVatPercent())/100) * Float.parseFloat(df.getAmount()) ;
		df.setVatAmount(Float.toString(vatamt));
		Float amt=Float.parseFloat(df.getAmount())+Float.parseFloat(df.getVatAmount());
		df.setTotalAmount(Float.toString(amt));
		logger.debug("DieselPurchaseAction: vatMethod------------->");		
		return aMapping.findForward("load");
	}
	public ActionForward totalAmountMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DieselPurchaseAction: totalAmountMethod<-------------");		
		DieselPurchaseForm df=(DieselPurchaseForm)form;
		logger.debug("xx"+df.getAmount()+df.getVatAmount()+df.getAdditionalAmount()+df.getDeliveryAmount());
		Float amt=Float.parseFloat(df.getAmount())+Float.parseFloat(df.getVatAmount());
		if(!StringUtils.isEmpty(df.getAdditionalAmount()))
			amt=amt+Float.parseFloat(df.getAdditionalAmount());
		if(!StringUtils.isEmpty(df.getDeliveryAmount()))
			amt=amt+Float.parseFloat(df.getDeliveryAmount()	);	
					
		df.setTotalAmount(Float.toString(amt));
		logger.debug("DieselPurchaseAction: totalAmountMethod------------->");		
		return aMapping.findForward("load");
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
		DieselPurchaseForm of=(DieselPurchaseForm)form;
		float vatpercent,vatamount,additionalamount=0,amount;
		int sid=ds.getsid();
		String date=of.getBillDate();
		String billno=of.getBillNo();
		String delivereddate=of.getDeliveredDate();            
		String reqitem=of.getGoodsType();
		String cname=of.getCompanyName();
		String place=of.getPlace();
		
		logger.debug("DieselPurchaseAction: insertvalues for supplier table->record passed to service");
		ds.insertSupplier(sid,jobid,date,billno,delivereddate,cname,place,reqitem);
		logger.debug("DieselPurchaseAction: values are inserted to the supplier table");
		
		String partno=ds.fetchPartNo("Diesel");
		String load=of.getLoadNo();
		String vno=of.getDeliveryVehicleNo();
		String dname=of.getDriverName();
		String damount=of.getDeliveryAmount();
		String dtime=of.getDeliveryTime();
		String tipscale=of.getTipScale();
		
		logger.debug("DieselPurchaseAction: insertvalues for Product table->record passed to service");
		ds.insertProduct(partno,jobid,sid,load,vno,dname,damount,dtime,tipscale);
		logger.debug("DieselPurchaseAction: values are inserted to the diesel product table");
		
		String brandname="281";
		String brandcategory="281";
		int quantity=Integer.parseInt(of.getQtyPurchased());
		Float unitprice=Float.parseFloat(of.getUnitPrice());
		vatpercent=Float.parseFloat(of.getVatPercent());
		vatamount=Float.parseFloat(of.getVatAmount());
		additionalamount=Float.parseFloat(of.getAdditionalAmount());
		amount=Float.parseFloat(of.getAmount());
		
		logger.debug("OilGreasePurchaseAction: insertvalues for product table->record1 passed to service");
		ds.insertVat(jobid,sid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
		
		logger.debug("DieselPurchaseAction: insertvalues for Product table->record passed to service");
		ds.insertcommontrans(unitprice, quantity);
		logger.debug("DieselPurchaseAction: values are inserted to the common transaction table");
		
		logger.debug("insertvalues >>>>>>>>>>>>>>>>");
		
	  		
	}

}
