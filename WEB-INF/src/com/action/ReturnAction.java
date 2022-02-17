package com.action;
import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.ReturnForm;
//import com.wf.*;




public class ReturnAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(ReturnAction.class);
	//job jb=new job();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		//ReturnForm sf=(ReturnForm)form;
			String ss1=mapping.getName();
			logger.debug("DieselAction: defaultMethod<-------------"+ss1);
			logger.debug("calling job "+mapping.getName());	
			logger.debug("spare1Action:defaultMethod---------->");
			return mapping.findForward("load");
		
	}
	
	// to create the job and task
	
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// gets the form name and passes it to create job and tasks
		
		
		logger.debug("inside job method");
		String ss1=mapping.getName();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		logger.debug("inside job method");
		Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
		//jb.creatJob(ss1,con);
		return mapping.findForward("inb");
	
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
		//	jb.approveStatus(job,task,con);
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
