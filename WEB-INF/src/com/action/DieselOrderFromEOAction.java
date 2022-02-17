package com.action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.formbean.DieselOrderFromEOForm;
import com.formbean.DieselRequisitionForm;
import com.service.DieselOrderFromEOService;
import com.service.DieselRequisitionService;
import com.vo.DieselOrderFromEOVO;
import com.vo.DieselRequisitionVO;

//import com.wf.*;
public class DieselOrderFromEOAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DieselOrderFromEOAction.class);
	//job jb=new job();
	DieselOrderFromEOService ds=new DieselOrderFromEOService();
	DieselOrderFromEOVO vo=	new DieselOrderFromEOVO();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("dieselorder from eo defaultMethod<-------------");
		DieselOrderFromEOForm df=(DieselOrderFromEOForm)form;
		df.setDate("");
		df.setFrom("");
		DieselRequisitionService ds1=new DieselRequisitionService();
		ArrayList petrollist= ds1.getPetrolCompany();
		logger.debug("petrol list size :"+petrollist.size());
		ArrayList banklist=ds1.getBankList();
		logger.debug("petrol banklist size :"+banklist.size());
		 HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		 int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
		String required=ds1.getRequiredLiters(job);
		df.setFrom(userName);
		df.setBanklist(banklist);
		df.setCompanylist(petrollist);
		df.setRequiredLiters(required);
			String ss1=mapping.getName();
			logger.debug("DieselAction: defaultMethod<-------------"+ss1);
			logger.debug("calling job "+mapping.getName());	
			logger.debug("DieselAction:defaultMethod---------->");
			return mapping.findForward("load");
		
	}
	
	// to create the job and task
	public ActionForward inboxMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		DieselOrderFromEOForm df=(DieselOrderFromEOForm)form;
		//clear(form);	
		DieselRequisitionService ds1=new DieselRequisitionService();
		ArrayList petrollist= ds1.getPetrolCompany();
		ArrayList banklist=ds1.getBankList();
		df.setBanklist(banklist);
		df.setCompanylist(petrollist);
		ArrayList list=new ArrayList();
		HttpSession session = ((HttpServletRequest) request).getSession();
		int jobid=(Integer)session.getAttribute("jobseq");
		list=ds.retrieve(jobid);
		logger.debug("list size.."+list.size());
		vo=(DieselOrderFromEOVO)list.get(0);
		
		logger.debug(vo.getDate()+vo.getFrom()+vo.getCompanyName()+vo.getRequiredLiters()+vo.getCheckNo());
		df.setDate(vo.getDate());
		df.setFrom(vo.getFrom());
		df.setCompanyName(vo.getCompanyName());
		df.setRequiredLiters(vo.getRequiredLiters());
		df.setCheckNo(vo.getCheckNo());
		df.setBankName(vo.getBankName());
		df.setAmount(vo.getAmount());
			
		return mapping.findForward("load");
	}

	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		String reqName="DieselRequisition";
		HttpSession session = ((HttpServletRequest) request).getSession();
		logger.debug("inside job method");
		int job=(Integer)session.getAttribute("jobseq");
		logger.debug("job in acquire"+job);
		String ss1=mapping.getName();
		try{
			logger.debug("BEFORE INSERT");
			insertvalues(job,form);
			logger.debug("AFTER INSERT");
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		
		
		logger.debug("insert executed");
		return mapping.findForward("subtoincharge");
	
	}
	
	
	
	public void insertvalues(int jobid,ActionForm form)
	{
		logger.debug("inside inservalues method ");
		DieselOrderFromEOForm df=(DieselOrderFromEOForm)form;
		DieselOrderFromEOVO vo=new DieselOrderFromEOVO();
		logger.debug("HI");
		vo.setJobid(Integer.toString(jobid));
		logger.debug(vo.getJobid());
		vo.setDate(df.getDate());
		logger.debug(vo.getDate());
		vo.setFrom(df.getFrom());
		logger.debug(vo.getFrom());
		vo.setCompanyName(df.getCompanyName());
		logger.debug(vo.getCompanyName());
		vo.setRequiredLiters(df.getRequiredLiters());
		logger.debug(vo.getRequiredLiters());
		vo.setCheckNo(df.getCheckNo());
		logger.debug(vo.getCheckNo());
		vo.setBankName(df.getBankName());
		logger.debug(vo.getBankName());
		vo.setAmount(df.getAmount());
		ds.insert(vo);	
		logger.debug("insertvalues : passed to service method");
		

	}
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
			return mapping.findForward("load");
	}
	
	public ActionForward approveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the approve task
		//and 0 for issue task
		// called from the corresponding form
		
		
			return mapping.findForward("load");
	}
	
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the issue task
		
		 HttpSession session = ((HttpServletRequest) request).getSession();
			
			return mapping.findForward("load");
	}

}
