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

import com.dbcom.dbcom;
import com.formbean.OilGreaseRequisitionForm;
import com.formbean.TyreRequisitionForm;
import com.service.OilGreasePurchaseService;
import com.service.OilGreaseRequisitionService;
import com.service.TyreRequisitionService;
import com.vo.OilGreaseRequisitionVO;
import com.vo.TyreRequisitionVO;
import com.wf.job;

//import com.wf.*;

public class TyreRequisitionAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(TyreRequisitionAction.class);
	
	ArrayList list=new ArrayList();
	TyreRequisitionVO vo=new TyreRequisitionVO();
	TyreRequisitionService ts=new TyreRequisitionService();
	job jb=new job();
	dbcom db=new dbcom();
	int jobid;
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		TyreRequisitionForm tf=(TyreRequisitionForm)form;
			String ss1=mapping.getName();
			logger.debug("TyreRequisitionAction: defaultMethod<-------------"+ss1);
			list=ts.getTyreBrandList();
			logger.debug("TyreRequisitionAction:tyrebrandlostsize"+list.size());
			tf.setTyreTypeList(list);
			list=ts.getTyreSizeList();
			tf.setTyreSizeList(list);
			list=ts.getTyrePlyList();
			tf.setTyrePlyList(list);
			list=ts.getTyrePartsList();
			tf.setTyrePartsList(list);
			logger.debug("TyreRequisitionAction:defaultMethod---------->");
			return mapping.findForward("eject1");
		
	}
	
	// to create the job and task
	
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		TyreRequisitionForm of=(TyreRequisitionForm)form;
		String reqName="TyreRequisition";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		String ss1=mapping.getName();
		try{
		jobid=jb.creatJob(ss1,userName,reqName);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		
		insertvalues(jobid,form);
		return mapping.findForward("eject1");

	}
	
	
	public ActionForward availableMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			TyreRequisitionForm tf=(TyreRequisitionForm)form;
		    logger.debug("availableQty Mtd <<<<<<<<<<<<<<<<");
		    int brandname;
		    int size;
		    int ply;
			if(StringUtils.isEmpty(tf.getNeedQty1()))
			{ 	
				  logger.debug("availableQty Mtd:tf.getNeedQty1"+tf.getNeedQty1());
				brandname=Integer.parseInt(tf.getTyreType1());
				size=Integer.parseInt(tf.getTyreSize1());
				ply=Integer.parseInt(tf.getTyrePly1());
				int availability=ts.getavailability(brandname,size,ply);
				String avail=Integer.toString(availability);
				logger.debug("availableQty Mtd"+availability);
				tf.setQtyAvailable1(avail);
			
			}
			else if(StringUtils.isEmpty(tf.getNeedQty2()))
			{	
				brandname=Integer.parseInt(tf.getTyreType2());
				size=Integer.parseInt(tf.getTyreSize2());
				ply=Integer.parseInt(tf.getTyrePly2());
				int availability=ts.getavailability(brandname,size,ply);
				String avail=Integer.toString(availability);
				tf.setQtyAvailable2(avail);
			}
			else if(StringUtils.isEmpty(tf.getNeedQty3()))
			{
				brandname=Integer.parseInt(tf.getTyreType3());
				size=Integer.parseInt(tf.getTyreSize3());
				ply=Integer.parseInt(tf.getTyrePly3());
				int availability=ts.getavailability(brandname,size,ply);
				String avail=Integer.toString(availability);
				tf.setQtyAvailable3(avail);
			}
			else if(StringUtils.isEmpty(tf.getNeedQty4()) )
			{
				brandname=Integer.parseInt(tf.getTyreType4());
				size=Integer.parseInt(tf.getTyreSize4());
				ply=Integer.parseInt(tf.getTyrePly4());
				int availability=ts.getavailability(brandname,size,ply);
				String avail=Integer.toString(availability);
				tf.setQtyAvailable4(avail);
			}
			else if(StringUtils.isEmpty(tf.getNeedQty5()))
			{
				brandname=Integer.parseInt(tf.getTyreType5());
				size=Integer.parseInt(tf.getTyreSize5());
				ply=Integer.parseInt(tf.getTyrePly5());
				int availability=ts.getavailability(brandname,size,ply);
				String avail=Integer.toString(availability);
				tf.setQtyAvailable5(avail);
			}
			logger.debug("availableQty Mtd >>>>>>>>>>>>>");
			return mapping.findForward("eject1");
	}
	
	
	
	
	
	public void insertvalues(int jobid,ActionForm form)
	{
		logger.debug("TyreRequisitionAction:insertvalues <<<<<<<<<<<<");
		TyreRequisitionForm tf=(TyreRequisitionForm)form;
		String date=tf.getDate();
		String name=tf.getFrom();
		String vehicleno=tf.getVehicleNo();
		String tyreparts;
		int brandname,size,ply,availability,neededqty;
		String newtyrebrand,newsize,newply;
		int bid,bcid;
		 
		
		if(!StringUtils.isEmpty(tf.getNeedQty1()))
		{
			brandname=Integer.parseInt(tf.getTyreType1());
			size=Integer.parseInt(tf.getTyreSize1());
			ply=Integer.parseInt(tf.getTyrePly1());
			String categorystr = ",";
			for(int i=0;i<tf.getTyreParts1().length;i++){
				 String str1=tf.getTyreParts1()[i];
				 categorystr=categorystr+str1+",";
		     }
			tyreparts=categorystr.substring(1, categorystr.length()-1);
			availability=Integer.parseInt(tf.getQtyAvailable1());
			neededqty=Integer.parseInt(tf.getNeedQty1());
			ts.insert(jobid,date,name,vehicleno,brandname,size,ply,tyreparts,availability,neededqty);
			logger.debug("TyreRequisitionAction: insertvalues->record1 passed to service"); 
		}
		
		if(!StringUtils.isEmpty(tf.getNeedQty2()))
		{
			brandname=Integer.parseInt(tf.getTyreType2());
			size=Integer.parseInt(tf.getTyreSize2());
			ply=Integer.parseInt(tf.getTyrePly2());
			String categorystr = ",";
			for(int i=0;i<tf.getTyreParts2().length;i++){
				 String str1=tf.getTyreParts1()[i];
				 categorystr=categorystr+str1+",";
		     }
			tyreparts=categorystr.substring(1, categorystr.length()-1);
			availability=Integer.parseInt(tf.getQtyAvailable2());
			neededqty=Integer.parseInt(tf.getNeedQty2());
			ts.insert(jobid,date,name,vehicleno,brandname,size,ply,tyreparts,availability,neededqty);
			logger.debug("TyreRequisitionAction: insertvalues->record2 passed to service"); 
		}
		
		
		if(!StringUtils.isEmpty(tf.getNeedQty3()))
		{
			brandname=Integer.parseInt(tf.getTyreType3());
			size=Integer.parseInt(tf.getTyreSize3());
			ply=Integer.parseInt(tf.getTyrePly3());
			String categorystr = ",";
			for(int i=0;i<tf.getTyreParts1().length;i++){
				 String str1=tf.getTyreParts3()[i];
				 categorystr=categorystr+str1+",";
		     }
			tyreparts=categorystr.substring(1, categorystr.length()-1);
			availability=Integer.parseInt(tf.getQtyAvailable3());
			neededqty=Integer.parseInt(tf.getNeedQty3());
			ts.insert(jobid,date,name,vehicleno,brandname,size,ply,tyreparts,availability,neededqty);
			logger.debug("TyreRequisitionAction: insertvalues->record3 passed to service"); 
		}
		
		if(!StringUtils.isEmpty(tf.getNeedQty4()))
		{
			brandname=Integer.parseInt(tf.getTyreType4());
			size=Integer.parseInt(tf.getTyreSize4());
			ply=Integer.parseInt(tf.getTyrePly4());
			String categorystr = ",";
			for(int i=0;i<tf.getTyreParts4().length;i++){
				 String str1=tf.getTyreParts4()[i];
				 categorystr=categorystr+str1+",";
		     }
			tyreparts=categorystr.substring(1, categorystr.length()-1);
			availability=Integer.parseInt(tf.getQtyAvailable4());
			neededqty=Integer.parseInt(tf.getNeedQty4());
			ts.insert(jobid,date,name,vehicleno,brandname,size,ply,tyreparts,availability,neededqty);
			logger.debug("TyreRequisitionAction: insertvalues->record4 passed to service"); 
		}
		
		if(!StringUtils.isEmpty(tf.getNeedQty5()))
		{
			brandname=Integer.parseInt(tf.getTyreType5());
			size=Integer.parseInt(tf.getTyreSize5());
			ply=Integer.parseInt(tf.getTyrePly5());
			String categorystr = ",";
			for(int i=0;i<tf.getTyreParts5().length;i++){
				 String str1=tf.getTyreParts5()[i];
				 categorystr=categorystr+str1+",";
		     }
			tyreparts=categorystr.substring(1, categorystr.length()-1);
			availability=Integer.parseInt(tf.getQtyAvailable5());
			neededqty=Integer.parseInt(tf.getNeedQty5());
			ts.insert(jobid,date,name,vehicleno,brandname,size,ply,tyreparts,availability,neededqty);
			logger.debug("TyreRequisitionAction: insertvalues->record5 passed to service"); 
		}
		
		if(!StringUtils.isEmpty(tf.getNewNeededQty1()))
		{
			newtyrebrand=tf.getNewTyreType1();
			newsize=tf.getNewTyreSize1();
			newply=tf.getNewTyrePly1();
			availability=0;
			tyreparts=tf.getNewTyreParts1();
			neededqty=Integer.parseInt(tf.getNewNeededQty1());
			int brandid=ts.insertlookup(newtyrebrand,"tyrebrand");
			int sizeid=ts.insertlookup(newsize,"tyresize");
			int plyid=ts.insertlookup(newply,"tyreply");
			ts.insert(jobid,date,name,vehicleno,brandid,sizeid,plyid,tyreparts,availability,neededqty);
			
		}
		
		if(!StringUtils.isEmpty(tf.getNewNeededQty2()))
		{
			newtyrebrand=tf.getNewTyreType2();
			newsize=tf.getNewTyreSize2();
			newply=tf.getNewTyrePly2();
			availability=0;
			tyreparts=tf.getNewTyreParts2();
			neededqty=Integer.parseInt(tf.getNewNeededQty2());
			int brandid=ts.insertlookup(newtyrebrand,"tyrebrand");
			int sizeid=ts.insertlookup(newsize,"tyresize");
			int plyid=ts.insertlookup(newply,"tyreply");
			ts.insert(jobid,date,name,vehicleno,brandid,sizeid,plyid,tyreparts,availability,neededqty);
			
		}
		
		if(!StringUtils.isEmpty(tf.getNewNeededQty3()))
		{
			newtyrebrand=tf.getNewTyreType3();
			newsize=tf.getNewTyreSize3();
			newply=tf.getNewTyrePly3();
			availability=0;
			tyreparts=tf.getNewTyreParts3();
			neededqty=Integer.parseInt(tf.getNewNeededQty3());
			int brandid=ts.insertlookup(newtyrebrand,"tyrebrand");
			int sizeid=ts.insertlookup(newsize,"tyresize");
			int plyid=ts.insertlookup(newply,"tyreply");
			ts.insert(jobid,date,name,vehicleno,brandid,sizeid,plyid,tyreparts,availability,neededqty);
		}

		logger.debug("insertvalues >>>>>>>>>>>>>>>>");
	  		
	}
	
	public ActionForward inboxMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("TyreRequisitionAction:inboxMethod Mtd <<<<<<<<<<<<<<");
		TyreRequisitionForm tf=(TyreRequisitionForm)form;
		ArrayList list=new ArrayList();
		ArrayList list1=new ArrayList();
		HttpSession session = ((HttpServletRequest) request).getSession();
		int jobid=(Integer)session.getAttribute("jobseq");
		list=ts.retrieve(jobid);
		list1=ts.fetchApproveStatusList();
		tf.setApproveStatusList(list1);
		logger.debug("list size :"+list.size());
		for(int i=0;i<list.size();i++)
		{
			logger.debug("for i="+i);
			vo=(TyreRequisitionVO)list.get(i);
			//logger.debug("record :"+i+""+vo.getDate()+vo.getFrom()+vo.getItemDes()+vo.getBrandName1()+vo.getBrandType1());
			logger.debug("TyreRequisitionAction"+vo.getDate()+vo.getFrom());
			tf.setDate(vo.getDate());
			tf.setFrom(vo.getFrom());
			tf.setVehicleNo(vo.getVehicleNo());
			logger.debug("TyreRequisitionAction:vehiclenovo"+vo.getVehicleNo());
			logger.debug("TyreRequisitionAction:vehiclenofo"+tf.getVehicleNo());
			logger.debug("TyreRequisitionAction:date"+tf.getDate());
			//combolist1=os.fetchRequiredItem();
			list1=ts.getTyreBrandList();
			tf.setTyreTypeList(list1);
			list1=ts.getTyreSizeList();
			tf.setTyreSizeList(list1);
			list1=ts.getTyrePlyList();
			tf.setTyrePlyList(list1);
			list1=ts.getTyrePartsList();
			tf.setTyrePartsList(list1);
			// assign database value
			
			switch(i)
			{
			case 0:
				tf.setTyreType1(vo.getTyreType1());
				logger.debug("TyreRequisitionAction:getTyreType1"+tf.getTyreType1());
				tf.setTyreSize1(vo.getTyreSize1());
				tf.setTyrePly1(vo.getTyrePly1());
				tf.setQtyAvailable1(vo.getAvailableQty1());
				tf.setNeedQty1(vo.getQtyNeeded1());
				tf.setApproveStatus1(vo.getApproveStatus());
				logger.debug("TyreRequisitionAction:vo.getApproveStatus1()"+vo.getApproveStatus());
				logger.debug("TyreRequisitionAction:tf.getApproveStatus1()"+tf.getApproveStatus1());
				break;
			case 1:
				tf.setTyreType2(vo.getTyreType1());
				tf.setTyreSize2(vo.getTyreSize1());
				tf.setTyrePly2(vo.getTyrePly1());
				tf.setQtyAvailable2(vo.getAvailableQty1());
				tf.setNeedQty2(vo.getQtyNeeded1());
				tf.setApproveStatus2(vo.getApproveStatus());
				break;
			case 2:
				tf.setTyreType3(vo.getTyreType1());
				tf.setTyreSize3(vo.getTyreSize1());
				tf.setTyrePly3(vo.getTyrePly1());
				tf.setQtyAvailable3(vo.getAvailableQty1());
				tf.setNeedQty3(vo.getQtyNeeded1());
				tf.setApproveStatus3(vo.getApproveStatus());
				break;
			case 3:
				tf.setTyreType4(vo.getTyreType1());
				tf.setTyreSize4(vo.getTyreSize1());
				tf.setTyrePly4(vo.getTyrePly1());
				tf.setQtyAvailable4(vo.getAvailableQty1());
				tf.setNeedQty4(vo.getQtyNeeded1());
				tf.setApproveStatus4(vo.getApproveStatus());
				break;
			case 4:
				tf.setTyreType5(vo.getTyreType1());
				tf.setTyreSize5(vo.getTyreSize1());
				tf.setTyrePly5(vo.getTyrePly1());
				tf.setQtyAvailable5(vo.getAvailableQty1());
				tf.setNeedQty5(vo.getQtyNeeded1());
				tf.setApproveStatus5(vo.getApproveStatus());
				break; 
			case 5:
				tf.setNewTyreType1(vo.getTyreType1());
				tf.setNewTyreSize1(vo.getTyreSize1());
				tf.setNewTyrePly1(vo.getTyrePly1());
				tf.setNeedQty1(vo.getQtyNeeded1());
				tf.setApproveStatus1(vo.getApproveStatus());
				break; 
			case 6:
				tf.setNewTyreType2(vo.getTyreType1());
				tf.setNewTyreSize2(vo.getTyreSize1());
				tf.setNewTyrePly2(vo.getTyrePly1());
				tf.setNeedQty2(vo.getQtyNeeded1());
				tf.setApproveStatus2(vo.getApproveStatus());
				break;
			case 7:
				tf.setNewTyreType3(vo.getTyreType1());
				tf.setNewTyreSize3(vo.getTyreSize1());
				tf.setNewTyrePly3(vo.getTyrePly1());
				tf.setNeedQty3(vo.getQtyNeeded1());
				tf.setApproveStatus1(vo.getApproveStatus());
				break;
				
			}
			
		}
		logger.debug("inboxMethod >>>>>>>>>>>>>>>");
		return mapping.findForward("eject1");
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
			logger.debug("TyreRequisitionAction: approveMethod<<<<<<<<<<<<");	
			TyreRequisitionForm tf=(TyreRequisitionForm)form;
			 HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			if(!StringUtils.isEmpty(tf.getNeedQty1())) 	
				ts.status(job,tf.getTyreType1(),tf.getTyreSize1(),tf.getTyrePly1(),tf.getApproveStatus1());
			if(!StringUtils.isEmpty(tf.getNeedQty2())) 
				ts.status(job,tf.getTyreType2(),tf.getTyreSize2(),tf.getTyrePly2(),tf.getApproveStatus2());
			if(!StringUtils.isEmpty(tf.getNeedQty3())) 
				ts.status(job,tf.getTyreType3(),tf.getTyreSize3(),tf.getTyrePly3(),tf.getApproveStatus3());
			if(!StringUtils.isEmpty(tf.getNeedQty4())) 
				ts.status(job,tf.getTyreType4(),tf.getTyreSize4(),tf.getTyrePly4(),tf.getApproveStatus4());
			if(!StringUtils.isEmpty(tf.getNeedQty5())) 
				ts.status(job,tf.getTyreType5(),tf.getTyreSize5(),tf.getTyrePly5(),tf.getApproveStatus5());
			if(!StringUtils.isEmpty(tf.getNewNeededQty1())) 
				ts.status(job,tf.getNewTyreType1(),tf.getNewTyreSize1(),tf.getNewTyrePly1(),tf.getNewApproveStatus1());
			if(!StringUtils.isEmpty(tf.getNewNeededQty2())) 
				ts.status(job,tf.getNewTyreType2(),tf.getNewTyreSize2(),tf.getNewTyrePly2(),tf.getNewApproveStatus2());
			if(!StringUtils.isEmpty(tf.getNewNeededQty3())) 
				ts.status(job,tf.getNewTyreType3(),tf.getNewTyreSize3(),tf.getNewTyrePly3(),tf.getNewApproveStatus3());
			jb.approveStatus(job,task);
			logger.debug("TyreRequisitionAction: approveMethod>>>>>>>>>>>>>");	
			return mapping.findForward("fwdtoincharge");
			
			
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
