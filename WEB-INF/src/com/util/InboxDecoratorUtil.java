package com.util;



 
import java.text.ParseException;



import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;

import com.vo.InboxdbVO;






	public class InboxDecoratorUtil  extends TableDecorator{
		private static final Logger logger = (Logger) Logger.getInstance(InboxDecoratorUtil.class);
		private boolean start = false;
		
	
		
		public InboxDecoratorUtil() {
			super();
		}
		
	
		
		public Object getViewLink() {
			logger.info("getViewLink method-------->>");
		
			String jobId = "";
			String taskId =""; 
			String requestNbrLink ="";
			String fmName = "hai";
			
			String status="";
			String path = "";
			
			InboxdbVO inboxVO = (InboxdbVO)getCurrentRowObject();
			HttpServletRequest request = (HttpServletRequest)getPageContext().getRequest();
			jobId = inboxVO.getJobId();
			taskId = inboxVO.getTaskId();  
			fmName=inboxVO.getFmName();
			logger.debug("fname"+fmName);
			status=inboxVO.getStatus();				
			
			path = "javascript:getTaskPage('"+jobId+"','"+taskId+"','"+fmName+"','"+status+"')";
			logger.debug("path........ "+path);
			requestNbrLink =
				new StringBuffer("<a href=")
				.append(path)
				.append("><img src=")
				.append(request.getContextPath())
				.append("/images//VIEW.jpg border=0>")													
				.toString();		 
				return null != requestNbrLink ? requestNbrLink : " ";
			
			
			} 
		
		
	}

