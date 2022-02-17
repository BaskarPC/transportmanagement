package com.action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.formbean.OilGreasePurchaseForm;
import com.formbean.OilGreaseRequisitionForm;
import com.service.OilGreasePurchaseService;
import com.service.OilGreaseRequisitionService;
import com.vo.OilGreasePurchaseVO;
import com.vo.OilGreaseRequisitionVO;
import com.wf.job;

//import com.wf.*;


public class OilGreasePurchaseAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(OilGreasePurchaseAction.class);
	job jb=new job();
	int jobid;
	ArrayList list1=new ArrayList();
	ArrayList list2=new ArrayList();
	ArrayList list3=new ArrayList();
	ArrayList brandnamelist=new ArrayList();
	ArrayList brandCategorylist=new ArrayList();
	static float totalamount=0;
	OilGreasePurchaseService os=new OilGreasePurchaseService();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		HttpSession session = ((HttpServletRequest) request).getSession();
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		
			String ss1=mapping.getName();
			logger.debug("OilGreasePurchaseAction: defaultMethod<-------------"+ss1);
			list1=os.fetchCompanyName();
			of.setCompanyNameList(list1);		
			// Assign value to the Type
			list2=os.fetchItemDes();
			of.setItemDesList(list2);
			jobid=(Integer)session.getAttribute("jobseq");
			String reqitem=os.getPurchaseItem(jobid);
			of.setReqItem(reqitem);
			
			//to display part no
			String itemcode=of.getReqItem();
			String itemdes=os.getItemName(itemcode);
			String partno=os.fetchpartno(itemdes);
		    brandnamelist=os.fetchBrandName(jobid);
			brandCategorylist=os.fetchBrandType(jobid);
			of.setPartNo(partno);
			of.setBrandNameList(brandnamelist);
			of.setBrandCategoryList(brandCategorylist);	
			of.setAvailableQty1("");
			of.setAvailableQty2("");
			of.setAvailableQty3("");
			of.setAvailableQty4("");
			of.setAvailableQty5("");
			
			logger.debug("OilGreasePurchaseAction: defaultMethod------------->");
			return mapping.findForward("load");		
	}
	
	public ActionForward totalamountMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction: totalamountMethod<-------------");
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		String tot=Float.toString(totalamount);
		of.setTotalAmount(tot);
		logger.debug("OilGreasePurchaseAction: totalamountMethod------------->");
			return mapping.findForward("load");		
	}
	
	public ActionForward fetchplacelist(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction: fetchplacelist<-------------");
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		String cname=of.getCompanyName();
			String ss1=mapping.getName();
			list3=os.fetchplacelist(cname);
			of.setPlaceList(list3);
			logger.debug("OilGreasePurchaseAction: fetchplacelist------------->");
			return mapping.findForward("load");	
			
	}
	
	public ActionForward availableQtyMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		    OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		    logger.debug("OilGreasePurchaseAction:availableQty Mtd <---------");
			if(StringUtils.isEmpty(of.getAvailableQty1()))
			{ 	
				of.setAvailableQty1("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
			ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType1());
			OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				//if(vo.getAvailableQty1().equals("null"))''
				String s=vo.getAvailableQty1();
				of.setAvailableQty1(s);
			
			}
			else if(StringUtils.isEmpty(of.getAvailableQty2()))
			{	of.setAvailableQty2("0");
			OilGreasePurchaseService os=new OilGreasePurchaseService();
			ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType2());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty2(s);
			}
			else if(StringUtils.isEmpty(of.getAvailableQty3()))
			{
				of.setAvailableQty3("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
				ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType3());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty3(s);
				
			}
			else if(StringUtils.isEmpty(of.getAvailableQty4()) )
			{
				of.setAvailableQty4("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
				ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType4());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty4(s);
			}
			else if(StringUtils.isEmpty(of.getAvailableQty5()))
			{
				of.setAvailableQty5("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
				ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType5());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty5(s);
			}
			
			else if(StringUtils.isEmpty(of.getAvailableQty6()))
			{
				of.setAvailableQty6("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
				ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType6());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty6(s);
			}
			
			else if(StringUtils.isEmpty(of.getAvailableQty5()))
			{
				of.setAvailableQty7("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
				ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType5());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty7(s);
			}
			
			else if(StringUtils.isEmpty(of.getAvailableQty5()))
			{
				of.setAvailableQty8("0");
				OilGreasePurchaseService os=new OilGreasePurchaseService();
				ArrayList list=os.fetchAvailableQty(of.getReqItem(),of.getBrandType5());
				OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty8(s);
			}
			logger.debug("OilGreasePurchaseAction:availableQty Mtd --------->");
			return mapping.findForward("load");
	}
	
	public ActionForward vatpercentMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		logger.debug("OilGreasePurchaseAction:vatpercentMethod  <---------");
		if((!StringUtils.isEmpty(of.getQtyPurchased1()))&&(StringUtils.isEmpty(of.getVatAmount1())))
		{
		float vatper=Float.parseFloat(of.getVatPercent1());
		float unitrate=Float.parseFloat(of.getUnitRate1());
		float qty=Float.parseFloat(of.getQtyPurchased1());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount1(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(of.getQtyPurchased2()))&&(StringUtils.isEmpty(of.getVatAmount2())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent2());
		float unitrate=Float.parseFloat(of.getUnitRate2());
		float qty=Float.parseFloat(of.getQtyPurchased2());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount2(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(of.getQtyPurchased3()))&&(StringUtils.isEmpty(of.getVatAmount3())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent3());
		float unitrate=Float.parseFloat(of.getUnitRate3());
		float qty=Float.parseFloat(of.getQtyPurchased3());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount3(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(of.getQtyPurchased4()))&&(StringUtils.isEmpty(of.getVatAmount4())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent4());
		float unitrate=Float.parseFloat(of.getUnitRate4());
		float qty=Float.parseFloat(of.getQtyPurchased4());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount4(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(of.getQtyPurchased5()))&&(StringUtils.isEmpty(of.getVatAmount5())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent5());
		float unitrate=Float.parseFloat(of.getUnitRate5());
		float qty=Float.parseFloat(of.getQtyPurchased5());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount5(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(of.getQtyPurchased6()))&&(StringUtils.isEmpty(of.getVatAmount6())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent6());
		float unitrate=Float.parseFloat(of.getUnitRate6());
		float qty=Float.parseFloat(of.getQtyPurchased6());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount6(vatamount);
		
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased7()))&&(StringUtils.isEmpty(of.getVatAmount7())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent7());
		float unitrate=Float.parseFloat(of.getUnitRate7());
		float qty=Float.parseFloat(of.getQtyPurchased7());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount7(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(of.getQtyPurchased8()))&&(StringUtils.isEmpty(of.getVatAmount8())))
		{
			
		float vatper=Float.parseFloat(of.getVatPercent8());
		float unitrate=Float.parseFloat(of.getUnitRate8());
		float qty=Float.parseFloat(of.getQtyPurchased8());
		float vatamt=vatper*unitrate*qty;
				String vatamount=Float.toString(vatamt);
		of.setVatAmount8(vatamount);
		
		}
		logger.debug("OilGreasePurchaseAction:vatpercentMethod  --------->");
			return mapping.findForward("load");		
	}
		
	public ActionForward amountMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction:AmountMethod  <---------");
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		float additionalamt=0;
		float unitrate=0;
		float qty=0;
		float vatamt=Float.parseFloat(of.getVatAmount1());
	
		if((!StringUtils.isEmpty(of.getQtyPurchased1()))&&(StringUtils.isEmpty(of.getAmount1())))
		{
		if(!StringUtils.isEmpty(of.getAdditionalAmount1()))
		additionalamt=Float.parseFloat(of.getAdditionalAmount1());
		unitrate=Float.parseFloat(of.getUnitRate1());
		qty=Float.parseFloat(of.getQtyPurchased1());
		if(!StringUtils.isEmpty(of.getVatAmount1()))
		vatamt=Float.parseFloat(of.getVatAmount1());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount1(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased2()))&&(StringUtils.isEmpty(of.getAmount2())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount2()))
		additionalamt=Float.parseFloat(of.getAdditionalAmount2());
			unitrate=Float.parseFloat(of.getUnitRate2());
			qty=Float.parseFloat(of.getQtyPurchased2());
			if(!StringUtils.isEmpty(of.getVatAmount2()))
			vatamt=Float.parseFloat(of.getVatAmount2());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount2(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased3()))&&(StringUtils.isEmpty(of.getAmount3())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount3()))
			
		additionalamt=Float.parseFloat(of.getAdditionalAmount3());
			unitrate=Float.parseFloat(of.getUnitRate3());
			qty=Float.parseFloat(of.getQtyPurchased3());
			if(!StringUtils.isEmpty(of.getVatAmount3()))
			vatamt=Float.parseFloat(of.getVatAmount3());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount3(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased4()))&&(StringUtils.isEmpty(of.getAmount4())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount4()))
			
		additionalamt=Float.parseFloat(of.getAdditionalAmount4());
			unitrate=Float.parseFloat(of.getUnitRate4());
			qty=Float.parseFloat(of.getQtyPurchased4());
			if(!StringUtils.isEmpty(of.getVatAmount4()))
			vatamt=Float.parseFloat(of.getVatAmount4());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount4(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased5()))&&(StringUtils.isEmpty(of.getAmount5())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount5()))
		additionalamt=Float.parseFloat(of.getAdditionalAmount5());
			unitrate=Float.parseFloat(of.getUnitRate5());
			qty=Float.parseFloat(of.getQtyPurchased5());
			if(!StringUtils.isEmpty(of.getVatAmount5()))
			vatamt=Float.parseFloat(of.getVatAmount5());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount5(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased6()))&&(StringUtils.isEmpty(of.getAmount6())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount6()))
		additionalamt=Float.parseFloat(of.getAdditionalAmount6());
			unitrate=Float.parseFloat(of.getUnitRate6());
			qty=Float.parseFloat(of.getQtyPurchased6());
			if(!StringUtils.isEmpty(of.getVatAmount6()))
			vatamt=Float.parseFloat(of.getVatAmount6());	
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount6(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased7()))&&(StringUtils.isEmpty(of.getAmount7())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount7()))
		additionalamt=Float.parseFloat(of.getAdditionalAmount7());
			unitrate=Float.parseFloat(of.getUnitRate7());
			qty=Float.parseFloat(of.getQtyPurchased7());
			if(!StringUtils.isEmpty(of.getVatAmount7()))
			vatamt=Float.parseFloat(of.getVatAmount7());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount7(amount);
		totalamount=totalamount+amt;
		}
		if((!StringUtils.isEmpty(of.getQtyPurchased8()))&&(StringUtils.isEmpty(of.getAmount8())))
		{
			if(!StringUtils.isEmpty(of.getAdditionalAmount8()))

		additionalamt=Float.parseFloat(of.getAdditionalAmount8());
			unitrate=Float.parseFloat(of.getUnitRate8());
			qty=Float.parseFloat(of.getQtyPurchased8());
			if(!StringUtils.isEmpty(of.getVatAmount8()))
			vatamt=Float.parseFloat(of.getVatAmount8());
		Float amt=(unitrate*qty)+vatamt+additionalamt;
		String amount=Float.toString(amt);
		of.setAmount8(amount);
		totalamount=totalamount+amt;
		}
		logger.debug("OilGreasePurchaseAction:AmountMethod  --------->");
		return mapping.findForward("load");		
	}
	
	
	
	
	// to create the job and task
	
	public ActionForward jobPurchaseMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction:jobPurchaseMethod  <---------");
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		String name=of.getReqItem();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		String ss1=mapping.getName();
		int jobid=0;
		int taskid=0;
		try{
			
			jobid=(Integer)session.getAttribute("jobseq");
			String reqName=os.getPurchaseItem(jobid)+"Purchase";
			taskid=(Integer)session.getAttribute("taskseqseq");	
		jb.approveStatus(jobid,taskid);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		insertvalues(jobid,form);
		logger.debug("OilGreasePurchaseAction:jobPurchaseMethod  --------->");
		return mapping.findForward("success");

	}
	public ActionForward saveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction:saveMethod  <---------");
		HttpSession session = ((HttpServletRequest) request).getSession();
		int jobid=0;
		int taskid=0;
		try{
			jobid=(Integer)session.getAttribute("jobseq");
			taskid=(Integer)session.getAttribute("taskseqseq");
			insertvalues(jobid,form);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}	
		logger.debug("OilGreasePurchaseAction:saveMethod  --------->");
		
		return mapping.findForward("load");
	}
	public void insertvalues(int jobid,ActionForm form)
	{
		logger.debug("insertvalues <<<<<<<<<<<<");
		OilGreasePurchaseForm of=(OilGreasePurchaseForm)form;
		String date=of.getBillDate();
		String billno=of.getBillNumber();
		String delivereddate=of.getDeliveredDate();
		String cname=of.getCompanyName();
		String place=of.getPlace();
		String reqitem=of.getReqItem();
		String partno=of.getPartNo();
		
		os.insertSupplier(jobid,date,billno,delivereddate,cname,place,reqitem);
	
		String brandname,brandcategory;
		int availability,quantity;
		float unitprice;
		float vatpercent=0,vatamount=0,additionalamount=0,amount;
		if(!StringUtils.isEmpty(of.getQtyPurchased1()))
		{	
			brandname=of.getBrandName1();
			brandcategory=of.getBrandType1();
			availability=Integer.parseInt(of.getAvailableQty1());						
				quantity=Integer.parseInt(of.getQtyPurchased1());
				unitprice=Float.parseFloat(of.getUnitRate1());
				if(!StringUtils.isEmpty(of.getVatPercent1()))
				vatpercent=Float.parseFloat(of.getVatPercent1());
				if(!StringUtils.isEmpty(of.getVatAmount1()))
				vatamount=Float.parseFloat(of.getVatAmount1());
				if(!StringUtils.isEmpty(of.getAdditionalAmount1()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount1());
				amount=Float.parseFloat(of.getAmount1());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
			
				os.insertcommontrans(reqitem,brandcategory,unitprice,quantity);
			
				
			}
		
		if(!StringUtils.isEmpty(of.getQtyPurchased2()))
		{
			brandname=of.getBrandName2();
			brandcategory=of.getBrandType2();
			availability=Integer.parseInt(of.getAvailableQty2());						
				quantity=Integer.parseInt(of.getQtyPurchased2());
				unitprice=Float.parseFloat(of.getUnitRate2());
				if(!StringUtils.isEmpty(of.getVatPercent2()))
				vatpercent=Float.parseFloat(of.getVatPercent2());
				if(!StringUtils.isEmpty(of.getVatAmount2()))
				vatamount=Float.parseFloat(of.getVatAmount2());
				if(!StringUtils.isEmpty(of.getAdditionalAmount2()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount2());
				amount=Float.parseFloat(of.getAmount2());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record2 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
			}
		
		if(!StringUtils.isEmpty(of.getQtyPurchased3()))
		{
			brandname=of.getBrandName3();
			brandcategory=of.getBrandType3();
			availability=Integer.parseInt(of.getAvailableQty3());						
				quantity=Integer.parseInt(of.getQtyPurchased3());
				unitprice=Float.parseFloat(of.getUnitRate3());
				if(!StringUtils.isEmpty(of.getVatPercent3()))
				vatpercent=Float.parseFloat(of.getVatPercent3());
				if(!StringUtils.isEmpty(of.getVatAmount3()))
				vatamount=Float.parseFloat(of.getVatAmount3());
				if(!StringUtils.isEmpty(of.getAdditionalAmount3()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount3());
				amount=Float.parseFloat(of.getAmount3());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record3 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
		}
		
		if(!StringUtils.isEmpty(of.getQtyPurchased4()))
		{
			brandname=of.getBrandName4();
			brandcategory=of.getBrandType4();
			availability=Integer.parseInt(of.getAvailableQty4());						
				quantity=Integer.parseInt(of.getQtyPurchased4());
				unitprice=Float.parseFloat(of.getUnitRate4());
				if(!StringUtils.isEmpty(of.getVatPercent4()))
				vatpercent=Float.parseFloat(of.getVatPercent4());
				if(!StringUtils.isEmpty(of.getVatAmount4()))
				vatamount=Float.parseFloat(of.getVatAmount4());
				if(!StringUtils.isEmpty(of.getAdditionalAmount4()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount4());
				amount=Float.parseFloat(of.getAmount4());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record4 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
		}
		
		if(!StringUtils.isEmpty(of.getQtyPurchased5()))
		{
			brandname=of.getBrandName5();
			brandcategory=of.getBrandType5();
			availability=Integer.parseInt(of.getAvailableQty5());						
				quantity=Integer.parseInt(of.getQtyPurchased5());
				unitprice=Float.parseFloat(of.getUnitRate5());
				if(!StringUtils.isEmpty(of.getVatPercent5()))
				vatpercent=Float.parseFloat(of.getVatPercent5());
				if(!StringUtils.isEmpty(of.getVatAmount5()))
				vatamount=Float.parseFloat(of.getVatAmount5());
				if(!StringUtils.isEmpty(of.getAdditionalAmount5()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount5());
				amount=Float.parseFloat(of.getAmount5());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record5 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
				}
		
		
		if(!StringUtils.isEmpty(of.getQtyPurchased6()))
		{
			brandname=of.getBrandName6();
			brandcategory=of.getBrandType6();
			availability=Integer.parseInt(of.getAvailableQty6());						
				quantity=Integer.parseInt(of.getQtyPurchased6());
				unitprice=Float.parseFloat(of.getUnitRate6());
				if(!StringUtils.isEmpty(of.getVatPercent6()))
				vatpercent=Float.parseFloat(of.getVatPercent6());
				if(!StringUtils.isEmpty(of.getVatAmount6()))
				vatamount=Float.parseFloat(of.getVatAmount6());
				if(!StringUtils.isEmpty(of.getAdditionalAmount6()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount6());
				amount=Float.parseFloat(of.getAmount6());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record6 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
				
				}
		
		if(!StringUtils.isEmpty(of.getQtyPurchased7()))
		{
			brandname=of.getBrandName7();
			brandcategory=of.getBrandType7();
			availability=Integer.parseInt(of.getAvailableQty7());						
				quantity=Integer.parseInt(of.getQtyPurchased7());
				unitprice=Float.parseFloat(of.getUnitRate7());
				if(!StringUtils.isEmpty(of.getVatPercent7()))
				vatpercent=Float.parseFloat(of.getVatPercent7());
				if(!StringUtils.isEmpty(of.getVatAmount7()))
				vatamount=Float.parseFloat(of.getVatAmount7());
				if(!StringUtils.isEmpty(of.getAdditionalAmount7()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount7());
				amount=Float.parseFloat(of.getAmount7());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record7 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
		}
		
		if(!StringUtils.isEmpty(of.getQtyPurchased8()))
		{
			brandname=of.getBrandName8();
			brandcategory=of.getBrandType8();
			availability=Integer.parseInt(of.getAvailableQty8());						
				quantity=Integer.parseInt(of.getQtyPurchased8());
				unitprice=Float.parseFloat(of.getUnitRate8());
				if(!StringUtils.isEmpty(of.getVatPercent8()))
				vatpercent=Float.parseFloat(of.getVatPercent8());
				if(!StringUtils.isEmpty(of.getVatAmount8()))
				vatamount=Float.parseFloat(of.getVatAmount8());
				if(!StringUtils.isEmpty(of.getAdditionalAmount8()))
				additionalamount=Float.parseFloat(of.getAdditionalAmount8());
				amount=Float.parseFloat(of.getAmount8());
				os.insertProduct(jobid,brandname,brandcategory,availability);
				logger.debug("OilGreasePurchaseAction: insertvalues for product table->record8 passed to service");
				os.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
				
		}
		logger.debug("insertvalues >>>>>>>>>>>>>>>>");
	  		
	}
	
	//to chage the status to 1 after the approval of E.O 
	
	public ActionForward acquiredMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		//have to pass the jobid,taskid to change the status to 1 for the approve task
		//called form the inbox
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			logger.debug("inside job method");
			Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
			logger.debug("inside acquired method");
			int job=Integer.parseInt(request.getParameter("jobid"));
			logger.debug("job in acquire"+job);
			int task=Integer.parseInt(request.getParameter("taskid"));
			logger.debug("task in acquire"+task);
			//jb.acquiredStatus(job,task,con);
			return mapping.findForward("eject1");
	}
	
	public ActionForward approveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the approve task
		//and 0 for issue task
		// called from the corresponding form
		
		
		 HttpSession session = ((HttpServletRequest) request).getSession();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			logger.debug("inside approve method");
			Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			//jb.approveStatus(job,task,con);
			return mapping.findForward("inb");
	}
	
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the issue task
		
		 HttpSession session = ((HttpServletRequest) request).getSession();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			logger.debug("inside approve method");
			Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			//jb.okStatus(job,task,con);
			return mapping.findForward("eject1");
	}
	

}
