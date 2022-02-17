package com.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.dbcom.dbcom;
import com.formbean.InboxForm;
import com.service.InboxService;
import com.vo.InboxVO;
import com.vo.InboxdbVO;
import com.wf.*;

public class InboxAction extends BaseDispatchAction{
	String voname;
	String name;
	private static final Logger logger=(Logger)Logger.getLogger(InboxAction.class);
	job jb=new job();
	
	dbcom db=new dbcom();
	 String vofile="com.vo.InboxVO";
	String fname="";
	ArrayList res_list=new ArrayList();
	InboxService inboxservice=new InboxService();
	ArrayList userList=new ArrayList();
	/**
	 * called when executive officer enters into inbox and adds the values in list
	 */
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		InboxdbVO dbvo=new InboxdbVO();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		logger.debug("session user name :"+userName);
		InboxForm inb=(InboxForm)form;
		ArrayList l1=new ArrayList();
		userList=inboxservice.fetchUser(userName);
		dbvo=(InboxdbVO)userList.get(0);
		String role=dbvo.getUserRole();
		logger.debug("role"+role);
		if(role.equals("EXECUTIVE OFFICER"))
		{
		String query="select jobid as JOB,taskid as TASKSEQ,taskname as FORMNAME,status as STAT from tasktab1 where status=0 or status=1 and acquiredby='executive officer'";
	    res_list=db.selectQuery(vofile,query);
	    logger.debug("res_list"+res_list.size());
	    }
		else if(role.equals("INCHARGE"))
		{
			String query="select jobid as JOB,taskid as TASKSEQ,taskname as FORMNAME,status as STAT from tasktab1 where status=0 or status=1 and acquiredby='incharge'";
		    res_list=db.selectQuery(vofile,query);
		    logger.debug("res_list"+res_list.size());
		}
		for(int i=0;i<res_list.size();i++)
	    {
	    	InboxdbVO inbox=new InboxdbVO();
	    	InboxVO vo=new InboxVO();
        	logger.debug("inside while");
        	vo=(InboxVO)res_list.get(i);
	    	inbox.setJobId(vo.getJobseq());
	    	inbox.setTaskId(vo.getTaskseq());
	    	inbox.setFmName(vo.getFormname());
	    	inbox.setStatus(vo.getStat());
	    	l1.add(inbox);
	     }
        request.setAttribute("inboxList", l1);
		inb.setInboxList(l1);
		logger.debug(l1.size());
		return mapping.findForward("view");
		
	}
	
	
	
	/**
	 * have to pass the jobid,taskid to change the status to 1 for the approve task
	 * It's called form the inbox
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward acquiredMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		    HttpSession session = ((HttpServletRequest) request).getSession();
		    String userName=(String) session.getAttribute("userId");
			logger.debug("inside acquired method");
			int job=Integer.parseInt(request.getParameter("jobId"));
			session.setAttribute("jobseq",job);
			ArrayList l1=new ArrayList();
			logger.debug("job in acquire"+job);
			int task=Integer.parseInt(request.getParameter("taskId"));
			session.setAttribute("taskseqseq",task);
			logger.debug("task in acquire"+task);
			String path=request.getParameter("fmName");
			jb.acquiredStatus(job,task,userName);
			return mapping.findForward(path);
	}
	
	
}
