function refreshClient()
{
alert("refreshClient()");
	if ( document.forms[0].strClient.value !=  "")
	{
		document.forms[0].action = "claimaccountregistration.do?invoke=refreshClient&documentSeqId=<%=request.getParameter("documentSeqId")%>&taskId=<%=request.getParameter("taskId")%>&taskName=<%=request.getParameter("taskName")%>&jobId=<%=request.getParameter("jobId")%>&screenId=<%=request.getParameter("screenId")%>"; 
		document.forms[0].submit();
	}
	
}