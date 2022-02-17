<!-- /**
 *********************************************************
 * Project Name		:	KONGU TRANSPORT MANAGEMENT SYSTEM
 * Document Name	: 	BaseLayout.jsp
 * Desc				:	This jsp is used by all screens.
 * copyright  	    :   Copyright (C) 2009 Department of Computer Applications
 * 
 **********************************************************
 */ -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%-- Include common set of tag library declarations for each layout --%>

<%@ include file="/include/taglibs.jsp"%>

<html:html xhtml="true" locale="true">
<head>
	<%-- Push tiles attributes in page context --%>
	<tiles:importAttribute />

	<%-- Include common set of meta tags for each layout --%>
    <%@ include file="/include/meta.jsp" %>

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

	<title>
    	<bean:message key="webapp.prefix"/>
        <bean:message name="titleKey"/>
    </title>

    <%-- Get List of Stylesheets --%>
    <tiles:useAttribute id="styleList" name="styles"
        classname="java.util.List" ignore="true"/>

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
			</tr>
		</table>
		<table width="100%" cellspacing="0" cellpadding="0">
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
			<tr>				
				<td valign="top" width="100%" >
					<!-- table 1 opens -->
					<table cellspacing="0" cellpadding="0" width="100%">
						<tr valign="top">						
							<td width="100%">							
								<tiles:insert attribute="content"/>
							</td>
						</tr>
					</table>
					<!-- table 2 close -->
				</td>				
			</tr>			
		</table> 
</body>
</html:html>