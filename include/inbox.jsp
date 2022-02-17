<%--
/*==================================================================================
 * Copyright ©  2007 Swiss Re.  ALL RIGHTS RESERVED.
 * Filename: techBCInbox.jsp
 * Purpose:  Application JSP for the European Life Induction Tech Account application
 * Classes:  techBCInbox
 *==================================================================================*/
--%>
<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/techInbox.do";
%>
<html:html>
	<head>
		<title>Inbox</title>
		
	</head>
	<script language="JavaScript">
	function getTaskPage(jobId,taskId,fmName,status)
	{
	
		var jobId = jobId;
		
		var fmName = fmName;
		var taskId = taskId;
		var status = status;
		
		document.forms[0].method = "post";		
		document.forms[0].action="<%=request.getContextPath()%>/inbox.do?invoke=acquiredMethod&fmName="+fmName+"&jobId="+jobId+"&taskId="+taskId+"&status="+status;
		document.forms[0].submit();
	}
	
	</script>
	<body>
		<html:form action="inbox">	
			<table width = "100%">
				
				<tr>
					<td width="2%"><img src="images/spacer.gif" width="20" height="1"></td>					 
					<td>					
						
						
						<logic:present property="inboxList" name="InboxForm">
							<bean:define id="inboxList" name="InboxForm" property="inboxList" scope="session" type="java.util.Collection"/>
							<display:table name="inboxList" requestURI="<%=url%>" decorator="com.util.InboxDecoratorUtil">
									<display:column property="fmName"  title="TASK NAME"/>
									<display:column property="jobId" title="JOB ID" />
									<display:column property="taskId" title="TASK ID" />
									<display:column property="status" title="STATUS" />			
									<display:column property="viewLink" title = ""/>
							</display:table>
						</logic:present>	
						<logic:notPresent name="inboxList" scope="request">
									 No Tasks Found 
						</logic:notPresent>
					</td>
											 
				</tr>		 
				<tr>
					<td colspan="8">&nbsp;</td>				
				</tr>		 
			</table>
		</html:form>
	</body>
</html:html>