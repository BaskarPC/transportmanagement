package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.DieselDAO;
import com.dao.InboxDAO;

public class InboxService {
	ArrayList instlist;
	private static final Logger logger=(Logger)Logger.getLogger(InboxService.class);
	InboxDAO inboxdao=new InboxDAO();
	public ArrayList fetchJobAttribute()
	{
		logger.debug("inside fetch job attri in service");
		instlist=inboxdao.fetchJobAttribute();
		return instlist;
	}
	public ArrayList fetchJobId()
	{
		logger.debug("Inside fetchjobid in service");
		instlist=inboxdao.fetchJobId();
		return instlist;
	}
	public ArrayList fetchTaskId()
	{
		instlist=inboxdao.fetchTaskId();
		return instlist;
	}
	
	public void InsertJob(int nextvalue,String form,int userid,String userName)
	{
		inboxdao.InsertJob(nextvalue,form,userid,userName);
	}
	public void InsertTask(int jobseq,int nextvalue1,String task,String rolename,int status,String userName,String reqName)
	{
		inboxdao.InsertTask(jobseq,nextvalue1,task,rolename,status,userName,reqName);
	}
	public ArrayList fetchTaskAttribute(int attrid)
	{
		instlist=inboxdao.fetchTaskAttribute(attrid);
		return instlist;
	}
	public ArrayList fetchUserTab()
	{
		instlist=inboxdao.fetchUserTab();
		return instlist;
	}
	public void UpdateTask(int stat,int task)
	{
		inboxdao.UpdateTask(stat,task);
	}
	public void UpdateTaskStatus(int stat,int task,String userName)
	{
		
		inboxdao.UpdateTaskStatus(stat,task,userName);
	}
	public ArrayList fetchUser(String userName)
	{
		instlist=inboxdao.fetchUser(userName);
		return instlist;
	}
}
