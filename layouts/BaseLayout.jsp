<!-- /**
 
 */ -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%-- Include common set of tag library declarations for each layout --%>

<%@ include file="/include/taglibs.jsp"%>

<html:html xhtml="true" >
<head>
	<%-- Push tiles attributes in page context --%>
	<tiles:importAttribute />

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

	<title>
    	<bean:message key="webapp.prefix"/>
        <bean:message name="titleKey"/>
    </title>

    <%-- Get List of Stylesheets --%>
    <tiles:useAttribute id="styleList" name="styles"
        classname="java.util.List" ignore="true"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/content.css"></link>
    <c:forEach var="css" items="${styleList}">
        <link rel="stylesheet" type="text/css" media="all"
            href="<c:url value="${css}"/>" />
    </c:forEach>	
</head>
<body link="#555555" vlink="#555555" alink="#555555" bgcolor="#ffffff">
	<!-- header -->
	<tiles:insert attribute="header" ignore="true"/>
		<!-- table 1 open -->
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="#555555"><img src="<%=request.getContextPath()%>/images/spacer.gif" alt="" width="1"></td>
				<td valign="top" width="100%" align="left">
					<table cellspacing="0" cellpadding="0" width="100%">
						<tr>
						  <td>
							<table cellspacing=0 bgcolor="#e9e9e9" width="100%">
								<tr>
									<td>						
										<tiles:insert attribute="menu" ignore="true"/>		
									</td>
								</tr>								
							</table>
						  </td>
						</tr>				 
					</table>
				</td>				
			</tr>
		</table>
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>				
				<td valign="top" width="100%">
					<!-- table 1 opens -->
					<table cellspacing="0" cellpadding="0" width="100%">
					<%-- Error Messages --%>
						<logic:messagesPresent>
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
								</tr>
							<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td class="errormes" width="32">
								<img src = "<%=request.getContextPath()%>/images/ico_error.gif" width="32" height="29"/>
								</td>
								<td class="errormes">
								<html:messages id="error"><bean:write name="error" filter="false"/></html:messages>
								</td>
							</tr>
						</table>
						</logic:messagesPresent>
						<%-- Success Messages --%>
						<logic:messagesPresent message="true">
							<table cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
								</tr>
							<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><img src = "<%=request.getContextPath()%>/images/ico_i.gif"/></td>
								<td><html:messages id="message" message="true">
									&nbsp;&nbsp;<b><bean:write name="message" filter="false"/></b><br/>
									</html:messages>
								</td>
							</tr>
							</table>							
						</logic:messagesPresent>	
						<tr valign="top">						
							<td>							
								<tiles:insert attribute="content"/>
							</td>
						</tr>
					</table>
					<!-- table 2 close -->
				</td>				
			</tr>			
		</table> 
		<tiles:insert attribute="footer"/>
		<tiles:insert attribute="copyright"/>
</body>
</html:html>