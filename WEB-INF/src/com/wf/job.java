package com.wf;

import org.apache.log4j.Logger;

import com.dbcom.*;
import com.service.InboxService;
import com.vo.InboxVO;


import java.util.ArrayList;
import java.util.Date;

public class job {
	private static final Logger logger=(Logger)Logger.getLogger(job.class);
	String s1="_approve";
	String s2="_issue";
	String task="";
	int job_id;
	String name;
	Date create_dt;
	int creator_id;
	String rolename;
	int status=0;
	int nextvalue=0;
	int nextvalue1=0;
	int count;
	int id;
	int userid;
	String taskname; 
	java.sql.Date cdate=new java.sql.Date(new java.util.Date().getTime());
	String ssname="";
	InboxVO vo=new InboxVO();	
	ArrayList res_list=new ArrayList();
	ArrayList res_list1=new ArrayList();
	ArrayList res_list2=new ArrayList();
	ArrayList res_list3=new ArrayList();
	InboxService inboxservice=new InboxService();
	 
	 /**
	  * to create a job and calls the task method
	  * @param form gets the form name 
	  */
	 public int creatJob(String form,String userName,String reqName)
	 {
		 
		 		logger.debug("called job "+form);
		 		
		 		res_list=inboxservice.fetchJobAttribute();
			    for(int i=0;i<res_list.size();i++)
			    {
			    	logger.debug("inside for loop");
			    	vo=(InboxVO)res_list.get(i);
			    	if(form.equals(vo.getJobname()))
			    	{
			    		count=Integer.parseInt(vo.getTaskcount());
			 			id=Integer.parseInt(vo.getAttributeid());
			 			logger.debug("count "+count);
			 			logger.debug("attribute id"+id);
			    	}
			     }
			    // to get sequence for job id
			    res_list=inboxservice.fetchJobId();
				logger.debug("called job:: "+res_list.size());
		 		for(int i=0;i<res_list.size();i++)
				{
			 		vo=(InboxVO)res_list.get(i);
					logger.debug("seq value"+vo.getSeq());
					nextvalue=Integer.parseInt(vo.getSeq())+1;
		    	}
				
				//to get the user id from user table
				res_list=inboxservice.fetchUserTab();
				logger.debug("called job::: "+res_list.size());
		 	 	for(int i=0;i<res_list.size();i++)
				{
			 
					vo=(InboxVO)res_list.get(i);
					if(vo.getUsername().equals("incharge")||vo.getUsername().equals("INCHARGE") )
					{
						userid=Integer.parseInt(vo.getUserid());
						logger.debug("user id value"+userid);
					}
				}
				try
				    {
				    	
				   		inboxservice.InsertJob(nextvalue,form,userid,userName);
				   		logger.debug("inserted into job table successfully");
				    }
				    catch(Exception e)
				    {
				    	logger.debug("error"+e);
				    }
			
				   // calls the task method to create the tasks for the job
	               creatTask(count,id,nextvalue,form,reqName);     
				   return nextvalue;    		
	 }
	 
	 
	 /**
	  * create tasks in tasktable 
	  * @param count task count of the form
	  * @param attrid 
	  * @param jobseq
	  * @param ssname
	  */
	 public void creatTask(int count,int attrid,int jobseq,String ssname,String reqName)
	 {
		
			    String userName=null;
			   	res_list=inboxservice.fetchTaskAttribute(attrid);
			    for(int i=0;i<res_list.size();i++)
			    {
			    	vo=(InboxVO)res_list.get(i);
			    	taskname=vo.getTask();
			    	
			    	    res_list1=inboxservice.fetchTaskId();
						logger.debug("Taskid size "+res_list1.size());
						for(int i2=0;i2<res_list1.size();i2++)
					    {
					    	vo=(InboxVO)res_list1.get(i2);
					    	logger.debug("task sequence value"+vo.getTaskid());
					    	nextvalue1=Integer.parseInt(vo.getTaskid())+1;
					    }
						
			    	
			   		res_list2=inboxservice.fetchUserTab();
					for(int i1=0;i1<res_list2.size();i1++)
				    {    	vo=(InboxVO)res_list2.get(i1);
				    	if(taskname.equals(vo.getRole()))
				    	{
				    		rolename=vo.getUsername();
				 			logger.debug("role name in task method"+rolename);
				    	}
				     }
				    if(taskname.equals("approve"))
					 {
						 task=ssname.concat(s1);
						 logger.debug("name approve task"+task);
						 status=0;
					 }
					 else if(taskname.equals("issue"))
					 {
						 task=ssname.concat(s2);
						 logger.debug("name issue task"+task);
						 status=-1;
					 }
					 else if(taskname.equals("purchase"))
					 {
						 task=ssname.concat("_purchase");
						 logger.debug("name for purchase"+task);
						 status=-1;
					 }
				    try
				    {
				    	inboxservice.InsertTask(jobseq,nextvalue1,task,rolename,status,userName,reqName);
				   		logger.debug("inserted in Task Successfully");
				    }
				    catch(Exception e)
				    {
				    	logger.debug("error"+e);
				    }
				    logger.debug("inserted in job");
			     }
			  
	 }
	 
	 
	 /**
	  * changes the status to 1 for approve task after viewing the page from inbox
	  * @param job
	  * @param task
	  */
	 
	 public void acquiredStatus(int job,int task,String userName)
	 {
		 try
		 {
			 
			  inboxservice.UpdateTaskStatus(1,task,userName);
			  logger.debug("in acquired method updated successfully");
		 
		 }
		 catch(Exception e){
			 logger.debug("error in acquired"+e);
		 }
		 
	 }
	 
	 
	 /**
	  * updates the status of approve task of that form to 2 and issue task to 0.
	  * @param job
	  * @param task
	  */

	 public void approveStatus(int job,int task)
	 {
		 try
		 {	 
			 inboxservice.UpdateTask(2,task);
	   		 logger.debug("in approve method updates the status to 2 successfully");
		 }
		 catch(Exception e){
			 logger.debug("error in approve"+e);
		 }
		 try
		 {
			 
			 task=task+1;
			 inboxservice.UpdateTask(0,task);
			 logger.debug("in acquired method updates the status to 0 successfully");
		 }
		 catch(Exception e){
			 logger.debug("error in acquired"+e);
		 }
		 
			
	 }
	 
	 
	 /**
	  * updates the status of issue task of that form to 2 
	  * @param job
	  * @param task
	  */
	 public void okStatus(int job,int task)
	 {
		 try
		 {	
			 inboxservice.UpdateTask(2,task);
			 logger.debug("In ok method updates the status to 2 successfully");
		 }
		 catch(Exception e){
		 logger.debug("error in acquired"+e);
		 }
	 
		 
	 }

}



