package com.action;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseDispatchAction;
import com.formbean.DieselRequisitionForm;
import com.formbean.KeroseneClothRequisitionForm;
import com.formbean.OilGreaseRequisitionForm;
import com.service.DieselRequisitionService;
import com.service.KeroseneClothRequisitionService;
import com.service.OilGreaseRequisitionService;
import com.vo.DieselRequisitionVO;
import com.vo.KeroseneClothRequisitionVO;
import com.vo.OilGreaseRequisitionVO;
import com.wf.job;
//import com.service.kerreqservice;
//import com.vo.userVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class KeroseneClothRequisitionAction extends BaseDispatchAction{
	KeroseneClothRequisitionService ks=new KeroseneClothRequisitionService();
	KeroseneClothRequisitionVO vo=new KeroseneClothRequisitionVO();
	ArrayList list;
	job jb=new job();
	int jobid;
		private static final Logger logger=(Logger)Logger.getLogger( KeroseneClothRequisitionAction.class);
		public ActionForward defaultMethod(ActionMapping aMapping,
		        ActionForm form, HttpServletRequest request,
		        HttpServletResponse aResponse)throws Exception{
			logger.debug("kerosenerequisitionAction: defaultMethod<-------------");	
			KeroseneClothRequisitionForm f=(KeroseneClothRequisitionForm)form;
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("username");
			f.setFrom(userName);
			list=ks.itemList();
			f.setItemList(list);
			return aMapping.findForward("load");
		    	}

		public ActionForward availableMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
					logger.debug("availableQty Mtd --------->");		
					KeroseneClothRequisitionForm f=(KeroseneClothRequisitionForm)form;
					logger.debug("code for required item :"+Integer.parseInt(f.getItemDes()));
					String qty=ks.fetchAvailableQty(Integer.parseInt(f.getItemDes()));
					f.setAvailableQty(qty);
					logger.debug("get available qty :"+f.getAvailableQty());
					return mapping.findForward("load");
				}
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
				return mapping.findForward("taskcomplete");
		}
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
				return mapping.findForward("fwdtoincharge");
		}
		public ActionForward jobMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			String reqName="KeroseneRequisition";
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("username");
			String role=ks.getRole(userName);
			//if(role.equals("incharge"))
			//{
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
			return mapping.findForward("success");
			//'}
			//'return mapping.findForward("load");
		}
		public void insertvalues(int jobid,ActionForm form)
		{
			KeroseneClothRequisitionForm df=(KeroseneClothRequisitionForm)form;
			vo.setJobid(jobid);
			vo.setDate(df.getDate());
			vo.setFrom(df.getFrom());
			vo.setItemDes(df.getItemDes());
			vo.setAvailableQty(df.getAvailableQty());
			vo.setQtyNeeded(df.getQtyNeeded());
			vo.setDescription(df.getDescription());
			ks.insert(vo);	
			logger.debug("insertvalues : passed to service method");
			

		}
		public ActionForward inboxMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			KeroseneClothRequisitionForm kf=(KeroseneClothRequisitionForm)form;
			ArrayList list=new ArrayList();
			HttpSession session = ((HttpServletRequest) request).getSession();
			int jobid=(Integer)session.getAttribute("jobseq");
			list=ks.retrieve(jobid);
			logger.debug("list size.."+list.size());
			vo=(KeroseneClothRequisitionVO)list.get(0);			
			kf.setDate(vo.getDate());
			kf.setFrom(vo.getFrom());
			list=ks.itemList();
			kf.setItemList(list);
			kf.setItemDes(vo.getItemDes());
			kf.setAvailableQty(vo.getAvailableQty());
			kf.setQtyNeeded(vo.getQtyNeeded());
			kf.setDescription(vo.getDescription());
			return mapping.findForward("load");
		}


}
