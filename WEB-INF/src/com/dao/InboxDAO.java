package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;

public class InboxDAO {
	ArrayList instlist;
	dbcom db=new dbcom();
	 String vofile="com.vo.InboxVO";
	private static final Logger logger=(Logger)Logger.getLogger(InboxDAO.class);
	public ArrayList fetchJobAttribute()
	{
		logger.debug("inside fetch job attri in dao");
		String query="select jobname as jobname,taskcount as taskcount,attributeid as attrid from jobattribute1";
		instlist=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instlist.size());
		return instlist;
	}
	public ArrayList fetchJobId()
	{
		logger.debug("inside fetch job id in dao");
		String query="select MAX(jobid) as sequence from JOBTAB1";
		instlist=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instlist.size());
		return instlist;
	}
	public ArrayList fetchTaskId()
	{
		
		String query="select MAX(taskid) as taskid from TASKTAB1";
		instlist=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instlist.size());
		return instlist;
	}
	
	public void InsertJob(int nextvalue,String form,int userid,String userName)
	{
		
		String query="insert into jobtab1 values("+nextvalue+",'"+form+"',SYSDATE,"+userid+",'"+userName+"')";
		db.otherQuery(query);
		logger.debug("Inserted into Job table");
	}
	public void InsertTask(int jobseq,int nextvalue1,String task,String rolename,int status,String userName,String reqName)
	{
		
		String query="insert into tasktab1 values("+jobseq+","+nextvalue1+",'"+task+"',SYSDATE,SYSDATE,'"+rolename+"',"+status+",'"+userName+"','"+reqName+"')";
		db.otherQuery(query);
		logger.debug("Inserted into Task table");
	}
	public ArrayList fetchTaskAttribute(int attrid)
	{
		
		String query="select taskname as task from taskattribute1 where attributeid="+attrid+" order by taskname asc";
		instlist=db.selectQuery(vofile,query);
		logger.debug("fetches task list size="+instlist.size());
		return instlist;
	}
	public ArrayList fetchUserTab()
	{
		
		String query="select userid as userid,username as username,role as role from usertab1";
		instlist=db.selectQuery(vofile,query);
		logger.debug("fetches user role list size="+instlist.size());
		return instlist;
	}
	public void UpdateTask(int stat,int task)
	{
		
		String query="update tasktab1 set status="+stat+" where taskid="+task+"";
		db.otherQuery(query);
		logger.debug("Updated into Task");
	}
	public void UpdateTaskStatus(int stat,int task,String userName)
	{
		
		String query="update tasktab1 set status="+1+",username='"+userName+"',ACQUIREDDT=SYSDATE where taskid="+task+"";
		db.otherQuery(query);
		logger.debug("Updated into Task");
	}
	public ArrayList fetchUser(String userName)
	{
		
		String query="select USER_ROLE as userrole from login where USER_NAME='"+userName+"'";
		instlist=db.selectQuery("com.vo.InboxdbVO",query);
		logger.debug("Selected from login table"+instlist.size());
		return instlist;
	}
}
