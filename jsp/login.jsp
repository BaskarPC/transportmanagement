<%@ include file="/include/taglibs.jsp"%>
<%@ include file="/include/front.jsp"%>
<%
	String url =  request.getContextPath()+"/login.do";
%>
<html:html>
	<head>
		<title>Logins</title>
	</head>
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">

	function login()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/login.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	
</script>

<body>
		<html:form action="login" enctype="multipart/form-data">
			<table align="center"><br/><br/><br/><br/><br/><br/><br/><br/>
				<tr>
					<td width="100">Login Id </td>
					<td>
						<html:text property="userId" style="width:113"/>		
					</td>
				</tr>
				<tr>
					<td width="100">Password </td>
					<td>
						<html:password property="passWord" style="width:113"/>
					</td>
				</tr>
				<tr>
					<td align="center"><br/>
					<img border="0" src="<%=request.getContextPath()%>/images/btn_login.jpg" onclick="login()"></td>
					</td>
					<td align="center"><br/>
						<img border="0" src="<%=request.getContextPath()%>/images/btn_reset.jpg" onclick="login()"></td>
					</td>
				</tr>
				
			</table>

</html:form>
</body>
</html:html>